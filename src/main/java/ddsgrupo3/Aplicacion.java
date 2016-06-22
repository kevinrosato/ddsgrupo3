package ddsgrupo3;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import dds.grupo3.POIsSistem.FabricaDePOIs;
import dds.grupo3.POIsSistem.POI;

public class Aplicacion {

	private FabricaDePOIs fabrica=new FabricaDePOIs();
	
	public Aplicacion() {
		// TODO Auto-generated constructor stub
	}
	
	public void menuLogin(Usuario usuario){
		String nomUsuario, password;
		System.out.println("--------------------------------");
		System.out.println("	MENU LOGIN");
		System.out.println("--------------------------------");
		System.out.println("");
		Scanner teclado = new Scanner(System.in);

		do {
			System.out.println("INGRESE USUARIO:");
			nomUsuario = teclado.nextLine();
			System.out.println("INGRESE CONTRASENIA:");
			password = teclado.nextLine();
		} while (!this.validarUser(nomUsuario,password));
		usuario.setNombre(nomUsuario);
		usuario.setContrasenia(password);

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


	public void menuPrincipal(Usuario usuario){

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

          case 1: this.menuAltaPOI(usuario); break;
          case 2: this.menuBajaPOI(usuario); break;
          case 3: this.menuModificarPOI(usuario); break;
          case 4: this.menuConsultarPOI(usuario); break;
          case 5: this.menuPrincipal(usuario); break;
          default: System.out.println ("Opcion incorrecta"); break;
      }
		//System.out.println("usted ingreso la opcion:"+n);
				
		opcion.close();		
	}
	
	public void menuAltaPOI(Usuario usuario){
		
		Scanner opcion = new Scanner(System.in);
		System.out.println("---------------------------------------");
		System.out.println("		ALTA DE UN POI");
		System.out.println("----------------------------------------");
		System.out.println();
		String camposPOI=pedirInfo(opcion);
		System.out.println(camposPOI);
		System.out.println();
		System.out.println("Elija el TIPO DE POI que desea agregar:");
		System.out.println(" 1 - CGP");
		System.out.println(" 2 - BANCO");
		System.out.println(" 3 - PARADA DE COLECTIVO");
		System.out.println(" 4 - LOCAL");
		System.out.println(" 5 - Volver al menu principal");
		System.out.print(" OPCION -> ");
		int opcionElegida = opcion.nextInt();

		switch (opcionElegida) {
			case 1: POI cgp=crearCGP(camposPOI);
					usuario.agregarPOI(cgp);
					break;
			case 2: POI banco=crearBanco(camposPOI);
					usuario.agregarPOI(banco);
					break;
			case 3: POI parada=crearParada(camposPOI);
					usuario.agregarPOI(parada);
					break;
			case 4: POI local=crearLocal(camposPOI);
					usuario.agregarPOI(local);
					break;		
			case 5: this.menuPrincipal(usuario); break;
			default: System.out.println ("Opcion incorrecta"); break;
		}
		this.menuPrincipal(usuario);
		opcion.close();
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
		
		Scanner opcion = new Scanner(System.in);

		System.out.println("---------------------------------------");
		System.out.println("		BAJA DE UN POI");
		System.out.println("----------------------------------------");
		System.out.println();
		System.out.println("Ingrese el nombre del poi a borrar:");

		System.out.println("Elija el TIPO DE POI que desea eliminar:");
		System.out.println(" 1 - CGP");
		System.out.println(" 2 - BANCO");
		System.out.println(" 3 - PARADA DE COLECTIVO");
		System.out.println(" 4 - LOCAL");
		System.out.println(" 5 - Volver al menu principal");
		
		System.out.print(" OPCION -> ");
		int opcionElegida = opcion.nextInt();
		String camposPOI=pedirInfo(opcion);
		
		switch (opcionElegida) {
		case 1: POI cgp=crearCGP(camposPOI);
				usuario.borrarPOI(cgp);
				break;
		case 2: POI banco=crearBanco(camposPOI);
				usuario.borrarPOI(banco);
				break;
		case 3: POI parada=crearParada(camposPOI);
				usuario.borrarPOI(parada);
				break;
		case 4: POI local=crearLocal(camposPOI);
				usuario.borrarPOI(local);
				break;
		case 5: this.menuPrincipal(usuario); break;
		default: System.out.println ("Opcion incorrecta"); break;
		}	

		
		opcion.close();

	}
	public void menuModificarPOI(Usuario usuario){
		
		System.out.println("---------------------------------------");
		System.out.println("		MODIFICACION DE UN POI");
		System.out.println("----------------------------------------");
		System.out.println();
		System.out.println("");
		
	}
	
	public void menuConsultarPOI(Usuario usuario){
		
		Scanner opcion = new Scanner(System.in);
		System.out.println("---------------------------------------");
		System.out.println("		CONSULTA DE UN POI");
		System.out.println("----------------------------------------");
		System.out.println();
		System.out.println("");
		usuario.consultarPOI(null);
		opcion.close();
		this.menuPrincipal(usuario);
		
	}
	
	//*Metodos adicionales*//
	
	private String pedirInfo(Scanner scanner){
		System.out.println("Ingrese datos del POI de la siguiente manera:");
		System.out.println("comuna,latitud,longitud,nombre,calle,altura,callesPerpenIzq,callesPerpenDer,barrio,localidad,provincia,pais");
		System.out.println("Deje en blanco los campos que no use.");
		return scanner.nextLine();
	}
	
	private POI crearBanco(String camposPOI){
		Scanner teclado = new Scanner(System.in);
		System.out.println("Ingrese datos de la sucursal de banco de la siguiente manera:");
		System.out.println("codigo postal,departamento,piso,unidad,servicios");
		String campos=teclado.nextLine();
		POI banco=fabrica.crearSucursalDeBanco(campos, camposPOI);
		teclado.close();
		return banco;
	}
	private POI crearLocal(String camposPOI){
		Scanner teclado = new Scanner(System.in);
		System.out.println("Ingrese datos del POI de la siguiente manera:");
		System.out.println("codigoPostal,departamento,piso,unidad,rubro");
		System.out.println("Deje en blanco los campos que no use.");
		String campos=teclado.nextLine();
		POI local=fabrica.crearLocal(campos, camposPOI);
		teclado.close();
		return local;
	}
	private POI crearCGP(String camposPOI){
		System.out.println("Ingrese datos del cgp de la siguiente manera:");
		System.out.println("cp,departamento,piso,unidad,numeroCGP,servicios");

		
		String campos="34,2,13,12,1,sfr";
		//campos=	scanner.nextLine();

		System.out.println(campos);
		return fabrica.crearCGP(campos, camposPOI);
	}
	private POI crearParada(String camposPOI){
		Scanner teclado = new Scanner(System.in);
		System.out.println("Ingrese las lineas de colectivo:");
		String campo=teclado.nextLine();
		POI parada=fabrica.crearParadaDeColectivo(campo, camposPOI);
		teclado.close();
		return parada;
	}
	
	//* MAIN *//
	
	public static void main(String[] args) {
		Usuario usuario=new Usuario();
		Mapa mapa=new Mapa();
		usuario.setMapa(mapa);
		Rol admin= new Rol();
		List<Funcionalidad> permisos=new ArrayList<Funcionalidad>();
		permisos.add(new AgregarPOI());
		permisos.add(new ConsultarPOI(null));
		admin.setPermisos(permisos);
		usuario.setRol(admin);
		
		Aplicacion aplicacion = new Aplicacion();
		aplicacion.menuLogin(usuario);
	
	}

}