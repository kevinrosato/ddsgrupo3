package dds.grupo3.ProcesosAsincronicos;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import dds.grupo3.Interfaces.Funcionalidad;
import dds.grupo3.Interfaces.ProcesoAsincronico;
import dds.grupo3.Interfaces.User;


public class AgregarAcciones extends ProcesoAsincronico implements Funcionalidad{

	private String permisosNuevos="";
	private String respuesta ="";
	
	public AgregarAcciones(String permiso, String respuesta){
		this.permisosNuevos = permiso;
		this.respuesta = respuesta;
	}
	
	@Override
	public void run(){
		if(respuesta.equals("N")){
			try {
				escribirArchivo();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void escribirArchivo() throws IOException{
		List<String> newLines = new ArrayList<>();
		for (String linea : Files.readAllLines(Paths.get("Rol.properties"), StandardCharsets.UTF_8)) {
			newLines.add(linea+","+permisosNuevos);
		}
		Files.write(Paths.get("Rol.properties"), newLines, StandardCharsets.UTF_8);
	}

	@Override
	public Integer desplegarConsola(User usuario, String terminal_ID,Scanner teclado) {
		usuario.agregarAcciones(terminal_ID);
		return null;
	}

	@Override
	public void mostrarOpcion() {
		System.out.println("	AGREGAR ACCIONES A USUARIOS");
	}

	@Override
	public void pedirInfo() {
		Scanner teclado = new Scanner(System.in);
		System.out.println("---------------------------------------");
		System.out.println("		AGREGAR ACCIONES");
		System.out.println("----------------------------------------");
		System.out.println();
		System.out.println("Ingrese permisos que desea agregar:");
		this.permisosNuevos = teclado.nextLine();
		System.out.println("Se agregaron correctamente los permisos. ¿Desea deshacer los cambios?(Y/N)");
		this.respuesta=teclado.nextLine();
		System.out.println();
		teclado.close();
	}
	@Override
	public void setTask() {
		this.task= new AgregarAcciones(permisosNuevos,respuesta);
	}
	@Override
	public String setProceso() {
		return "Agregar Acciones a Usuarios";
	}
}
