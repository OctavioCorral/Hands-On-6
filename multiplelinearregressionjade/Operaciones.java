//Octavio Corral Tovar 5to "A" Sistemas
//No. Control 19011234

package multiplelinearregressionjade;

/**
 *
 * @author Tavin
 */
class Operaciones {

    double matrizx[][] = {{1, 41.9, 29.1}, {1, 43.4, 29.3}, {1, 43.9, 29.5}, {1, 44.5, 29.7}, {1, 47.3, 29.9},
    {1, 47.5, 30.3}, {1, 47.9, 30.5}, {1, 50.2, 30.7}, {1, 52.8, 30.8}, {1, 53.2, 30.9},
    {1, 56.7, 31.5}, {1, 57.0, 31.7}, {1, 63.5, 31.9}, {1, 65.3, 32.0}, {1, 71.1, 32.1},
    {1, 77.0, 32.5}, {1, 77.8, 32.9}};

    double matrizxT[][] = new double[3][17];

    double matrizy[][] = {{251.3}, {251.3}, {248.3}, {267.5}, {273.0}, {276.5}, {270.3}, {274.9}, {285.0}, {290.0},
    {297.0}, {302.5}, {304.5}, {309.3}, {321.7}, {330.7}, {349.0}};

    double resultadoxty[][] = new double[3][3];

    int i = 0, j = 0;

    //Imprime la matriz X
    public void matrizX(double matrizx[][]) {
        System.out.print("n   Xi1  Xi2\n");

    }

    //Imprime la matriz Y
    public void matrizY(double matrizy[][]) {
        System.out.print(" Yi\n");
        for (i = 0; i < 17; i++) { // Filas
            for (j = 0; j < 1; j++) { // Columnas
                System.out.print(matrizy[i][j] + " ");
            }
            System.out.println("");
        }

    }

    //Transponiendo la matriz X 
    public double[][] matrizxTra() {

        for (i = 0; i < 3; i++) {
            for (j = 0; j < 17; j++) {
                matrizxT[i][j] = matrizx[j][i];
            }
        }
        System.out.println("\nLa martiz transpuesta de X es: ");
        for (i = 0; i < 3; i++) {
            for (j = 0; j < 17; j++) {
                System.out.print(matrizxT[i][j] + " ");
            }
            System.out.println("");
        }

        return matrizxT;
    }

    public double[][] xTx(double[][] matrizxT, double[][] matrizx) {
        //Filas y Columans de la primera matriz
        int filas = matrizxT.length;
        int columnas = matrizxT[0].length;

        //Filas y Columans de la Segunda Matriz
        int filas2 = matrizx.length;
        int columnas2 = matrizx[0].length;

        double[][] resultadoxtx = new double[filas][columnas2];

        for (i = 0; i < filas; i++) {
            for (j = 0; j < columnas2; j++) {
                for (int k = 0; k < columnas; k++) { //Recorre las columnas de la primera matriz
                    resultadoxtx[i][j] += matrizxT[i][k] * matrizx[k][j];
                } 
            }
        }
        return resultadoxtx;
    }

    public double determinante(double matrizxT[][]) {

        double det1, det2, det3, resultado;
        det1 = ((matrizxT[1][1] * matrizxT[2][2]) - (matrizxT[2][1] * matrizxT[1][2])) * matrizxT[0][0];
        det2 = ((matrizxT[1][0] * matrizxT[2][2]) - (matrizxT[2][0] * matrizxT[1][2])) * -matrizxT[0][1];
        det3 = ((matrizxT[1][0] * matrizxT[2][1]) - (matrizxT[2][0] * matrizxT[1][1])) * matrizxT[0][2];
        resultado = det1 + det2 + det3;

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

        //Filas y Columans de la  matriz adjumta y la determinante
        double det = determinante(matrizxT);
        double adj[][] = adjunta(matrizxT);

        //Filas y Columans de la adjunta
        int filas = adj.length;
        int columnas = adj[0].length;

        double[][] resultadoinv = new double[filas][columnas];

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                resultadoinv[i][j] = adj[i][j] / det;  //Cada elemento de la matriz se divivde entre la determinante
            }
        }
        return resultadoinv;

    }

    public void imprimir(double resultadoxtx[][]) {

        double fila = resultadoxtx.length;
        double columna = resultadoxtx[0].length;

        for (int i = 0; i < fila; i++) {
            for (int j = 0; j < columna; j++) {
                System.out.print(resultadoxtx[i][j] + " ");

            }
            System.out.println("");

        }

    }
        
        
      
    
}
