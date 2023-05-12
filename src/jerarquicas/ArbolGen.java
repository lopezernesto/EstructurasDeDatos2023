package jerarquicas;
import lineales.dinamicas.*;
public class ArbolGen {
    private NodoGen raiz;
    public ArbolGen(){
        raiz=null;
    }
    

    public boolean insertar(NodoGen elemNuevo,NodoGen elemPadre){
        boolean exito=false;
        if(esVacio()){
            raiz.setElem(elemNuevo);
            exito=true;
        }else{

        }
        return exito;
    }
    public boolean esVacio(){
        return this.raiz==null;
    }
    private NodoGen obtenerNodo(NodoGen n,Object elem){
        
    }
    public Lista listarInorden(){
        Lista l=new Lista();
        listarInordenAux(this.raiz,l);
        return l;
    }
    private void listarInordenAux(NodoGen n, Lista ls){
        if(n!=null){
            //llamado recursivo con primer hijo de n
            if(n.getHijoIzquierdo()!=null){
                listarInordenAux(n.getHijoIzquierdo(), ls);
            }
            //visita del nodo n
            ls.insertar(n.getElem(), ls.longitud()+1);
            if(n.getHijoIzquierdo()!=null){
                NodoGen hijo=n.getHijoIzquierdo().getHermanoDerecho();
                while(hijo!=null){
                    listarInordenAux(hijo, ls);
                    hijo=hijo.getHermanoDerecho();
                }
            }
        }
    }
}
