package uy.ort.ob201901;



public class Gestor implements Comparable<Object>{

	private String cedula;
	private String nombre;
	private String celular;
	//private ILista<Contenedor> listaContenedoresDelGestor;
	
	
	
	
	public Gestor(String cedula, String nombre, String celular) {
		super();
		this.cedula = cedula;
		this.nombre = nombre;
		this.celular = celular;
		//this.setListaContenedoresDelGestor(listaContenedoresDelGestor);
	
	}
	
	public String getCedula() {
		return cedula;
	}
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCelular() {
		return celular;
	}
	public void setCelular(String celular) {
		this.celular = celular;
	}
	
	//public ILista<Contenedor> getListaContenedoresDelGestor() {
	//	return listaContenedoresDelGestor;
	//}

	//public void setListaContenedoresDelGestor(ILista<Contenedor> listaContenedoresDelGestor) {
	//	this.listaContenedoresDelGestor = listaContenedoresDelGestor;
	//}
	
	
	public Gestor(String cedula) {
		
		
		this.cedula = cedula;
		
	}

	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Gestor other = (Gestor) obj;
		if (cedula != other.cedula)
			return false;
		return true;
	}

	@Override
	public int compareTo(Object arg0) {
		   int r=(this.getCedula().compareTo(((Gestor) arg0).getCedula())*-1);
		    return r;
	}

	
}
