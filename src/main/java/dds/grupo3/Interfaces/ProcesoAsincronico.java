package dds.grupo3.Interfaces;

import java.util.Calendar;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import dds.grupo3.UsoTerminales.ResultadoDAO;

public abstract class ProcesoAsincronico extends TimerTask implements Funcionalidad {
	//TODO: Agregar horas de inicio y fin para agregar a BD con fecha no basta
	//TODO: Archivo de configuracion para mail de usuario y opcion por defecto ante falla
	ResultadoDAO daoBaseDeDatos= new ResultadoDAO(); //Conexion a base de datos
	Calendar fechaInicio; //fecha de inicio de ejecucion programada
	String proceso;
	String resultado; 
	String error ="";
	TimerTask task;

	public Object	realizarFuncion(List<POIGral> listaPois,Object fecha){
		fechaInicio= (Calendar)fecha;
		setProceso();
		setTask();
		//Nicole aca pondrias unos scanner para agregar permisos
		Timer timer= new Timer(true);
		timer.schedule(task,fechaInicio.getTime()); //ejecuta el "run" a la hora de fechaInicio
		return (null);
	}
	public void setTask(){
		//task= new ProcesoAsincronico(); //pisar esto y poner la clase correspondiente del proceso
	}
	public void setProceso(){ //pisar esto y poner el tipo correspondiente ej "Actualizar Comercios"
		proceso="";
	}
	
	@Override
	public void run(){
		//Logica individual de cada proceso asincronico
		//debe instanciar el resultado y si hay error, el string de error
		//Resultado solo puede tomar valor "OK" o "ERROR", error es un string con el exception
		//ejemplo=
		Boolean ejecucionCorrecta=true;
		if (ejecucionCorrecta){
			resultadoOK();
		}
		else{
			resultadoError("insertarError");
		}
	}
	public void resultadoOK(){
		resultado="OK";
		error="";
		publicarResultado();
	}
	public void resultadoError(String error){
		//TODO: Deberia tener tres opciones, configuradas por archivo de config: Mail, intentar n veces 
		// o no hacer nada que es lo que esta haciendo ahora
		resultado="ERROR";
		this.error=error;
		publicarResultado();
	}
	public void publicarResultado(){
		String fechaS= calendarToString(fechaInicio);
		String fechaFin= calendarToString(Calendar.getInstance());
		daoBaseDeDatos.agregarABaseDeDatos(fechaS, fechaFin, proceso, resultado, error); //Guarda en BD
	}
	
	private String calendarToString(Calendar cal){
		String fechaS = Integer.toString(cal.get(Calendar.DAY_OF_MONTH));
		fechaS = fechaS.concat("/");
		fechaS = fechaS.concat(Integer.toString(1 + cal.get(Calendar.MONTH)));
		fechaS = fechaS.concat("/");
		fechaS = fechaS.concat(Integer.toString(cal.get(Calendar.YEAR)));
		return (fechaS);
	}

	@Override
	public void setParametro(Object obj) {
	}
	
	public abstract void execute();
}
