package proyecto2;

public class ListaSimple
{

	public sNodo primero;
	public sNodo ultimo;
	public int length;

        public static int crearLista(ListaSimple lista){
		lista.primero = null;
		lista.ultimo = null;
		lista.length = 0;
		return 0;
	}
        
	public static int insertar(ListaSimple lista, int id){
		sNodo nuevo = new sNodo();
		nuevo.id = id;
		if (lista.length > 0){
				lista.ultimo.siguiente = nuevo;
				lista.ultimo = nuevo;
				lista.length++;
		}
		else{
			lista.primero = nuevo;
			lista.ultimo = nuevo;
			lista.length++;
		}
		return 0;
	}
        
	public static String escribirDOT(ListaSimple lista){
		String texto = "subgraph cluster_6 { ";
		texto += "label = \"Estaciones de mantenimiento\";\n";
		if (lista.length > 0){
			sNodo aux = lista.primero;
			while (aux != null){
				texto += "\"Estacion " + aux.id + "\"";
				texto += "[label=\"{<f0>Estacion: " + aux.id + "|";
				if (aux.avion != null){
					texto += "<f1>Ocupado? Si|";
					texto += "<f2>Avion atendido: " + aux.avion.id + "|";
					texto += "<f3>Turnos: " + aux.avion.mantenimiento;
				}
				else{
					texto += "<f1>Ocupado? No|";
					texto += "<f3>Turnos: 0";
				}
				texto += "}\" shape=record];\n";
				aux = aux.siguiente;
			}
		}
		texto += "{rank=same;\n";
		if (lista.length > 0){
			sNodo aux = lista.primero;
			while (aux.siguiente != null)
			{
				texto += "\"Estacion " + aux.id + "\"->\"Estacion " + aux.siguiente.id + "\";";
				aux = aux.siguiente;
			}
		}

		texto += "}\n}\n";
		return texto;
	}
        
	public static int crearEstaciones(ListaSimple lista, int cantidad){
		crearLista(lista);
		if (cantidad > 0){
			for (int i = 0; i < cantidad; i++){
				insertar(lista, i + 1);
			}
		}
		return 0;
	}

	public static String escribirInformacion(ListaSimple lista){
		String texto = "*********Estaciones de mantenimiento*********\n";
		if (lista.length > 0){
			sNodo aux = lista.primero;
			while (aux != null){
				texto += "Estacion " + aux.id + ":\n";
				if (aux.avion != null){
					texto += "       Estado: Ocupado.\n";
					texto += "       Avion atendido: " + aux.avion.id + ".\n";
					texto += "       Turnos restantes: " + aux.avion.mantenimiento + ".\n";
				}
				else{
					texto += "       Estado: libre.\n";
					texto += "       Avion atendido: Ninguno.\n";
					texto += "       Turnos restantes: ....\n";
				}
				aux = aux.siguiente;
			}
		}
		texto += "***********************************************\n";
		return texto;
	}   
}