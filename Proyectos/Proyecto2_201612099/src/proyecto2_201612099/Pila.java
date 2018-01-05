package proyecto2_201612099;

public class Pila {
	public Nodo cabeza;
	public Nodo cola;
	public int tamanio;

	public Pila(){
		this.cabeza = null;
		this.cola = null;
		this.tamanio = 0;
	}

	public final void apilar(int numero){
		Nodo nuevo = new Nodo(numero);
		if (this.cabeza == null){
			this.cabeza = nuevo;
			this.cola = nuevo;
		}
		else{
			this.cabeza.anterior = nuevo;
			nuevo.siguiente = this.cabeza;
			this.cabeza = nuevo;
		}
		this.tamanio++;
	}
        
	public final void desapilar(){
		if (this.cabeza != null){
			if (this.cabeza.siguiente != null){

				Nodo aux = this.cabeza;
				this.cabeza = this.cabeza.siguiente;
				this.cabeza.anterior = null;
				aux = null;

			}
			else{
				this.eliminar();
			}

		}
		else{
			System.out.print("Vacios! ");
			System.out.print("\n");
		}
	}
        
	public final void recorrer(){
		if (this.cabeza != null){
			Nodo aux = this.cabeza;
			while (aux != null){
				System.out.print("Pila: ");
				System.out.print(aux.numero);
				System.out.print("\n");
				aux = aux.siguiente;
			}
		}
		else{
			System.out.print("Vacio");
			System.out.print("\n");
		}
	}
        
	public final void eliminar(){
		this.cabeza = null;
		this.cabeza = null;
	}

}
