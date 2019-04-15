import java.util.ArrayList; 

public abstract class  Batiment{
	double coef;
	ArrayList <Depenses> liste = new ArrayList();
	int niveau;
	int[] x;
	int[] y;
	String image;
	
	public Batiment (int x, int y){
		this.x= new int[1];
		this.y=new int[1];
		this.x[0]=x;
		this.y[0]=y;
	}
	
	public void fusion(Batiment b, Map m){
		if (this.image == b.image && this.niveau <=3){
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
			this.trouverPosition(m);
		} else {
			System.out.println("Impossible à fusionner");
		}
	}
	
	public abstract void attribuerIm();

	public void trouverPosition(Map m){
		do{
			int xRandom = (int) (Math.random()*11);
			int yRandom = (int) (Math.random()*11);
			for (int i=0; i<this.x.length;i++){
				this.x[i]=xRandom+i;
			}
			for (int i=0; i<this.y.length;i++){
				this.y[i]=yRandom+i;
			}
		} while (!m.testPresence(this));
	}
	
	public void deplacer(int newx, int newy){
		x[0]=newx;
		y[0]=newy;
	}
	
	
	public String toString(){
		return ("Construction d'un bâtiment de niveau " + niveau + " de coefficient " + coef + " à la position (" + x + "," + y + ")") ;
	}
}

