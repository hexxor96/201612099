package proyecto2_201612099;

public class Cola {

	public Nodo cabeza;
	public Nodo cola;


	public Nodo cabezaD;
	public Nodo colaD;

	public int tamanio;
	public int tamanioD;

	public Cola()
	{
		this.cabeza = null;
		this.cola = null;

		this.cabezaD = null;
		this.colaD = null;

		this.tamanio = 0;
		this.tamanioD = 0;

	}
	public final void push(Pasajero pasajero){
		Nodo nuevo = new Nodo(new Pasajero(pasajero));
		if (this.cabeza == null)
		{
			this.cabeza = nuevo;
			this.cola = nuevo;
		}
		else
		{
			this.cola.siguiente = nuevo;
			this.cola = nuevo;
		}
		++tamanio;
	}
	public final Nodo * struct pop()
	{
		if (this.cabeza != null)
		{
			if (this.cabeza.siguiente != null)
			{
				Nodo aux = this.cabeza;
				this.cabeza = this.cabeza.siguiente;
				aux.siguiente = null;
				--tamanio;
				return aux;
			}
			else
			{
				Nodo aux = this.cabeza;
				this.cabeza = null;
				--tamanio;
				return aux;
			}
		}
		System.out.print("Vacio DX !! ");
		System.out.print("\n");
		return null;
	}
	public final void grafoPasajero()
	{
		string grafo = "digraph g{\n";
		grafo += "\t node[shape=box, style=filled, color=Gray95];\n";
		grafo += "\t edge[color=black];\n";
		grafo += "\t subgraph ColaPasajero{\n";
		grafo += "\t node[style=filled];\n";
		this.cadenaPasajero(grafo);
		grafo += "\t}\n";
		grafo += "}\n";
		ofstream archivo = new ofstream("grafoPasajero.dot");
		archivo << grafo;
		archivo.close();
		system("dot -Tpng grafoPasajero.dot -o grafoPasajero.png");

	}
	public final void cadenaPasajero(string graph)
	{
		if (this.cabeza != null)
		{
			Nodo aux = this.cabeza;

			while (aux.siguiente != null)
			{
				String direccion;
				{
					std::ostringstream ostm = new std::ostringstream();
					ostm << reinterpret_cast<Short>(aux);
					direccion = ostm.str();
				}

				String direccionsig;
				{
					std::ostringstream ostms = new std::ostringstream();
					ostms << reinterpret_cast<Short>(aux.siguiente);
					direccionsig = ostms.str();
				}

				graph += "\t" + direccion + "[label=\"" + aux.pasajero.toString() + "\"];\n";
				graph += "\t" + direccionsig + "[label=\"" + aux.siguiente.pasajero.toString() + "\"];\n";
				graph += "\t" + direccion + " -> " + direccionsig;

				aux = aux.siguiente;

			}
		}
		else{
			graph += "\"Vacio DX\"";
		}
	}

	public final void pushA(Avion avion){
		Nodo nuevo = new Nodo(new Avion(avion));
		if (this.cabeza == null)
		{
			this.cabeza = nuevo;
			this.cola = nuevo;
		}
		else
		{
			this.cola.siguiente = nuevo;
			this.cola = nuevo;
		}
		++tamanio;

	}
	public final Nodo * struct popA(){
		if (this.cabeza != null){
			if (this.cabeza.siguiente != null){
				Nodo aux = this.cabeza;
				this.cabeza = this.cabeza.siguiente;
				aux.siguiente = null;
				--tamanio;
				return aux;
			}
			else{
				Nodo aux = this.cabeza;
				this.cabeza = null;
				--tamanio;
				return aux;
			}
		}
		System.out.print("Vacio DX !! ");
		System.out.print("\n");
		return null;

	}
	public final void recorrerA(){
		if (this.cabeza != null)
		{
			Nodo aux = this.cabeza;
			while (aux != null)
			{
				System.out.print("Cola : ");
				System.out.print(aux.avion.toString());
				System.out.print("\n");
				aux = aux.siguiente;
			}
		}
		else
		{
			System.out.print("Vacio DX !!");
			System.out.print("\n");
		}
	}

	public final void grafoAvion()
	{

		string grafo = "digraph g{\n";
		grafo += "\t node[shape=box, style=filled, color=Gray95];\n";
		grafo += "\t edge[color=black];\n";
		grafo += "\t subgraph ColaAvion{\n";
		grafo += "\t node[style=filled];\n";
		this.cadenaAvion(grafo);
		grafo += "\t}\n";
		grafo += "}\n";
		ofstream archivo = new ofstream("grafoAvion.dot");
		archivo << grafo;
		archivo.close();
		system("dot -Tpng grafoAvion.dot -o grafoAvion.png");

	}
	public final void cadenaAvion(string graph)
	{
		if (this.cabeza != null)
		{
			Nodo aux = this.cabeza;

			while (aux.siguiente != null)
			{
				String direccion;
				{
					std::ostringstream ostm = new std::ostringstream();
					ostm << reinterpret_cast<Short>(aux);
					direccion = ostm.str();
				}

				String direccionsig;
				{
					std::ostringstream ostms = new std::ostringstream();
					ostms << reinterpret_cast<Short>(aux.siguiente);
					direccionsig = ostms.str();
				}

				graph += "\t" + direccion + "[label=\"" + aux.avion.toString() + "\"];\n";
				graph += "\t" + direccionsig + "[label=\"" + aux.siguiente.avion.toString() + "\"];\n";
				graph += "\t" + direccion + " -> " + direccionsig;

				aux = aux.siguiente;
			}
		}
		else
		{
			graph += "Vacio";
		}
	}


	public final void pushD(Avion avion){
		Nodo nuevo = new Nodo(new Avion(avion));
		if (this.cabezaD == null)
		{
			this.cabezaD = this.colaD = nuevo;
		}
		else
		{
			this.colaD.siguiente = nuevo;
			nuevo.anterior = this.colaD;
			this.colaD = nuevo;
		}
		++tamanioD;
	}
	public final Nodo * struct popD(){
		if (this.cabezaD != null){
			if (this.cabezaD.siguiente != null){
				Nodo aux = this.cabezaD;
				this.cabezaD = this.cabezaD.siguiente;
				aux.siguiente = null;
				this.cabezaD.anterior = null;
				--tamanioD;
				return aux;
			}
			else{
				Nodo aux = this.cabezaD;
				this.cabezaD = null;
				--tamanioD;
				return aux;
			}
		}
		return null;
	}
        
	public final void grafoAvionD(){
		String grafo = "digraph g{\n";
		grafo += "\t node[shape=box, style=filled, color=Gray95];\n";
		grafo += "\t edge[color=black];\n";
		grafo += "\t subgraph ColaAvionDesabordaje{\n";
		grafo += "\t node[style=filled];\n";
		this.cadenaAvionD(grafo);
		grafo += "\t}\n";
		grafo += "}\n";
		ofstream archivo = new ofstream("grafoAvionD.dot");
		archivo << grafo;
		archivo.close();
		system("dot -Tpng grafoAvionD.dot -o grafoAvionD.png");
	}
        
	public final void cadenaAvionD(String graph){
		if (this.cabezaD != null){
			Nodo aux = this.cabezaD;
			while (aux.siguiente != null){
				String direccion;
				{
					std::ostringstream ostm = new std::ostringstream();
					ostm << reinterpret_cast<Short>(aux);
					direccion = ostm.str();
				}

				String direccionsig;
				{
					std::ostringstream ostms = new std::ostringstream();
					ostms << reinterpret_cast<Short>(aux.siguiente);
					direccionsig = ostms.str();
				}

				if (aux.anterior != null){

					String direccionAnt;
					{
						std::ostringstream ostmA = new std::ostringstream();
						ostmA << reinterpret_cast<Short>(aux.anterior);
						direccionAnt = ostmA.str();
					}

					graph += "\t" + direccionAnt + "[label=\"" + aux.anterior.avion.toString() + "\"];\n";
					graph += "\t" + direccion + " -> " + direccionAnt;

				}
				graph += "\t" + direccion + "[label=\"" + aux.avion.toString() + "\"];\n";
				graph += "\t" + direccionsig + "[label=\"" + aux.siguiente.avion.toString() + "\"];\n";
				graph += "\t" + direccion + " -> " + direccionsig;

				aux = aux.siguiente;
			}
		}
		else{
			graph += "Vacio";
		}
	}

	public final void recorrer(){
		if (this.cabeza != null){
			Nodo aux = this.cabeza;
			while (aux != null){
				System.out.print("Cola : ");
				System.out.print(aux.pasajero.toString());
				System.out.print("\n");
				aux = aux.siguiente;
			}
		}
		else{
			System.out.print("Vacio DX !!");
			System.out.print("\n");
		}
	}
	public final void recorrerD(){
		if (this.cabezaD != null){
			Nodo aux = this.cabezaD;
			while (aux != null){
				System.out.print("Cola : ");
				System.out.print(aux.avion.toString());
				System.out.print("\n");
				aux = aux.siguiente;
			}
		}
		else{
			System.out.print("Vacio DX !!");
			System.out.print("\n");
		}
	}

}
