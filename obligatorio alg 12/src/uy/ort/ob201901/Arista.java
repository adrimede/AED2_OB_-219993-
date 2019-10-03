package uy.ort.ob201901;

public class Arista {


public int posicion;
public int peso;//(valor de la arista)



public Arista(int posicion, int peso) {
	super();
	this.posicion = posicion;
	this.peso = peso;
}

public Arista() {
	
	this.posicion = 0;
	this.peso = 0;
}

public int getPosicion() {
	return posicion;
}

public void setPosicion(int posicion) {
	this.posicion = posicion;
}

public int getPeso() {
	return peso;
}

public void setPeso(int peso) {
	this.peso = peso;
}




}
