package ddsgrupo3;


import java.util.Scanner;

import dds.grupo3.POIsSistem.POI;
import dds.grupo3.POIsSistem.POIGral;

public class Aplicacion {

	public Aplicacion() {
		// TODO Auto-generated constructor stub
	}

	
	public void menuLogin(Aplicacion aplicacion){
		Scanner teclado = new Scanner(System.in);
		String usuario, password;
		Boolean valor=true;
		while(valor){
		System.out.println("--------------------------------");
		System.out.println("	MENU LOGIN");
		System.out.println("--------------------------------");
		System.out.println("");

		System.out.println("INGRESE USUARIO:");
		usuario = teclado.nextLine();
		System.out.println("INGRESE CONTRASENIA:");
		password = teclado.nextLine();
		
		if(usuario.equals("admin") && password.equals("admin1234")){
			//	System.out.println("ACA VA EL MENU PRINCIPAL");
				aplicacion.menuPrincipal(aplicacion);
		}
		else{
			System.out.println("No existe usuario o contrasenia equivocada. Intente nuevamente.");
		}
		}
		teclado.close();
	}
	
	public void menuPrincipal(Aplicacion aplicacion){
		
		System.out.println("----------------------------------------");
		System.out.println("Bienvenido al sistema de POIS");
		System.out.println("----------------------------------------");
		
		Usuario usuario= new Usuario();
		Scanner opcion = new Scanner(System.in);
 
		Boolean valor=true;
		while(valor){
		System.out.println("Ingrese la opcion deseada:");
		System.out.println("	1 - ALTA DE UN POI");
		System.out.println("	2 - BAJA DE UN POI");
		System.out.println("	3 - MODIFICAR UN POI");
		System.out.println("	4 - CONSULTAR UN POI POR ALGUN CRITERIO");
		System.out.println("	5 - VOLVER AL MENU PRINCIPAL");
		System.out.print("OPCION DESEADA:");
		int opcionElegida = opcion.nextInt();

		switch (opcionElegida) {
          case 1:  System.out.println ("Eligio dar de alta un poi"); 
          			POI poi=null;
          			usuario.agregarPOI(poi);
          			break;
          case 2: System.out.println ("Eligio dar de baja un poi"); break;
          case 3: System.out.println ("Eligio modificar un poi"); break;
          case 4: System.out.println("ELigio consultar un poi"); break;
          case 5: aplicacion.menuPrincipal(aplicacion); break;
          default: System.out.println ("Opcion incorrecta"); break;
      }
		//System.out.println("usted ingreso la opcion:"+n);
		}		
		opcion.close();		
	}
	
	public static void main(String[] args) {
		Aplicacion aplicacion = new Aplicacion();
		aplicacion.menuLogin(aplicacion);
	
	}

}
