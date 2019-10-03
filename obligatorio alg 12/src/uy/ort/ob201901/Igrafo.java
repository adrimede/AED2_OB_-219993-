package uy.ort.ob201901;

public interface Igrafo{


	public void agregarArista(int origen, int destino, int peso);
	

	public void agregarVertice(int v) ;
	
	public void agregarVerticeObj(Vertice v) ;

	public void eliminarArista(int origen, int destino) ;
		

	public boolean esVacio() ;
		

	public boolean sonAdyacentes(int a, int b) ;
	

	public void eliminarVertice(int v);
	

	
		

	public boolean estaVertice(int v) ;
		
	


	
}
