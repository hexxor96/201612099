package proyecto2_201612099;

public class Escritorios {
        public byte desk;
	public Cola pasajeros;
	public Pila documentos;
	public Escritorios siguiente;
	public Escritorios anterior;
	public Escritorios(byte desk)
	{
		this.desk = desk;
		this.siguiente = null;
		this.anterior = null;
		this.documentos = new Pila();
		this.pasajeros = new Cola();

	}

}
