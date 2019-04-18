import java.awt.*;
import java.awt.geom.Line2D;
import java.util.*;
import javax.swing.JPanel;
/* La classe courbe est une classe objet qui extends JPanel.
 * C'est une classe qui s'occupe de l'affichage des dépenses sous forme de courbe (montant des dépenses en fonction du temps).
 * En plus de faire l'affichage elle calcule les courbes de prévisions à l'aide des méthode Interpolationv2 et LeastSquares.
 */



public class Courbe extends JPanel{ 

	ArrayList<Depenses> dep = new ArrayList<Depenses>();
	double[] tmp;
	double[] mont;
	double[] polynomes;
	double[] coorLeastSaquares;
	double x;
	double y;
	double diffX;
	
	public Courbe (ArrayList<Depenses> d){   //Constructeur de courbe prend une liste de toutes les dépenses
		this.setLayout(null);
		this.setBackground(new Color(248,210,211));
		//this.setPreferredSize(new Dimension(700,700));
		dep=d;
		
		// Les valeurs qui nous intéresse des dépenses, à savoir leur montant et leur date sont placées dans des tableaux de double pour faciliter leur utilisation.
		// C'est avec ces valeurs que seront tracer les courbes
		tmp= new double[dep.size()];
		mont= new double[dep.size()];
		x=dep.get(0).getDate();	
		for (int i=0; i<dep.size(); i++){
			tmp[i]=(dep.get(i).getDate()) -x;
			mont[i]=(dep.get(i).getAmount());
		}
		diffX=tmp[tmp.length-1];
		for (int i=0; i<dep.size(); i++){
			tmp[i]=tmp[i]*((660/2)/diffX);
		}
		// Interpolation polynomiale. 
		//Ici on récupère dans le tableau polynomes tous les coefficients (a0, a1, ..., an) d'un polynomes passant par les points représentant les dépenses.
		Interpolationv2 inter=new Interpolationv2(tmp,mont);
		polynomes = inter.getCoeff();
		
		
		// Méthode des moindres carrés
		// Cela nous permet de récupérer dans le tableau coorLeastSquares les coefficients a et b de la droite ax+b approximant la courbe des dépenses
		LeastSquares approximation=new LeastSquares(tmp,mont);
		coorLeastSaquares= approximation.tabCourbe();
	}
	

	// La méthode tracerPoint trace des cercles de rayon 5 pixels autour des points dépenses réels
	public void tracerPoint(Graphics g){
		
		g.setColor(new Color (204,0,5));
		for(int i=0; i<dep.size();i++){
			g.fillOval((int)(tmp[i]-5), this.getHeight()-(int)mont[i]-5, 10, 10);  
			//La valeur avec la plus petite date (et donc la première dans la liste, puis dans les tableaux) est placée à l'extrimité gauche du panel. (la même chose est effectuée par la suite)
		}
	}
	
	
	
	
	// La méthode tracerCourbe relis les points de tracer Point par un trait noir.
	public void tracerCourbe(Graphics g, Graphics2D g2){
		g.setColor(Color.black);
		for(int i=0; i<tmp.length-1;i++){
			
			g.drawLine((int)(tmp[i]), this.getHeight()-(int)mont[i], (int)(tmp[i+1]), this.getHeight()-(int)mont[i+1]);
		}
	}
	
	
	
	
	
	
	// La méthode tracerCourbeLagrange trace une courbe à l'aide des coefficients de polynome.
	// Elle relie chaque point par un trait, avec un point par pixel calculé.
	public void tracerCourbeLagrange(Graphics g, Graphics2D g2){
		
		
		double y1=0;
		double y2=0;
		g.setColor(new Color(121,121,255));
		for (int i=0; i<this.getWidth();i++){
			for (int j=0; j<dep.size();j++){
				y1=y1+(Math.pow(i,j))*(polynomes[j]);
				y2=y2+(Math.pow((i+1),j))*(polynomes[j]);
			}
			g2.draw(new Line2D.Float(i, this.getHeight()-(int)y1, i+1, this.getHeight()-(int)y2));
			y1=0;
			y2=0;
		}
	}
	
	
	
	
	
	
	// La méthode tracerCourbeLagrange trace une courbe à l'aide des coefficients a et b de la méthode des moindre carrés
	// La courbe obtenue étant une droite, on utilise drawLine entre les deux extrémités de la fenêtre
	public void tracerCourbeLeastSquares(Graphics g, Graphics2D g2){
		
		double a=coorLeastSaquares[0];
		int b=(int)coorLeastSaquares[1];
		g.setColor(new Color (3,165,75));
		g.drawLine(0, this.getHeight()-b, this.getWidth(), this.getHeight()-((int)(a*this.getWidth()) + b));
	}
	
	//	Classe permettant de dessiner toutes les courbes.
	public void paintComponent (Graphics g){
		Graphics2D g2 = (Graphics2D) g;
		g2.setStroke(new BasicStroke(2));
		tracerCourbeLagrange(g,g2);
		tracerCourbeLeastSquares(g,g2);
		tracerCourbe(g,g2);
		tracerPoint(g);
	}
	
	
}
		
