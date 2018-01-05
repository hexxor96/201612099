package proyecto2_201612099;

public class Lista{
    
	public Nodo cabezaS;
	public Nodo colaS;
	public Nodo cabezaD;
	public Nodo colaD;
	public Nodo cabezaC;
	public Nodo colaC;
	public int tamanioS;
	public int tamanioD;
	public int tamanioC;

	public Lista(){
		this.cabezaS = null;
		this.colaS = null;
		this.cabezaD = null;
		this.colaD = null;
		this.cabezaC = null;
		this.colaC = null;
		this.tamanioS = 0;
		this.tamanioD = 0;
		this.tamanioC = 0;
	}
        
	public final void insertarS(int numero){
		Nodo nuevo = new Nodo(numero);
		if (this.cabezaS == null){
			this.cabezaS = nuevo;
			this.colaS = nuevo;
		}
		else{
			this.colaS.siguiente = nuevo;
			this.colaS = nuevo;
		}
		this.tamanioS++;
	}
        
	public final void insertarD(int numero){
		Nodo nuevo = new Nodo(numero);
		if (this.cabezaD == null){
			this.cabezaD = nuevo;
			this.colaD = nuevo;
		}
		else{
			this.colaD.siguiente = nuevo;
			nuevo.anterior = this.colaD;
			this.colaD = nuevo;
		}
		this.tamanioD++;
	}
        
	public final void insertarC(int numero){
		Nodo nuevo = new Nodo(numero);
		if (this.cabezaC == null){
			nuevo.siguiente = nuevo;
			nuevo.anterior = nuevo;
			this.cabezaC = this.colaC = nuevo;
		}
		else{
			this.colaC.siguiente = nuevo;
			nuevo.anterior = this.colaC;
			nuevo.siguiente = this.cabezaC;
			this.cabezaC.anterior = nuevo;
			this.colaC = nuevo;
		}
		this.tamanioC++;
	}

	public final void insertarDEsc(byte esc){
		Nodo nuevo = new Nodo(esc);
		if (this.cabezaD == null){
			this.cabezaD = nuevo;
			this.colaD = nuevo;
		}
		else{
			this.colaD.siguiente = nuevo;
			nuevo.anterior = this.colaD;
			this.colaD = nuevo;
		}
		this.tamanioD++;

	}

	public final void insertarSD(int numero){
		Nodo nuevo = new Nodo(numero);
		if (this.cabezaS == null){
			this.cabezaS = nuevo;
			this.colaS = nuevo;
		}
		else{
			nuevo.siguiente = this.cabezaS;
			this.cabezaS = nuevo;
		}
		this.tamanioS++;
	}
        
	public final void insertarDD(int numero){
		Nodo nuevo = new Nodo(numero);
		if (this.cabezaD == null){
			this.cabezaD = nuevo;
			this.colaD = nuevo;
		}
		else{
			this.cabezaD.anterior = nuevo;
			nuevo.siguiente = this.cabezaD;
			this.cabezaD = nuevo;
		}
		this.tamanioD++;
	}
        
	public final void insertarCD(int numero){
		Nodo nuevo = new Nodo(numero);
		if (this.cabezaC == null){
			nuevo.siguiente = nuevo;
			nuevo.anterior = nuevo;
			this.cabezaC = this.colaC = nuevo;
		}
		else{
			this.cabezaC.anterior = nuevo;
			nuevo.siguiente = this.cabezaC;
			nuevo.anterior = this.colaC;
			this.colaC.siguiente = nuevo;
			this.cabezaC = nuevo;
		}
		this.tamanioC++;
	}

	public final void popC(){
		if (this.cabezaC != null){
			if (this.cabezaC == this.colaC){
				this.cabezaC = null;
				this.colaC = null;
				this.cabezaC = null;
				this.colaC = null;
				return;
			}
			else if (this.cabezaC.siguiente == this.colaC){
				Nodo aux = this.cabezaC;
				this.cabezaC = this.cabezaC.siguiente;
				this.cabezaC.anterior = this.colaC;
				this.cabezaC.siguiente = this.colaC;
				this.colaC.anterior = this.cabezaC;
				this.colaC.siguiente = this.cabezaC;
				aux = null;
				aux = null;
				return;
			}
			Nodo aux = this.cabezaC;
			this.cabezaC = this.cabezaC.siguiente;
			this.cabezaC.anterior = this.colaC;
			this.colaC.siguiente = this.cabezaC;
			aux.anterior = null;
			aux.siguiente = null;
			aux = null;
			aux = null;
			return;
		}
		else{
			System.out.print("Vacia ggizi");
			System.out.print("\n");
		}

	}


	public final void recorrerS(){
		if (this.cabezaS != null){
			Nodo auxiliar = this.cabezaS;
			while (auxiliar != null){
				System.out.print(auxiliar.numero);
				System.out.print("\n");
				auxiliar = auxiliar.siguiente;
			}
		}
		else{
		   System.out.print("Vacio DX !! \n");
		}

	}
        
	public final void recorrerD(){
		if (this.cabezaD != null){
			Nodo auxiliar = this.cabezaD;
			while (auxiliar != null){
				System.out.print(auxiliar.numero);
				System.out.print("\n");
				auxiliar = auxiliar.siguiente;
			}
		}
		else{
		   System.out.print("Vacio DX !! \n");
		}

	}
        
	public final void recorrerC(){
		if (this.cabezaC != null){
			Nodo auxiliar = this.cabezaC;
			do{
				System.out.print(auxiliar.numero);
				System.out.print("\n");
				auxiliar = auxiliar.siguiente;
			} while (auxiliar != this.cabezaC);
		}
	else{
		   System.out.print("Vacio DX !! \n");
	}
        }

	public final void eliminarS(int numero){
		if (this.cabezaS != null){
			if (this.cabezaS.numero == numero){
				if (this.cabezaS.siguiente != null){
					Nodo aux = this.cabezaS;
					this.cabezaS = this.cabezaS.siguiente;
					aux = null;
					aux = null;
				}
				else{
					this.cabezaS = null;
				}
			}
			else{
				Nodo ant = null;
				Nodo aux = this.cabezaS;
				while (aux.siguiente != null){
					if (aux.numero == numero){
						ant.siguiente = aux.siguiente;
						aux = null;
						this.tamanioS--;
						return;
					}
					ant = aux;
					aux = aux.siguiente;
				}
				if (aux.siguiente == null && aux.numero == numero){
					ant.siguiente = null;
					aux = null;
				}
			}
			this.tamanioS--;
		}
		else{
			System.out.print("Vacio DX !!");
			System.out.print("\n");
		}
	}
        
	public final void eliminarD(int numero){
		if (this.cabezaD != null){
			if (this.cabezaD.numero == numero){
				if (this.cabezaD.siguiente != null){
					Nodo aux = this.cabezaD;
					this.cabezaD = this.cabezaD.siguiente;
					this.cabezaD.anterior = null;
					aux = null;
				}
				else{
					this.cabezaD = null;
				}
			}
			else{
				Nodo aux = this.cabezaD;
				while (aux.siguiente != null){
					if (aux.numero == numero){
						aux.siguiente.anterior = aux.anterior;
						aux.anterior.siguiente = aux.siguiente;
						aux = null;
						this.tamanioD--;
						return;
					}
					aux = aux.siguiente;
				}
				if (aux.siguiente == null && aux.numero == numero){
					aux.anterior.siguiente = null;
					aux = null;
				}
			}
			this.tamanioD--;
		}
		else{
			System.out.print("Vacio DX !!");
			System.out.print("\n");
		}
	}
        
	public final void eliminarC(int numero){
		if (this.cabezaC != null){
			if (this.cabezaC.numero == numero){
				if (this.cabezaC.siguiente != this.cabezaC){
					Nodo aux = this.cabezaC;
					this.cabezaC = this.cabezaC.siguiente;
					this.colaC.siguiente = this.cabezaC;
					this.cabezaC.anterior = this.colaC;
					aux = null;
				}
				else{
					this.cabezaC = null;
					this.colaC = null;
					this.cabezaC = null;
					this.colaC = null;
				}
			}
			else{
				Nodo aux = this.cabezaC;
				do{
					if (aux.numero == numero){
						aux.anterior.siguiente = aux.siguiente;
						aux.siguiente.anterior = aux.anterior;
						aux = null;
						aux = null;
						this.tamanioC--;
						return;
					}
					aux = aux.siguiente;
				}
                                while (aux.siguiente != this.cabezaC);
				if (aux.siguiente == this.cabezaC && aux.numero == numero){
					aux.anterior.siguiente = this.cabezaC;
					this.colaC = aux.anterior;
					aux = null;
					aux = null;
				}
			}
			this.tamanioC--;
		}
		else{
			System.out.print("Vacio DX !!");
			System.out.print("\n");
		}
	}
}