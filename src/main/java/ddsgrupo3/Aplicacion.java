package ddsgrupo3;


import java.util.Scanner;

public class Aplicacion {

	public Aplicacion() {
		// TODO Auto-generated constructor stub
	}

	
	public void menuLogin(Aplicacion aplicacion){
		String usuario, password;
		System.out.println("--------------------------------");
		System.out.println("	MENU LOGIN");
		System.out.println("--------------------------------");
		System.out.println("");
		Scanner teclado = new Scanner(System.in);

		System.out.println("INGRESE USUARIO:");
		usuario = teclado.nextLine();
		System.out.println("INGRESE CONTRASENIA:");
		password = teclado.nextLine();
		
		if(usuario.equals("lucas") && password.equals("hola1234")){
			//	System.out.println("ACA VA EL MENU PRINCIPAL");
				aplicacion.menuPrincipal(aplicacion);
		}
		teclado.close();
	}
	
	public void menuPrincipal(Aplicacion aplicacion){
		System.out.println("----------------------------------------");
		System.out.println("Bienvenido al sistema de POIS");
		System.out.println("----------------------------------------");
		
		Scanner opcion = new Scanner(System.in);

		System.out.println("Ingrese la opcion deseada:");
		System.out.println("	1 - ALTA DE UN POI");
		System.out.println("	2 - BAJA DE UN POI");
		System.out.println("	3 - MODIFICAR UN POI");
		System.out.println("	4 - CONSULTAR UN POI POR ALGUN CRITERIO");
		System.out.println("	5 - VOLVER AL MENU PRINCIPAL");
		System.out.print("OPCION DESEADA:");
		int opcionElegida = opcion.nextInt();

		switch (opcionElegida) {
          case 1:  System.out.println ("Eligio dar de alta un poi"); break;
          case 2: System.out.println ("Eligio dar de baja un poi"); break;
          case 3: System.out.println ("Eligio modificar un poi"); break;
          case 4: System.out.println("ELigio consultar un poi"); break;
          case 5: aplicacion.menuPrincipal(aplicacion); break;
          default: System.out.println ("Opcion incorrecta"); break;
      }
		//System.out.println("usted ingreso la opcion:"+n);
				
		opcion.close();		
	}
	
	public static void main(String[] args) {
		Aplicacion aplicacion = new Aplicacion();
		aplicacion.menuLogin(aplicacion);
	
	}

}
