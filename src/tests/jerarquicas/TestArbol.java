package tests.jerarquicas;
import javax.swing.SpringLayout;
import lineales.dinamicas.*;
import jerarquicas.*;
public class TestArbol {
    public static void main(String[] arg){
        Arbol arbol1= new Arbol();
        arbol1.insertar(1, null, 'I');
        arbol1.insertar(2, 1, 'I');
        arbol1.insertar(5, 2, 'I');
        arbol1.insertar(4, 1, 'D');
        arbol1.insertar(3, 2, 'D');
        arbol1.insertar(6, 4, 'I');
        arbol1.insertar(7, 4, 'D');
        arbol1.insertar(8, 7, 'I');
        arbol1.insertar(9, 8, 'I');
        arbol1.insertar(11, 9, 'I');
        arbol1.insertar(12, 9, 'D');
        arbol1.insertar(10, 11, 'D');

        System.out.println(arbol1.toString());
        //System.out.println("La altura del arbol es: "+arbol1.altura());
        //System.out.println("Nivel debe ser 5: "+arbol1.nivel(11));
        //System.out.println("El padre  debe ser 9: "+arbol1.padre(11));
        System.out.println("El recorrido en PreOrden del arbnol es: "+(arbol1.listarPreorden()).toString());
        //funciona
        System.out.println("El recorrido en Inorden del arbnol es: "+(arbol1.listarInorden()).toString());

        System.out.println("El recorrido en PosOrden del arbnol es: "+(arbol1.listarPosorden()).toString());
        
        System.out.println("El arbol listado por niveles se veria asi: "+ (arbol1.listarNiveles()).toString() );

    }
}
