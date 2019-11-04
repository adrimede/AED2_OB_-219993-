package uy.edu.ort.obli;


public class GrafoLista  {
	
	private int size;//la cantidad de nodos usados
	private int cantNodos;//cantidad de nodos q contiene el array del grafo
	private ListaAdy<Arista>[] listaAdyacencia;
	private Vertice[] nodosUsados;
	
	
	
	//Crea el grafo vacio (sin nodos ni aristas) con capacidad de almacenamiento de n vértices
	public GrafoLista(int n) {
		this.size = 0;
		this.cantNodos = n;
		this.listaAdyacencia = new ListaAdy[this.cantNodos+1];
		for (int i = 1; i<=this.cantNodos; i++)
			this.listaAdyacencia[i]= new ListaAdy();		
		
		this.nodosUsados = new Vertice[this.cantNodos+1];
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
	
	public Vertice[] getNodosUsados() {
		return nodosUsados;
	}


	public void setNodosUsados(Vertice[] nodosUsados) {
		this.nodosUsados = nodosUsados;
	}
	
	
	public ListaAdy[] getListaAdyacencia() {
		return listaAdyacencia;
	}


	public void setListaAdyacencia(ListaAdy[] listaAdyacencia) {
		this.listaAdyacencia = listaAdyacencia;
	}
	
	
	
	public void agregarArista(int posVertice, Arista a) {
		extracted(posVertice, a);
	}

	private void extracted(int posVertice, Arista a) {
		this.listaAdyacencia[posVertice].agregar(a);
	}


	
	
	public void agregarVertice(String chipId,
		double coordX, double coordY) {
		boolean esta=false;
		int i=0;
		while(i<nodosUsados.length && !esta)
		{
			
			if(this.nodosUsados[i]==null){
				
			//	Vertice ver=new 
				
				this.nodosUsados[i] = new Monopatin(chipId,coordX,coordY);
			
             //  this.nodosUsados[i]=true;
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
			while(i<nodosUsados.length && !esta)
			{
				
				if(this.nodosUsados[i]==null){
					
				//	Vertice ver=new 
					
					this.nodosUsados[i] = new Esquina(coordX,coordY);
				
	              // this.nodosUsados[i]=true;
	               this.size ++;
	             
				   esta=true;
				}
				
			i++;
			}
		//	listaAdyacencia[size].;
			
			//this.nodosUsados[v]=true;
			
			//this.nodosUsados[]=true;
			
		}
	

	public void eliminarArista(int posVertice,Arista a ) {
	
		this.nodosUsados[posVertice].getListaArista().borrar(a);                           
	}

	public boolean esVacio() {
		return this.size==0;
	}

	public boolean sonAdyacentes(int posVertice,Arista a) {
		return this.nodosUsados[posVertice].getListaArista().existeG(a);
	}

	public void eliminarVertice(int posVertice) {
		this.nodosUsados[posVertice]=null;
		this.size--;
		
		//Elimino las aristas donde v es miembro
		this.listaAdyacencia[posVertice] = null;	
		//BUSCAR EN TODOS LOS VERTICES LA ARISTA
		for (int i = 1; i<=cantNodos; i++)
			this.nodosUsados[i].getListaArista().borrarPos(posVertice);	
	}

	public ListaAdy verticesAdyacentes(int v) {
		return this.listaAdyacencia[v];
	}

	public boolean estaVertice(int v) {
				
		return this.nodosUsados[v]!=null;
	}
	
	/*
	public int costoCaminoMinimo(int vertOrig,int vertDest ){
		int[] costo=new int[cantNodos];
		boolean[] visitados = new boolean[cantNodos];
		visitados[vertOrig]=true;
		for(int i=0;i<cantNodos;i++){
			
			if(listaAdyacencia[vertOrig].existe(i)){
		
			costo[i]=listaAdyacencia[vertOrig].buscar(i).peso;//hacer metodo buscar
			}else{
				costo[i]=Integer.MAX_VALUE;
			}
					
		}
	}
	
*/
	
	 public Vertice[] monopatinesEnZona(double x, double y) {
		 
	//	 Vertice[] listaMonopatines;
		 
		   
		 
		 int t = BuscarVertice(x,y);
		 
		  int[] costo = new int[cantNodos+1];

	        int[] camino = new int[cantNodos+1];

	        boolean[] visitado = new boolean[cantNodos+1];

	        //Inicializo costos con valor INFINITO

	        for(int i=1; i<=cantNodos; i++){

	            if (i!=x)

	                  costo[i]=Integer.MAX_VALUE;

	        }
	        costo[t] =  0;
        	visitado[t] = true;
	 	        for(int i=1; i<=cantNodos; i++){

	            //vertice con la distancia mas corta no visitado

	            int u = distanciaMasCorta(costo, visitado, x, y);

	            visitado[u]=true;

	            for(int j=1; j<=cantNodos; j++){
	            	
	                  if(this.sonAdyacentes(u, j) && !visitado[j]){

	                    if(this.listaAdyacencia[u].recuperar(new Arista(j,0)).peso+costo[u]<costo[j]){//recuperar es como buscar

	                        costo[j]=this.listaAdyacencia[u].recuperar(new Arista(j,0)).peso+costo[u];

	                        camino[j]=u;

	                    }

	                  }

	            }

	        }	    
	 	        Vertice[] listaMonopatines=null;
	 	    
	 	       for(int p=0;p<costo.length;p++){
	 	    	  
	 	    	   if(costo[p]<=1000  ){
	 	    		   
	 	    		  listaMonopatines =new Vertice[p];
	 	    		 
	 	    		//  listaMonopatines.
	 	    		  
	 	    	//tengo q guardar los vertices 
	 	    	   }
	 	    	   
	 	       }
		 
		
	 	       return listaMonopatines; 
	 }

	    
	
	
	
	
	 private int BuscarVertice(double x, double y) {
		 
		 int encontrado = 0;
		 
		 
		 for(int j=1; j<=nodosUsados.length; j++){
			  if(nodosUsados[j].getCoordX()== x && nodosUsados[j].getCoordY() ==y ){
				  
				  encontrado=j; 
			  }
		  }
		return encontrado;
	}

	public int caminoMinimo(double o, double d)      

	    {


	        int[] costo = new int[cantNodos+1];

	        int[] camino = new int[cantNodos+1];

	        boolean[] visitado = new boolean[cantNodos+1];
	      

	        //Inicializo costos con valor INFINITO

	        for(int i=1; i<=cantNodos; i++){

	            if (i!=o)

	            
	                  costo[i]=Integer.MAX_VALUE;

	        }
	    	
	 	     for(int i=1; i<=cantNodos; i++){

	            //vertice con la distancia mas corta no visitado

	            int u = distanciaMasCorta(costo, visitado, o, d);

	            visitado[u]=true;
	            

	            for(int j=1; j<=cantNodos; j++){
	            	
	                  if(this.sonAdyacentes(u, j) && !visitado[j]){

	                    if(this.listaAdyacencia[u].recuperar(new Arista(j,0)).peso+costo[u]<costo[j]){//recuperar es como buscar

	                        costo[j]=this.listaAdyacencia[u].recuperar(new Arista(j,0)).peso+costo[u];

	                        camino[j]=u;

	                    }

	                  }

	            }

	        }	     

	        return costo[(int) d];

	    }
	 
	 //DEVUELVE EL VERTICE CON LA DISTANCIA MAS CORTA SIN VISITAR CON MENOS COSTO
	private int distanciaMasCorta(int[] costo, boolean[] visitado, double o, double d) {
		 int min =Integer.MAX_VALUE;
		 int vertice =-1;
		 
		 for(int i=0;i<cantNodos;i++){
			 if(!visitado[i] && costo[i]<min){
				 
				 min=costo[i];
				 vertice=i;
				 
			 }			 
			 
		 }
		 
		 return vertice;
	
	}

	//preguntar el pertenece
	
	public boolean sonAdyacentes(int a, int b) {
		return this.listaAdyacencia[a].existe(b);//el pertenece es existe
	}
	
}
  