package ddsgrupo3;

import java.util.Scanner;

import dds.grupo3.Interfaces.AdministradorPOIs;
import dds.grupo3.Interfaces.Funcionalidad;
import dds.grupo3.Interfaces.User;
import dds.grupo3.User.CuentasUsuario;
public class Aplicacion {
	private	Scanner teclado = new Scanner(System.in);	
	public void ejecutar(AdministradorPOIs mapa, String terminal_ID)
	{
		while(true){
		User usuario = this.menuLogin();
		usuario.setMapa(mapa);
		menuPrincipal(usuario,terminal_ID);
		}
	}
	public User menuLogin(){
		User usuario = null;
		String nomUsuario, password;
		System.out.println("--------------------------------");
		System.out.println("	MENU LOGIN");
		System.out.println("--------------------------------");
		System.out.println("");

		while (usuario == null)
		{
			System.out.println("INGRESE USUARIO:");
			nomUsuario = teclado.nextLine();
			if(CuentasUsuario.requierePass(nomUsuario))
			{
				System.out.println("INGRESE CONTRASENIA:");
				password = teclado.nextLine();
			}
			else	password = "null";
			usuario = CuentasUsuario.instanciarUsuario(nomUsuario,password);				
		}
		return usuario;
	}
	
	public void menuPrincipal(User usuario, String terminal_ID){
		Boolean flag = true;
		while(flag)
		{
			System.out.flush();
			System.out.println("----------------------------------------");
			System.out.println("	Bienvenido al sistema de POIS");
			System.out.println("----------------------------------------");
			System.out.println("Ingrese la opcion deseada:");
			Integer ultimaOpcion = usuario.mostrarOpciones();
			ultimaOpcion ++;
			System.out.println(ultimaOpcion.toString()+"->	Desconectar");
			System.out.print("OPCION DESEADA:");
			String opcionElegida = teclado.nextLine();
			System.out.println(opcionElegida);
			if(Integer.parseInt(opcionElegida) < ultimaOpcion)
			{
				Funcionalidad f = usuario.getRol().getPermisos().get(Integer.parseInt(opcionElegida)-1);
				f.desplegarConsola(usuario,terminal_ID,teclado);				
			}
			else if (Integer.parseInt(opcionElegida) == ultimaOpcion){
				flag = false;
			}
			else{
				System.out.println("...Opcion Inexistente...");
			}
		}
	}
}