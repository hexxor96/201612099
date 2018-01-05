package proyecto2_201612099;

public class ListaMantenimiento {
    
	public Mantenimiento primero;
	public Mantenimiento ultimo;
        
	public ListaMantenimiento(Mantenimiento primero, Mantenimiento ultimo){
		this.primero = null;
		this.ultimo = null;
        }
        
	public final void insertar(int numero){
		Mantenimiento nuevo = new Mantenimiento(numero);
		if (this.primero == null){
			this.primero = nuevo;
			this.ultimo = nuevo;
		}
		else{
			this.ultimo.siguiente = nuevo;
			this.ultimo = nuevo;
		}
	}
        
	public final void insertarA(Avion avion, int numero){
		if (this.primero != null){
			Mantenimiento busca = this.buscarM(numero);
			if (busca != null){
				busca.avionesM.pushA(avion);
			}
			else{
				System.out.print("No se encontro la estacion !!");
				System.out.print("\n");
			}
		}
		else{
			System.out.print("Vacios!!");
			System.out.print("\n");
		}

	}
        
	public final Mantenimiento buscarM(int numero){
		if (this.primero != null){
			Mantenimiento buscar = this.primero;
			while (buscar != null){
				if (buscar.numero == numero){
					return buscar;
				}
				buscar = buscar.siguiente;
			}
		}
		return null;
	}
        
	public final void recorrer(){
		if (this.primero != null){
			Mantenimiento aux = this.primero;
			while (aux != null){
				System.out.print(aux.numero);
				System.out.print("\n");
				aux.avionesM.recorrerA();
				aux = aux.siguiente;
			}
		}
		else{
			System.out.print("Vacio DX !!");
			System.out.print("\n");
		}
	}

}
