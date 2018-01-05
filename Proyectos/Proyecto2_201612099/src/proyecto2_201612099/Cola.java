package proyecto2_201612099;

import java.io.*;
import java.util.Scanner;

public class Cola {

	public Nodo cabeza;
	public Nodo cola;


	public Nodo cabezaD;
	public Nodo colaD;

	public int tamanio;
	public int tamanioD;

	public Cola(){
		this.cabeza = null;
		this.cola = null;

		this.cabezaD = null;
		this.colaD = null;

		this.tamanio = 0;
		this.tamanioD = 0;

	}
        
	public final void push(Pasajero pasajero){
		Nodo nuevo = new Nodo(pasajero);
		if (this.cabeza == null){
			this.cabeza = nuevo;
			this.cola = nuevo;
		}
		else{
			this.cola.siguiente = nuevo;
			this.cola = nuevo;
		}
		++tamanio;
	}
        
	public final Nodo pop(){
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
        
        
	public final void pushA(Avion avion){
		Nodo nuevo = new Nodo(avion);
		if (this.cabeza == null){
			this.cabeza = nuevo;
			this.cola = nuevo;
		}
		else{
			this.cola.siguiente = nuevo;
			this.cola = nuevo;
		}
		++tamanio;
	}
        
	public final Nodo popA(){
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
		if (this.cabeza != null){
			Nodo aux = this.cabeza;
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

	


	public final void pushD(Avion avion){
		Nodo nuevo = new Nodo(avion);
		if (this.cabezaD == null){
			this.cabezaD = this.colaD = nuevo;
		}
		else{
			this.colaD.siguiente = nuevo;
			nuevo.anterior = this.colaD;
			this.colaD = nuevo;
		}
		++tamanioD;
	}
        
	public final Nodo popD(){
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
