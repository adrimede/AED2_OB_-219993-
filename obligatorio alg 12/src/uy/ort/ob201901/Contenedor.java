package uy.ort.ob201901;





public class Contenedor extends Vertice {
	//private ListaSE<Arista> listaArista;
	 private String nombre;
	 public TipoContenedor tipo;
	 public enum Estados { LLENO, ROTO, DISPONIBLE };
	 public enum TipoContenedor { PLASTICOS, PILAS, PAPEL, ORGANICOS, VIDRIO };
	 private String CIgestor;
	 private int capacidad;
	
	
	 
	


	public String getNombre() {
		return nombre;
	}


	public Contenedor(ListaSE<Arista> listaArista, double coordX, double coordY, String nombre,TipoContenedor tipo,
			String cIgestor, int capacidad) {
		super(listaArista, coordX, coordY);
		this.nombre = nombre;
		this.tipo = tipo;
		CIgestor = cIgestor;
		this.capacidad = capacidad;
		
	}
	

	
	
	
	public Contenedor(String nombre2, String cIgestor2,TipoContenedor tipo2, double coordX,
			double coordY) {
		super(coordX, coordY);
		this.nombre = nombre2;
		this.tipo = tipo2;
		this.CIgestor = cIgestor2;
		// TODO Apéndice de constructor generado automáticamente
	}


	


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	//public double getCoordX() {
//		return coordX;
////	}


//	public void setCoordX(double coordX) {
//		this.coordX = coordX;
//	}


	//public double getCoordY() {
	//	return coordY;
	//}


	//public void setCoordY(double coordY) {
	//	this.coordY = coordY;
	//}


	public TipoContenedor getTipo() {
		return tipo;
	}


	public void setTipo(TipoContenedor tipo) {
		this.tipo = tipo;
	}


	public String getCIgestor() {
		return CIgestor;
	}


	public void setCIgestor(String cIgestor) {
		CIgestor = cIgestor;
	}


	public int getCapacidad() {
		return capacidad;
	}


	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}





	//public ListaSE<Arista> getListaArista() {
	//	return listaArista;
	//}


	//public void setListaArista(ListaSE<Arista> listaArista) {
	//	this.listaArista = listaArista;
	//}
	 

	 
	 
	// alt shift s + r + (alt + a) + o + enter 
	 
	 
	 
}
