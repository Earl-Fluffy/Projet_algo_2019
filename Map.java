import java.util.LinkedList;
import java.util.ArrayList;
import javax.swing.Timer;
import java.awt.event.*;
import java.io.*;
import java.util.Collections;

public class Map implements ActionListener{
	public ArrayList<Batiment> listBat;
	public Timer time; //Permet de récolter l'argent à intervalle donné
	public long argent;
	public boolean[][] positions; //Indique les positions occupées et libres. Libre == true
	
	public Map(String[][] batACreer) {
		listBat= new ArrayList<Batiment>();
        positions = new boolean[10][10];
		if(!batACreer[0][0].equals("")) { //Si il y a des bâtiments archivés à recréer
			ArrayList<Batiment> batArchives=creerBat(batACreer);
		    listBat.addAll(batArchives);
			for (Batiment bat : batArchives){
			    modifierPresence(false,bat);
            }
		}
		time=new Timer (300000,this); //Argent sera récolté toutes les 5 minutes


		//Test des batiments (à supprimer)
		for(int i=0;i<listBat.size();i++) {
			System.out.println(listBat.get(i));
		}
	}
	
	public LinkedList<Depenses> sommer (){ //Fonction qui permet de sommer toutes les dépenses enregistrées et de les organiser par date
		LinkedList <Depenses> sum = new LinkedList <Depenses>();
		for (Batiment b :listBat){
			sum.addAll(b.liste);
		}
		Collections.sort(sum);
		return sum;
	}
	
	public void save (){ //Fonction qui permet de sauvegarder toutes les dépenses à la fermeture du programme
	 String save="";
	  for (Batiment b : listBat){
		  save+= (b.x[0])+ ";" + (b.y[0])+";"+(b.niveau)+ ";" + b.toString() + "\n";
	  }
	   //System.out.println(save);
	  try {
            usingBufferedWritter(save,"media/tDoc.txt");
            usingBufferedWritter(""+System.currentTimeMillis(),"media/date.txt");
        } catch (FileNotFoundException u) {
            u.printStackTrace();
        } catch (IOException u) {
            u.printStackTrace();
        }
	}
	
	 public static void usingBufferedWritter(String fileContent,String pathname) throws IOException { //Fonction qui permet d'écrire fileContent dans tDoc

        BufferedWriter writer = new BufferedWriter(new FileWriter(TestMain.class.getResource(pathname).getPath()));
        // !!!!!! Ne pas toucher sinon mort potentielle du PC
        writer.write(fileContent);
        writer.close();
    }

    public void modifierPresence (boolean valeur, Batiment bat){
		for (int i=0; i<bat.x.length;i++){
			for(int j=0;j<bat.y.length;j++){
				positions[bat.y[j]][bat.x[i]]=valeur;
				}
			}
	}

	public boolean testPresence(Batiment bat){ //Fonction qui permet de vérifier si bat (bâtiment) est à une position occupée

		for (int i=0; i<bat.x.length;i++){
			for(int j=0;j<bat.y.length;j++){
			    if(i>9 || j>9){
			        return false;
                }
				if (positions[j][i]){
					return false;
				}
			}
		}
		return true;
	}
	
	public boolean ajoutBat(Batiment ajout){ //Permet d'ajouter un bâtiment à la map et de mettre à jour le tableau des positions
		boolean possible=testPresence(ajout);
		if(testPresence(ajout)){
			listBat.add(ajout);
			modifierPresence(false,ajout);
		}
		return possible;
	}
	
	public boolean deplacementBat(Batiment bat, int newX, int newY){ //Permet de savoit si déplacer un bat est possible et de le faire si oui
		int x=bat.x[0];
		int y=bat.y[0];
		modifierPresence(true,bat);
		bat.deplacer(newX,newY);
		if (testPresence(bat)){
			modifierPresence(false,bat);
			return true;
		} else {
			bat.deplacer(x,y);
			modifierPresence(false,bat);
			return false;
		}
		
	}
	
	private void gagneArgent(){ //Permet de récolter l'argent des batiments
		for (int i=0; i<listBat.size();i++){
			argent = argent + (int)listBat.get(i).niveau*5;
		}
	}
	
	public void gagneArgentLaunch(long tempsEcouleMilli){ //Permet de récupérer l'argent des bâtiments en fonction du temps passé depuis la dernière fois
		for(int i=0;i<listBat.size();i++){
			argent= argent + (long)listBat.get(i).niveau*5*(tempsEcouleMilli/300000);
			System.out.println(argent);
		}
	}

	//Utile ? A voir plus tard
	public void actionPerformed(ActionEvent e){
		
	}

	public Batiment quelTypeBatiment(String[] batimentCode){ //Permet de creer le bon type de bâtiment en fonction de son numéro de catégorie
		Batiment batimentDecode=null;
		switch (Integer.parseInt(batimentCode[3])){
			case 1:
				batimentDecode = new Hopital (Integer.parseInt(batimentCode[0]), Integer.parseInt(batimentCode[1]));
				break;
			case 2:
				batimentDecode = new Resto (Integer.parseInt(batimentCode[0]), Integer.parseInt(batimentCode[1]));
				break;
			case 3 :
				batimentDecode = new Maison (Integer.parseInt(batimentCode[0]), Integer.parseInt(batimentCode[1]));
				break;
			case 4:
				batimentDecode = new Parc (Integer.parseInt(batimentCode[0]), Integer.parseInt(batimentCode[1]));
				break;
			case 5:
				batimentDecode = new Mall (Integer.parseInt(batimentCode[0]), Integer.parseInt(batimentCode[1]));
				break;
			case 6:
				batimentDecode = new Banque (Integer.parseInt(batimentCode[0]), Integer.parseInt(batimentCode[1]));
				break;
			case 7:
				batimentDecode = new Gare (Integer.parseInt(batimentCode[0]), Integer.parseInt(batimentCode[1]));
				break;
			case 8:
				batimentDecode = new Cinema (Integer.parseInt(batimentCode[0]), Integer.parseInt(batimentCode[1]));
				break;
			default:
				System.out.println("batiment non reconnu");
				break;
		}
		return batimentDecode;
	}
	
	public ArrayList<Batiment> creerBat (String [][] infoBat){ //Permet de creer les batiments archivés au lancement à partir du contenu de tDoc traité
		ArrayList<Batiment> reconstruction = new ArrayList <Batiment> ();
		Batiment newBat = null;
		for (int i=0;i<infoBat.length;i++){
			newBat=quelTypeBatiment(infoBat[i]);
			newBat.niveau = Integer.parseInt(infoBat[i][2]);
			reconstruction.add(newBat);
		}

		return reconstruction;
		
	}
}
