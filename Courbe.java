import java.awt.Color;
import java.awt.Graphics;
import java.util.*;
import javax.swing.JPanel;

public class Courbe extends JPanel{ 

	ArrayList<Depenses> dep = new ArrayList<Depenses>();
	double[] tmp= new double[dep.size()];
	double[] mont= new double[dep.size()];
	double[] polynomes;
	double[] coorLeastSaquares;
	
	public Courbe (ArrayList<Depenses> d){
		dep=d;
		for (int i=0; i<dep.size(); i++){
			tmp[i]=dep.get(i).getDate();
			mont[i]=dep.get(i).getAmount();
		}
		polynomes = LagrangeInterpolation.findPolynomialFactors (tmp, mont);
		LeastSquares approximation=new LeastSquares(tmp,mont);
		coorLeastSaquares= approximation.tabCourbe();
	}
	

	
	public void tracerPoint(Graphics g){
		for(int i=0; i<dep.size();i++){
			g.fillOval((int)dep.get(i).getDate(), (int)(dep.get(i).getAmount()), 2, 2);
		}
		
		
	}
	
	public void tracerCourbe(Graphics g){
		for(int i=0; i<tmp.length-1;i++){
			g.drawLine((int)tmp[i], (int)mont[i], (int)tmp[i+1], (int)mont[i+1]);
		}
	}
	
	public void tracerCourbeLagrange(Graphics g){
		double y1=0;
		double y2=0;
		for (int i=0; i<800;i++){
			for (int j=0; j<dep.size();j++){
				y1=y1+(i^j)*polynomes[j];
				y2=y2+((i+1)^j)*polynomes[j];
			}
			g.drawLine(i, (int)y1, i+1, (int)y2);
			y1=0;
			y2=0;
		}
	}
	
	public void tracerCourbeLeastSquares(Graphics g){
		int a=(int)coorLeastSaquares[0];
		int b=(int)coorLeastSaquares[1];
		g.drawLine(0, b, 1, a + b);
	}
		
	public void paintComponent (Graphics g){
		tracerPoint(g);
		tracerCourbe(g);
		tracerCourbeLagrange(g);
		tracerCourbeLeastSquares(g);
	}
	
	
}
		

//drawLine(int x1, int y1, int x2, int y2)
