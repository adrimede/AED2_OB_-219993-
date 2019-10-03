package uy.edu.ort.obli;

public interface ILista<T> extends Iterable<T> {
	
	// Pre: 
	// Pos: Agrega al elemento 'dato' en la lista
	public void agregar(T dato);

	// Pre: existe(dato)
	// Pos: Borra al elemento 'dato' de la lista
	public void borrar(T dato);
	
	// Pre: existe(dato)
		// Pos: Borra al elemento 'dato' de la lista
		public void borrarPos(int dato);

	// Pre: !esVacia()
	// Pos: Borra al primer elemento de la lista
	public void borrarPpio();
	
	// Pre: !esVacia()
	// Pos: Borra al último elemento de la lista
	public void borrarFin();

	// Pre: 
	// Pos: Retorna el largo de la lista
	public int largo();

	// Pre:
	// Pos: Retorna true si 'dato' está en la lista. False en caso contrario.
	public boolean existe(T dato);

	// Pre: existe(dato)
	// Pos: retorna un elemento "igual" al pedido
	public T recuperar(T dato);

	// Pre:
	// Pos: Retorna true si la lista no tiene elementos. False en caso contrario.
	public boolean esVacia();
	
	
	
}
