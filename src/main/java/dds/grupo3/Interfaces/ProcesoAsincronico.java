package dds.grupo3.Interfaces;

import java.util.Calendar;
import java.util.List;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

import ddsgrupo3.Factory;

public abstract class ProcesoAsincronico implements Funcionalidad {
	public Calendar fechaInicio; //fecha de inicio de ejecucion programada
	public TimerTask task;
	public String terminalID;
	private CommandProcesos command;
	private String archivo="";
	
	public Object	realizarFuncion(List<POIGral> listaPois,Object usuario){
		command.pedirInfo();
		fechaInicio= this.setFecha();
		command.setTask(task,fechaInicio,(User)usuario,this.terminalID);
		Timer timer= new Timer(true);
		timer.schedule(task,fechaInicio.getTime()); //ejecuta el "run" a la hora de fechaInicio
		return (null);
	}
	public abstract void pedirInfo();
	private Calendar setFecha(){
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		System.out.println("Ingrese fecha de inicio de ejecucion (hh:mm)");
		Calendar horaDeInicio= Calendar.getInstance();
		String auxiliar[]= scanner.nextLine().split(":");
//		scanner.close();
		horaDeInicio.set(Calendar.HOUR_OF_DAY, Integer.parseInt(auxiliar[0]));
		horaDeInicio.set(Calendar.MINUTE, Integer.parseInt(auxiliar[1]));
		return (horaDeInicio);
	}
	
//	@Override
//	public void run(){
//		//Logica individual de cada proceso asincronico
//		//debe instanciar el resultado y si hay error, el string de error
//		//Resultado solo puede tomar valor "OK" o "ERROR", error es un string con el exception
//		//ejemplo=
//		fechaInicio=Calendar.getInstance();
//		try {
//			Thread.sleep(2000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//		Boolean ejecucionCorrecta=true;
//		if (ejecucionCorrecta){
//			resultadoOK();
//		}
//		else{
//			resultadoError("insertarError");
//		}
//	}

	@Override
	public void setParametro(Object obj) {
		String[] parametros=((String)obj).split(",");
		this.terminalID=parametros[0];
		setCommand((CommandProcesos) Factory.getObject(parametros[1]));
	}
	@Override
	public String mostrarOpcion(){
		return "DISPARAR PROCESO ASINCRONICO";
	};	
	
	@Override
	public Integer desplegarConsola(User usuario, String terminal_ID,Scanner teclado){
		System.out.println("---------------------------------------");
		System.out.println("		PROCESO ASINCRONICO");
		System.out.println("----------------------------------------");
		System.out.println();
		System.out.println("Elija el proceso asincronico:");
		System.out.println(" 1 - Actualizar locales comerciales");
		System.out.println(" 2 - Baja de POIs");
		System.out.println(" 3 - Agregar acciones a los usuarios");
		System.out.println(" 4 - Proceso Multiple");
		System.out.println(" 5 - Volver al menu principal");
		System.out.print(" OPCION -> ");
		String opcionElegida = teclado.nextLine();
		String comando="";
		switch (Integer.parseInt(opcionElegida)) {
		case 1: comando="ActualizacionLocalComercial";
				break;
		case 2: comando="BajaDePOI";
				break;
		case 3: comando="AgregarAcciones";
				break;
		case 4: comando="ProcesoMultiple";
				break;
		default: System.out.println ("Opcion incorrecta"); 
				return Integer.parseInt(opcionElegida);
		}	
		usuario.dispararProcesoAsincronico(terminal_ID+","+comando);
		return 0;
	};
	
	public CommandProcesos getCommand() {
		return command;
	}
	public void setCommand(CommandProcesos command) {
		this.command = command;
	}
	public String getArchivo() {
		return archivo;
	}
	public void setArchivo(String archivo) {
		this.archivo = archivo;
	}
}
