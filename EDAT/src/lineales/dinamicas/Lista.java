package lineales.dinamicas;

public class Lista {
    private Nodo cabecera;
    private int longitud;

    private Lista(int longitud){
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
            aux=aux.setEnlace().getEnlace();
            //Avanzo 2 posiciones en mis nodos, borrando el nodo de en medio(pos)
        }
    }

    public boolean esVacia(){
        return longitud==0;
    }
    
}
