import java.awt.*;
import java.util.*;
import javax.swing.JPanel;


public class PStat extends JPanel{

	JPanel pCourbes=null;
	PanelImage Cartouche;
	PAxeX axeX;
	PAxeY axeY;
	Bouton retour = new Bouton("","media/retourCourbe.bmp");

	public PStat(ArrayList<Depenses> d){
		this.setLayout(new BorderLayout());
		this.setBackground(new Color (248,210,211));
		if(d.size()>1) {
			pCourbes = new Courbe(d);
		} else{
			pCourbes = new PanelImage("media/noDepense.bmp");
		}
		Cartouche= new PanelImage("media/legende.bmp");
		Cartouche.setPreferredSize(new Dimension(80,700));
		retour.setBounds(700,0,90,20);
		axeX = new PAxeX(d);
		axeX.add(retour);
		axeY = new PAxeY(d);
		this.add(axeX,BorderLayout.SOUTH);
		this.add(axeY,BorderLayout.WEST);
		this.add(Cartouche,BorderLayout.EAST);
		this.add(pCourbes,BorderLayout.CENTER);
		this.repaint();
	}



}
class PAxeX extends JPanel{
	public PAxeX(ArrayList<Depenses> d){
		this.setPreferredSize(new Dimension(700,20));
		this.setBackground(new Color(226,241,254));
		this.setLayout(null);
	}

	public void paintComponent(Graphics g){
		super.paintComponent(g);
	}


}

class PAxeY extends JPanel{
	public PAxeY(ArrayList<Depenses> d){
		this.setBackground(new Color (226,241,254));
		this.setPreferredSize(new Dimension(20,680));
		this.setLayout(null);
	}

	public void paintComponent(Graphics g){
		super.paintComponent(g);
	}


}
