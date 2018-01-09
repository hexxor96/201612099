package proyecto2;

public class pNodo
{

	public pNodo siguiente;
	public pNodo anterior;

        public pNodo(pNodo siguiente, pNodo anterior){
	this.siguiente = siguiente;
        this.anterior = anterior;
        }
        
        public pNodo (){
        }
        
        public void setSiguiente(pNodo siguiente){
        this.siguiente = siguiente;
        }
    
        public void setAnterior(pNodo anterior){
        this.anterior = anterior;
        }
    
        public pNodo getAnterior(){
        return this.anterior;
        }
     
        public pNodo getSiguiente(){
        return this.siguiente;
        }   
}
