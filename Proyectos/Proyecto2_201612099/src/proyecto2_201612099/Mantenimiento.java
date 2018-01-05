package proyecto2_201612099;

public class Mantenimiento {
    
	public int numero;
	public Cola avionesM;
	public Mantenimiento siguiente;
	public Mantenimiento(int numero){
		this.numero = numero;
		this.avionesM = new Cola();
		this.siguiente = null;
	}
}
