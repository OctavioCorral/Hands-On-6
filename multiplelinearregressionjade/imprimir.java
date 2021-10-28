
package multiplelinearregressionjade;

/**
 *
 * @author Tavin
 */
public class imprimir extends DataSet{
    
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
