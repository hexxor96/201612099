package proyecto2;

public class lNodo{
	public lNodo siguiente;
        public lNodo anterior;
	public Avion avion;

        public lNodo(lNodo siguiente, lNodo anterior, Avion avion){
            this.siguiente = siguiente;
            this.anterior = anterior;
            this.avion = avion;
        }
        
        public lNodo(){
            
        }
        
        public void setSiguiente(lNodo siguiente){
            this.siguiente = siguiente;
        }
        
        public lNodo getSiguiente(){
            return this.siguiente;
        }

        public void setAvion(Avion avion){
            this.avion = avion;
        }
        
        public Avion getAvion(){
            return this.avion;
        }        

        public void setAnterior(lNodo anterior){
            this.anterior = anterior;
        }
        
        public lNodo getAnterior(){
            return this.anterior;
        }        
}