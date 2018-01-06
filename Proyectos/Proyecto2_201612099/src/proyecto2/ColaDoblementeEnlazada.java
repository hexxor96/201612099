package proyecto2;

public class ColaDoblementeEnlazada
{

	public Nodo primero;
	public Nodo ultimo;
	public int length;
        
        public static int crearCola(ColaDoblementeEnlazada cola){
		cola.length = 0;
		cola.primero = null;
		cola.ultimo = null;
		return 0;
	}
        
	public static int queue(ColaDoblementeEnlazada cola, Avion avion_){
		Nodo nuevo = new Nodo();
		nuevo.avion = avion_;
		if (esVacia(cola) == 0){
			cola.ultimo.siguiente = nuevo;
			nuevo.anterior = cola.ultimo;
			cola.ultimo = nuevo;
			cola.length++;
		}
		else{
			cola.primero = nuevo;
			cola.ultimo = nuevo;
			cola.length++;
		}
		return 0;
	}
        
	public static int dequeue(ColaDoblementeEnlazada cola){
		if (esVacia(cola) == 0){
			if (cola.primero.siguiente != null){
				cola.primero.siguiente.anterior = null;
				cola.primero = cola.primero.siguiente;
				cola.length--;
			}
			else{
				cola.primero = null;
				cola.ultimo = null;
				cola.length = 0;
			}
		}
		return 0;
	}
        
	public static int esVacia(ColaDoblementeEnlazada cola){
		if (cola.length > 0){
			return 0;
		}
		return 1;
	}
        
	public static int estaLlena(ColaDoblementeEnlazada cola){
		if (esVacia(cola) == 0){
			return 1;
		}
		return 0;
	}
        
	public static Avion primero(ColaDoblementeEnlazada cola){
		if (esVacia(cola) == 0){
		}
                return cola.primero.avion;
	}
        
	public static int getSize(ColaDoblementeEnlazada cola){
		return cola.length;
	}
        
	public static int imprimirCola(ColaDoblementeEnlazada cola){
		if (esVacia(cola) == 0){
			Nodo aux = cola.primero;
			while (aux != null){
				System.out.print(aux.avion.id);
				System.out.print("\n");
				aux = aux.siguiente;
			}
		}
		return 0;
	}
        
	public static String escribirDOT(ColaDoblementeEnlazada cola){
		String texto = "subgraph cluster_0 { \n";
		texto += "label = \"Llegadas de aviones\";\n";
		if (esVacia(cola) == 0){
			Nodo aux = cola.primero;
			while (aux != null){
				texto += "\"Avion " + aux.avion.id;
				texto += "\"[label=\"{<f0>Avion: " + aux.avion.id + "|";
				texto += "<f1>Tipo: " + aux.avion.tipo + "|";
				texto += "<f2>Desbordaje: " + aux.avion.desabordaje + "|";
				texto += "<f3>Pasajeros: " + aux.avion.pasajeros + "|";
				texto += "<f4>Mantenimiento: " + aux.avion.mantenimiento;
				texto += "}\" shape=record];\n";
				aux = aux.siguiente;
			}
		}
		if (esVacia(cola) == 0){
			Nodo aux = cola.primero;
			while (aux != null){
				if (aux.siguiente != null){
					texto += "\"Avion " + aux.avion.id + "\"->\"Avion " + aux.siguiente.avion.id + "\";\n";
					texto += "\"Avion " + aux.siguiente.avion.id + "\"->\"Avion " + aux.avion.id + "\";\n";
					aux = aux.siguiente;
				}
				else{
					aux = aux.siguiente;
				}
			}
		}
		texto += "}\n";
		return texto;
	}
        
            public static Avion crearAvion(int id_){
		Avion nuevo = new Avion();
		nuevo.id = id_;
		nuevo.desabordaje = (int) (Math.random()) % 3 + 1;
		if (nuevo.desabordaje == 1){
			nuevo.tipo = "pequeño";
			nuevo.pasajeros = (int) (Math.random()) % 5 + 5;
			nuevo.mantenimiento = (int) (Math.random()) % 3 + 1;
		}
		else if (nuevo.desabordaje == 2){
			nuevo.tipo = "mediano";
			nuevo.pasajeros = (int) (Math.random()) % 10 + 15;
			nuevo.mantenimiento =  (int) (Math.random()) % 3 + 2;
		}
		else if (nuevo.desabordaje == 3){
			nuevo.tipo = "grande";
			nuevo.pasajeros =  (int) (Math.random()) % 10 + 30;
			nuevo.mantenimiento = (int) (Math.random()) % 4 + 3;
		}
		return nuevo;
	}
}