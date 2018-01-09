package proyecto2;

public class csNodo{
    
	public csNodo siguiente;
	public Pasajero pasajero;
        
    public csNodo(csNodo siguiente, Pasajero pasajero){
    this.siguiente = siguiente;
    this.pasajero = pasajero;
    }
    
    public csNodo(){
        
    }
        public void setSiguiente(csNodo siguiente){
        this.siguiente = siguiente;
        }
    
        public csNodo getSiguiente(){
        return this.siguiente;
        }
    
        public void setPasajero(Pasajero pasajero){
        this.pasajero = pasajero;
        }
    
        public Pasajero getPasajero(){
        return this.pasajero;
        }
}