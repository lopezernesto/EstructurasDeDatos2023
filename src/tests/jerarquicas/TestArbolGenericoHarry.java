package tests.jerarquicas;

import jerarquicas.*;

public class TestArbolGenericoHarry {
    public static void main(String[] arg) {
        ArbolGen arbol1 = new ArbolGen();
       
            arbol1.insertar(1, null);
            for(int i=1;i<=10;i++){
                arbol1.insertar(i+1, i);
            }

        System.out.println(arbol1.toString());

    }
}
