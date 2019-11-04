package uy.edu.ort.obli;



public class Vertice {
	public enum Estado {Monopatin,Esquina};
	private Estado estados;
	
	 private ListaAdy<Arista> listaArista;
	 private double coordX;
	 private double coordY;
	
	 
	 
	 
	 public Vertice( ListaAdy<Arista> listaArista,double coordX, double coordY) {
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
	 
	public ListaAdy<Arista> getListaArista() {
		return listaArista;
	}
	public void setListaArista(ListaAdy<Arista> listaArista) {
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

	public Estado getEstados() {
		return estados;
	}

	public void setEstados(Estado estados) {
		this.estados = estados;
	}



}
