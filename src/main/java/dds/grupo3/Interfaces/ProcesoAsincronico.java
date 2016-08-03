package dds.grupo3.Interfaces;

import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

import dds.grupo3.User.Usuario;
import dds.grupo3.UsoTerminales.ResultadoDAO;
import ddsgrupo3.Mailbox;

public abstract class ProcesoAsincronico extends TimerTask implements Funcionalidad {
	public Calendar fechaInicio; //fecha de inicio de ejecucion programada
	public String proceso;
	public String resultado; 
	public String error ="";
	public String mail="";
	public TimerTask task;
	public Integer errorDefault=0; //0= mail, 1= reintento, cualquier otro valor= no hace nada particular
	public Integer errorReintento=0;
	public Integer cantReintentosActuales=0;
	public String terminalID;
	public User usuario;
	
	public Object	realizarFuncion(List<POIGral> listaPois,Object usuario){
		this.usuario=(Usuario) usuario;
		pedirInfo();
		fechaInicio= this.setFecha();
		setTask();
		Timer timer= new Timer(true);
		timer.schedule(task,fechaInicio.getTime()); //ejecuta el "run" a la hora de fechaInicio
		return (null);
	}
	public abstract void pedirInfo();
	private Calendar setFecha(){
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		System.out.println("Ingrese fecha de inicio de ejecucio (hh:mm)");
		Calendar horaDeInicio= Calendar.getInstance();
		String auxiliar[]= scanner.nextLine().split(":");
//		scanner.close();
		horaDeInicio.set(Calendar.HOUR_OF_DAY, Integer.parseInt(auxiliar[0]));
		horaDeInicio.set(Calendar.MINUTE, Integer.parseInt(auxiliar[1]));
		return (horaDeInicio);
	}
	public abstract void setTask();//task= new ProcesoAsincronico(); usar inicializar
								//pisar esto y poner la clase correspondiente del proceso
	public abstract String setProceso(); //proceso="algo "
						//pisar esto y poner el tipo correspondiente ej "Actualizar Comercios"
//	public abstract void inicializar();
	
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
		switch (errorDefault){
		case 0:
			Mailbox.enviarMail(mail, "Hubo un error", "Ocurrio un error en el sistema de POIs."+
		                                              "Este es un mensaje generado automaticamente.");
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
		proceso= setProceso();
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss a");
		String fechaS= dateFormat.format(fechaInicio.getTime());
		String fechaFin= dateFormat.format((Calendar.getInstance()).getTime());
		System.out.println("Inicio "+fechaS); //Para testeo
		System.out.println("Fin "+fechaFin);
		System.out.println("Proceso "+ proceso);
		System.out.println("Resultado "+ resultado);
		System.out.println("Error "+ error);
		//ResultadoDAO.agregarABaseDeDatos(fechaS, fechaFin, proceso, resultado, error); 
	}
	@Override
	public void setParametro(Object obj) {
		terminalID=(String)obj;
	}
	@Override
	public abstract void mostrarOpcion();
	
	@Override
	public abstract Integer desplegarConsola(User usuario, String terminal_ID,Scanner teclado);
}
