package uy.edu.ort.obli;

public class NodoAB<T> {
    //Atributos
    private Object dato;
	private NodoAB<T> der ;
	private NodoAB<T> izq ;

    //Constructores
    public NodoAB(Object n){
        dato = n;
        izq = null;
        der = null;
     }

    public NodoAB(Object n, NodoAB<T> i, NodoAB<T> d){
        dato = n;
        izq = i;
        der = d;
     }

    //Dato
    public  Object getDato(){
        return dato;
    }
    public  void setDato(Object n){
        dato = n;
    }
    
    //Derecho
    public  NodoAB<T> getDer(){
        return der;
    }
    public  void setDer(NodoAB<T> d){
       der = d;
    }
    
    //Izquierdo
    public  NodoAB<T> getIzq(){
        return izq;
    }
    public  void setIzq(NodoAB<T> i){
        izq = i;
    }

}
