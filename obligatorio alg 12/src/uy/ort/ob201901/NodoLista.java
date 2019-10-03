package uy.ort.ob201901;

public class NodoLista<T> {
	private T dato;
	private NodoLista<T> sig;
	
	// alt shift s + o + enter
	public NodoLista(T dato, NodoLista<T> inicio) {
		this.dato = dato;
		this.sig = inicio;
	}

	public NodoLista(T dato) {
		this.dato = dato;
	}

	// alt shift s + r + (alt + a) + o + enter 
	public T getDato() {
		return dato;
	}

	public void setDato(T dato) {
		this.dato = dato;
	}

	public NodoLista<T> getSig() {
		return sig;
	}

	public void setSig(NodoLista<T> sig) {
		this.sig = sig;
	}

	// alt shift s + s + enter
	@Override
	public String toString() {
		return dato + "";
	}
	
	
	
	
}
