package proyecto2_201612099;

public class Nodo {
        public int numero;
	public Pasajero pasajero = new Pasajero();
	public byte escritorio;
	public Avion avion = new Avion();
	public Nodo anterior;
	public Nodo siguiente;
	public Nodo arriba;
	public Nodo abajo;
        
	public Nodo(int numero){
		this.numero = numero;
		this.anterior = null;
		this.siguiente = null;
		this.arriba = null;
		this.abajo = null;
	}
        
	public Nodo(Pasajero pasajero){
                
                this.pasajero.copyFrom(pasajero);
		this.anterior = null;
		this.siguiente = null;
		this.arriba = null;
		this.abajo = null;
	}
        
	public Nodo(byte escritorio){
		this.escritorio = escritorio;
		this.anterior = null;
		this.siguiente = null;
		this.arriba = null;
		this.abajo = null;
	}
        
	public Nodo(Avion avion){
		this.avion.copyFrom(avion);
		this.anterior = null;
		this.siguiente = null;
		this.arriba = null;
		this.abajo = null;
	}
}
