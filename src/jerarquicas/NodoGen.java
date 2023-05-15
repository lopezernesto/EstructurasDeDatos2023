package jerarquicas;

public class NodoGen {
    Object elem;
    NodoGen hijoIzquierdo;
    NodoGen hermanoDerecho;

    public  NodoGen(Object elem, NodoGen hijoIzquierdo,NodoGen hermanoDerecho){
        this.elem=elem;
        this.hijoIzquierdo=hijoIzquierdo;
        this.hermanoDerecho=hermanoDerecho;
    }
    public Object getElem(){
        return this.elem;
    }
    public NodoGen getHijoIzquierdo(){
        return this.hijoIzquierdo;
    }
    public NodoGen getHermanoDerecho(){
        return this.hermanoDerecho;
    }
    public void setElem(Object elem){
        this.elem=elem;
    }
    public void setHijoIzquierdo(NodoGen hijoIzquierdo){
        this.hijoIzquierdo=hijoIzquierdo;
    }
    public void setHermanoDerecho(NodoGen hermanoDerecho){
        this.hermanoDerecho=hermanoDerecho;
    }
}
