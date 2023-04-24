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

    public String toString() {
        String s = "[";
        Nodo aux = this.cabecera;
        while (aux != null) {
            s = s + aux.getElem() + "|";
            aux = aux.getEnlace();
        }
        return s + "]";
    }

    public Lista invertir(Lista l1) {
        Lista listaInvertida = new Lista();
        int i, j = 1;
        for (i = l1.longitud(); i > 0; i--) {
            listaInvertida.insertar(l1.recuperar(i), j);
            j++;
        }
        return listaInvertida;
    }

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

    public Lista concatenar(Lista l1, Lista l2) {
        Lista listaConcatenada = new Lista();
        listaConcatenada = l1.clone();
        for (int i = 1; i <= l2.longitud(); i++) {
            Object elem = l2.recuperar(i);
            listaConcatenada.insertar(elem, l1.longitud() + i);
        }
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
     * verifica si los elementos que contiene tienen la forma cadena0cadena0cadena*
     * (donde cadena* es cadena invertida).
     * Atención: la longitud de cada cadena no se conoce de antemano, hay que
     * identificarla por la primera posición de 0 en la lista.
     * Nota: Utilizar una Pila y una Cola como estructuras auxiliares.
     */
    public boolean comprobar(Lista l1) {
        boolean exito = false;
        Lista nuevaLista = new Lista();
        int dist1 = l1.localizar(0);
        int dist2 = 2 * dist1;
        int j = dist1 - 1;
        // Calcula la longitud de la lista y localiza los dos 0 de la lista
        // Parte 1
        // Copio la lista ingresada por parametro a la lista nueva, hasta donde hallle
        // el 1er 0, alli va a estar mi primera parte" cadena0
        for (int i = 1; i < dist1; i++) {
            nuevaLista.insertar(l1.recuperar(i), i);
        }
        nuevaLista.insertar(0, dist1);
        // Parte 2
        // Inserto el 0 asi tener forma adena0
        // Ahora que tenemos la forma cadena0 hay que ahcer la otra parte cadena0
        for (int i = nuevaLista.longitud() + 1; i < dist2; i++) {
            nuevaLista.insertar(l1.recuperar(i - dist1), i);
        }
        // Agrega el segundo 0, luego de concatenar PRIMERA y SEGUNDA PARTE
        nuevaLista.insertar(0, dist2);
        // Ya tenemos forma cadena0cadena0
        // Parte 3
        // Insertamos en la Lista nueva, de la misma forma quie en parte 1 pero en orden
        // inverso
        for (int i = (dist2 + 1); i < (3 * dist1); i++) {
            nuevaLista.insertar(l1.recuperar(j), i);
            j--;
        }
        // Ya tenemos la lista copiada de la forma cadena0cadena0cadena*
        // ahora queda comprobar

        int w = 1;
        while (w <= nuevaLista.longitud() && exito) {
            exito = nuevaLista.recuperar(w) == l1.recuperar(w);
            w++;
        }

        return exito;
    }
}
