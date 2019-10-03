package uy.ort.ob201901;

public class ArbolG {
NodoAG raiz;



// private Nodo raiz;

public ArbolG() {
this.raiz = null;
}

public NodoAG getRaiz() {
return raiz;
}

public boolean esArbolVacio() {
return (raiz == null) ;
}

public void mostrarPreOrder(){
mostrarPreOrder(this.raiz);
}
public void mostrarPreOrder(NodoAG a){
if (a!=null){
    System.out.print(a.getDato()+"   ");
    mostrarPreOrder(a.getIzq());
    mostrarPreOrder(a.getDer());
}
}

public void mostrarInOrder(){
mostrarInOrder(this.raiz);
}
public void mostrarInOrder(NodoAG a){
if (a!=null){
    mostrarInOrder(a.getIzq());
    System.out.print(a.getDato()+"  ");
    mostrarInOrder(a.getDer());
}
}

public void mostrarPosOrder(){
mostrarPosOrder(this.raiz);
}
public void mostrarPosOrder(NodoAG a){
if (a!=null){
    mostrarPosOrder(a.getIzq());
    mostrarPosOrder(a.getDer());
    System.out.print(a.getDato()+"  ");
}
}

public boolean existeElemento(int e) {
NodoAG nodo = obtenerElemento(e, raiz);

if(nodo != null) {
	return true;
} else {
	return false;
}
}

public boolean existe(int e, NodoAG a) {
boolean existe;
if(a == null)
	existe = false;
else
{
    if( e == a.getDato() )
		existe=true;
	else if( e < a.getDato() )
		existe = existe(e, a.getIzq());
	else
		existe = existe(e, a.getDer());
}
return existe;
}

public NodoAG obtenerElemento(int n, NodoAG nodo) {
if(nodo == null) {
	return nodo;
} else {
	if(n == nodo.getDato() ) {
		return nodo;
	} else if( n < nodo.getDato() ) {
		return obtenerElemento(n, nodo.getIzq());
	} else {
		return obtenerElemento(n, nodo.getDer());
	}
}
}

public int cantNodos(NodoAG nodo) {
int cont = 0;
if(nodo != null)
{
	cont += cantNodos(nodo.getIzq()); 	//cuenta subarbol izquierdo
	cont++; 							// contabilizar el nodo visitado
	cont += cantNodos(nodo.getDer());	//cuenta subarbol derecho
    
}
return cont;
}

public int obtenerPeso(NodoAG nodo) {
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


public void insertarElemento(int n, NodoAG nodo) {
NodoAG nuevo = null;

if (this.esArbolVacio())
    this.raiz = new NodoAG(n);

else if( n < nodo.getDato())
{   // n < dato => insertaré en subárbol izq.
    if(nodo.getIzq() == null)
    {
        nuevo = new NodoAG(n);
        nodo.setIzq(nuevo);
     }
     else
         insertarElemento(n, nodo.getIzq());
}
else if( n > nodo.getDato())
{   // n > dato => insertaré en subárbol derecho
	if(nodo.getDer() == null)
    {
		nuevo = new NodoAG(n);
		nodo.setDer(nuevo);
	}
    else
		insertarElemento(n, nodo.getDer());
}
}

public int cantHojas(NodoAG nodo){
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

public NodoAG borrarMinimo(NodoAG nodo){
if( nodo == null )
    return nodo;

if (nodo.getIzq()!= null ) {
    nodo.setIzq(borrarMinimo( nodo.getIzq() )) ;
    return nodo;
} else
    return nodo.getDer();
}

public void insertar( int x ) {
raiz = insertar( x, raiz );
}

private NodoAG insertar( int x, NodoAG a ) {
if( a == null )
    a = new NodoAG( x );
else if(x < a.getDato() )
    a.setIzq( insertar( x, a.getIzq()) ); // a.izq = insertar(x, a.izq); con los atributos públicos
else if( x > a.getDato() )
    a.setDer( insertar( x, a.getDer()) );	// a.der = insertar(x, a.der); con los atributos públicos
return a;
}

public int altura(){
// TO-DO
return 0;
}

}