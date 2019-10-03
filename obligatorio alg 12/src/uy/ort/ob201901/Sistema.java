package uy.ort.ob201901;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

import uy.edu.ort.obli.TipoContenedor;
import uy.ort.ob201901.Retorno.Resultado;
import uy.ort.ob201901.Vertice.Estado;

public class Sistema implements ISistema {

	


	GrafoLista grafo;
	ArbolB listaGestores=new  ArbolB();
	//private Arbol<Gestor> listaGestores;  
	private ILista<Contenedor> listaContenedores;
	
//	public GrafoLista getGrafo() {
	//	return grafo;
	//}

	//public void setGrafo(GrafoLista grafo) {
	//	this.grafo = grafo;
	//}
	
//	public ArbolB<Gestor> getListaGestores() {
	//	return listaGestores;
	//}

	//public void setListaGestores(ArbolB<Gestor> listaGestores) {
	//	this.listaGestores = listaGestores;
	//}
	

	
	@Override
	public Retorno inicializarSistema (int maxPuntos) {
	
		
	//	if(maxPuntos<1){
	//		return new Retorno(Resultado.ERROR_1);
	//	}
		grafo=new GrafoLista(maxPuntos);
				
     	listaContenedores=new  ListaSE<Contenedor>();
		this.listaGestores =new  ArbolB();
		//ArbolB listaGestores=new  ArbolB();
		
		return new Retorno(Resultado.OK);
		
		
	}
	
	@Override
	public Retorno destruirSistema() {
		
		grafo=null;
		
		return new Retorno(Resultado.OK);
	}

	@Override
	public Retorno registrarGestor(String cedula, String nombre, String celular) {
				
		
		Gestor nuevoGestor= new  Gestor(cedula,nombre,celular);
			
		Pattern patternCI = Pattern.compile("^\\d{1}.\\d{3}.\\d{3}-\\d{1}");   //^\\d{1}/.\\d{3}/.\\d{3}-\\d$
		
	        Matcher matherCI = patternCI.matcher(cedula);
	        
	        Pattern patternCel = Pattern.compile("^09\\d{7}$");
			  
	        Matcher matherCel = patternCel.matcher(celular);
	 
	 
	        if (matherCI.find() == false) {
	         System.out.println("La cédula ingresada es inválida.2222");
	            return new Retorno(Resultado.ERROR_1);
	        }
	      

	        if (matherCel.find() == false) {
	          System.out.println("El celular ingresado es inválido33.");
	            return new Retorno(Resultado.ERROR_2);
	        }
	      

			if(listaGestores.existeElemento(new Gestor(nuevoGestor.getCedula()))){					
				return new Retorno(Resultado.ERROR_3);				
			}			
				
		listaGestores.insertar(nuevoGestor);
				return new Retorno(Resultado.OK);
		  

	}

	@Override
	public Retorno contenedoresDelGestor(String CI) {
	//	int contador=0;
		
		
		   Pattern patternCI = Pattern.compile("^\\d{1}.\\d{3}.\\d{3}-\\d{1}");   //^\\d{1}/.\\d{3}/.\\d{3}-\\d$
			
	       Matcher matherCI = patternCI.matcher(CI);
	       if (matherCI.find() == false) {
		         System.out.println("Ljnjin");
		            return new Retorno(Resultado.ERROR_1);
		        }
		
       Gestor gest = (Gestor) listaGestores.Buscar(new Gestor(CI)).getDato();   
       
    //   System.out.println(gest.getNombre()+";" +"\r\n" );	
       System.out.println(gest.getNombre()+"hola");
		if(gest==null)
		{
			return new Retorno(Resultado.ERROR_2);
			
			
		}else{
			
			System.out.println(gest.getNombre()+";" +"\r\n" );
			return new Retorno(Resultado.OK);
	//	for(Contenedor v : listaContenedores)
		//{
		//	contador++;
		
		//if(gest.getCedula().equals(v.getCIgestor())) 
     	//{
			//System.out.println(gest.getNombre()+";" +"\r\n" );		
			
    	
		}
		
		//}
		
	//	System.out.println("Cantidad de recorridas"+contador+"\r\n" );
		//}
		
		//}else {
	//		
		//	return new Retorno(Resultado.ERROR_2);
			
		//}
		
	}

	@Override
	public Retorno listarGestores() {
				
	Retorno ret=new Retorno(Resultado.OK);
	
	ret.valorString=listaGestores.mostrarInOrder();
	
	ret.valorString=ret.valorString.substring(0, ret.valorString.length()-1);

	return ret;
	}


		
		
	
	
	@Override
	public Retorno registrarContenedor(String nombre, String CIgestor, TipoContenedor tipo, Double coordX,
			Double coordY) {
		
	
		//inicializarSistema(0)
		
	//	System.out.println(grafo.getCantNodos() );
	
			//if(grafo.getCantNodos()>2)
		//	{
			//	return new Retorno(Resultado.ERROR_1);
				
		//	}else {
			
		

		
		/*	
		
		//if(grafo.getSize()>grafo.getCantNodos()){
		boolean a=true;
		for(int i=0;i>grafo.getCantNodos();i++){	
			
			if(!grafo.getNodosUsados()[i]){
				a=false;
				return new Retorno(Resultado.ERROR_1);
			}
				
	if(a){
	//	return new Retorno(Resultado.ERROR_1);
	}
		//}
	*/
		
		/*
			int cant=0;	
		for(int i=0;i>grafo.getNodosUsados().length-1;i++){	
		{
			if(grafo.getNodosUsados()[i])
			{
				cant++;
			
			}
		
		}
		*/
		/*
		if(cant>grafo.getCantNodos()){
			
			return new Retorno(Resultado.ERROR_1);
		}else{
		*/
		
		
		
		for(Vertice v : grafo.getListaAdyacencia())
		{
		
		if(v!=null &&v.getCoordX()==coordX && v.getCoordY()==coordY) 
		{
			
			return new Retorno(Resultado.ERROR_2);
		}
		
		}
		
		if(!listaGestores.existeElemento(CIgestor))
		{
					
					
		return new Retorno(Resultado.ERROR_3);
				
	    }
		
		
		
	
		           grafo.agregarVertice(nombre,CIgestor,tipo,coordX,coordY);
		
		
		          return new Retorno(Resultado.OK);
			
		

		
	}

	@Override
	public Retorno registrarEsquina(Double coordX, Double coordY) {
		
		
		for(Vertice v : grafo.getListaAdyacencia())
		{
		
		if(v!=null &&v.getCoordX()==coordX && v.getCoordY()==coordY) 
		{
			
			return new Retorno(Resultado.ERROR_2);
		}
		
		}
		
		
	    grafo.agregarVerticeEsq(coordX,coordY);
		
		
        return new Retorno(Resultado.OK);
		
		
	}

	@Override
	public Retorno registrarTramo(Double coordXi, Double coordYi, Double coordXf, Double coordYf, int longitud) {
		return new Retorno(Resultado.NO_IMPLEMENTADA);
	}

	@Override
	public Retorno caminoContenedor(Double coordX, Double coordY, TipoContenedor tipo) {
		for(Vertice v : grafo.getListaAdyacencia())
		{	
		//	if(Vertice.Estado != true)
			//if(v.estado)
			//for(Arista a : v.getListaArista())
			//{	
		//	if(a.) {
				
		//	}
			//}
		}
		
		return new Retorno(Resultado.NO_IMPLEMENTADA);
	}

	@Override
	public Retorno estadoVias() {
		return new Retorno(Resultado.NO_IMPLEMENTADA);
	}

	@Override
	public Retorno dibujarMapa() {
		return new Retorno(Resultado.NO_IMPLEMENTADA);
	}

	
	
	/*
	
	public ILista<Contenedor> getListaContenedores() {
		return listaContenedores;
	}

	public void setListaContenedores(ILista<Contenedor> listaContenedores) {
		this.listaContenedores = listaContenedores;
	}

*/
	

	
	
}
