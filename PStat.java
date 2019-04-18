import java.awt.*;
import java.util.*;
import javax.swing.JPanel;

// PStat est une classe objet qui s'occupe de créer les courbes, ses axes, et de quoi retourner au menu principal

public class PStat extends JPanel{

	JPanel pCourbes=null;
	PanelImage Cartouche;
	PAxeX axeX;
	PAxeY axeY;
	Bouton retour = new Bouton("","media/retourCourbe.bmp");

	public PStat(ArrayList<Depenses> d){           //Elle prend en constructeur la liste totale des dépenses, dont Courbe à besoin
		this.setLayout(new BorderLayout());
		this.setBackground(new Color (248,210,211));
		if(d.size()>1 && d!=null) {
			pCourbes = new Courbe(d);  //Création du panneau Courbe
			
		} else{
			pCourbes = new PanelImage("media/noDepense.bmp"); //S'il y a moins de deux dépenses, on ne peut tracer de courbe
		}
		Cartouche= new PanelImage("media/legende.bmp");
		Cartouche.setPreferredSize(new Dimension(80,700));
		retour.setBounds(700,0,90,20);
		
		if(d.size()>1 ) {
			axeX = new PAxeX(d);    //Création des axes
		    axeX.add(retour);
		    axeY = new PAxeY(d);
		    this.add(axeX,BorderLayout.SOUTH);
		    this.add(axeY,BorderLayout.WEST);
		} else {                                // Toujours pas de création s'il n'y a pas au moins deux dépenses
			JPanel pasAxeX = new JPanel();      // Mais il faut tout de même un panel pour le bouton retour
			pasAxeX.setPreferredSize(new Dimension(700,40));
			pasAxeX.setBackground(new Color(226,241,254));
			pasAxeX.setLayout(null);
			pasAxeX.add(retour);
			this.add(pasAxeX,BorderLayout.SOUTH);
		}
		
		
		this.add(Cartouche,BorderLayout.EAST);
		this.add(pCourbes,BorderLayout.CENTER);
		this.repaint();
	}



}

//Classe pour l'axe x
class PAxeX extends JPanel{
	int dateInitiale;
	double diffX;
	public PAxeX(ArrayList<Depenses> d){
		this.setPreferredSize(new Dimension(700,40));
		this.setBackground(new Color(226,241,254));
		this.setLayout(null);
		dateInitiale=(int)d.get(0).date;
		diffX=d.get(d.size()-1).date-d.get(0).date;
	}

	public void paintComponent(Graphics g){
		super.paintComponent(g);
		tracerAxeX(g);
		
	}
	
	// traçage d'un axe dynamique, les valeurs affichées dépendent des valeurs dans la liste des dépenses
	public void tracerAxeX(Graphics g){
		g.drawLine(40, this.getHeight()/4, this.getWidth()-80, this.getHeight()/4);
		for (int i=0; i<((this.getWidth())-80); i+=30){
			 g.drawLine(i+40,0 , i+40 ,this.getHeight()/4 );
			 g.drawString( convertion(i*diffX/330 + dateInitiale), i+40, 3*this.getHeight()/4);
		 }
	}
	
	// méthode permettant de passer d'une date en jour à une date en jour et mois
	public String convertion(double x){
		String s;
		int m=(int)(x/30.4);
		int j=(int) (x-30.4*m);
		if(m>12){
			m=m%12;
			if(m==0){
				m=12;
			}
		}
		s=j+"/"+m;
		return s;
	}


}


//Classe pour l'axe y, non dynamique par faute de temps
class PAxeY extends JPanel{
	
	public PAxeY(ArrayList<Depenses> d){
		this.setBackground(new Color (226,241,254));
		this.setPreferredSize(new Dimension(40,680));
		this.setLayout(null);
		
	}

	public void paintComponent(Graphics g){
		super.paintComponent(g);
		tracerAxeY(g);
		
	}
	
	public void tracerAxeY(Graphics g){
		g.drawLine(3*this.getWidth()/4, 0, 3*this.getWidth()/4, this.getHeight());
		for (int i=0; i<(this.getHeight())/50; i++){
			 g.drawLine(3*this.getWidth()/4,this.getHeight()-(i*50)-1,this.getWidth() , this.getHeight()-(i*50)-1);
			 g.drawString( Integer.toString(i*50), this.getWidth()/4,this.getHeight()-(i*50));
		 }
	}


}
