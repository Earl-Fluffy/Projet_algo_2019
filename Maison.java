public class Maison extends Batiment{
	
	public Maison (int x, int y){
		super (x,y);
	}
	public void attribuerIm(){
		switch (niveau){
			case 0:
			image = images.maison1;
			break;
			case 1:
			image = images.maison2;
			break;
			case 2:
			image =images.maison3;
			break;
		}
	}
	
	public String toString(){
		return "3";
	}
	
}

