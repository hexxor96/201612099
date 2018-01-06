package proyecto2;

public class ColaSimpleAviones
{
	public lNodo primero;
	public lNodo ultimo;
	public int length;
        
        public static int crearCola(ColaSimpleAviones cola){
		cola.length = 0;
		cola.primero = null;
		cola.ultimo = null;
		return 0;
	}
        
	public static int queue(ColaSimpleAviones cola, Avion avion_){
		lNodo nuevo = new lNodo();
		nuevo.avion = avion_;
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
        
	public static int dequeue(ColaSimpleAviones cola){
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
        
	public static int esVacia(ColaSimpleAviones cola){
		if (cola.length > 0){
			return 0;
		}
		return 1;
	}
        
    	public static String escribirDOT(ColaSimpleAviones cola){
		String texto = "subgraph cluster_5 { \n";
		texto += "label = \"Mantenimiento\";\n";
		if (esVacia(cola) == 0){
			lNodo aux = cola.primero;
			while (aux != null){
				texto += "\"Avion " + aux.avion.id;
				texto += "\"[label=\"{<f0>Avion: " + aux.avion.id + "|";
				texto += "<f1>Tipo: " + aux.avion.tipo + "|";
				texto += "<f2>Mantenimiento: " + aux.avion.mantenimiento;
				texto += "}\" shape=record];\n";
				aux = aux.siguiente;
			}
		if (esVacia(cola) == 0){
			lNodo aux1 = cola.primero;
			while (aux1 != null){
				if (aux1.siguiente != null){
					texto += "\"Avion " + aux.avion.id + "\"->\"Avion " + aux.siguiente.avion.id + "\";\n";
					aux = aux.siguiente;
				}
				else{
					aux = aux.siguiente;
				}
			}
		}
            }    
            texto += "}\n";
            return texto;   
        }
}