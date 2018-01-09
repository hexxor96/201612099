package proyecto2;

public class Escritorio{

	public int id;
        public int escritorio;
	public ColaSimple cola;
	public Pila pilaDocumentos;

	public static int crearEscritorios(ListaDoblementeEnlazada lista, int cantidad){
		for (int i = 0;i < cantidad;i++){
			ListaDoblementeEnlazada.insertar(lista, ListaDoblementeEnlazada.crearEscritorio(i + 65));
		}
		return 0;
	}
}