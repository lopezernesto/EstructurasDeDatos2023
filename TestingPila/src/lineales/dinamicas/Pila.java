package lineales.dinamicas;

public class Pila {

    private Nodo tope;

    public Pila() {
        this.tope = null;
    }

    public boolean apilar(Object nuevoElem) {
        //crea un nuevo nodo delante de la anituga cabecera
        Nodo nuevo = new Nodo(nuevoElem, this.tope);
        //Actualiza el tope para que apunte al nodo nuevo
        this.tope = nuevo;
        //devuelve true porque la pila nunca se llena
        return true;
    }

    public boolean desapilar() {
        boolean exito = false;
        if (tope == null) {
            exito = false;
        } else {
            this.tope = this.tope.getEnlace();
        }
        return exito;
    }

    public boolean esVacia(){
        boolean pilaVacia=false;
        if(this.tope==null){
            pilaVacia=true;
        }
        return pilaVacia;
    }

    public Object obtenerTope() {
        Object obj=null;
        if(this.tope!=null){
            obj=tope.getElem();
        }
        return obj;
    }

    public void vaciar() {
        this.tope = null;
    }

    public Pila clone(){
        Pila clon = new Pila();
        clonar(clon,this.tope);
        return clon;
    }
    public void clonar(Pila clon, Nodo otroEnlace){
        //Metodo recursivo para clonar Nodo por nodo
        if(otroEnlace!=null){
            // Condicion de Salida: Que llegemos al ultimo nodo (cabecera)
            clonar(clon,otroEnlace.getEnlace());
            //Se ejecuta recursivamente hasta el ultimo nodo
            clon.tope= new Nodo(otroEnlace.getElem(),clon.tope);
            //Al tope de la Pila Clon le asigna el elemento del Nodo y el puntero del tope actual
        }
    }
    public String toString(){
        String s="";
        Nodo aux;
        if(this.tope == null){
            s= "Pila Vacia";
        }else{
            //Se ubica para recorrer la pila
             aux =this.tope;
            s="[";

            while(aux!=null){
                //Agrega el texto del nuevo elemento y avanza al siguiente nodo
                s+= aux.getElem().toString();
                aux=aux.getEnlace();
                if(aux!=null){
                    s+=",";
                }
                s+="]";
            }
        }
        return s;
    }
}
