import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.event.*;
import java.util.*;
import java.io.PrintWriter;
import java.io.FileWriter;




public class PCity extends JPanel implements ActionListener{
	private BorderLayout g1 = new BorderLayout();
	public Bouton bNouvelleEntree=new Bouton("","media/NouvelleEntree.gif");
	public Bouton bStats= new Bouton("","media/Stats.gif");
	public JButton close = new JButton ("Fermer");
	public LinkedList <Batiment> buildings;
	
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
		close.setBounds (700,0,50,50);
		close.setBackground(Color.red);
		this.add(close);
		close.addActionListener(this);
		
	}
	
	public void actionPerformed (ActionEvent e){
	/*var fileSystem=new ActiveXObject("Scripting.FileSystemObject");
	//fileSystem.CreateTextFile("monFichier.txt",true);
	var monfichier=fileSystem.OpenTextFile("monFichier.txt", 2 ,true); 
	//Sauvegarder tous les bâtiments en texte et la date de la fermeture: https://www.tutorielsenfolie.com/tutoriels-92-Lire-et-ecrire-dans-un-fichier-en-JavaScript.html
	monFichier.close();*/
	/*File fichier = new File("c:\\fichier.txt") ; 
PrintWriter out = new PrintWriter(new FileWriter(fichier)) ; 
out.write("Bonjour") ; //écris bonjour dans le fichier 
out.println() ; //fais un retour à la ligne dans le fichier 
out.write("Comment allez vous") ; //écris dans le fichier 
out.close() ; */
	System.exit(0);//this.dispose(); // tout fermer
	}
	
	public void saveBatiment(Batiment b){
		buildings.add(b);
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
