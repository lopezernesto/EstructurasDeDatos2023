package tests.lineales;
import java.util.List;

import javax.swing.SpinnerDateModel;

import lineales.dinamicas.Lista;
public class TestListaHarry {
    public static void main(String[] arg){
        
        Lista lista1 = new Lista();
        
        for(int i=1;i<10;i++){
            lista1.insertar(i, i);
        }
        System.out.println(lista1.toString());
        
        Lista lista2= lista1.obtenerMultiplos(2);
        System.out.println(lista2.toString());
        //lista1.eliminarApariciones(6);
        //System.out.println(lista1.toString());
        
        //9,6,5,0,9,6,5,0,5,6,9
        

    }
}
