public class Maison extends Batiment{
	
	public Maison (int x, int y){
		super (x,y);
	}
	public void attribuerIm(){
		switch (niveau){
			case 1:
			image = "\"media\"maison n1";	
			break;
			case 2:
			image = "\"media\"maison n2";
			break;
			case 3:
			image ="\"media\"maison n3";
			break;
		}
	}
	
	public String toString(){
		return "3";
	}
	
}

