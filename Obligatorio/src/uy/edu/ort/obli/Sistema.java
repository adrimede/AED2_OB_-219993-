package uy.edu.ort.obli;

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
		//ArbolB listaGestores=new  ArbolB();
		
		return new Retorno(Resultado.OK);
		
	}

	@Override
	public Retorno destruirSistema() {
		grafo=null;
		
		return new Retorno(Resultado.OK);
	}

	@Override
	public Retorno registrarUsuario(String email, String nombre) {
		
								
			Usuario nuevoUsuario= new Usuario(email,nombre);
			Pattern patternEmail = Pattern.compile("\"^[_A-Za-z0-9-\\\\+]+(\\\\.[_A-Za-z0-9-]+)*@\"\r\n" + 
												" + \"[A-Za-z0-9-]+(\\\\.[A-Za-z0-9]+)*(\\\\.[A-Za-z]{2,})$\"");   //^\\d{1}/.\\d{3}/.\\d{3}-\\d$
			
	        Matcher matherEmail = patternEmail.matcher(email);
			
			 if (matherEmail.find() == false) {
		         System.out.println("Email invalido");
		            return new Retorno(Resultado.ERROR_1);
		        }
		      	        

				if(listaUsuarios.existeElemento(new Usuario(nuevoUsuario.getEmail()))){					
					return new Retorno(Resultado.ERROR_3);				
				}			
					
				listaUsuarios.insertar(nuevoUsuario);
					return new Retorno(Resultado.OK);
	}

	@Override
	public Retorno buscarUsuario(String email) {
		
		
		Pattern patternEmail = Pattern.compile("\"^[_A-Za-z0-9-\\\\+]+(\\\\.[_A-Za-z0-9-]+)*@\"\r\n" + 
				" + \"[A-Za-z0-9-]+(\\\\.[A-Za-z0-9]+)*(\\\\.[A-Za-z]{2,})$\""); 

		Matcher matherEmail = patternEmail.matcher(email);

			if (matherEmail.find() == false) {
					System.out.println("Email invalido");
						return new Retorno(Resultado.ERROR_1);
					}
		
		
		
		
		Usuario usu = (Usuario) listaUsuarios.Buscar(new Usuario(email)).getDato();   
	       
	    //   System.out.println(gest.getNombre()+";" +"\r\n" );	
	    //   System.out.println(gest.getNombre()+"hola");
			if(usu==null)
			{
				return new Retorno(Resultado.ERROR_2);
				
				
			}else{
				
				System.out.println(usu.getEmail()+";" +usu.getNombre());
				return new Retorno(Resultado.OK);
			}
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
	
		/*
		for(ListaAdy v : grafo.getListaAdyacencia())
		{
		
		if(v!=null &&v.getCoordX()==coordX && v.getCoordY()==coordY) 
		{
			
			return new Retorno(Resultado.ERROR_2);
		}
		
		}
		*/
	//	if(!listaGestores.existeElemento(emailUsu))
	//	{
					
					
	//	return new Retorno(Resultado.ERROR_3);
				
	//    }
		
		
		
	
		        //   grafo.agregarVertice(nombre,emailUsu,tipo,coordX,coordY);
		
		
		          return new Retorno(Resultado.OK);
			
	}

	@Override
	public Retorno registrarEsquina(double coordX, double coordY) {
		return new Retorno(Resultado.NO_IMPLEMENTADA);
	}

	@Override
	public Retorno registrarTramo(double coordXi, double coordYi, double coordXf, double coordYf, int metros) {
		return new Retorno(Resultado.NO_IMPLEMENTADA);
	}

	@Override
	public Retorno monopatinMasCercano(double coordX, double coordY) {
		return new Retorno(Resultado.NO_IMPLEMENTADA);
	}

	@Override
	public Retorno monopatinesEnZona(double coordX, double coordY) {
		return new Retorno(Resultado.NO_IMPLEMENTADA);
	}

	@Override
	public Retorno dibujarMapa() {
		return new Retorno(Resultado.NO_IMPLEMENTADA);
	}

}
