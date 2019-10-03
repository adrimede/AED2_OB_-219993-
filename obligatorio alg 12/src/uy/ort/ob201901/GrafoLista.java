package uy.ort.ob201901;

import uy.edu.ort.obli.TipoContenedor;
import uy.ort.ob201901.Vertice.Estado;



public class GrafoLista  {
	private int size;//la cantidad de nodos usados
	private int cantNodos;//cantidad de nodos q contiene el array del grafo
	private Vertice[] listaAdyacencia;
	private boolean[] nodosUsados;
	
	//Crea el grafo vacio (sin nodos ni aristas) con capacidad de almacenamiento de n vértices
	public GrafoLista(int n) {
		this.size = 0;
		this.cantNodos = n;
		this.listaAdyacencia = new Vertice[this.cantNodos+1];
		for (int i = 1; i<=this.cantNodos; i++)
			this.listaAdyacencia[i]=null;		
		
		this.nodosUsados = new boolean[this.cantNodos+1];
	}
	
	public int getSize() {
		return size;
	}


	public void setSize(int size) {
		this.size = size;
	}
	
	public int getCantNodos() {
		return cantNodos;
	}


	public void setCantNodos(int cantNodos) {
		this.cantNodos = cantNodos;
	}
	
	public Vertice[] getListaAdyacencia() {
		return listaAdyacencia;
	}


	public void setListaAdyacencia(Vertice[] listaAdyacencia) {
		this.listaAdyacencia = listaAdyacencia;
	}
	
	public boolean[] getNodosUsados() {
		return nodosUsados;
	}


	public void setNodosUsados(boolean[] nodosUsados) {
		this.nodosUsados = nodosUsados;
	}
	
	
	
	public void agregarArista(int posVertice, Arista a) {
		this.listaAdyacencia[posVertice].getListaArista().agregar(a);
	}

	public void agregarVertice(String nombre,String cIgestor,TipoContenedor tipo, 
		double coordX, double coordY) {
		boolean esta=false;
		int i=0;
		while(i<listaAdyacencia.length && !esta)
		{
			
			if(this.nodosUsados[i]==false){
				
			//	Vertice ver=new 
				
				this.listaAdyacencia[i] = new Contenedor(nombre,cIgestor,tipo,coordX,coordY);
			
               this.nodosUsados[i]=true;
               this.size ++;
             
			   esta=true;
			}
			
		i++;
		}
	//	listaAdyacencia[size].;
		
		//this.nodosUsados[v]=true;
		
		//this.nodosUsados[]=true;
		
	}
	
	public void agregarVerticeEsq(
			double coordX, double coordY) {
			boolean esta=false;
			int i=0;
			while(i<listaAdyacencia.length && !esta)
			{
				
				if(this.nodosUsados[i]==false){
					
				//	Vertice ver=new 
					
					this.listaAdyacencia[i] = new Esquina(coordX,coordY);
				
	               this.nodosUsados[i]=true;
	               this.size ++;
	             
				   esta=true;
				}
				
			i++;
			}
		//	listaAdyacencia[size].;
			
			//this.nodosUsados[v]=true;
			
			//this.nodosUsados[]=true;
			
		}
	
	//public void agregarVerticeObj(Vertice v) {
	
	//	this.nodosUsados[v]=true;
	//	this.size ++;
	//}

	public void eliminarArista(int posVertice,Arista a ) {
	
		this.listaAdyacencia[posVertice].getListaArista().borrar(a);                          //borrar(destino);                   
	}

	public boolean esVacio() {
		return this.size==0;
	}

	public boolean sonAdyacentes(int posVertice,Arista a) {
		return this.listaAdyacencia[posVertice].getListaArista().existe(a);
	}

	public void eliminarVertice(int posVertice) {
		this.nodosUsados[posVertice]=false;
		this.size--;
		
		//Elimino las aristas donde v es miembro
		this.listaAdyacencia[posVertice] = null;	
		//BUSCAR EN TODOS LOS VERTICES LA ARISTA
		for (int i = 1; i<=cantNodos; i++)
			this.listaAdyacencia[i].getListaArista().borrarPos(posVertice);	
	}

	public Vertice verticesAdyacentes(int v) {
		return this.listaAdyacencia[v];
	}

	public boolean estaVertice(int v) {
		return this.nodosUsados[v];
	}

	
}
  