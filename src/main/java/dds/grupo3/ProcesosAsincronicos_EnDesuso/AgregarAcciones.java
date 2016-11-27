package dds.grupo3.ProcesosAsincronicos_EnDesuso;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;
import java.util.TimerTask;

import dds.grupo3.Interfaces.User;
import dds.grupo3.Interfaces.EnDesuso.CommandProcesos;


public class AgregarAcciones extends TimerTask implements CommandProcesos{

	public String permisosNuevos="";
	public String respuesta ="";
	private Calendar fechaInicio;
	
	public void run(){
		ResultadosProcesos resultado=new ResultadosProcesos(this,this.fechaInicio);
		if(respuesta.equals("N")){
			try {
				escribirArchivo();
				resultado.resultadoOK();
			} catch (IOException e) {
				e.printStackTrace();
				resultado.resultadoError(e.toString());
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

	public void pedirInfo() {
		@SuppressWarnings("resource")
		Scanner teclado = new Scanner(System.in);
		System.out.println("---------------------------------------");
		System.out.println("		AGREGAR ACCIONES");
		System.out.println("----------------------------------------");
		System.out.println();
		System.out.println("Ingrese permisos que desea agregar:");
		this.permisosNuevos = teclado.nextLine();
		System.out.println("Se agregaron correctamente los permisos a la lista. �Desea deshacer los cambios?(Y/N)");
		this.respuesta=teclado.nextLine();
		System.out.println();
	}
	
	public void setTask(TimerTask task,Calendar fechaInicio,User usuario,String terminalID) {
		AgregarAcciones a = new AgregarAcciones();
		a.permisosNuevos = this.permisosNuevos;
		a.respuesta = this.respuesta;
		fechaInicio=Calendar.getInstance();
		a.fechaInicio=fechaInicio;
		task=(TimerTask)a;
	}
	
	public String setProceso() {
		return "Agregar Acciones a Usuarios";
	}
}
