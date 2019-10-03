package uy.ort.ob201901;

public class NodoAG {
    //Atributos
    private int dato;
	private NodoAG primerHijo ;
	private NodoAG sigHermano ;

    //Constructores
    public NodoAG(int n){
        dato = n;
        sigHermano = null;
        primerHijo = null;
     }

    public NodoAG(int n, NodoAG i, NodoAG d){
        dato = n;
        sigHermano = i;
        primerHijo = d;
     }

    //Dato
    int getDato(){
        return dato;
    }
    void setDato(int n){
        dato = n;
    }
    
    //Derecho
    NodoAG getDer(){
        return primerHijo;
    }
    void setDer(NodoAG d){
    	primerHijo = d;
    }
    
    //Izquierdo
    NodoAG getIzq(){
        return sigHermano;
    }
    void setIzq(NodoAG i){
    	sigHermano = i;
    }

}
