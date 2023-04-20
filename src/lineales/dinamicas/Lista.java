package lineales.dinamicas;

public class Lista {
    private Nodo cabecera;
    private int longitud;

    public Lista() {
        this.cabecera = null;
        this.longitud = 0;
    }

    public boolean insertar(Object nuevoElem, int pos) {
        boolean exito = false;
        if (pos > 0 && pos <= this.longitud + 1) {
            if (pos == 1) {
                cabecera = new Nodo(nuevoElem, this.cabecera);
                exito = true;
            } else {
                Nodo aux = this.cabecera;
                int i = 1;
                while (i < pos - 1) {
                    aux = aux.getEnlace();
                    i++;
                }
                aux.setEnlace(new Nodo(nuevoElem, aux.getEnlace()));
                exito = true;
            }
            longitud++;
        }
        return exito;
    }

    public boolean eliminar(int pos) {
        boolean exito = false;
        if (pos > 0 && pos <= this.longitud) {
            if (pos == 1) {
                this.cabecera = this.cabecera.getEnlace();
            } else {
                Nodo aux = this.cabecera;
                int i = 1;
                while (i < pos - 1) {
                    aux = aux.getEnlace();
                    i++;
                }
                aux.setEnlace(aux.getEnlace().getEnlace());
            }
            exito = true;
            longitud--;
        }
        return exito;
    }

    public int longitud() {
        return this.longitud;
    }

    public boolean esVacia() {
        return longitud == 0;
    }

    public void vaciar() {
        this.cabecera = null;
        this.longitud = 0;
    }

    public Object recuperar(int pos) {
        Object recuperado = null;
        if (pos >= 1 && pos <= this.longitud) {
            if (pos == 1) {
                recuperado = this.cabecera.getElem();
            } else {
                Nodo aux = this.cabecera;
                int i = 0;
                while (i < pos - 2) {
                    aux = aux.getEnlace();
                    i++;
                }
                recuperado = aux.getEnlace().getElem();
            }
        }
        return recuperado;
    }

    public int localizar(Object buscado) {
        int pos = -1;
        if (!this.esVacia()) {
            int i = 1;
            Nodo aux = this.cabecera;
            while (aux != null && !aux.getElem().equals(buscado)) {
                // mientras no llegue al final y no encuentre el objeto avanzo
                aux = aux.getEnlace();
                i++;
            }
            if (aux != null) {
                // si se corto porque encontro el objeto retorna el nodo donde se encuentra el
                // buscado
                pos = i;
            }
        }
        return pos;
    }
    // a

    public Lista clone() {
        Lista listaClon = new Lista();
        if (!esVacia()) {
            listaClon.cabecera = new Nodo(this.cabecera.getElem(), null);
            // asigno a lista clon mi cabecera sin enlace
            cloneAux(listaClon.cabecera, this.cabecera.getEnlace());
            // clona los nodos recursivamente
            listaClon.longitud = this.longitud;
        }
        return listaClon;
    }

    private void cloneAux(Nodo nodoTemp, Nodo nodoEnlace) {
        // modulo recursivo para clonar una estructuira dinamica de Nodos
        // nodoTemp es usado para construir el clon, nodoEnlace es el nodo actual de la
        // cola
        if (nodoEnlace != null) {
            // condicion de salida que se llegue al final de la estructura
            nodoTemp.setEnlace(new Nodo(nodoEnlace.getElem(), null));
            // crea el siguiente nodo de nodoTemp con el valor del nodoEnlace.
            cloneAux(nodoTemp.getEnlace(), nodoEnlace.getEnlace());
            // llama al modulo con el nodo recien Creado y el siguiente nodo de la
            // estructura
        }
    }

    public String toString() {
        String s = "[";
        Nodo aux = this.cabecera;
        while (aux != null) {
            s = s + aux.getElem() + "|";
            aux = aux.getEnlace();
        }
        return s + "]";
    }

    /*
     * concatenar: recibe dos listas L1 y L2 y devuelve una lista nueva con los
     * elementos de L1 y L2
     * concatenados. Ej: si L1=[2,4,6] y L2=[5,1,6,7] debe devolver [2,4,6,5,1,6,7
     */
    public Lista concatenar(Lista l1, Lista l2) {
        Lista listaConcatenada = new Lista();
        listaConcatenada.cabecera = new Nodo(l1.cabecera.getElem(), null);
        cloneAux(listaConcatenada.cabecera, l1.cabecera.getEnlace());

        cloneAux(listaConcatenada.obtenerUltimoNodo(l1), l2.cabecera.getEnlace());
        return listaConcatenada;
    }

    public Nodo obtenerUltimoNodo(Lista l1) {
        if (l1.cabecera == null) {
            return null; // la lista está vacía
        } else {
            Nodo nodoAux = l1.cabecera;
            while (nodoAux.getEnlace() != null) {
                nodoAux = nodoAux.getEnlace();
            }
            return nodoAux; // devuelve el último nodo
        }
    }

    /*
     * comprobar: recibe una lista L1 cargada con dígitos (números enteros de 0 a 9)
     * y verifica si los
     * elementos que contiene tienen la forma cadena0cadena0cadena* (donde cadena*
     * es cadena invertida).
     * Ej: si L1=[9,6,5,0,9,6,5,0,5,6,9], cadena=965, luego cadena*=569, entonces la
     * lista L1 cumple con la
     * condición deseada.
     * Atención: la longitud de cada cadena no se conoce de antemano, hay que identi
     * carla por la primera
     * posición de 0 en la lista.
     * Nota: Utilizar una Pila y una Cola como estructuras auxiliares.
     */
    public boolean comprobar(Lista l1) {
        boolean exito = false;

        return false;
    }
    /*
     * invertir: recibe una lista L y devuelve una lista nueva con los elementos de
     * L invertidos. Ej: si
     * L1=[2,4,6] debe devolver [6,4,2]
     */
    public Lista invertir(Lista l1){
         Lista listaInvertida = new Lista();
         listaInvertida.cabecera = new Nodo(l1.obtenerUltimoNodo(l1).getElem(), null);
        int i;
        for(i=l1.longitud();i>=0;i--){
            
        }

         return listaInvertida;
    }
    /*
     * private void cloneAux(Nodo nodoTemp, Nodo nodoEnlace) {
        // modulo recursivo para clonar una estructuira dinamica de Nodos
        // nodoTemp es usado para construir el clon, nodoEnlace es el nodo actual de la
        // cola
        if (nodoEnlace != null) {
            // condicion de salida que se llegue al final de la estructura
            nodoTemp.setEnlace(new Nodo(nodoEnlace.getElem(), null));
            // crea el siguiente nodo de nodoTemp con el valor del nodoEnlace.
            cloneAux(nodoTemp.getEnlace(), nodoEnlace.getEnlace());
            // llama al modulo con el nodo recien Creado y el siguiente nodo de la
            // estructura
        }
    }
     */
}
