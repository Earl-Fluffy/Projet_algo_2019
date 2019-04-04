import java.util.ArrayList;
import javax.swing.Timer;
import java.awt.event.*;
import java.io.*;

public class Map implements ActionListener{
	public ArrayList<Batiment> listBat;
	public Timer time;
	public int argent;
	public boolean[][] positions;
	public ArrayList<Depenses> sommeDepenses;
	Hopital h = new Hopital (50,50);
	
	public Map() {
		listBat= new ArrayList<Batiment>();
		time=new Timer (30000,this);
		positions = new boolean[6][12];
		listBat.add(h);
	}
	
	public ArrayList<Depenses> sommer (){
		ArrayList <Depenses> sum = new ArrayList <Depenses>();
		for (Batiment b :listBat){
			for (Depenses d : b.liste){
				sum.add(d);
			}
		}
		return sum;
	}
	
	public void save (){
	 String save = " ";
	  for (Batiment b : listBat){
		  save+= String.valueOf(b.x)+String.valueOf(b.y)+b.image+"\n";
	  }
	   
	  try {

            appendFile(save);
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

    public static void appendFile(String fileContent) throws IOException
    {
        String thisLine;
        String res="";
        BufferedReader tBuff = new BufferedReader(new FileReader(TestMain.class.getResource("media/tDoc.txt").getPath()));
        while ((thisLine = tBuff.readLine()) != null) {
            res +="\n"+ thisLine;
        }
        tBuff.close();
        usingBufferedWritter(res + "\n" + fileContent);
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
}
