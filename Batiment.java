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
	
	public void fusion(Batiment b1, Batiment b2){
		
	}
	
	public void deplacer(int newx, int newy){
		x=newx;
		y=newy;
	}
	
	public double genereArgent(){
		return 1;
	}
	
	public String toString(){
		return ("Construction d'un bâtiment de niveau " + niveau + " de coefficient " + coef + " à la position (" + x + "," + y + ")") ;
	}
}

