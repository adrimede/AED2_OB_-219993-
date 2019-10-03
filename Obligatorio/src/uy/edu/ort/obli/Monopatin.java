package uy.edu.ort.obli;

public class Monopatin extends Vertice {

	private String chipId;
	public enum Estados { Averiado, Descargado, Activo };
	
	public Monopatin(String chipId,ListaAdy<Arista> listaArista, double coordX, double coordY) {
		super(listaArista, coordX, coordY);
		
		this.chipId=chipId;
		
	}


	public String getChipId() {
		return chipId;
	}



	public void setChipId(String chipId) {
		this.chipId = chipId;
	}

	
	
	
	
}
