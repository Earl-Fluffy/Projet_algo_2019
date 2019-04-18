import java.awt.*;
import java.awt.geom.Line2D;
import java.util.*;
import javax.swing.JPanel;

public class Courbe extends JPanel{ 

	ArrayList<Depenses> dep = new ArrayList<Depenses>();
	double[] tmp;
	double[] mont;
	double[] polynomes;
	double[] coorLeastSaquares;
	double x;
	double y;
	
	public Courbe (ArrayList<Depenses> d){
		this.setLayout(null);
		this.setBackground(new Color(248,210,211));
		//this.setPreferredSize(new Dimension(700,700));
		dep=d;
		tmp= new double[dep.size()];
		mont= new double[dep.size()];
		x=dep.get(0).getDate();
		y=665/2 + dep.get(0).getAmount();
		for (int i=0; i<dep.size(); i++){
			tmp[i]=(dep.get(i).getDate()) -x;
			mont[i]=(dep.get(i).getAmount()+ y);
		}
		
		Interpolationv2 inter=new Interpolationv2(tmp,mont);
		polynomes = inter.getCoeff();
		LeastSquares approximation=new LeastSquares(tmp,mont);
		coorLeastSaquares= approximation.tabCourbe();
	}
	

	
	public void tracerPoint(Graphics g){
		
		g.setColor(new Color (204,0,5));
		for(int i=0; i<dep.size();i++){
			
			g.fillOval((int)tmp[i]-5, this.getHeight()-(int)mont[i]-5, 10, 10);
		}
	}
	
	public void tracerCourbe(Graphics g, Graphics2D g2){
		g.setColor(Color.black);
		for(int i=0; i<tmp.length-1;i++){
			
			g.drawLine((int)tmp[i], this.getHeight()-(int)mont[i], (int)tmp[i+1], this.getHeight()-(int)mont[i+1]);
		}
	}
	
	public void tracerCourbeLagrange(Graphics g, Graphics2D g2){
		double y1=0;
		double y2=0;
		g.setColor(new Color(121,121,255));
		for (int i=1; i<801;i++){
			for (int j=0; j<dep.size();j++){
				y1=y1+(Math.pow(i,j))*(polynomes[j]);
				y2=y2+(Math.pow((i+1),j))*(polynomes[j]);
			}
			g2.draw(new Line2D.Float(i, this.getHeight()-(int)y1, i+1, this.getHeight()-(int)y2));
			y1=0;
			y2=0;
		}
	}
	
	public void tracerCourbeLeastSquares(Graphics g, Graphics2D g2){
		double a=coorLeastSaquares[0];
		int b=(int)coorLeastSaquares[1];
		g.setColor(new Color (3,165,75));
		g.drawLine(0, this.getHeight()-b, this.getWidth(), this.getHeight()-((int)(a*this.getWidth()) + b));
	}
		
	public void paintComponent (Graphics g){
		Graphics2D g2 = (Graphics2D) g;
		g2.setStroke(new BasicStroke(2));
		tracerCourbeLagrange(g,g2);
		tracerCourbeLeastSquares(g,g2);
		tracerCourbe(g,g2);
		tracerPoint(g);
	}
	
	
}
		
