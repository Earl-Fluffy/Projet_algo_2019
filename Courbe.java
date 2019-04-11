import java.awt.Color;
import java.awt.Graphics;
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
		this.setBackground(Color.white);
		dep=d;
		tmp= new double[dep.size()];
		mont= new double[dep.size()];
		x=dep.get(0).getDate();
		y=665/2 + dep.get(0).getAmount();
		for (int i=0; i<dep.size(); i++){
			tmp[i]=(dep.get(i).getDate()) -x;
			mont[i]=(dep.get(i).getAmount()+ y);
		}
		polynomes = LagrangeInterpolation.findPolynomialFactors (tmp, mont);
		System.out.print(polynomes[0]);
		LeastSquares approximation=new LeastSquares(tmp,mont);
		coorLeastSaquares= approximation.tabCourbe();
		System.out.println(x+  "          " +y +"     "+ this.getHeight());
	}
	

	
	public void tracerPoint(Graphics g){
		
		g.setColor(Color.red);
		for(int i=0; i<dep.size();i++){
			
			g.fillOval((int)tmp[i]-5, (int)mont[i]-5, 10, 10);
		}
	}
	
	public void tracerCourbe(Graphics g){
		g.setColor(Color.black);
		for(int i=0; i<tmp.length-1;i++){
			
			g.drawLine((int)tmp[i], (int)mont[i], (int)tmp[i+1], (int)mont[i+1]);
		}
	}
	
	public void tracerCourbeLagrange(Graphics g){
		double y1=0;
		double y2=0;
		g.setColor(Color.blue);
		for (int i=0; i<800;i++){
			for (int j=0; j<dep.size();j++){
				y1=y1+(i^j)*polynomes[j];
				y2=y2+((i+1)^j)*polynomes[j];
			}
			System.out.println(i+" "+(int)y1 +" "+ i +" "+ (int)y2);
			g.drawLine(i, (int)y1, i+1, (int)y2);
			y1=0;
			y2=0;
		}
	}
	
	public void tracerCourbeLeastSquares(Graphics g){
		double a=coorLeastSaquares[0];
		int b=(int)coorLeastSaquares[1];
		g.setColor(Color.green);
		g.drawLine(0, b, this.getWidth(), (int)(a*this.getWidth()) + b);
		System.out.println( b+ "~~~~~~~~~~~~~~~~~~~~~~~~~  " +a);
	}
		
	public void paintComponent (Graphics g){
		tracerPoint(g);
		tracerCourbe(g);
		tracerCourbeLagrange(g);
		tracerCourbeLeastSquares(g);
	}
	
	
}
		

//drawLine(int x1, int y1, int x2, int y2)
