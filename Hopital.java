public class Hopital extends Batiment{
	
public Hopital (int x, int y){
		super (x,y);
	}
		
		public void attribuerIm(){
			switch (niveau){
			case 0:
			image = images.hopital1;
			break;
			case 1:
			image = images.hopital2;
			break;
			case 2:
			image =images.hopital3;
			break;
		}
		
	}
	
	public String toString(){
		return "1";
	}
	
	
}

