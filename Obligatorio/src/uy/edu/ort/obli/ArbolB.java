package uy.edu.ort.obli;



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
		 z+= mostrarUsuario((Usuario) a.getDato());  
			z+= mostrarInOrder(a.getDer());	
	}    	
      
      
   
    return z;
}


public String mostrarUsuario(Usuario a){
	String z="";
    if (a!=null){
         z=a.getEmail()+";";	   
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
    else if(((Usuario) a.getDato()).compareTo(x)<0 )
        a.setIzq( insertar( x, a.getIzq()) ); // a.izq = insertar(x, a.izq); con los atributos públicos
    else if( ((Usuario) a.getDato()).compareTo(x)>0 )
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


public void nivelConMasNodos(NodoAB<T> n , int k, int nivelActual,int[] niveles) {
	if(n==null)return ;
			if(nivelActual>=k)return;
				
			niveles[nivelActual]++;
			nivelConMasNodos(n.getIzq(),k,nivelActual+1,niveles);
			nivelConMasNodos(n.getDer(),k,nivelActual+1,niveles);

			}

public boolean haySinVisitar(boolean[] vis){
	boolean a=true;
	for(int i=0;i<=vis.length;i++) {
		if(!vis[i]) {
			a=false;
		}
	}
	return a;
}

}


// alt shift s + o + enter

