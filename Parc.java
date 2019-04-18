public class Parc extends Batiment{
	
	public Parc (int x, int y){
		super (x,y);
	}
	
	public void attribuerIm(){
		switch (niveau){
			case 0:
			image = images.parc1;
			break;
			case 1:
			image = images.parc2;
			break;
			case 2:
			image =images.parc3;
			break;
		}
	}
	
	public String toString(){
		return "4";
	}
	
}

