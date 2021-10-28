//Octavio Corral Tovar 5to "A" Sistemas
//No. Control 19011234

package multiplelinearregressionjade;
import jade.core.Agent;
import jade.core.behaviours.OneShotBehaviour;

/**
 *
 * @author Tavin
 */
public class MultipleLinearRegressionJADE extends Agent{

    @Override
    protected void setup(){
        
        System.out.println("Agente "+getLocalName()+" iniciado");
        addBehaviour(new MyOneShotBehaviour());
    }
        
    private class MyOneShotBehaviour extends OneShotBehaviour {

    @Override
    public void action() {
       Operaciones operacion = new Operaciones();
        
        double matrizx[][] = {{1,41.9,29.1},{1,43.4,29.3},{1,43.9,29.5},{1,44.5,29.7},{1,47.3,29.9},
                             {1,47.5,30.3},{1,47.9,30.5},{1,50.2,30.7},{1,52.8,30.8},{1,53.2,30.9},
                             {1,56.7,31.5},{1,57.0,31.7},{1,63.5,31.9},{1,65.3,32.0},{1,71.1,32.1},
                             {1,77.0,32.5},{1,77.8,32.9}};
        
        double matrizxT[][];
        double matrizy[][] = {{251.3},{251.3},{248.3},{267.5},{273.0},{276.5},{270.3},{274.9},{285.0},{290.0},
                             {297.0},{302.5},{304.5},{309.3},{321.7},{330.7},{349.0}};
        
        double resultadoxtx[][];
        double resultadoxty[][];
        double resultadodet;
        double adj[][];
        double inv[][];
        double bet[][];
        
  
        System.out.print("\nLa matriz X es: \n");
        operacion.imprimir(matrizx);
        
        matrizxT = operacion.matrizxTra();
        
        System.out.print("\nLa matriz Y es: \n");
        operacion.matrizY(matrizy);
        
        System.out.print("\nLa matriz XT*X es: \n"); 
        resultadoxtx = operacion.xTx(matrizxT, matrizx);
        operacion.imprimir(resultadoxtx);
        
        System.out.print("\nLa matriz XT*Y es: \n");
        resultadoxty = operacion.xTx(matrizxT, matrizy);
        operacion.imprimir(resultadoxty);
        
        System.out.print("\nLa determinante de XT es: \n");
        resultadodet = operacion.determinante(resultadoxtx);
        System.out.println(resultadodet);
        
        System.out.print("\nLa Adjunta de XT es: \n");
        adj = operacion.adjunta(resultadoxtx);
        operacion.imprimir(adj);
        
        System.out.print("\nLa inversa de XT es: \n");
        inv = operacion.inversa(resultadoxtx);
        operacion.imprimir(inv);
        
        System.out.print("\nLas betas son: \n");
        bet = operacion.xTx(inv,resultadoxty);
        operacion.imprimir(bet);
        
    } 
    @Override
    public int onEnd() {
        System.out.println("\nAgente Muerto");
      myAgent.doDelete();   
      return super.onEnd();
    } 
  }
    
    
}
