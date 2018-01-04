package proyecto2_201612099;

public class ListaPasajeros extends NodoPasajero {
    
    private NodoPasajero principio;
    private int tam;

    public NodoPasajero getPrincipio(){
        return principio;
    }
    
    public void setPrincipio(NodoPasajero principio){
        this.principio = principio;
    }
    
    public void ListaPasajeros(){
        principio = null;
        tam = 0;
    }
    
    public int getTam(){
        return tam;
    }
        
    public void insertarAlFrente(int valor, int valor1, int valor2, int valor3){
        NodoPasajero npasajero = new NodoPasajero();
        npasajero.setid(valor);
        npasajero.setCMaletas(valor1);
        npasajero.setCDocumentos(valor2);
        npasajero.setNRegistro(valor3);
        if(estaVacia()){
            principio = npasajero;
        }
        else{
            npasajero.setsiguiente(principio);
            principio = npasajero;
        }
        tam++;
    }
    public object eliminarDelFrente() throws ExcepcionListaVacia{
        if(estaVacia())
            throw new ExcepcionListaVacia(nombre);
        object elementoEliminado = primerNodo.datos;
        
        if(primerNodo ==ultimoNodo)
            primerNodo = ultimoNodo = null;
        else
            primerNodo = primerNodo.siguiente;
        return elementoEliminado;
    }

    public void insertarAlFinal(int valor, int valor1, int valor2, int valor3){
        NodoPasajero npasajero = new NodoPasajero();
        npasajero.setid(valor);
        npasajero.setCMaletas(valor1);
        npasajero.setCDocumentos(valor2);
        npasajero.setNRegistro(valor3);
        if(estaVacia()){
            principio = npasajero;
        }
        else{
            NodoPasajero aux = principio;
            while(aux.getsiguiente() != null){
                aux = aux.getsiguiente();
            }
            aux.setsiguiente(npasajero);
        }
        tam++;
    }
    
    public Object eliminarDelFinal() throws ExcepcionListaVacia{
        if ( estaVacia() ) 
        throw new ExcepcionListaVacia( nombre );
        Object elementoEliminado = ultimoNodo.datos;
        if ( primerNodo == ultimoNodo )
        primerNodo = ultimoNodo = null;
        else{
        NodoPasajero actual = primerNodo;

        while ( actual.siguienteNodo != ultimoNodo )
        actual = actual.siguienteNodo;

        ultimoNodo = actual; 
        actual.siguienteNodo = null;
    } 
      
        return elementoEliminado; 
    } 

        public boolean estaVacia(){
        return principio == null;
    } 

        public int getValor(int ppasajero) throws Exception{
        if(ppasajero >= 0 && ppasajero < tam){
            if (ppasajero == 0) {
                return principio.getid();
            }else{
                NodoPasajero aux = principio;
                for (int i = 0; i < ppasajero; i++) {
                    aux = aux.getsiguiente();
                }
                return aux.getid();
            }
        } else {
            throw new Exception("No existe");
        }
    }
        
    public boolean buscar(int ref){
        NodoPasajero aux = principio;
        boolean buscado = false;
        while(aux != null && buscado != true){
            if (ref== aux.getid()){
                buscado = true;
            }
            else{
                aux = aux.getsiguiente();
            }
        }
        return buscado;
    }
    
    public void imprimir(){
        if ( estaVacia()){
        System.out.printf( "%s vacia\n", nombre );
        return;
        } 

        System.out.printf( "La %s es: ", nombre );
        NodoPasajero actual = primerNodo;

        while ( actual != null ){
        System.out.printf( "%s ", actual.datos );
        actual = actual.siguiente;
        } 

        System.out.println( "\n" ); 
    }     
}
