package proyecto2;

public class ListaDobleCircular
{

	public ldcNodo primero;
	public ldcNodo ultimo;
	public int length;
	public int contador;
	
        public static int crearLista(ListaDobleCircular lista){
		lista.primero = null;
		lista.ultimo = null;
		lista.length = 0;
		lista.contador = 1;
		return 0;
	}
        
	public static int insertar(ListaDobleCircular lista){
		ldcNodo nuevo = new ldcNodo();
		nuevo.id = lista.contador;
		lista.contador++;
		if (esVacia(lista) == 0){
			lista.ultimo.siguiente = nuevo;
			nuevo.anterior = lista.ultimo;
			nuevo.siguiente = lista.primero;
			lista.primero.anterior = nuevo;
			lista.ultimo = nuevo;
			lista.length++;
		}
		else{
			lista.primero = nuevo;
			lista.ultimo = nuevo;
			nuevo.siguiente = nuevo;
			nuevo.anterior = nuevo;
			lista.length++;
		}
		return 0;
	}
        
	public static int eliminar(ListaDobleCircular lista){
		if (esVacia(lista) == 0){
			if (lista.length > 1){
				lista.primero.anterior = lista.ultimo.anterior;
				lista.ultimo.anterior.siguiente = lista.primero;
				lista.ultimo = lista.ultimo.anterior;
				lista.length--;
				lista.contador--;
			}
			else{
				lista.primero = null;
				lista.ultimo = null;
				lista.length = 0;
				lista.contador = 1;
			}
		}
		return 0;
	}
        
	public static int esVacia(ListaDobleCircular lista){
		if (lista.length > 0){
			return 0;
		}
		return 1;
	}
        
	public static String escribirDOT(ListaDobleCircular lista){
		String texto = "subgraph cluster_3 { \n";
		texto += "label = \"Equipaje\";\n";
		if (esVacia(lista) == 0){
			ldcNodo aux = lista.primero;
                        texto += "\"Maleta " + aux.id + "\"";
			texto += "[label=\"Maleta: " + aux.id;
			texto += "\" shape=record];\n";
			aux = aux.siguiente;
			while (aux != lista.primero){
				texto += "\"Maleta " + aux.id + "\"";
				texto += "[label=\"Maleta: " + aux.id;
				texto += "\" shape=record];\n";
				aux = aux.siguiente;
			}
		}
		texto += "{\n";
		//PARA COLOCAR LAS RELACIONES
		if (esVacia(lista) == 0){
			ldcNodo aux = lista.primero;
			if (aux.siguiente != aux && lista.length > 2){
				texto += "\"Maleta " + aux.id + "\"->\"Maleta " + aux.siguiente.id + "\";\n";
				texto += "\"Maleta " + aux.siguiente.id + "\"->\"Maleta " + aux.id + "\";\n";
				aux = aux.siguiente;
			}
			if (lista.length == 2){
				aux = aux.siguiente;
			}
			while (aux != lista.primero){
				if (aux.siguiente != null){
					texto += "\"Maleta " + aux.id + "\"->\"Maleta " + aux.siguiente.id + "\";\n";
					texto += "\"Maleta " + aux.siguiente.id + "\"->\"Maleta " + aux.id + "\";\n";
					aux = aux.siguiente;

				}
				else{
					aux = aux.siguiente;
				}
			}
		}
		texto += "}\n}\n";
		return texto;
	}

}