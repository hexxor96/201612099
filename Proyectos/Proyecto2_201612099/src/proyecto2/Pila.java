package proyecto2;

public class Pila{
	public pNodo primero;
	public pNodo ultimo;
	public int length;

        public static int crearPila(Pila pila){
		pila.primero = null;
		pila.ultimo = null;
		pila.length = 0;
		return 0;
	}
        
	public static int push(Pila pila){
		pNodo nuevo = new pNodo();
		if (pila.length > 0){
		pila.ultimo.siguiente = nuevo;
		nuevo.anterior = pila.ultimo;
		pila.ultimo = nuevo;
		pila.length++;
		}
		else{
			pila.primero = nuevo;
			pila.ultimo = nuevo;
			pila.length++;
		}
		return 0;
	}
        
	public static int pop(Pila pila){
		if (pila.length > 0){
			if (pila.length > 1){
				pila.ultimo.anterior.siguiente = null;
				pila.ultimo = pila.ultimo.anterior;
				pila.length--;
			}
			else{
				pila.ultimo = null;
				pila.primero = null;
				pila.length = 0;
			}
		}
		return 0;
	}
}