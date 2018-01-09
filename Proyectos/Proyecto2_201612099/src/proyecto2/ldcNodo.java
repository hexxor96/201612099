package proyecto2;

public class ldcNodo
{

	public ldcNodo siguiente;
	public ldcNodo anterior;
	public int id;

        public ldcNodo(ldcNodo siguiente, ldcNodo anterior, int id){
	this.siguiente = siguiente;
        this.anterior = anterior;
        this.id = id;
        }
        
        public ldcNodo (){
        }
        
        public void setSiguiente(ldcNodo siguiente){
        this.siguiente = siguiente;
        }
    
        public void setAnterior(ldcNodo anterior){
        this.anterior = anterior;
        }
    
        public ldcNodo getAnterior(){
        return this.anterior;
        }
     
        public ldcNodo getSiguiente(){
        return this.siguiente;
        }   
    
        public void setId(int id){
        this.id = id;
        }
    
        public int getId(){
        return this.id;
        }
}