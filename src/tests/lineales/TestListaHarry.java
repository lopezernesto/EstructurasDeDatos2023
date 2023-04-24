package tests.lineales;
import java.util.List;

import javax.swing.SpinnerDateModel;

import lineales.dinamicas.Lista;
public class TestListaHarry {
    public static void main(String[] arg){
        
        Lista lista1 = new Lista();
        
        lista1.insertar(9, 1);
        lista1.insertar(6, 2);
        lista1.insertar(5, 3);
        lista1.insertar(0, 4);
        lista1.insertar(9, 5);
        lista1.insertar(6, 6);
        lista1.insertar(5, 7);
        lista1.insertar(0, 8);
        lista1.insertar(5, 9);
        lista1.insertar(6, 10);
        lista1.insertar(9, 11);
        System.out.println(lista1.toString());
        System.out.println(lista1.comprobar(lista1));
        
        //9,6,5,0,9,6,5,0,5,6,9
        

    }
}
