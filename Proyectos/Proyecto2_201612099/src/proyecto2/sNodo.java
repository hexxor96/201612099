package proyecto2;

public class sNodo
{

	public int id;
	public sNodo siguiente;
	public Avion avion;

        public sNodo(sNodo siguiente, int id, Avion avion){
	this.siguiente = siguiente;
        this.id = id;
        this.avion = avion;
        }
        
        public sNodo (){
        }
        
        public void setSiguiente(sNodo siguiente){
        this.siguiente = siguiente;
        }
    
        public void setId(int id){
        this.id = id;
        }
    
        public int getId(){
        return this.id;
        }
     
        public sNodo getSiguiente(){
        return this.siguiente;
        }   
    
        public void setAvion(Avion avion){
        this.avion = avion;
        }
    
        public Avion getAvion(){
        return this.avion;
        }
}