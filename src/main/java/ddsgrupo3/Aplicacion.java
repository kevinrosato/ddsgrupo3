package ddsgrupo3;


import java.util.Scanner;

public class Aplicacion {

	public Aplicacion() {
		// TODO Auto-generated constructor stub
	}
	
	public void menuLogin(){
		String usuario, password;
		System.out.println("--------------------------------");
		System.out.println("	MENU LOGIN");
		System.out.println("--------------------------------");
		System.out.println("");
		Scanner teclado = new Scanner(System.in);

		do {
			System.out.println("INGRESE USUARIO:");
			usuario = teclado.nextLine();
			System.out.println("INGRESE CONTRASENIA:");
			password = teclado.nextLine();
		} while (!this.validarUser(usuario,password));
		
		this.menuPrincipal(usuario);

		
		teclado.close();
	}
	
	public boolean validarUser(String usuario, String password) {
		if(usuario.equals("lucas") && password.equals("hola1234")){
			return true;
		}
		System.out.println("usuario o password incorrecto");
		System.out.println("--------------------------------");

		return false;
	}

	public void menuPrincipal(String usuario){
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
          case 1: this.menuAltaPOI(); break;
          case 2: this.menuBajaPOI(usuario); break;
          case 3: this.menuModificarPOI(); break;
          case 4: this.menuConsultarPOI(); break;
          case 5: this.menuPrincipal(usuario); break;
          default: System.out.println ("Opcion incorrecta"); break;
      }
		//System.out.println("usted ingreso la opcion:"+n);
				
		opcion.close();		
	}

	public void menuAltaPOI(){
		
		System.out.println("---------------------------------------");
		System.out.println("		ALTA DE UN POI");
		System.out.println("----------------------------------------");
		System.out.println();
		System.out.println("Elija el TIPO DE POI que desea agregar:");
		System.out.println(" 1 - CGP");
		System.out.println(" 2 - BANCO");
		System.out.println(" 3 - PARADA DE COLECTIVO");
		System.out.println(" 4 - Volver al menu principal");
		Scanner opcion = new Scanner(System.in);
		System.out.print(" OPCION -> ");
		int opcionElegida = opcion.nextInt();

		switch (opcionElegida) {
			case 1: this.menuAltaCGP(); break;
			case 2: this.menuAltaBanco(); break;
			case 3: this.menuAltaParadaColectivo(); break;
			case 4: this.menuPrincipal(); break;
			default: System.out.println ("Opcion incorrecta"); break;
		}	
		opcion.close();
	}
	public void menuAltaParadaColectivo() {
		System.out.println("--------------------------------------------");
		System.out.println("	ALTA DE UNA PARADA DE COLECTIVO");
		System.out.println("--------------------------------------------");

	}

	public void menuAltaBanco() {
		// TODO Auto-generated method stub
		System.out.println("-----------------------------------");
		System.out.println("	ALTA DE BANCO");
		System.out.println("-----------------------------------");

	}

	public void menuAltaCGP() {
		// TODO Auto-generated method stub
		System.out.println("---------------------------------------");
		System.out.println("	ALTA DE UNA CGP");
		System.out.println("---------------------------------------");
		Scanner teclado = new Scanner(System.in);
		System.out.println("Ingrese Numero de CGP:");
		int numCGP = teclado.nextInt();
		System.out.println("Ingrese nombre de la CGP:");
		String nombreCGP = teclado.nextLine();
		System.out.println("Ingrese codigo postal");
		Integer codPostal = teclado.nextInt();
		System.out.println("Ingrese departamento");
		Byte dpto = teclado.nextByte();
		
		System.out.println("Ingrese SERVICIOS que ofrece:");
	
		
		
		teclado.close();
	}

	public void menuBajaPOI(Usuario usuario){
		
		System.out.println("---------------------------------------");
		System.out.println("		BAJA DE UN POI");
		System.out.println("----------------------------------------");
		System.out.println();
		System.out.println("Ingrese el nombre del poi a borrar:");
		usuario.borrarPOI(poi);
		
		
	}
	public void menuModificarPOI(Usuario usuario){
		
		System.out.println("---------------------------------------");
		System.out.println("		MODIFICACION DE UN POI");
		System.out.println("----------------------------------------");
		System.out.println();
		System.out.println("");
		usuario.modificarPOI(poi, poiNuevo);
		
	}
	
	public void menuConsultarPOI(Usuario usuario){
		
		System.out.println("---------------------------------------");
		System.out.println("		CONSULTA DE UN POI");
		System.out.println("----------------------------------------");
		System.out.println();
		System.out.println("");
		usuario.consultarPOI(poi);
		
	}
	
	
	public static void main(String[] args) {
		Aplicacion aplicacion = new Aplicacion();
		aplicacion.menuLogin();
	
	}

}
