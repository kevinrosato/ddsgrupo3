package dds.grupo3.ProcesosAsincronicos;

import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Properties;

import dds.grupo3.Interfaces.CommandProcesos;
import dds.grupo3.UsoTerminales.ResultadoDAO;
import ddsgrupo3.Mailbox;

public class ResultadosProcesos {

	public Calendar fechaInicio; //fecha de inicio de ejecucion programada
	public String proceso;
	public String resultado; 
	public String error ="";
	public String mail="";
	public Integer errorDefault=0; //0= mail, 1= reintento, cualquier otro valor= no hace nada particular
	public Integer errorReintento=0;
	public Integer cantReintentosActuales=0;
	private CommandProcesos command;
	
	public ResultadosProcesos(CommandProcesos command,Calendar fechaInicio){
		this.command=command;
		this.fechaInicio=fechaInicio;
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
				command.run();
				return;
			}
			break;
		}
		resultado="ERROR";
		this.error=error;
		publicarResultado();
	}
	public void publicarResultado(){
		proceso= command.setProceso();
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss a");
		String fechaS= dateFormat.format(fechaInicio.getTime());
		String fechaFin= dateFormat.format((Calendar.getInstance()).getTime());
		/*System.out.println("Inicio "+fechaS); //Para testeo
		System.out.println("Fin "+fechaFin);
		System.out.println("Proceso "+ proceso);
		System.out.println("Resultado "+ resultado);
		System.out.println("Error "+ error);*/
		ResultadoDAO.agregarABaseDeDatos(fechaS, fechaFin, proceso, resultado, error); 
	}
}
