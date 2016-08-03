package dds.grupo3.ProcesosAsincronicos;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import dds.grupo3.Interfaces.ProcesoAsincronico;
import dds.grupo3.Interfaces.User;
import ddsgrupo3.Factory;

public class ProcesoMultiple extends ProcesoAsincronico{
	private List<ProcesoAsincronico> procesos= new ArrayList<ProcesoAsincronico>();
	String procesoMultiple;
	Scanner teclado;
	public ProcesoMultiple(List<ProcesoAsincronico> procesos, String terminal_ID, User usuario){
		this.usuario=usuario;
		this.terminalID=terminal_ID;
		this.procesos=procesos;
	}
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
		this.task= new ProcesoMultiple(procesos,terminalID,usuario);
		
	}

	@Override
	public String setProceso() {
		return "Proceso Multiple";
	}
}
