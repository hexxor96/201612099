package proyecto2;

public class ldNodo{

	public ldNodo siguiente;
	public ldNodo anterior;
	public Escritorio escritorio;

        public ldNodo(ldNodo siguiente, ldNodo anterior, Escritorio escritorio){
	this.siguiente = siguiente;
        this.anterior = anterior;
        this.escritorio = escritorio;
        }
        
        public ldNodo (){
        }
        
        public void setSiguiente(ldNodo siguiente){
        this.siguiente = siguiente;
        }
    
        public void setAnterior(ldNodo anterior){
        this.anterior = anterior;
        }
    
        public ldNodo getAnterior(){
        return this.anterior;
        }
     
        public ldNodo getSiguiente(){
        return this.siguiente;
        }   
    
        public void setEscritorio(Escritorio escritorio){
        this.escritorio = escritorio;
        }
    
        public Escritorio getEscritorio(){
        return this.escritorio;
        }
}