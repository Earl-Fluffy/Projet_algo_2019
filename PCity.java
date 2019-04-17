import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.event.*;



public class PCity extends JPanel implements ActionListener{
	private BorderLayout g1 = new BorderLayout();
	public Bouton bNouvelleEntree=new Bouton("","media/NouvelleEntree.gif");
	public Bouton bStats= new Bouton("","media/Stats.gif");
	public JButton close = new JButton ("Fermer");
	public Map myMap;
	JPanel commande =new JPanel();
	PanelImage cityBack=null;
	
	PCity(String[][] batACreer){
		myMap = new Map(batACreer); //L'objet qui répertorie et gère tous les bâtiments

		this.setLayout(g1);

		commande.setLayout(null); //Panel qui contient les deux boutons Nouvelle entrée et Statisiques
		commande.setBackground(Color.blue);
		commande.setPreferredSize(new Dimension(800,100));
		bNouvelleEntree.setBounds(100,15,200,67);
		bStats.setBounds(500,15,200,67);
		commande.add(bNouvelleEntree);
		commande.add(bStats);
		this.add(commande, BorderLayout.SOUTH);
		
		cityBack = new PanelImage("media/CityBackground.jpg"); //Panel où va être affiché la ville
		cityBack.setLayout(null);

		this.dessiner();


		
		this.add(cityBack,BorderLayout.CENTER);

		JPanel infoArgent = new JPanel(); //Panel avec l'argent virtuel et le bouton fermer
		infoArgent.setLayout(null);
		infoArgent.setBackground(Color.blue);
		infoArgent.setPreferredSize(new Dimension(800,30));
		this.add(infoArgent,BorderLayout.NORTH);
		close.setBounds (700,0,100,30);
		close.setBackground(Color.red);
		infoArgent.add(close);
		close.addActionListener(this);

	}
	
	public void actionPerformed (ActionEvent e){
		myMap.save();
		System.exit(0);
	}

	public void dessiner (){
		for(Batiment bat : myMap.listBat){
			PanelImage pBat = new PanelImage(bat.image);
			pBat.setBounds(60+bat.x[0]*60,3+bat.y[0]*60,58*bat.x.length,58*bat.y.length);
			bat.myPanel=pBat;
			cityBack.add(pBat);
		}
	}

	class PanelImage extends JPanel{ //Dédfinit un JPanel avec une image de fond
		private Image img=null;
		PanelImage(String pathname){
			try{
				img = ImageIO.read(new File(TestMain.class.getResource(pathname).getPath()));
			} catch (IOException e){
				e.printStackTrace();
			}
		}

		PanelImage(Image img){
			this.img=img;
		}
		public void paintComponent(Graphics g){
			g.drawImage(img,0,0,this.getWidth(),this.getHeight(),this);
		}
	}


}

