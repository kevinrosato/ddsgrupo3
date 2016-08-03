package dds.grupo3.ProcesosAsincronicos;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;
import java.util.TimerTask;

import dds.grupo3.Interfaces.ProcesoAsincronico;
import dds.grupo3.Interfaces.User;
import ddsgrupo3.Factory;

public class ProcesoMultiple extends ProcesoAsincronico{
	private List<ProcesoAsincronico> procesos= new ArrayList<ProcesoAsincronico>();
	String procesoMultiple;
	Scanner teclado;
	@Override
	public void run(){
		try{
			for(ProcesoAsincronico i:procesos){
				i.desplegarConsola(usuario, terminalID, teclado);
			}
			this.resultadoOK();
		}
		catch(Exception e){
			this.resultadoError(e.toString());
		}
	}

	@Override
	public Integer desplegarConsola(User usuario, String terminal_ID,Scanner teclado) {
		usuario.procesoMultiple(terminal_ID);
		return null;
	}

	@Override
	public void mostrarOpcion() {
		System.out.println("-->	DISPARAR PROCESO MULTIPLE");
	}

	@Override
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

	@Override
	public void setTask() {
		ProcesoMultiple a= new ProcesoMultiple();
		a.usuario=usuario;
		a.terminalID=terminalID;
		a.procesos=procesos;
		a.fechaInicio=Calendar.getInstance();
		this.task= (TimerTask) a;
		
	}

	@Override
	public String setProceso() {
		return "Proceso Multiple";
	}
}
