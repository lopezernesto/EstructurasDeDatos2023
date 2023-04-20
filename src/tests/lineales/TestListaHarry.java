package tests.lineales;
import lineales.dinamicas.Lista;
public class TestListaHarry {
    public static void main(String[] arg){
        
        Lista lista1 = new Lista();
        Lista lista2 = new Lista();
        /* for (int i = 1; i <= 5; i++) {
            lista1.insertar(i, i);
        }*/
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

      
    }
}
