public class Resto extends Batiment {
	
	public Resto (int x, int y){
		super (x,y);
	}
		
	
	public void attribuerIm(){
		switch (niveau){
			case 0:
			image = images.resto1;
			break;
			case 1:
			image = images.resto2;
			break;
			case 2:
			image =images.resto3;
			break;
		}
	}
	
	public String toString(){
		return "2";
	}
	
	
}

