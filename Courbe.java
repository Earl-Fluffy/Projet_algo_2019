import java.awt.Color;
import java.awt.Graphics;
import java.util.*;
import javax.swing.JPanel;

public class Courbe {   //implements JPanel ??

	ArrayList<Depenses> dep = new ArrayList<Depenses>();
	double[] tmp;
	double[] mont;
	
	public Courbe (ArrayList<Depenses> d){
		dep=d;
	}
	
	public Courbe(double[] t, double[] m){
		tmp=t;
		mont=m;
	}
	
	public void tracerPoint(Graphics g){
		for(int i=0; i<dep.size();i++){
			g.fillOval(dep.get(i).getDate(), (int)(dep.get(i).getAmount()), 2, 2);
		}
		
		
	}
	
	public void tracerCourbe(Graphics g){
		for(int i=0; i<tmp.length-1;i++){
			g.drawLine((int)tmp[i], (int)mont[i], (int)tmp[i+1], (int)mont[i+1]);
		}
	}
	
}
		

//drawLine(int x1, int y1, int x2, int y2)
