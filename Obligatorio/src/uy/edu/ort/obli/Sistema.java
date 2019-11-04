package uy.edu.ort.obli;

import java.awt.Desktop;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import uy.edu.ort.obli.Retorno.Resultado;



public class Sistema implements ISistema {

	
	
	
	GrafoLista grafo;
	ArbolB listaUsuarios=new  ArbolB();
	
	//private ILista<Vertice> listaVertices;
	
	
	@Override
	public Retorno inicializarSistema(int maxPuntos) {
		grafo=new GrafoLista(maxPuntos);
		
     	//listaContenedores=new  ListaSE<Contenedor>();
		this.listaUsuarios =new  ArbolB();
	
		
		return new Retorno(Resultado.OK);
		
	}

	@Override
	public Retorno destruirSistema() {
		grafo=null;
		listaUsuarios=null;
		return new Retorno(Resultado.OK);
	}

	@Override
	public Retorno registrarUsuario(String email, String nombre) {
		
								
			Usuario nuevoUsuario=new Usuario(email,nombre);
			
			Pattern patternEmail = Pattern.compile("\"^[_A-Za-z0-9-\\\\+]+(\\\\.[_A-Za-z0-9-]+)*@\"\r\n" + 
												" + \"[A-Za-z0-9-]+(\\\\.[A-Za-z0-9]+)*(\\\\.[A-Za-z]{2,})$\"");   //^\\d{1}/.\\d{3}/.\\d{3}-\\d$
			
	        Matcher matherEmail = patternEmail.matcher(email);
			
			 if (matherEmail.find() == false) {
		        
		            return new Retorno(Resultado.ERROR_1);
		        }
		      	        

				if(listaUsuarios.existeElemento(new Usuario(nuevoUsuario.getEmail()))){					
					return new Retorno(Resultado.ERROR_2);				
				}	
					
				
				listaUsuarios.insertar(nuevoUsuario);
					return new Retorno(Resultado.OK);
					
					
				
	}

	@Override
	public Retorno buscarUsuario(String email) {
		
		Retorno ret ;
		Pattern patternEmail = Pattern.compile("\"^[_A-Za-z0-9-\\\\+]+(\\\\.[_A-Za-z0-9-]+)*@\"\r\n" + 
				" + \"[A-Za-z0-9-]+(\\\\.[A-Za-z0-9]+)*(\\\\.[A-Za-z]{2,})$\""); 

		Matcher matherEmail = patternEmail.matcher(email);

			if (matherEmail.find() == false) {
				
						return new Retorno(Resultado.ERROR_1);
					}
		
			Entero contador = new Entero();
		Usuario usu = (Usuario) listaUsuarios.Buscar(new Usuario(email),contador).getDato();   
	       
	    //   System.out.println(gest.getNombre()+";" +"\r\n" );	
	    //   System.out.println(gest.getNombre()+"hola");
			if(usu==null)
			{
				return new Retorno(Resultado.ERROR_2);
				
				
			}else{
				ret = new Retorno(Resultado.OK);
				ret.valorEntero=contador.getValor();
				ret.valorString=(usu.getEmail()+";" +usu.getNombre());
			
			}
			return ret;
	}

	@Override
	public Retorno listarUsuarios() {
		
		Retorno ret=new Retorno(Resultado.OK);
	
		ret.valorString=listaUsuarios.mostrarInOrder();
		
		ret.valorString=ret.valorString.substring(0, ret.valorString.length()-1);

		return ret;	
		}
	
//la lista de adyasencia va a tener los vertices? 
	
	@Override
	public Retorno registrarMonopatin(String chipId, double coordX, double coordY) {
	
		if (grafo.getCantNodos() <= grafo.getSize()) {

			return new Retorno(Resultado.ERROR_1);
		}
		
		for(Vertice v : grafo.getNodosUsados())
		{
		
		if(v!=null &&v.getCoordX()==coordX && v.getCoordY()==coordY) 
		{
			
			return new Retorno(Resultado.ERROR_2);
		}
		
		}
	
				
		
	   grafo.agregarVertice(chipId,coordX,coordY);
		
		
		          return new Retorno(Resultado.OK);
			
	}

	@Override
	public Retorno registrarEsquina(double coordX, double coordY) {
		
		if (grafo.getCantNodos() <= grafo.getSize()) {

			return new Retorno(Resultado.ERROR_1);
		}
		
		for(Vertice v : grafo.getNodosUsados())
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
	public Retorno registrarTramo(double coordXi, double coordYi, double coordXf, double coordYf, int metros) {
		
		Vertice vertOri = null;
		Vertice vertDest = null;
		int posDest = -1;
		if (metros <= 0) {
			return new Retorno(Resultado.ERROR_1);
		}
		int pos = 0;
		for (Vertice v : grafo.getNodosUsados()) {

			if (v != null && v.getCoordX() == coordXf && v.getCoordY() == coordYf) {
				vertDest = v;
				posDest = pos;
			}

			if (v != null && v.getCoordX() == coordXi && v.getCoordY() == coordYi) {
				vertOri = v;
			}

			pos++;
		}

		if (vertOri == null || vertDest == null) {
			return new Retorno(Resultado.ERROR_2);
		}
		Arista ari = new Arista(posDest, metros);
		if (vertOri.getListaArista() != null && vertOri.getListaArista().existeG(ari)) {
			return new Retorno(Resultado.ERROR_3);
		}
		
		vertOri.getListaArista().agregar(ari);
		return new Retorno(Resultado.OK);
		
		
	}

	@Override
	public Retorno monopatinMasCercano(double coordX, double coordY) {
		Retorno ret  ;
		
		for (Vertice v : grafo.getNodosUsados()) {

			if (v != null && v.getCoordX() != coordX && v.getCoordY() != coordY) {
				return new Retorno(Resultado.ERROR_1);
			}
		}
		
		
		if(grafo.caminoMinimo(coordX, coordY)== 0){
			return new Retorno(Resultado.ERROR_2);
			
		}else{			
			
		ret= new Retorno(Resultado.OK);
		ret.valorEntero=grafo.caminoMinimo(coordX, coordY);
		
		}
		
		return ret;
	
	}

	@Override
	public Retorno monopatinesEnZona(double coordX, double coordY) {
		Retorno ret  ;

		Vertice[] lista=grafo.monopatinesEnZona(coordX, coordY);

		for(int i=0;i<lista.length;i++){

	//	ret.valorString= (lista[i].getCoordX()+";"+ lista[i].getCoordY() +"|");
	
		}
		ret= new Retorno(Resultado.OK);
		return ret;
	}

	@Override
	public Retorno dibujarMapa() {
String url = "http://maps.googleapis.com/maps/api/staticmap?&size=1200x600&maptype=roadmap";
		
		for (Vertice v : grafo.getNodosUsados()) {
			if (v != null) {
				Double coorX = v.getCoordX();
				Double coorY = v.getCoordY();

				url += "&markers=%7C" + coorX + "," + coorY;
			}
		}
		url += "sensor=false&key=AIzaSyC2kHGtzaC3OOyc7Wi1LMBcEwM9btRZLqw";
		try {
			Desktop.getDesktop().browse(new URL(url).toURI());
		} catch (Exception e) {
			e.printStackTrace();
		}

	
		return new Retorno(Resultado.OK);
	}

}
