public class Gare extends Batiment{
	
	public Gare (int x, int y){
		super (x,y);
	}
	public void attribuerIm(){
		switch (niveau){
			case 0:
			image = images.gare1;
			break;
			case 1:
			image = images.gare2;
			break;
			case 2:
			image =images.gare3;
			break;
		}
	}
	
	public String toString(){
		return "7";
	}
	
}

