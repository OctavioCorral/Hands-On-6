package multiplelinearregressionjade;

public class matrizxTra {
            
    //Transponiendo la matriz X 
        public double [][] matrizxTra(double matrizx[][]){
            
            double[][] matrizxT = new double [3][17];
       
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 17; j++) {
                matrizxT[i][j] = matrizx[j][i];
            }
        }
        System.out.println("\nLa martiz transpuesta de X es: ");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 17; j++) {
                System.out.print(matrizxT[i][j] + " ");
            }
            System.out.println("");
        }

        return matrizxT;
    }
    
}