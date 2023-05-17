package jerarquicas;

import lineales.dinamicas.*;

public class ArbolGen {
    private NodoGen raiz;

    public ArbolGen() {
        raiz = null;
    }

    public boolean insertar(Object elemNuevo, Object elemPadre) {
        boolean exito = false;
        if (esVacio()) {
            raiz.setElem(elemNuevo);
            exito = true;
        } else {
            NodoGen nodo = obtenerNodo(this.raiz, elemPadre);
            if (nodo != null) {
                NodoGen nodoTemp = nodo.getHijoIzquierdo();
                if (nodoTemp == null) {
                    nodo.setHijoIzquierdo(new NodoGen(elemNuevo, null, null));
                } else {
                    nodoTemp.setHermanoDerecho(new NodoGen(elemNuevo, null, null));
                    nodo.setHijoIzquierdo(nodoTemp);
                }
                exito = true;
            }

        }
        return exito;
    }

    public boolean esVacio() {
        return this.raiz == null;
    }

    public Lista ancestros(Object elem){
        Lista l=new Lista();
        if(pertenece(elem)==true && !this.raiz.getElem().equals(elem)){
            ancestrosAux(elem,this.raiz,l);
        }
        return l;
    }
    private void ancestrosAux(Object elem, NodoGen n,Lista l){

    }

    public boolean pertenece(Object elemento) {
        return perteneceAux(elemento, this.raiz);
    }

    private boolean perteneceAux(Object elemento, NodoGen nodo) {
        boolean encontrado = false;
        // mientras el arbol no sea nulo que busque
        if (nodo != null) {
            // si lo encuentra en la raiz retorna true sino lo busca en el hijo izquierdo
            if (nodo.getElem().equals(elemento)) {
                encontrado = true;
            } else {
                // si tiene hijo izquierdo que busque en el hijo izquierdo
                if (nodo.getHijoIzquierdo() != null) {
                    perteneceAux(elemento, nodo.getHijoIzquierdo());
                } else {
                    perteneceAux(elemento, nodo.getHermanoDerecho());
                }
            }
        }
        return encontrado;
    }

    private NodoGen obtenerNodo(NodoGen n, Object elem) {
        NodoGen nodoTemp = null;
        if (n != null) {
            // si es distinto de nulo
            if (n.getElem().equals(elem)) {
                // llegue al nodo que busco, se corta el ciclo
                nodoTemp = n;
            } else {
                n = obtenerNodo(n.getHijoIzquierdo(), elem);
                // avanza al hijo izquierdo
                if (nodoTemp == null) {
                    nodoTemp = obtenerNodo(n.getHermanoDerecho(), elem);
                    // busca recursivamente en sus hermanos
                }
            }
        }
        return nodoTemp;
    }
    
    public Object padre (Object elemento){
        Object resultado;
        NodoGen aux;
        //caso especial: la primer aparicion del elem es la raiz (no tiene padre)
        if(raiz.getElem().equals(elemento) || esVacio()){
            resultado=null;
        }
        else{
            aux=padreAux(elemento, this.raiz);
            resultado=aux.getElem();
        }
        return resultado;
    }
    private NodoGen padreAux(Object elemento, NodoGen nodo){        
        NodoGen pos=null;
        //si no es vacio
        if(nodo != null){
            //si esta justo en el hijo izquierdo, guardo el nodo padre
            if(nodo.getHijoIzquierdo().getElem().equals(elemento)){
                pos=nodo;
            }
            else{
                //sino busca en los demas hijos izquierdos
                pos=padreAux(elemento, nodo.getHijoIzquierdo());
            }                
            if (pos==null){
                //si pos e
                pos=padreAux(elemento, nodo.getHermanoDerecho());
            }
        }
        
        return pos;
        
    }

    public Lista listarInorden() {
        Lista l = new Lista();
        listarInordenAux(this.raiz, l);
        return l;
    }

    private void listarInordenAux(NodoGen n, Lista ls) {
        if (n != null) {
            // llamado recursivo con primer hijo de n
            if (n.getHijoIzquierdo() != null) {
                listarInordenAux(n.getHijoIzquierdo(), ls);
            }
            // visita del nodo n
            ls.insertar(n.getElem(), ls.longitud() + 1);
            if (n.getHijoIzquierdo() != null) {
                NodoGen hijo = n.getHijoIzquierdo().getHermanoDerecho();
                while (hijo != null) {
                    listarInordenAux(hijo, ls);
                    hijo = hijo.getHermanoDerecho();
                }
            }
        }
    }
}
