package uy.edu.ort.obli;


public class Usuario implements Comparable<Object>{
	private String email;
	private String nombre;
	
	
	public Usuario(String email, String nombre) {
		this.email=email;
		this.nombre=nombre;
	}
	
	
	
	public Usuario(String email) {
		this.email=email;
	}



	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if (email != other.email)
			return false;
		return true;
	}
	
	
	@Override
	public int compareTo(Object arg0) {
		   int r=(this.getEmail().compareTo(((Usuario) arg0).getEmail())*-1);
		    return r;
	}
}
