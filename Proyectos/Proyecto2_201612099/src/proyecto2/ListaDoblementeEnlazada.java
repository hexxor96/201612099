package proyecto2;

public class ListaDoblementeEnlazada
{

	public ldNodo primero;
	public ldNodo ultimo;
	public int length;
	public int numeroEscritorios;

	public static int crearLista(ListaDoblementeEnlazada lista){
		lista.primero = null;
		lista.ultimo = null;
		lista.length = 0;
		lista.numeroEscritorios = 0;
		return 0;
	}
        
	public static int insertar(ListaDoblementeEnlazada lista, Escritorio escritorio){
		ldNodo nuevo = new ldNodo();
		nuevo.escritorio = escritorio;
		if (esVacia(lista) == 0){
			ldNodo aux = new ldNodo();
			aux = lista.primero;
			while (nuevo.escritorio.id < aux.escritorio.id && aux != null){
				aux = aux.siguiente;
			}
			if (aux != null){
			if (aux.anterior != null){
				nuevo.siguiente = aux;
				nuevo.anterior = aux.anterior;
				aux.anterior.siguiente = nuevo;
				aux.anterior = nuevo;
				lista.length++;
			}
			else{
				nuevo.siguiente = aux;
				aux.anterior = nuevo;
				lista.primero = nuevo;
				lista.length++;
			}
			}
			else{
				lista.ultimo.siguiente = nuevo;
				nuevo.anterior = lista.ultimo;
				nuevo.siguiente = null;
				lista.ultimo = nuevo;
				lista.length++;
			}
		}
		else{
			lista.primero = nuevo;
			lista.ultimo = nuevo;
			lista.length++;
		}
		return 0;
	}
        
	public static int esVacia(ListaDoblementeEnlazada lista){
		if (lista.length > 0){
			return 0;
		}
		return 1;
	}
        
	public static int getSize(ListaDoblementeEnlazada lista){
		return lista.length;
	}
        
	public static String escribirDOT(ListaDoblementeEnlazada lista){
		String texto = "subgraph cluster_2 { ";
		texto += "label = \"Escritorios de registro\";\n";
		if (esVacia(lista) == 0){
			ldNodo aux = lista.ultimo;
			while (aux != null){
				texto += "\"Escritorio " + aux.escritorio.id + "\"";
				texto += "[label=\"{<f0>Escritorio: " + aux.escritorio.id + "|";
				if (aux.escritorio.cola.primero != null){
					texto += "<f1>Ocupado? Si|";
					texto += "<f2>Pasajero atendido: " + aux.escritorio.cola.primero.pasajero.id + "|";
					texto += "<f3>Documentos: " + aux.escritorio.pilaDocumentos.length + "|";
					texto += "<f4>Turnos: " + aux.escritorio.cola.primero.pasajero.numeroTurnos;
				}
				else{
					texto += "<f1>Ocupado? No|";
					texto += "<f3>Documentos: 0";
				}
				texto += "}\" shape=record];\n";
				aux = aux.anterior;
			}
		}
		texto += "{rank=same;\n";
		if (esVacia(lista) == 0){
			ldNodo aux = lista.primero;
			while (aux != null){
				if (aux.siguiente != null){
					texto += "\"Escritorio " + aux.escritorio.id + "\"->\"Escritorio " + aux.siguiente.escritorio.id + "\";\n";
					texto += "\"Escritorio " + aux.siguiente.escritorio.id + "\"->\"Escritorio " + aux.escritorio.id + "\";\n";
					aux = aux.siguiente;
				}
				else{
					aux = aux.siguiente;
				}
			}
		}
		texto += "}\n";
		texto += "{";
		if (esVacia(lista) == 0){
			ldNodo aux = lista.primero;
			while (aux != null){
				if (aux.escritorio.cola.primero != null){
					csNodo aux2 = aux.escritorio.cola.primero;
					while (aux2 != null){
						texto += "\"Pasajero2 " + aux2.pasajero.id + "\"";
						texto += "[label=\"{<f0>Pasajero: " + aux2.pasajero.id + "|";
						texto += "<fi>Avion: " + aux2.pasajero.avion + "|";
						texto += "<f2>Maletas: " + aux2.pasajero.maletas + "|";
						texto += "<f3>Documentos: " + aux2.pasajero.documentos + "|";
						texto += "<f4>Turnos: " + aux2.pasajero.numeroTurnos + "";
						texto += "}\" shape=record];\n";
						aux2 = aux2.siguiente;
					}
					csNodo aux3 = aux.escritorio.cola.primero;
					if (aux3 != null){
						texto += "\"Escritorio " + aux.escritorio.id + "\"->\"Pasajero2 " + aux3.pasajero.id + "\";";
					}
					while (aux3.siguiente != null){
						texto += "\"Pasajero2 " + aux3.pasajero.id + "\"->\"Pasajero2 " + aux3.siguiente.pasajero.id + "\";";
						aux3 = aux3.siguiente;
					}
				}
				aux = aux.siguiente;
			}
		}
		texto += "}\n}\n";
		return texto;
	}
        
        public static Escritorio crearEscritorio(byte id_){
		Escritorio nuevo = new Escritorio();
		nuevo.id = id_;
		nuevo.cola = new ColaSimple();
		nuevo.pilaDocumentos = new Pila();
		return nuevo;

	}
        
	public static int crearEscritorios(ListaDoblementeEnlazada lista, int cantidad){
		for (int i = 0; i < cantidad; i++){
		}
		return 0;
	}
        
	public static int ingresar(ColaSimple cola, Pasajero pasajero){
		System.out.print("aqui");
		System.out.print("\n");
		System.out.print(cola.primero);
		System.out.print("\n");
		System.out.print("aqui no xd ");
		System.out.print("\n");
		return 0;
	}
        
	public static int espaciosVacios(ListaDoblementeEnlazada lista){
		int contador = 0;
		if (esVacia(lista) == 0){
			ldNodo aux = lista.primero;
			while (aux != null){
				contador++;
				aux = aux.siguiente;
			}
		}
		return contador;
	}
        
	public static String escribirInformacion(ListaDoblementeEnlazada lista){
		String texto = "-------Escritorios de registro------\n";
		if (esVacia(lista) == 0){
			ldNodo aux = lista.primero;
			while (aux != null){
				texto += "Escritorio " + aux.escritorio.id + "\n";
				if (aux.escritorio.cola.primero != null){
					texto += "        Ocupado? Si \n";
					texto += "        Pasajero atendido: " + aux.escritorio.cola.primero.pasajero.id + "\n";
					texto += "        Documentos: " + aux.escritorio.pilaDocumentos.length + "\n";
					texto += "        Turnos: " + aux.escritorio.cola.primero.pasajero.numeroTurnos + "\n";
				}
				else{
					texto += "        Ocupado? No\n";
					texto += "        Documentos: 0\n";
				}
				aux = aux.siguiente;
			}
		}
		texto += "-----------------------------------\n";
		return texto;
	}
        
}