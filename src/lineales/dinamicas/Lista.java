package lineales.dinamicas;

public class Lista {
    private Nodo cabecera;
    private int longitud;

    public Lista(){
        this.cabecera=null;
        this.longitud=0;
    }

    public boolean insertar(Object nuevoElem, int pos){
        //inserta el elemento nuevo en la posicion pos
        //detecta y reporta error posicion invalida
        boolean exito=true;
        if(pos<1  || pos >this.longitud()+1){
            exito=false;
        }else{
            if(pos==1)//crea un nuevo nodo y se enlaza en la cabecera
            {
                this.cabecera=new Nodo(nuevoElem,this.cabecera);
            }else{//avanza hasta el elemento en posicion pos-1
                Nodo aux= this.cabecera;
                int i=1;
                while(i<pos-1){
                    aux=aux.getEnlace();
                    i++;
                }
                //crea el nodo y lo enlaza
                Nodo nuevo= new Nodo(nuevoElem,aux.getEnlace());
                aux.setEnlace(nuevo);
            }
        }
        //lista es dinamica, no hay error de lista llena
        return exito;
    }
    public boolean eliminar(int pos){
        boolean exito=false;
        if(!esVacia() || (pos>=1 && pos<=this.longitud)){
            //Si mi lista no es vacia,  y pos es una posicion existente en la lista, entra al modulo
                Nodo aux=this.cabecera;
                int i=1;
                while(i<pos){
                    //recorro la lista hasta llegar al nodo anterior a pos
                    aux=aux.getEnlace();
                    i++;
                }
                aux.setEnlace(aux.getEnlace().getEnlace());
                exito=true;
            //Avanzo 2 posiciones en mis nodos, borrando el nodo de en medio(pos)
        }else{
            exito=false;
        }
        return exito;
    }
    public int longitud(){
        return this.longitud;
    }
    public boolean esVacia(){
        return longitud==0;
    }
    public void vaciar(){
        this.cabecera=null;
        this.longitud=0;
    }
    public Object recuperar(int pos){
        Object recuperado=null;

        if(!esVacia() || (pos>=1 && pos<=this.longitud)){
            //Si mi lista no es vacia,  y pos es una posicion existente en la lista, entra al modulo
                Nodo aux=this.cabecera;
                int i=1;
                while(i<pos){
                    //recorro la lista hasta llegar a pos
                    aux=aux.getEnlace();
                    i++;
                }
                recuperado=aux.getElem();
        }
        return recuperado;
    } 
    public int localizar(Object buscado){
        int pos=-1;
        if(!esVacia() || (pos>=1 && pos<=this.longitud)){
            //Si mi lista no es vacia,  y pos es una posicion existente en la lista, entra al modulo
                Nodo aux=this.cabecera;
                int i=1;
                while(aux.getElem()==buscado){
                    //recorro la lista hasta llegar al elemento buscado
                    aux=aux.getEnlace();
                    i++;
                }
                //se corta al llegar al elemento buscado
                pos=1;
        }
        return pos;
    }
    public Lista clone(){
        Lista listaClon= new Lista();
        if(!esVacia()){
            listaClon.cabecera = new Nodo(this.cabecera.getElem(), null);
            //asigno a lista clon mi cabecera sin enlace
            cloneAux(listaClon.cabecera, this.cabecera.getEnlace());
            //clona los nodos recursivamente
            listaClon.longitud = this.longitud;
        }
        return listaClon;
    }
    private void cloneAux(Nodo nodoTemp, Nodo nodoEnlace){
        //modulo recursivo para clonar una estructuira dinamica de Nodos
        //nodoTemp es usado para construir el clon, nodoEnlace es el nodo actual de la cola
        if(nodoEnlace != null){
            //condicion de salida que se llegue al final de la estructura
            nodoTemp.setEnlace(new Nodo(nodoEnlace.getElem(),null));
            //crea el siguiente nodo de nodoTemp con el valor del nodoEnlace.
            cloneAux(nodoTemp.getEnlace(),nodoEnlace.getEnlace());
            //llama al modulo con el nodo recien Creado y el siguiente nodo de la estructura
        }
    }
    public String toString(){
        String s="[";
        Nodo aux=this.cabecera;
            while(aux != null){
                s=s+aux.getElem()+"|";
                aux=aux.getEnlace();
            } 
        return s+"]";
    }
}
