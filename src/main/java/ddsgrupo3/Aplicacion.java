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
		this.menuPrincipal(teclado,usuario);

		
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

	public void menuPrincipal(Scanner scanner, Usuario usuario){
		System.out.println("----------------------------------------");
		System.out.println("Bienvenido al sistema de POIS");
		System.out.println("----------------------------------------");
		

		System.out.println("Ingrese la opcion deseada:");
		System.out.println("	1 - ALTA DE UN POI");
		System.out.println("	2 - BAJA DE UN POI");
		System.out.println("	3 - MODIFICAR UN POI");
		System.out.println("	4 - CONSULTAR UN POI POR ALGUN CRITERIO");
		System.out.println("	5 - VOLVER AL MENU PRINCIPAL");
		System.out.print("OPCION DESEADA:");
		String opcionElegida = scanner.nextLine();

		switch (Integer.parseInt(opcionElegida)) {
          case 1: this.menuAltaPOI(scanner,usuario); break;
          case 2: this.menuBajaPOI(scanner,usuario); break;
          case 3: this.menuModificarPOI(scanner,usuario); break;
          case 4: this.menuConsultarPOI(scanner,usuario); break;
          case 5: this.menuPrincipal(scanner,usuario); break;
          default: System.out.println ("Opcion incorrecta"); break;
      }
		//System.out.println("usted ingreso la opcion:"+n);
					
	}
	
	public void menuAltaPOI(Scanner scanner,Usuario usuario){
		
		System.out.println("---------------------------------------");
		System.out.println("		ALTA DE UN POI");
		System.out.println("----------------------------------------");
		System.out.println();
		String camposPOI=pedirInfo(scanner);
		System.out.println(camposPOI);
		System.out.println();
		System.out.println("Elija el TIPO DE POI que desea agregar:");
		System.out.println(" 1 - CGP");
		System.out.println(" 2 - BANCO");
		System.out.println(" 3 - PARADA DE COLECTIVO");
		System.out.println(" 4 - LOCAL");
		System.out.println(" 5 - Volver al menu principal");
		System.out.print(" OPCION -> ");
		String opcionElegida = scanner.nextLine();

		switch (Integer.parseInt(opcionElegida)) {
			case 1: POI cgp=crearCGP(scanner,camposPOI);
					usuario.agregarPOI(cgp);
					break;
			case 2: POI banco=crearBanco(scanner,camposPOI);
					usuario.agregarPOI(banco);
					break;
			case 3: POI parada=crearParada(scanner,camposPOI);
					usuario.agregarPOI(parada);
					break;
			case 4: POI local=crearLocal(scanner,camposPOI);
					usuario.agregarPOI(local);
					break;		
			case 5: this.menuPrincipal(scanner,usuario); break;
			default: System.out.println ("Opcion incorrecta"); break;
		}
		this.menuPrincipal(scanner,usuario);
	}


	public void menuBajaPOI(Scanner scanner,Usuario usuario){
		
		
		System.out.println("---------------------------------------");
		System.out.println("		BAJA DE UN POI");
		System.out.println("----------------------------------------");
		System.out.println();
		System.out.println("Elija el TIPO DE POI que desea eliminar:");
		System.out.println(" 1 - CGP");
		System.out.println(" 2 - BANCO");
		System.out.println(" 3 - PARADA DE COLECTIVO");
		System.out.println(" 4 - LOCAL");
		System.out.println(" 5 - Volver al menu principal");
		
		System.out.print(" OPCION -> ");
		String opcionElegida = scanner.nextLine();
		String camposPOI=pedirInfo(scanner);
		
		switch (Integer.parseInt(opcionElegida)) {
		case 1: POI cgp=crearCGP(scanner,camposPOI);
				usuario.borrarPOI(cgp);
				break;
		case 2: POI banco=crearBanco(scanner,camposPOI);
				usuario.borrarPOI(banco);
				break;
		case 3: POI parada=crearParada(scanner,camposPOI);
				usuario.borrarPOI(parada);
				break;
		case 4: POI local=crearLocal(scanner,camposPOI);
				usuario.borrarPOI(local);
				break;
		case 5: this.menuPrincipal(scanner,usuario); break;
		default: System.out.println ("Opcion incorrecta"); break;
		}	
		this.menuPrincipal(scanner,usuario);

		
	}
	public void menuModificarPOI(Scanner scanner,Usuario usuario){
		
		System.out.println("---------------------------------------");
		System.out.println("		MODIFICACION DE UN POI");
		System.out.println("----------------------------------------");
		System.out.println();
		System.out.println("Elija el TIPO DE POI que desea modificar:");
		System.out.println(" 1 - CGP");
		System.out.println(" 2 - BANCO");
		System.out.println(" 3 - PARADA DE COLECTIVO");
		System.out.println(" 4 - LOCAL");
		System.out.println(" 5 - Volver al menu principal");
		
		System.out.print(" OPCION -> ");
		String opcionElegida = scanner.nextLine();
		System.out.println("Ingrese los datos del POI que desea modificar.");
		String camposPOI=pedirInfo(scanner);
		String camposPOINuevo;
		
		switch (Integer.parseInt(opcionElegida)) {
		case 1: POI cgp=crearCGP(scanner,camposPOI);
				System.out.println("Ingrese los datos del POI nuevo.");
				camposPOINuevo=pedirInfo(scanner);
				POI cgp2=crearCGP(scanner,camposPOINuevo);
				usuario.modificarPOI(cgp, cgp2);;
				break;
		case 2: POI banco=crearBanco(scanner,camposPOI);
				System.out.println("Ingrese los datos del POI nuevo.");
				camposPOINuevo=pedirInfo(scanner);
				POI banco2=crearBanco(scanner,camposPOINuevo);
				usuario.modificarPOI(banco, banco2);
				break;
		case 3: POI parada=crearParada(scanner,camposPOI);
				System.out.println("Ingrese los datos del POI nuevo.");
				camposPOINuevo=pedirInfo(scanner);
				POI parada2=crearParada(scanner,camposPOINuevo);
				usuario.modificarPOI(parada, parada2);
				break;
		case 4: POI local=crearLocal(scanner,camposPOI);
				System.out.println("Ingrese los datos del POI nuevo.");
				camposPOINuevo=pedirInfo(scanner);
				POI local2=crearLocal(scanner,camposPOINuevo);
				usuario.modificarPOI(local, local2);
				break;
		case 5: this.menuPrincipal(scanner,usuario); break;
		default: System.out.println ("Opcion incorrecta"); break;
		}	
		this.menuPrincipal(scanner,usuario);
		
	}
	
	public void menuConsultarPOI(Scanner scanner,Usuario usuario){
		
		System.out.println("---------------------------------------");
		System.out.println("		CONSULTA DE UN POI");
		System.out.println("----------------------------------------");
		System.out.println();
		usuario.consultarPOI(null);
		this.menuPrincipal(scanner,usuario);
		
	}
	
	//*Metodos adicionales*//
	
	private String pedirInfo(Scanner scanner){
		System.out.println("Ingrese datos del POI de la siguiente manera:");
		System.out.println("comuna,latitud,longitud,nombre,calle,altura,callesPerpenIzq,callesPerpenDer,barrio,localidad,provincia,pais");
		System.out.println("Deje en blanco los campos que no use.");
		return scanner.nextLine();
	}
	
	private POI crearBanco(Scanner scanner,String camposPOI){
		System.out.println("Ingrese datos de la sucursal de banco de la siguiente manera:");
		System.out.println("codigo postal,departamento,piso,unidad,servicios");
		String campos=scanner.nextLine();
		POI banco=fabrica.crearSucursalDeBanco(campos, camposPOI);
		return banco;
	}
	private POI crearLocal(Scanner scanner,String camposPOI){
		System.out.println("Ingrese datos del POI de la siguiente manera:");
		System.out.println("codigoPostal,departamento,piso,unidad,rubro");
		System.out.println("Deje en blanco los campos que no use.");
		String campos=scanner.nextLine();
		POI local=fabrica.crearLocal(campos, camposPOI);
		return local;
	}
	private POI crearCGP(Scanner scanner,String camposPOI){
		System.out.println("Ingrese datos del cgp de la siguiente manera:");
		System.out.println("cp,departamento,piso,unidad,numeroCGP,servicios");
		String campos=	scanner.nextLine();
		return fabrica.crearCGP(campos, camposPOI);
	}
	private POI crearParada(Scanner scanner,String camposPOI){
		System.out.println("Ingrese las lineas de colectivo:");
		String campo=scanner.nextLine();
		POI parada=fabrica.crearParadaDeColectivo(campo, camposPOI);
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
		permisos.add(new ModificarPOI(null));
		permisos.add(new BorrarPOI());
		admin.setPermisos(permisos);
		usuario.setRol(admin);
		
		Aplicacion aplicacion = new Aplicacion();
		aplicacion.menuLogin(usuario);
	
	}

}