public class Parc extends Batiment{
	
	public Parc (int x, int y){
		super (x,y);
	}
	
	public void attribuerIm(){
		switch (niveau){
			case 0:
			image = null;
			break;
			case 1:
			image = null;
			break;
			case 2:
			image =null;
			break;
		}
	}
	
	public String toString(){
		return "4";
	}
	
}

