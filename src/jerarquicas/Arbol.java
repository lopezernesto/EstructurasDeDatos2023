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
}
