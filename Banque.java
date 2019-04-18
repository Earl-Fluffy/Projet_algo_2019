public class Banque extends Batiment{
	
	public Banque (int x, int y){
		super (x,y);
	}	
	public void attribuerIm(){
		switch (niveau){
			case 0:
			image = images.banque1;
			break;
			case 1:
			image = images.banque2;
			break;
			case 2:
			image =images.banque3;
			break;
		}
	}
	
	public String toString(){
		return "6";
	}
	
}


