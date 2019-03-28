import java.util.ArrayList; 

public abstract class  Batiment{
	double coef;
	ArrayList <Depenses> liste = new ArrayList();
	int niveau;
	int []x;
	int []y;
	String image;
	
	public Batiment (int x, int y){
		this.x[0]=x;
		this.y[0]=y;
	}
	
	public void fusion(Batiment b){
		if (this.image == b.image & this.niveau <=3){
			b.image = "0";
			this.liste.addAll(b.liste);
			this.niveau ++;
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
			this.coef +=0.1;
			this.attribuerIm();
		} else {
			System.out.println("Impossible à fusionner");
		}
	}
	
	public abstract void attribuerIm();	
	
	public void deplacer(int newx, int newy){
		x[0]=newx;
		y[0]=newy;
	}
	
	
	public String toString(){
		return ("Construction d'un bâtiment de niveau " + niveau + " de coefficient " + coef + " à la position (" + x + "," + y + ")") ;
	}
}

