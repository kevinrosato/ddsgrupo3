package dds.grupo3.Interfaces;

import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

import dds.grupo3.FabricaPOIs.FabricaDePOIs;
import dds.grupo3.UsoTerminales.ResultadoDAO;

public abstract class ProcesoAsincronico extends TimerTask implements Funcionalidad {
	ResultadoDAO daoBaseDeDatos= new ResultadoDAO(); //Conexion a base de datos
	Calendar fechaInicio; //fecha de inicio de ejecucion programada
	String proceso;
	String resultado; 
	String error ="";
	TimerTask task;
	String mail="";
	Integer errorDefault=0; //0= mail, 1= reintento, cualquier otro valor= no hace nada particular
	Integer errorReintento=0;
	Integer cantReintentosActuales=0;

	public Object	realizarFuncion(List<POIGral> listaPois,Object fecha){
		FileInputStream file;
		try {
			file = new FileInputStream("ProcesoAsincronico.properties");
		Properties propiedades = new Properties();
			propiedades.load(file);
		
		mail = propiedades.getProperty("mailDefault");
		errorDefault= Integer.parseInt(propiedades.getProperty("accionErrorDefault"));
		errorReintento= Integer.parseInt(propiedades.getProperty("errorReintento"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		fechaInicio= (Calendar)fecha;
		setTask();
		Timer timer= new Timer(true);
		timer.schedule(task,fechaInicio.getTime()); //ejecuta el "run" a la hora de fechaInicio
		return (null);
	}
	public void setTask(){
		//task= new ProcesoAsincronico(); //pisar esto y poner la clase correspondiente del proceso
	}
	public void setProceso(){ //pisar esto y poner el tipo correspondiente ej "Actualizar Comercios"
		proceso="Por Defecto";
	}
	
	@Override
	public void run(){
		//Logica individual de cada proceso asincronico
		//debe instanciar el resultado y si hay error, el string de error
		//Resultado solo puede tomar valor "OK" o "ERROR", error es un string con el exception
		//ejemplo=
		fechaInicio=Calendar.getInstance();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Boolean ejecucionCorrecta=true;
		if (ejecucionCorrecta){
			resultadoOK();
		}
		else{
			resultadoError("insertarError");
		}
	}
	public void resultadoOK(){
		resultado="SUCCESS";
		error="NONE";
		publicarResultado();
	}
	
	public void resultadoError(String error){
		switch (errorDefault){
		case 0:
			//TODO:enviar mail
			break;
		case 1:
			if (cantReintentosActuales>=errorReintento){
				cantReintentosActuales++;
				this.run();
				return;
			}
			break;
		}
		resultado="ERROR";
		this.error=error;
		publicarResultado();
	}
	public void publicarResultado(){
		setProceso();
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss a");
		String fechaS= dateFormat.format(fechaInicio.getTime());
		String fechaFin= dateFormat.format((Calendar.getInstance()).getTime());
		/*System.out.println("Inicio "+fechaS); //Para testeo
		System.out.println("Fin "+fechaFin);
		System.out.println("Proceso "+ proceso);
		System.out.println("Resultado "+ resultado);
		System.out.println("Error "+ error);*/
		daoBaseDeDatos.agregarABaseDeDatos(fechaS, fechaFin, proceso, resultado, error); 
	}

	@Override
	public void setParametro(Object obj) {
	}
	@Override
	public void mostrarOpcion() { //Pisar en cada implementacion
	}
	
	@Override
	public Integer desplegarConsola(User usuario, String terminal_ID,Scanner teclado){	 //pisar en cada implementacion que necesite 
		
		return 0;
	}
}
