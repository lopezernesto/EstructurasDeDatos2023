package jerarquicas;

import lineales.dinamicas.*;

public class ArbolGen {
    private NodoGen raiz;

    public ArbolGen() {
        raiz = null;
    }

    public boolean insertar(Object hijo, Object elemPadre) {
        boolean exito = false;

        if (esVacio()) {
            this.raiz = new NodoGen(hijo, raiz, raiz);
            exito = true;
        } else {
            NodoGen nodo = obtenerNodo(this.raiz, elemPadre);
            if (nodo != null) {
                if(nodo.getHijoIzquierdo()==null){
                    nodo.setHijoIzquierdo(new NodoGen(hijo, null, null));
                }
                exito = true;
            }

        }
        return exito;
    }

    public boolean esVacio() {
        return this.raiz == null;
    }

    public Lista ancestros(Object elem) {
        Lista l = new Lista();
        if (pertenece(elem) == true && !this.raiz.getElem().equals(elem)) {
            ancestrosAux(elem, this.raiz, l);
        }
        return l;
    }

    private void ancestrosAux(Object elem, NodoGen n, Lista l) {

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

    public Object padre(Object elemento) {
        Object resultado;
        NodoGen aux;
        // caso especial: la primer aparicion del elem es la raiz (no tiene padre)
        if (raiz.getElem().equals(elemento) || esVacio()) {
            resultado = null;
        } else {
            aux = padreAux(elemento, this.raiz);
            resultado = aux.getElem();
        }
        return resultado;
    }

    private NodoGen padreAux(Object elemento, NodoGen nodo) {
        NodoGen pos = null;
        // si no es vacio
        if (nodo != null) {
            // si esta justo en el hijo izquierdo, guardo el nodo padre
            if (nodo.getHijoIzquierdo().getElem().equals(elemento)) {
                pos = nodo;
            } else {
                // sino busca en los demas hijos izquierdos
                pos = padreAux(elemento, nodo.getHijoIzquierdo());
            }
            if (pos == null) {
                // si pos e
                pos = padreAux(elemento, nodo.getHermanoDerecho());
            }
        }

        return pos;

    }

    public int altura() {
        int aux = 0;
        // si es vacio, su altura es 0
        if (!esVacio()) {
            aux = alturaAux(raiz);
        }
        return aux;
    }

    private int alturaAux(NodoGen nodo) {
        int alt, altHermano = 0, altHijo = 0;
        // si el nodo es hoja, empieza la cuenta para arriba
        if (nodo == null) {
            alt = 1;
        } else {
            // si tiene hijo busco en el hijo
            if (nodo.getHijoIzquierdo() != null) {
                altHijo = alturaAux(nodo.getHijoIzquierdo()) + 1;
            }
            // sino busco en el hermano
            if (nodo.getHermanoDerecho() != null) {
                altHermano = alturaAux(nodo.getHermanoDerecho()) + 1;
            }
            // si la altura del hijo es mayor a la del hermano, me quedo con la del hijo
            if (altHijo > altHermano) {
                alt = altHijo;
            } else {
                // sino, con la altura del subarbol del hermano
                alt = altHermano;
            }
        }
        return alt;
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

    public String toString() {
        return toStringAux(this.raiz);
    }

    private String toStringAux(NodoGen n) {
        String s = "";
        if (n != null) {
            s += n.getElem().toString() + "->";
            NodoGen hijo = n.getHijoIzquierdo();
            while (hijo != null) {
                s += hijo.getElem().toString() + ",";
                hijo = hijo.getHermanoDerecho();
            }
            hijo = n.getHijoIzquierdo();
            while (hijo != null) {
                s += "\n" + toStringAux(hijo);
                hijo = hijo.getHermanoDerecho();
            }
        }
        return s;
    }
}
