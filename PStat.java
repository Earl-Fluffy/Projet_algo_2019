import java.awt.*;
import java.util.*;
import javax.swing.JPanel;


public class PStat extends JPanel{

	Courbe pCourbes;
	PanelImage Cartouche= new PanelImage("media/legende.bmp");
	PAxeX axeX;
	PAxeY axeY;
	Bouton retour = new Bouton("","media/retourCourbe.bmp");

	public PStat(ArrayList<Depenses> d){
		this.setLayout(new BorderLayout());
		this.setBackground(new Color (248,210,211));
		pCourbes = new Courbe(d);
		Cartouche.setPreferredSize(new Dimension(80,700));
		Cartouche.setBackground(new Color (226,241,254));
		retour.setBounds(700,0,90,20);
		axeX = new PAxeX(d);
		axeX.add(retour);
		axeY = new PAxeY(d);
		axeY.setBackground(new Color (226,241,254));
		this.add(Cartouche,BorderLayout.EAST);
		this.add(axeX,BorderLayout.SOUTH);
		this.add(axeY,BorderLayout.WEST);
		this.add(pCourbes,BorderLayout.CENTER);
		
	}


	public class PAxeX extends JPanel{
		public PAxeX(ArrayList<Depenses> d){
			this.setPreferredSize(new Dimension(700,20));
			this.setBackground(new Color(226,241,254));
			this.setLayout(null);
		}

		public void paintComponent (Graphics g){

		}
	}

	public class PAxeY extends JPanel{
		public PAxeY(ArrayList<Depenses> d){
			this.setPreferredSize(new Dimension(20,700));
			this.setBackground(new Color(226,241,254));
			this.setLayout(null);
		}

		public void paintComponent (Graphics g){

		}
	}
}
