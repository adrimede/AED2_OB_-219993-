package uy.ort.ob201901;



public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Sistema sistema=new Sistema();
		sistema.inicializarSistema(10);

		sistema.registrarGestor("4.444.444-4", "Piter",		 "099444444");
		sistema.registrarGestor("2.222.222-2", "Micaela",	 "099222222");
		sistema.registrarGestor("6.666.666-6", "Yoni",		 "099666666");
		sistema.registrarGestor("1.111.111-1", "Maikol",	 "099111111");
		sistema.registrarGestor("3.333.333-3", "Filomena",	 "099333333");
		sistema.registrarGestor("5.555.555-5", "Darcis",	 "099555555");
		sistema.registrarGestor("7.777.777-7", "Pol",		 "099777777");
		sistema.registrarGestor("8.888.888-8", "Choni",		 "099888888");
		
		System.out.println(sistema.listarGestores().valorString);
		
		//retorno = sistema.listarGestores();
		//ssertEquals(Resultado.OK, retorno.resultado);
		//assertEquals("1.111.111-1;Maikol;099111111|2.222.222-2;Micaela;099222222|3.333.333-3;Filomena;099333333|4.444.444-4;Piter;099444444|5.555.555-5;Darcis;099555555|6.666.666-6;Yoni;099666666|7.777.777-7;Pol;099777777|8.888.888-8;Choni;099888888",retorno.valorString);
		
		
	}

}
