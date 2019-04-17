public class Maison extends Batiment{
	
	public Maison (int x, int y){
		super (x,y);
	}
	public void attribuerIm(){
		switch (niveau){
			case 1:
			image = null;
			break;
			case 2:
			image = null;
			break;
			case 3:
			image =null;
			break;
		}
	}
	
	public String toString(){
		return "3";
	}
	
}

