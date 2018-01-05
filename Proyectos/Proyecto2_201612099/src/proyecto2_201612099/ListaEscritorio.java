package proyecto2_201612099;

public class ListaEscritorio {
    
	public Escritorios primero;
	public Escritorios ultimo;
	public int tamanioE;
        
	public ListaEscritorio(Escritorios primero, Escritorios ultimo, int tamanioE){
		this.primero = null;
		this.ultimo = null;
		this.tamanioE = 0;
	}
        
	public final void insertar(byte desk){
		Escritorios desktop = new Escritorios(desk);
		if (this.primero == null){
			this.primero = desktop;
			this.ultimo = desktop;
		}
		else{
			this.ultimo.siguiente = desktop;
			desktop.anterior = this.ultimo;
			this.ultimo = desktop;
		}
		++tamanioE;
	}
        
	public final Escritorios getEscritorio(byte desk){
		if (this.primero != null){
			Escritorios aux = this.primero;
			while (aux != null){
				if (aux.desk == desk){
					return aux;
				}
				aux = aux.siguiente;
			}
		}
		return null;
	}
}
