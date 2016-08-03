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
	String terminal_ID;
	Scanner teclado;
	public ProcesoMultiple(List<ProcesoAsincronico> procesos, String terminal_ID, User usuario){
		this.usuario=usuario;
		this.terminal_ID=""; //TODO:No se por ahora como implementar esto bien
		this.procesos=procesos;
	}
	@Override
	public void run(){
		try{
			for(ProcesoAsincronico i:procesos){
				i.desplegarConsola(usuario, terminal_ID, teclado);
			}
			this.resultadoOK();
		}
		catch(Exception e){
			this.resultadoError(e.toString());
		}
	}

	@Override
	public Integer desplegarConsola(User usuario, String terminal_ID,Scanner teclado) {
		for(String i: procesoMultiple.split(",")){
			procesos.add((ProcesoAsincronico) Factory.getObject(i));
		}
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
		this.task= new ProcesoMultiple(procesos,terminal_ID,usuario);
		
	}

	@Override
	public String setProceso() {
		return "Proceso Multiple";
	}
}
