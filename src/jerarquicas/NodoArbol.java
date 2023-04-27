package jerarquicas;

public class NodoArbol {
    private Object elem;
    private NodoArbol izquierdo;
    private NodoArbol derecho;

    public NodoArbol(Object elem, NodoArbol izquierdo, NodoArbol derecho){
        this.elem=elem;
        this.derecho=derecho;
        this.izquierdo=izquierdo;
    }
    public Object getElem(){
        return this.elem;
    }
    public void setElem(Object elem){
        this.elem=elem;
    }
    public NodoArbol getIzquierdo(){
        return this.izquierdo;
    }
    public void setIzquierdo(NodoArbol izquierdo){
        this.izquierdo=izquierdo;
    }
    public NodoArbol getDerecho(){
        return this.derecho;
    }
    public void setDerecho(NodoArbol derecho){
        this.derecho=derecho;
    }
}
