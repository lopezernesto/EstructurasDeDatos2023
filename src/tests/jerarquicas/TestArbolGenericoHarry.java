package tests.jerarquicas;

import jerarquicas.*;

public class TestArbolGenericoHarry {
    public static void main(String[] arg) {
        ArbolGen arbol1 = new ArbolGen();
       
            arbol1.insertar('A', null);
            arbol1.insertar('B', 'A');
            arbol1.insertar('C', 'A');
            arbol1.insertar('D', 'A');
            arbol1.insertar('E', 'B');
            arbol1.insertar('F', 'B');
            arbol1.insertar('G', 'B');
            arbol1.insertar('H', 'D');
            
        System.out.println(arbol1.toString());

    }
}
