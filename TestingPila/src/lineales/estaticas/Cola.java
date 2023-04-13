package lineales.estaticas;

public class Cola {
    
    private int tamanio=10;
    private int frente;
    private int fin;
    private Object[] array;

    public Cola(){
        this.array = new Object[this.tamanio];
        this.frente=0;
        this.fin=0;
    }

    public boolean esVacia(){
        return this.fin == this.frente;
    }
    public boolean poner(Object elemento){
        boolean exit= false;
        if(this.llena()){
          exit=false;
        }else{
            array[fin]=elemento;
            fin=(fin+1)%tamanio;
            exit=true;
        }
        return exit;
    }

    private boolean llena(){
        return (fin+1)%tamanio==frente;
    }

    public void vaciar() {
        while (!esVacia()){
            this.array[this.frente] = null;
            this.frente = (this.frente+1)%tamanio;
        }
    }
    public boolean sacar(){
        boolean exito=true;
        if(this.esVacia()){
            exito=true;
        }else{
            array[frente]=null;
            fin= (fin+1)%tamanio;
        }
        return exito;
    }
    public String toString(){
        String s="";
        for(int i=0;i<tamanio;i++){
            s=s+array[i];
        }
        return s;
    }
    public Object obtenerFrente(){
        Object obj = null;
        if (!esVacia()) {
            obj = this.array[frente];
        }
        return obj;
    }
    public Cola clone(){
        Cola colaClon=new Cola();
        if(!esVacia()){
            int i=this.frente;
            while(i!=this.fin){
                colaClon.array[i]=this.array[i];
                i=(i+1)%tamanio;
            }
        }
        return colaClon;
    }
    
}
