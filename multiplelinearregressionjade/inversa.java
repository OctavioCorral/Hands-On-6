package multiplelinearregressionjade;


/**
 *
 * @author Tavin
 */
public class inversa{
    
    
    public double determinante(double matrizxT[][]){
    
            double det1, det2, det3,resultado;
            det1 =  ((matrizxT[1][1] * matrizxT[2][2]) - (matrizxT[2][1] * matrizxT[1][2])) * matrizxT[0][0];
            det2 =  ((matrizxT[1][0] * matrizxT[2][2]) - (matrizxT[2][0] * matrizxT[1][2])) *-matrizxT[0][1];
            det3 =  ((matrizxT[1][0] * matrizxT[2][1]) - (matrizxT[2][0] * matrizxT[1][1])) * matrizxT[0][2];
            resultado = det1+det2+det3;
            
            return resultado;
        
      
        }
    
   
    
    public double[][] adjunta(double matrizxT[][]) {
        double adj[][] = new double[3][3];
        adj[0][0] = ((matrizxT[1][1] * matrizxT[2][2])) - ((matrizxT[2][1] * matrizxT[1][2]));
        adj[0][1] = -1 * (((matrizxT[1][0] * matrizxT[2][2])) - ((matrizxT[2][0] * matrizxT[1][2])));
        adj[0][2] = (matrizxT[1][0] * matrizxT[2][1]) - (matrizxT[2][0] * matrizxT[1][1]);
        adj[1][0] = -1 * ((matrizxT[0][1] * matrizxT[2][2]) - (matrizxT[2][1] * matrizxT[0][2]));
        adj[1][1] = (matrizxT[0][0] * matrizxT[2][2]) - (matrizxT[2][0] * matrizxT[0][2]);
        adj[1][2] = -1 * ((matrizxT[0][0] * matrizxT[2][1]) - (matrizxT[2][0] * matrizxT[0][1]));
        adj[2][0] = (matrizxT[0][1] * matrizxT[1][2]) - (matrizxT[1][1] * matrizxT[0][2]);
        adj[2][1] = -1 * ((matrizxT[0][0] * matrizxT[1][2]) - (matrizxT[1][0] * matrizxT[0][2]));
        adj[2][2] = (matrizxT[0][0] * matrizxT[1][1]) - (matrizxT[1][0] * matrizxT[0][1]);
        return adj;
    }
   
    
     public double[][] inversa(double matrizxT[][]) {
         //adjunta adjunta = new adjunta();
         

        //Filas y Columans de la  matriz adjumta y la determinante
        double det = determinante(matrizxT);
        double adj[][] = adjunta(matrizxT);

        //Filas y Columans de la adjunta
        int filas = adj.length;
        int columnas = adj[0].length;

        double[][] resultadoinv = new double[filas][columnas];

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                resultadoinv[i][j] = adj[i][j] / det;
            }
        }
        return resultadoinv;
        
        

    }
    
     
     
}
