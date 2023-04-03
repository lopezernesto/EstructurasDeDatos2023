package lineales.dinamicas;

class Nodo {
    private Object elem;
    private Nodo enlace;
    //builder
    public Nodo(Object elem, Nodo enlace) {
        this.elem = elem;
        this.enlace = enlace;
    }

    //modificadores
    public void setElem(Object elem) {
        this.elem = elem;
    }
    public void setEnlace(Nodo enlace) {
        this.enlace = enlace;
    }

    //observadoras
    public Object getElem() {
        return elem;
    }
   

     public Nodo getEnlace(){
         return enlace;
    }

}