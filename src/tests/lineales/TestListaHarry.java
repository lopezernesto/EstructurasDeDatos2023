package tests.lineales;
import java.util.List;

import javax.swing.SpinnerDateModel;

import lineales.dinamicas.Lista;
public class TestListaHarry {
    public static void main(String[] arg){
        
        Lista lista1 = new Lista();
        Lista lista2 = new Lista();
         for (int i = 1; i <= 5; i++) {
            lista2.insertar(i, i);
        }
        lista1.insertar(0, 1);
        lista1.insertar(9, 2);
        lista1.insertar(8, 3);
        lista1.insertar(7, 4);
        lista1.insertar(6, 5);
        lista1.insertar(5, 6);
        lista1.insertar(4, 7);
        lista1.insertar(3, 8);
        lista1.insertar(2, 9);
        lista1.insertar(0, 10);
        System.out.println("Lista 1: "+lista1.toString());
        System.out.println("Lista 2:"+lista2.toString());
        //System.out.println("Lista 1 invertida: "+(lista1.invertir(lista1)).toString());
        Lista lista3= new Lista();
        lista3=lista3.concatenar(lista1,lista2);
        System.out.println("Lista 1+Lista 2: "+lista3.toString());
        
        

    }
}
