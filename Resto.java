public class Resto extends Batiment {
	
	public Resto (int x, int y){
		super (x,y);
		coef = 0.1;
		switch (niveau){
			case 1:
			image = "\"media"+"\1";	
			coef = 0.2;
			break;
			/*case 2:
			image = 
			break;
			case 3:
			image =
			break;*/
		}
			
		
	}
	
	public String toString(){
		return " : Restaurant ";
	}
	
	
}

