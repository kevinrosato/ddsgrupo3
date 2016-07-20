package ddsgrupo3;

import java.util.Scanner;

import dds.grupo3.Interfaces.AdministradorPOIs;
import dds.grupo3.Interfaces.POI;
import dds.grupo3.Interfaces.User;
import dds.grupo3.POIsSistem.FabricaDePOIs;
import dds.grupo3.User.CuentasUsuario;
public class Aplicacion {

	private FabricaDePOIs fabrica = new FabricaDePOIs();
	private	Scanner teclado = new Scanner(System.in);

	public void ejecutar(AdministradorPOIs mapa)
	{
		User usuario = this.menuLogin();
		usuario.setMapa(mapa);
		menuPrincipal(usuario);
	}
	public User menuLogin(){
		User usuario = null;
		String nomUsuario, password;
		System.out.println("--------------------------------");
		System.out.println("	MENU LOGIN");
		System.out.println("--------------------------------");
		System.out.println("");

		do {
			System.out.println("INGRESE USUARIO:");
			nomUsuario = teclado.nextLine();
			System.out.println("INGRESE CONTRASENIA:");
			password = teclado.nextLine();
			usuario = CuentasUsuario.instanciarUsuario(nomUsuario, password);				
		} while (usuario.equals(null));
		return usuario;
	}
	
	public void menuPrincipal(User usuario){
		System.out.println("----------------------------------------");
		System.out.println("Bienvenido al sistema de POIS");
		System.out.println("----------------------------------------");
		System.out.println("Ingrese la opcion deseada:");
		System.out.println("	1 - ALTA DE UN POI");
		System.out.println("	2 - BAJA DE UN POI");
		System.out.println("	3 - MODIFICAR UN POI");
		System.out.println("	4 - CONSULTAR UN POI POR ALGUN CRITERIO");
		System.out.println("	5 - VOLVER AL MENU PRINCIPAL");
		System.out.println("	6 - Apagar");
		System.out.print("OPCION DESEADA:");
		String opcionElegida = teclado.nextLine();

		switch (Integer.parseInt(opcionElegida)) {
          case 1: this.menuAltaPOI(usuario); break;
          case 2: this.menuBajaPOI(usuario); break;
          case 3: this.menuModificarPOI(usuario); break;
          case 4: this.menuConsultarPOI(usuario); break;
          case 5: this.menuPrincipal(usuario); break;
          case 6: teclado.close(); break;
          default: System.out.println ("Opcion incorrecta"); break;
      }
	}
	
	public void menuAltaPOI(User usuario){
		
		System.out.println("---------------------------------------");
		System.out.println("		ALTA DE UN POI");
		System.out.println("----------------------------------------");
		System.out.println();
		String camposPOI=pedirInfo();
		System.out.println(camposPOI);
		System.out.println();
		System.out.println("Elija el TIPO DE POI que desea agregar:");
		System.out.println(" 1 - CGP");
		System.out.println(" 2 - BANCO");
		System.out.println(" 3 - PARADA DE COLECTIVO");
		System.out.println(" 4 - LOCAL");
		System.out.println(" 5 - Volver al menu principal");
		System.out.print(" OPCION -> ");
		String opcionElegida = teclado.nextLine();

		switch (Integer.parseInt(opcionElegida)) {
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
	}


	public void menuBajaPOI(User usuario){
		
		
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
		String opcionElegida = teclado.nextLine();
		String camposPOI=pedirInfo();
		
		switch (Integer.parseInt(opcionElegida)) {
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
		this.menuPrincipal(usuario);

		
	}
	public void menuModificarPOI(User usuario){
		
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
		String opcionElegida = teclado.nextLine();
		System.out.println("Ingrese los datos del POI que desea modificar.");
		String camposPOI=pedirInfo();
		String camposPOINuevo;
		
		switch (Integer.parseInt(opcionElegida)) {
		case 1: POI cgp=crearCGP(camposPOI);
				System.out.println("Ingrese los datos del POI nuevo.");
				camposPOINuevo=pedirInfo();
				POI cgp2=crearCGP(camposPOINuevo);
				usuario.modificarPOI(cgp, cgp2);;
				break;
		case 2: POI banco=crearBanco(camposPOI);
				System.out.println("Ingrese los datos del POI nuevo.");
				camposPOINuevo=pedirInfo();
				POI banco2=crearBanco(camposPOINuevo);
				usuario.modificarPOI(banco, banco2);
				break;
		case 3: POI parada=crearParada(camposPOI);
				System.out.println("Ingrese los datos del POI nuevo.");
				camposPOINuevo=pedirInfo();
				POI parada2=crearParada(camposPOINuevo);
				usuario.modificarPOI(parada, parada2);
				break;
		case 4: POI local=crearLocal(camposPOI);
				System.out.println("Ingrese los datos del POI nuevo.");
				camposPOINuevo=pedirInfo();
				POI local2=crearLocal(camposPOINuevo);
				usuario.modificarPOI(local, local2);
				break;
		case 5: this.menuPrincipal(usuario); break;
		default: System.out.println ("Opcion incorrecta"); break;
		}	
		this.menuPrincipal(usuario);
		
	}
	
	public void menuConsultarPOI(User usuario){
		
		System.out.println("---------------------------------------");
		System.out.println("		CONSULTA DE UN POI");
		System.out.println("----------------------------------------");
		System.out.println();
		usuario.consultarPOI(null);
		this.menuPrincipal(usuario);
		
	}
	
	//*Metodos adicionales*//
	
	private String pedirInfo(){
		System.out.println("Ingrese datos del POI de la siguiente manera:");
		System.out.println("comuna,lat,long,nombre,calle,altura,callesPerpenIzq,callesPerpenDer,barrio,localidad,provincia,pais");
		System.out.println("Deje en blanco los campos que no use.");
		return teclado.nextLine();
	}
	
	private POI crearBanco(String camposPOI){
		System.out.println("Ingrese datos de la sucursal de banco de la siguiente manera:");
		System.out.println("codigo postal,departamento,piso,unidad,servicios");
		String campos=teclado.nextLine();
		POI banco=fabrica.crearSucursalDeBanco(campos, camposPOI);
		return banco;
	}
	private POI crearLocal(String camposPOI){
		System.out.println("Ingrese datos del POI de la siguiente manera:");
		System.out.println("codigoPostal,departamento,piso,unidad,rubro");
		System.out.println("Deje en blanco los campos que no use.");
		String campos=teclado.nextLine();
		POI local=fabrica.crearLocal(campos, camposPOI);
		return local;
	}
	private POI crearCGP(String camposPOI){
		System.out.println("Ingrese datos del cgp de la siguiente manera:");
		System.out.println("cp,departamento,piso,unidad,numeroCGP,servicios");
		String campos=	teclado.nextLine();
		return fabrica.crearCGP(campos, camposPOI);
	}
	private POI crearParada(String camposPOI){
		System.out.println("Ingrese las lineas de colectivo:");
		String campo=teclado.nextLine();
		POI parada=fabrica.crearParadaDeColectivo(campo, camposPOI);
		return parada;
	}
	
}