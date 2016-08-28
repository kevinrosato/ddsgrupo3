package dds.grupo3.ProcesosAsincronicos;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;
import java.util.TimerTask;

import dds.grupo3.Interfaces.CommandProcesos;
import dds.grupo3.Interfaces.ProcesoAsincronico;
import dds.grupo3.Interfaces.User;
import ddsgrupo3.Factory;

public class ProcesoMultiple extends TimerTask implements CommandProcesos{
	private List<ProcesoAsincronico> procesos= new ArrayList<ProcesoAsincronico>();
	String procesoMultiple;
	Scanner teclado;
	private User usuario;
	private String terminalID;
	private Calendar fechaInicio;
	
	@Override
	public void run(){
		ResultadosProcesos resultado=new ResultadosProcesos(this,this.fechaInicio);
		try{
			for(ProcesoAsincronico i:procesos){
				i.realizarFuncion(usuario.getMapa().getListaPois(),usuario);
			}
			resultado.resultadoOK();
		}
		catch(Exception e){
			resultado.resultadoError(e.toString());
		}
	}

	public void pedirInfo() {
		teclado=new Scanner(System.in);
		System.out.println("---------------------------------------");
		System.out.println("		PROCESO MULTIPLE");
		System.out.println("----------------------------------------");
		System.out.println();
		System.out.println("Ingrese lista de procesos:");
		this.procesoMultiple = teclado.nextLine();
		for(String i: procesoMultiple.split(",")){
			procesos.add((ProcesoAsincronico) Factory.getObject(i));
		}
		System.out.println();
		
	}

	public void setTask(TimerTask task,Calendar fechaInicio,User usuario,String terminalID) {
		ProcesoMultiple a= new ProcesoMultiple();
		a.usuario=usuario;
		a.terminalID=terminalID;
		a.procesos=this.procesos;
		fechaInicio=Calendar.getInstance();
		a.fechaInicio=fechaInicio;
		task= (TimerTask) a;
		
	}

	public String setProceso() {
		return "Proceso Multiple";
	}
}
