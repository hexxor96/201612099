package proyecto2_201612099;

public class ColaPasajeros {

    private ListaPasajeros LCPasajeros;
    
    public ColaPasajeros(){  
    
        LCPasajeros = new ListaPasajeros("cola");
    }
    
    public void enqueue(object objeto){
        
        LCPasajeros.insertarAlFinal(objeto);
    }
    
    public object dequeue() throws ExcepcionListaVacia{
        return LCPasajeros.eliminarDelFrente();
    }
    
    public boolean estaVacia(){
        return LCPasajeros.estaVacia();
    }
    
    public void imprimir(){
        LCPasajeros.imprimir();
    }
    
    
}
