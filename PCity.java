import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;



public class PCity extends JPanel{
	private BorderLayout g1 = new BorderLayout();
	public Bouton bNouvelleEntree=new Bouton("","media/NouvelleEntree.gif");
	public Bouton bStats= new Bouton("","media/Stats.gif");
	
	PCity(){
		this.setLayout(g1);
		JPanel commande = new JPanel();
		commande.setLayout(null);
		commande.setBackground(Color.blue);
		commande.setPreferredSize(new Dimension(800,100));
		bNouvelleEntree.setBounds(100,15,200,67);
		bStats.setBounds(500,15,200,67);
		commande.add(bNouvelleEntree);
		commande.add(bStats);
		this.add(commande, BorderLayout.SOUTH);
		
		PanelImage cityBack = new PanelImage("media/CityBackground.jpg");
		this.add(cityBack,BorderLayout.CENTER);

		JPanel infoArgent = new JPanel();
		infoArgent.setLayout(null);
		infoArgent.setBackground(Color.blue);
		infoArgent.setPreferredSize(new Dimension(800,30));
		this.add(infoArgent,BorderLayout.NORTH);
	}
	
	public class PanelImage extends JPanel{
		private Image img=null;
		PanelImage(String pathname){
			try{
				img = ImageIO.read(new File(TestMain.class.getResource(pathname).getPath()));
			} catch (IOException e){
				e.printStackTrace();
			}
		}
		public void paintComponent(Graphics g){
			g.drawImage(img,0,0,this.getWidth(),this.getHeight(),this);
		}
	}
}
