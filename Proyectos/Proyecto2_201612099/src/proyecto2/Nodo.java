package proyecto2;

public class Nodo
{
        public Nodo siguiente;
	public Nodo anterior;
	public Avion avion;
        
    public Nodo(Nodo siguiente,Nodo anterior, Avion avion){
	this.siguiente = siguiente;
        this.anterior = anterior;
        this.avion = avion;
    }
    public Nodo (){
    }
        public void setSiguiente(Nodo siguiente){
        this.siguiente = siguiente;
        }
    
        public void setAnterior(Nodo anterior){
        this.anterior = anterior;
        }
    
        public Nodo getAnterior(){
        return this.anterior;
        }
     
        public Nodo getSiguiente(){
        return this.siguiente;
        }   
    
        public void setAvion(Avion avion){
        this.avion = avion;
        }
    
        public Avion getAvion(){
        return this.avion;
        }
}