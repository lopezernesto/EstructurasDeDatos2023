package jerarquicas;

public class Arbol {
    private NodoArbol raiz;
    public Arbol(){
        this.raiz=null;
    }
    public boolean insertar(Object elemNuevo, Object elemPadre, char lugar){
        boolean exito=false;
        if(this.raiz==null){
            //si el arbol esta vacio pone elemNuevo en la raiz
            this.raiz=new NodoArbol(elemNuevo, null, null);
        }else{
            //si el arbol no esta vacio busca al padre
            NodoArbol nPadre=obtenerNodo(this.raiz,elemPadre);
            //si el padre existe y lugar no esta ocupado lo pone, si no da error
            if(nPadre!=null){
                if(lugar=='I'&&nPadre.getIzquierdo()==null){
                    nPadre.setIzquierdo(new NodoArbol(elemNuevo, null, null));
                }else if(lugar=='D'&&nPadre.getDerecho()==null){
                    nPadre.setDerecho(new NodoArbol(elemNuevo, null, null));
                }else{
                    exito=false;
                }
            }else{
                exito=false;
            }
        }
        return exito;
    }
    private NodoArbol obtenerNodo(NodoArbol n,Object buscado){
        //metodo PRIVADO, busca un elem y devuelve el nodo que lo contiene, o de lo contrario null
        NodoArbol resultado=null;
        if(n!=null){
            if(n.getElem().equals(buscado)){
                resultado=n;
            }else{
                //si no es el buscado, busca primero en Hijo Izquierdo
                resultado=obtenerNodo(n.getIzquierdo(), buscado);
                //si no lo encontro en hijo izquierdo busca en hijo derecho
                if(resultado==null){
                    resultado=obtenerNodo(n.getDerecho(), buscado);
                }
            }
        }
        return resultado;
    }
    public int altura(NodoArbol nodoActual){
        int alturaIzquierdo;
        int alturaDerecho;
            if(nodoActual==null){
                return 0;
                //caso base, altura=0 entonces llegamos a una hoja
            }
        alturaIzquierdo=altura(nodoActual.getIzquierdo());
        //paso recursivo, consigo la altura del hijo izquierdo de mi nodo actual
        alturaDerecho=altura(nodoActual.getDerecho());
        return Math.max(alturaIzquierdo,alturaDerecho)+1;
        //retorna la altura +1(caso base=0 entonces altura padre de la hoja(caso base)=0+1)
    }
    public int nivel(Object buscado){
            int resultado=-1;
            resultado= nivelAux(buscado, raiz);
            return resultado;
    }

    private int nivelAux(Object buscado, NodoArbol nodoAux){
        int resultado;
            if(buscado!=nodoAux.getElem()){
                resultado= altura(nodoAux.getIzquierdo());
            }else{
                resultado=altura(nodoAux.getDerecho());
            }
        return resultado;
    }
    public boolean esVacio(){
        return this.raiz==null;
    }

    public String toString() {
        String cad = " ";
        if (this.raiz == null) {
            cad = "el arbol esta vacio";
        } else {
            cad = toStringAux(this.raiz);
        }
        return cad;
    }

    private String toStringAux(NodoArbol nodo) {
        String mensaje = "";
        if (nodo != null) {
            mensaje = "\n NODO: " + nodo.getElem() + mensaje;
            if (nodo.getIzquierdo() != null) {
                mensaje = mensaje + " HI:" + (nodo.getIzquierdo().getElem());
            } else {
                mensaje = mensaje + " HI: - ";
            }
            if (nodo.getDerecho() != null) {
                mensaje = mensaje + (" HD:" + nodo.getDerecho().getElem());
            } else {
                mensaje = mensaje + " HD: - ";
            }
        }

        if (nodo.getIzquierdo() != null) {
            mensaje = mensaje + toStringAux(nodo.getIzquierdo());
        }

        if (nodo.getDerecho() != null) {
            mensaje = mensaje + toStringAux(nodo.getDerecho());
        }

        return mensaje;
    }

}
