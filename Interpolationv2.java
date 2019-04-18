 /* Classe objet permettant de faire une interpolation à partir de tableau de point, et notament de récupérer les coefficients
  */



public class Interpolationv2{ 
	private double[]x;
	private Matrix y;
	private Matrix matVandermonde;  // Matrice de Vandermonde
	private double [] coeffs;
	
	public Interpolationv2(double [] xx, double[] yy){    // Constructeur, avec deux tableaux de points x et y=f(x)
		
		x=xx;
		
		// Création de matrice y avec les points yy (matrice n lignes et 1 colone)
		y=new Matrix(yy.length,1);
		System.out.println(y);
		for (int i=0; i<yy.length;i++){
			y.set(i,0,yy[i]);
			System.out.println(y.get(i,0));
		}
		
		// Initialisation de la matrice de Vandermonde suivant sa définition
		matVandermonde=new Matrix(x.length ,yy.length);
		for(int i=0;i<x.length;i++){
			for(int j=0;j<x.length;j++){
				matVandermonde.set(i,j,Math.pow(x[i],j));
			}
		}
		
		// Résolution de l'équation V*coeff=Y      V:matrice Vandermonde
		System.out.println("inversible ?  " + matVandermonde.det());
		Matrix coeff=matVandermonde.solve(y);
		coeffs=new double[yy.length];
		for(int i=0;i<yy.length;i++){
			coeffs[i]=coeff.get(i,0);
		}
	}

	public double[] getCoeff(){
		return this.coeffs;
	}
}

