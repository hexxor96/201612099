package proyecto2;

public class ColaSimple
{
	public csNodo primero;
	public csNodo ultimo;
	public int length;
        
    public static int crearCola(ColaSimple cola){
		cola.length = 0;
		cola.primero = null;
		cola.ultimo = null;
		return 0;
	}
    
	public static int queue(ColaSimple cola, Pasajero pasajero_){
		csNodo nuevo = new csNodo();
		nuevo.pasajero = pasajero_;
		if (esVacia(cola) == 0){
			cola.ultimo.siguiente = nuevo;
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
        
	public static int dequeue(ColaSimple cola){
		if (esVacia(cola) == 0){
			if (cola.primero.siguiente != null){
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
        
	public static int esVacia(ColaSimple cola){
		if (cola.length > 0){
			return 0;
		}
		return 1;
	}
        
	public static Pasajero primero(ColaSimple cola){
                if (esVacia(cola) == 0){
                    return cola.primero.pasajero;
                }
		return cola.ultimo.pasajero;
	}
        
	public static int getSize(ColaSimple cola){
		return cola.length;
	}
        
	public static String escribirDOT(ColaSimple cola){
		String texto = "subgraph cluster_1 { ";
		texto += "label = \"Desabordaje\";\n";
		if (esVacia(cola) == 0){
			csNodo aux = cola.primero;
			while (aux != null){
				texto += "\"Pasajero " + aux.pasajero.id + "\"";
				texto += "[label=\"{<f0>Pasajero: " + aux.pasajero.id + "|";
				texto += "<fi>Avion: " + aux.pasajero.avion + "|";
				texto += "<f2>Maletas: " + aux.pasajero.maletas + "|";
				texto += "<f3>Documentos: " + aux.pasajero.documentos + "|";
				texto += "<f4>Turnos: " + aux.pasajero.numeroTurnos + "";
				texto += "}\" shape=record];\n";
				aux = aux.siguiente;
			}
		}
		if (esVacia(cola) == 0){
			csNodo aux = cola.primero;
			while (aux != null){
				if (aux.siguiente != null){
					texto += "\"Pasajero " + aux.pasajero.id + "\"->\"Pasajero " + aux.siguiente.pasajero.id + "\";\n";
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
        
            public static Pasajero crearPasajero(int id_, int avion_){
		Pasajero nuevo = new Pasajero();
		nuevo.avion = avion_;
		nuevo.id = id_;
		nuevo.maletas = (int) (Math.random()) %4 + 1;
		nuevo.documentos = (int) (Math.random()) % 10 + 1;
		nuevo.numeroTurnos = (int) (Math.random()) % 3 + 1;
		return nuevo;
	}
}