/******************************************************************************
 *  Compilation:  javac LeastSquares.java
 *  Execution:    java LeastSquares
 *  Dependencies: Draw.java DrawListener.java
 * 
 *  Plots the points that the user clicks, and plots the least squares
 *  line through them.
 *
 ******************************************************************************/

import java.awt.Color;

public class LeastSquares {
    int N = 0;
    double sumx  = 0.0;                     // sum { x[i],      i = 1..n
    double sumy  = 0.0;                     // sum { y[i],      i = 1..n
    double sumx2 = 0.0;                     // sum { x[i]*x[i], i = 1..n
    double sumy2 = 0.0;                     // sum { y[i]*y[i], i = 1..n
    double sumxy = 0.0;                     // sum { x[i]*y[i], i = 1..n
    double[] x;
    double[] y;


    public LeastSquares(double [] xx, double [] yy) {
        this.x=xx;
        this.y=yy;
        
    }

    public double[] tabCourbe() {
        N=x.length;
        double[]retour=new double[2];
        for (int i=0 ; i<N;i++){
			
			sumx  += x[i];
			sumy  += y[i];
			sumx2 += x[i]*x[i];
			sumy2 += y[i]*y[i];
			sumxy += x[i]*y[i];
		}


        // draw the least squares line
        double a = (N*sumxy - sumx*sumy) / (N*sumx2 - sumx*sumx);
        double b = (sumy - a*sumx) / N;
        System.out.println("*********************"+a+"********************");
        System.out.println("*********************"+b+"********************");
        retour[0]=a;
        retour[1]=b;
        return retour;
	}

 

   
}
