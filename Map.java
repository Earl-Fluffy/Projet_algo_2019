import java.util.ArrayList;
import javax.swing.Timer;
import java.awt.event.*;

public class Map implements ActionListener{
	public ArrayList<Batiment> listBat;
	public Timer time;
	public int argent;
	public [][]boolean positions;
	
	public Map() {
		listBat= new ArrayList<Batiment>();
		time=new Timer (30000,this);
		positions = new boolean[6][12];
	}
	
	public boolean testPresence(Batiment bat){
		for (int i=0; i<ajout.x.length){
			for(int j=0;j<ajout.y.length){
				if (positions[j][i]==true){
					possible=false;
					break;
				}
			}
		}
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
