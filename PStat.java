import java.awt.Color;
import java.awt.Graphics;
import java.util.*;
import javax.swing.JPanel;
import java.awt.BorderLayout;


public class PStat extends JPanel{

	public PStat(ArrayList<Depenses> d){
		this.setLayout(new BorderLayout());
		Courbe toutes = new Courbe(d);
		this.add(toutes,BorderLayout.CENTER);
		
	}
}
