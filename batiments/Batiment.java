import java.util.LinkedList;

public class Batiment{
	double coef;
	LinkedList <Depenses> liste = new LinkedList();
	int niveau;
	int x;
	int y;
	
	public Batiment (int x, int y){
		this.x=x;
		this.y=y;
	}
	
	public void fusion(){
		
	}
	
	public void deplacer(){
	}
	
	public double genereArgent(){
		return 1;
	}
	
	public String toString(){
		return ("Construction d'un bâtiment de type de niveau " + niveau + " de coefficient " + coef + " à la position ?") ;
	}
}

