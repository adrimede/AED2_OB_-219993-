package uy.ort.ob201901;



public class ArbolB<T> {
NodoAB<T> raiz;

public ArbolB() {
	this.raiz = null;
}
	
public NodoAB<T> getRaiz() {
	return raiz;
}

public boolean esArbolVacio() {
	return (raiz == null) ;
}

public void mostrarPreOrder(){
	mostrarPreOrder(this.raiz);
}
public void mostrarPreOrder(NodoAB<T> a){
    if (a!=null){
        System.out.print(a.getDato()+"   ");
        mostrarPreOrder(a.getIzq());
        mostrarPreOrder(a.getDer());
    }
}

public String mostrarInOrder(){
	return mostrarInOrder(this.raiz);
	 
}
public String mostrarInOrder(NodoAB<T> a){
    String z="";
	
	if (a==null){
		 return "";}
	else{
		z+=  mostrarInOrder(a.getIzq());
		 z+= mostrarGestor((Gestor) a.getDato());  
			z+= mostrarInOrder(a.getDer());	
	}    	
      
      
   
    return z;
}


public String mostrarGestor(Gestor a){
	String z="";
    if (a!=null){
         z=a.getCedula()+";"+a.getNombre()+";"+a.getCelular()+"|";	   
        return z;
    }
    return z;
}



public void mostrarPosOrder(){
	mostrarPosOrder(this.raiz);
}
public void mostrarPosOrder(NodoAB<T> a){
    if (a!=null){
        mostrarPosOrder(a.getIzq());
        mostrarPosOrder(a.getDer());
        System.out.print(a.getDato()+"  ");
    }
}

public boolean existeElemento(Object e) {
	NodoAB<T> nodo = obtenerElemento(e, raiz);
	
	if(nodo != null) {
		return true;
	} else {
		return false;
	}
}

public boolean existe(String e, NodoAB<T> a) {
   boolean existe;
    if(a == null)
		existe = false;
	else
    {
        if( e == a.getDato() )
			existe=true;
		else if( e != a.getDato() )
			existe = existe(e, a.getIzq());
		else
			existe = existe(e, a.getDer());
	}
    return existe;
}



public NodoAB<T> obtenerElemento(Object val){
return obtenerElemento(val,raiz);
}



public NodoAB<T> obtenerElemento(Object n, NodoAB<T> nodo) {
	if(nodo == null) {
		return nodo;
	} else {
		if(nodo.getDato().equals(n) ) {
			return nodo;
		} else if( n != nodo.getDato() ) {
			return obtenerElemento(n, nodo.getIzq());
		} else {
			return obtenerElemento(n, nodo.getDer());
		}
	}
}

public int cantNodos(NodoAB<T> nodo) {
	int cont = 0;
	if(nodo != null)
    {
		cont += cantNodos(nodo.getIzq()); 	//cuenta subarbol izquierdo
		cont++; 							// contabilizar el nodo visitado
		cont += cantNodos(nodo.getDer());	//cuenta subarbol derecho
        
	}
	return cont;
}

public int obtenerPeso(NodoAB<T> nodo) {
	int peso     = 0;
	int peso_izq = 0;
	int peso_der = 0;

	if(nodo != null) {
		peso_izq = cantNodos(nodo.getIzq());
		peso_der = cantNodos(nodo.getDer());
		peso = peso_izq + peso_der;
        
	}
	return peso;
}

 /*
public void insertarElemento(Object n, NodoAB<T> nodo) {
	NodoAB<T> nuevo = null;

    if (this.esArbolVacio())
        this.raiz = new NodoAB<T>(n);

    else if((nodo.getDato()).compareTo(n)<0)
    {   // n < dato => insertaré en subárbol izq.
        if(nodo.getIzq() == null)
        {
            nuevo = new NodoAB<T>(n);
            nodo.setIzq(nuevo);
         }
         else
             insertarElemento(n, nodo.getIzq());
    }
    else if( nodo.getDato().compareTo(n.nodo)>0)
    {   // n > dato => insertaré en subárbol derecho
		if(nodo.getDer() == null)
        {
			nuevo = new NodoAB<T>(n);
			nodo.setDer(nuevo);
		}
        else
			insertarElemento(n, nodo.getDer());
	}
}

*/

public int cantHojas(NodoAB<T> nodo){
	if (nodo.getDer() == null)
		if (nodo.getIzq() == null)
			return 1;
		else
			return cantHojas(nodo.getIzq());
	else if (nodo.getIzq()== null)
			return cantHojas(nodo.getDer());
		else 
			return cantHojas(nodo.getIzq())+cantHojas(nodo.getDer());
}

public NodoAB<T> borrarMinimo(NodoAB<T> nodo){
	if( nodo == null )
        return nodo;
    
    if (nodo.getIzq()!= null ) {
        nodo.setIzq(borrarMinimo( nodo.getIzq() )) ;
        return nodo;
    } else
        return nodo.getDer();
}

public void insertar( Object x ) {
    raiz = insertar( x, raiz );
}

private NodoAB<T> insertar( Object x, NodoAB<T> a ) {
    if( a == null )
        a = new NodoAB<T>( x );
    else if(((Gestor) a.getDato()).compareTo(x)<0 )
        a.setIzq( insertar( x, a.getIzq()) ); // a.izq = insertar(x, a.izq); con los atributos públicos
    else if( ((Gestor) a.getDato()).compareTo(x)>0 )
        a.setDer( insertar( x, a.getDer()) );	// a.der = insertar(x, a.der); con los atributos públicos
    return a;
}

public int altura(){
	return altura(raiz);
}
public int altura(NodoAB<T> n){
	if(n==null)return -1;
	return 1+Math.max(altura(n.getIzq()), altura(n.getDer()));
}


public NodoAB<T> Buscar(Object val){
return Buscar(val,raiz);
}

public NodoAB<T> Buscar(Object val,NodoAB<T> n){
if(n==null)return null;
if(n.getDato().equals(val))return n;
	NodoAB<T> nuevo=Buscar(val,n.getIzq());
	if(nuevo!=null)return nuevo;	
	return Buscar(val,n.getDer());
}

/*public NodoAB<T> buscar(Object val,NodoAB<T> n){
if(n==null)return null;
if(n.getDato()==val) {
	return n;
}

NodoAB<T> r=buscar(val,n.getIzq());
if(r!=null) {
	return r;
}
else {
	return buscar(val,n.getDer());
}

}
*/
//public int nivelConMasNodos(ArbolB<T> a , int n) {
	//int cantNodos[]=new int[n];
	//if(a==null) {
//		cantNodos[0]=0;
//	}
//	return nivelConMasNodos(raiz,n);
//}
	
public void nivelConMasNodos(NodoAB<T> n , int k, int nivelActual,int[] niveles) {
	if(n==null)return ;
			if(nivelActual>=k)return;
				
			niveles[nivelActual]++;
			nivelConMasNodos(n.getIzq(),k,nivelActual+1,niveles);
			nivelConMasNodos(n.getDer(),k,nivelActual+1,niveles);

			}
/*
int costoCaminoMinimo(ArbolB<T> a,int vertOri,int vertDest) {
	int[] costos=new int[a.cantNodos(raiz)];
	boolean[] visitados=new boolean[a.cantNodos(raiz)];
			visitados[vertOri]=true;
			for(int i=0;i<a.cantNodos(raiz);i++) {
				if([vertOri][i].existe) {
					costos[i]=matrizAdy[vertOri][i].peso;
				}
				else {
					costos[i]=Integer.MAX_VALUE;
				}
			}
	while (haySinVisitar(visitados)) {
		int v=sinVisitarConCostoMinimo(visitados,costos);
		visitados[v]=true;
		for(int i=0;i<a.cantNodos(raiz);i++) {
			if(matrizAdy[v][i].existe && !visitados[i]) {
				costos[i]=Math.min(costos[i], costos[v]+matrizAdy[v][i].peso)
			}
		}
		return costos[vertDest];
	}				
}

*/
public boolean haySinVisitar(boolean[] vis){
	boolean a=true;
	for(int i=0;i<=vis.length;i++) {
		if(!vis[i]) {
			a=false;
		}
	}
	return a;
}
/*
public int sinVisitarConCostoMinimo(boolean[] vis,int[] costos){
int a=Integer.MAX_VALUE;
	for(int i=0;i<=vis.length;i++) {
		if(!vis[i]) {
			if(a>vis[i].peso)
				a=vis[i].peso;
		}
	}
return a;	
}

*/
}


// alt shift s + o + enter

