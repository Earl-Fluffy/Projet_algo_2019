import java.util.LinkedList; 

public class Batiment{
	double coef;
	LinkedList <Depenses> liste = new LinkedList();
	int niveau;
	int []x;
	int []y;
	String image;
	
	public Batiment (int x, int y){
		switch (niveau){
			case 1:
			this.x= new int[1];
			this.y=new int [1];
			break;
			case 2:
			this.x= new int [2];
			this.y=new int [1];
			break;
			case 3:
			this.x= new int [2];
			this.y=new int [2];
			break;
		}
		this.x[0]=x;
		this.y[0]=y;
	}
	
	public void fusion(Batiment b1, Batiment b2){
		
	}
	
	public void deplacer(int newx, int newy){
		x[0]=newx;
		y[0]=newy;
	}
	
	
	public String toString(){
		return ("Construction d'un bâtiment de niveau " + niveau + " de coefficient " + coef + " à la position (" + x + "," + y + ")") ;
	}
}

