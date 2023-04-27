package tests.jerarquicas;
import jerarquicas.*;
public class TestArbol {
    public static void main(String[] arg){
        Arbol arbol1= new Arbol();
        arbol1.insertar(1, null, 'I');
        
        arbol1.insertar(2, 1, 'I');
        arbol1.insertar(4, 1, 'D');
        System.out.println(arbol1.toString());

    }
        
}
