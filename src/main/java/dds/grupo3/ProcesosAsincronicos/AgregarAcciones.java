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

	public String permisosNuevos="";
	public String respuesta ="";
	
	@Override
	public void run(){
		if(respuesta.equals("N")){
			try {
				escribirArchivo();
				this.resultadoOK();
			} catch (IOException e) {
				e.printStackTrace();
				this.resultadoError(e.toString());
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
		@SuppressWarnings("resource")
		Scanner teclado = new Scanner(System.in);
		System.out.println("---------------------------------------");
		System.out.println("		AGREGAR ACCIONES");
		System.out.println("----------------------------------------");
		System.out.println();
		System.out.println("Ingrese permisos que desea agregar:");
		this.permisosNuevos = teclado.nextLine();
		System.out.println("Se agregaron correctamente los permisos a la lista. ¿Desea deshacer los cambios?(Y/N)");
		this.respuesta=teclado.nextLine();
		System.out.println();
	}
	@Override
	public void setTask() {
		AgregarAcciones a = new AgregarAcciones();
		a.permisosNuevos = permisosNuevos;
		a.respuesta = respuesta;
		this.task = new AgregarAcciones();
	}
	@Override
	public String setProceso() {
		return "Agregar Acciones a Usuarios";
	}
}
