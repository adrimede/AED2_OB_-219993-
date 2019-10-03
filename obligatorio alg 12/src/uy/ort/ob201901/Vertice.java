package uy.ort.ob201901;

public abstract class Vertice  {
	
	public enum Estado { Contenedor,Esquina};
	private Estado estados;
	 private ListaSE<Arista> listaArista;
	 private double coordX;
	 private double coordY;
	 
	 
	 
	 
	 public Vertice(ListaSE<Arista> listaArista, double coordX, double coordY) {
		super();
		this.listaArista = listaArista;
		this.coordX = coordX;
		this.coordY = coordY;
		
	}
	 
	 public Vertice(double coordX, double coordY) {
			super();
		
			this.coordX = coordX;
			this.coordY = coordY;
			
		}
	 
	 
	
	


	public ListaSE<Arista> getListaArista() {
		return listaArista;
	}
	public void setListaArista(ListaSE<Arista> listaArista) {
		this.listaArista = listaArista;
	}
	public double getCoordX() {
		return coordX;
	}
	public void setCoordX(double coordX) {
		this.coordX = coordX;
	}
	public double getCoordY() {
		return coordY;
	}
	public void setCoordY(double coordY) {
		this.coordY = coordY;
	}

	public Estado getEstado() {
		return estados;
	}

	public void setEstado(Estado estados) {
		this.estados = estados;
	}
	
}
