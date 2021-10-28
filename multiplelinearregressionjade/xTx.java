/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multiplelinearregressionjade;

/**
 *
 * @author Tavin
 */
public class xTx {
    
    public double[][] xTx(double[][] matrizxT, double[][] matrizx) {
        //Filas y Columans de la primera matriz
        int filas = matrizxT.length;
        int columnas = matrizxT[0].length;

        //Filas y Columans de la Segunda Matriz
        int filas2 = matrizx.length;
        int columnas2 = matrizx[0].length;

        double[][] resultadoxtx = new double[filas][columnas2];

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas2; j++) {
                for (int k = 0; k < columnas; k++) {
                    resultadoxtx[i][j] += matrizxT[i][k] * matrizx[k][j];
                }
            }
        }
        return resultadoxtx;
    }
    
}
