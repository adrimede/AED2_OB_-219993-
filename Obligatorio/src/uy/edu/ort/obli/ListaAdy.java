package uy.edu.ort.obli;

import java.util.Iterator;




public class ListaAdy<T> implements ILista<T> {

	protected NodoLista<T> inicio;
	protected int cantidad;
	
	
	@Override
	public void agregar(T dato) {
		agregarPpio(dato);
	}
	
	protected void agregarPpio(T dato)
	{
		NodoLista<T> nuevo = new NodoLista<T>(dato, inicio);
		inicio = nuevo;
		
		cantidad++;
	}

	@Override
	public void borrar(T dato) {
		if(inicio.getDato().equals(dato))
		{
			borrarPpio(); //inicio = inicio.getSig();
		}else{
			NodoLista<T> aux = inicio;
			while(aux.getSig() != null && 
					!aux.getSig().getDato().equals(dato))
			{
				aux = aux.getSig();
			}
			aux.setSig(aux.getSig().getSig());
			cantidad--;
		}
	}
	
	
	@Override
	public void borrarPos(int dato) {
		if(inicio.getDato().equals(dato))
		{
			borrarPpio(); //inicio = inicio.getSig();
		}else{
			NodoLista<T> aux = inicio;
			while(aux.getSig() != null && 
					!aux.getSig().getDato().equals(dato))
			{
				aux = aux.getSig();
			}
			aux.setSig(aux.getSig().getSig());
			cantidad--;
		}
	}

	@Override
	public void borrarPpio() {
		inicio = inicio.getSig();
		
		cantidad--;
	}

	@Override
	public void borrarFin() {
		if(cantidad == 1){
			borrarPpio();
		}else{
			NodoLista<T> aux = inicio;
			while(aux.getSig().getSig() != null)
			{
				aux = aux.getSig();
			}
			aux.setSig(null);
			cantidad--;
		}
	}

	@Override
	public int largo() {
		return cantidad;
	}

	@Override
	public boolean existe(T dato) {
		boolean esta = false;
		NodoLista<T> aux = inicio;
		while(aux != null && !esta){
			if(aux.getDato().equals(dato))
			{
				esta = true;
			} else {
				aux = aux.getSig();
			}
		}
		return esta;
	}

	@Override
	public boolean esVacia() {
		return inicio == null;
	}

	@Override
	public Iterator<T> iterator() {
		return new Iterator<T>() {

			NodoLista<T> aux = inicio;
			
			@Override
			public boolean hasNext() {
				return aux != null;
			}

			@Override
			public T next() {
				T dato = aux.getDato();
				aux = aux.getSig();
				return dato;
			}
		};
	}

	@Override
	public T recuperar(T dato) {
		NodoLista<T> aux = inicio;
		while(aux != null){
			if(aux.getDato().equals(dato))
			{
				return aux.getDato();
			}
			aux = aux.getSig();
		}
		return null;
	}

	


	
}
