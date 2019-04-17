import java.util.ArrayList; 

public abstract class  Batiment{

	ArrayList <Depenses> liste = new ArrayList(); //Liste des dépenses qui ont entrainné la création de ce bâtiment
	int niveau; //Détermine la taille du bâtiment
	int[] x; //Enregistre le(s) x que le batiment occupe
	int[] y; //Pareil pour les y
	String image; //Pathname de l'image correspondant au batiment (selon son type et son niveau)
	
	public Batiment (int x, int y){ //Création à niveau 0
		this.x= new int[1];
		this.y=new int[1];
		this.x[0]=x;
		this.y[0]=y;
		niveau=0;
		this.attribuerIm();
	}
	
	public void fusion(Batiment b, Map m){ //Permet de fusionner 2 bâtiments et de le replacer
		if (this.image == b.image && this.niveau <=3){
			b.image = "0";
			this.liste.addAll(b.liste);
			this.niveau ++;
			switch (niveau){
			case 1:
			this.x= new int[1];
			this.y=new int [1];
			break;
			case 2:
			this.x= new int [2];
			this.y=new int [1];
			break;
			case 3:
			this.x= new int [2];
			this.y=new int [2];
			break;
		}

			this.attribuerIm();
			this.trouverPosition(m);
		} else {
			System.out.println("Impossible à fusionner");
		}
	}
	
	public abstract void attribuerIm(); //Permet d'attribuer l'image correspondant eu niveau du bâtiment

	public void trouverPosition(Map m){ //Permet de trouver une position aléatoire non occupée à un batiment en prenant en compte sa taille
		do{
			int xRandom = (int) (Math.random()*10);
			int yRandom = (int) (Math.random()*10);
			for (int i=0; i<this.x.length;i++){
				this.x[i]=xRandom+i;
			}
			for (int i=0; i<this.y.length;i++){
				this.y[i]=yRandom+i;
			}
		} while (!m.testPresence(this));
	}
	
	public void deplacer(int newx, int newy){ //Permet de déplacer un batiment en prenant en compte sa taille mais sans test préliminaire
		for (int i =0; i<x.length;i++){
			x[0+i]=newx+i;
		}
		for (int i=0;i<y.length;i++) {
			y[0+i] = newy+i;
		}
	}
	
	
	public String toString(){
		return ("Construction d'un bâtiment de niveau " + niveau + " de coefficient " + niveau*5 + " à la position (" + x + "," + y + ")") ;
	}
}

