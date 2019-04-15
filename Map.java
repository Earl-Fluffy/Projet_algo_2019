import java.util.LinkedList;
import java.util.ArrayList;
import javax.swing.Timer;
import java.awt.event.*;
import java.io.*;
import java.util.Collections;

public class Map implements ActionListener{
	public ArrayList<Batiment> listBat;
	public Timer time;
	public int argent;
	public boolean[][] positions;
	public LinkedList<Depenses> sommeDepenses;
	Hopital h = new Hopital (50,50);
	
	public Map(String[][] batACreer) {
		listBat= new ArrayList<Batiment>();
		if(!batACreer[0][0].equals("")) {
			listBat.addAll(creerBat(batACreer));
		}
		time=new Timer (30000,this);
		positions = new boolean[10][10];
		//listBat.add(h);

		for(int i=0;i<listBat.size();i++) {
			System.out.println(listBat.get(i));
		}
	}
	
	public LinkedList<Depenses> sommer (){
		LinkedList <Depenses> sum = new LinkedList <Depenses>();
		for (Batiment b :listBat){
			for (Depenses d: b.liste){
				sum.add(d);
			}
		}
		Collections.sort(sum);
		return sum;
	}
	
	public void save (){
	 String save="";
	  for (Batiment b : listBat){
		  save+= (b.x[0])+ ";" + (b.y[0])+";"+(b.niveau)+ ";" + b.toString() + "\n";
	  }
	   System.out.println(save);
	  try {
            usingBufferedWritter(save);
        } catch (FileNotFoundException u) {
            u.printStackTrace();
        } catch (IOException u) {
            u.printStackTrace();
        }
	}
	
	 public static void usingBufferedWritter(String fileContent) throws IOException
    {


        BufferedWriter writer = new BufferedWriter(new FileWriter(TestMain.class.getResource("media/tDoc.txt").getPath()));
        // !!!!!! Ne pas toucher sinon mort potentielle du PC
        writer.write(fileContent);
        writer.close();
    }

        
	public boolean testPresence(Batiment bat){
		for (int i=0; i<bat.x.length;i++){
			for(int j=0;j<bat.y.length;j++){
				if (positions[j][i]){
					return false;
				}
			}
		}
		return true;
	}
	
	public boolean ajoutBat(Batiment ajout){
		boolean possible=testPresence(ajout);
		if(possible){
			listBat.add(ajout);
		}
		return possible;
	}
	
	public boolean deplacementBat(Batiment bat, int newX, int newY){
		int x=bat.x[0];
		int y=bat.y[0];
		bat.deplacer(newX,newY);
		if (testPresence(bat)){
			return true;
		} else {
			bat.deplacer(x,y);
			return false;
		}
		
	}
	
	private void gagneArgent(){
		for (int i=0; i<listBat.size();i++){
			argent = argent + (int)listBat.get(i).coef;
		}
	}
	
	public void gagneArgentLaunch(){
		
	}
	
	public void actionPerformed(ActionEvent e){
		
	}

	public Batiment quelTypeBatiment(String[] batimentCode){
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
	
	public ArrayList<Batiment> creerBat (String [][] infoBat){
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
