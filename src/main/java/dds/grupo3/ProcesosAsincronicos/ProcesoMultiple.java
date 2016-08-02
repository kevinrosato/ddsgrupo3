package dds.grupo3.ProcesosAsincronicos;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import dds.grupo3.Interfaces.ProcesoAsincronico;
import dds.grupo3.Interfaces.User;
import ddsgrupo3.Factory;

public class ProcesoMultiple extends ProcesoAsincronico{
	//TODO: Implementacion real
	private List<ProcesoAsincronico> procesos= new ArrayList<ProcesoAsincronico>();
	String procesoMultiple;
	User usuario;
	String terminal_ID;
	Scanner teclado;
	
	@Override
	public void run(){
		for(ProcesoAsincronico i:procesos){
			i.desplegarConsola(usuario, terminal_ID, teclado);
		}
	}

	@Override
	public Integer desplegarConsola(User usuario, String terminal_ID,Scanner teclado) {
		this.usuario=usuario;
		this.terminal_ID=terminal_ID;
		this.teclado=teclado;
		Factory factory = null;
		System.out.println("---------------------------------------");
		System.out.println("		PROCESO MULTIPLE");
		System.out.println("----------------------------------------");
		System.out.println();
		System.out.println("Ingrese lista de procesos:");
		this.procesoMultiple = teclado.nextLine();
		for(String i: procesoMultiple.split(",")){
			procesos.add((ProcesoAsincronico) factory.getObject(i));
		}
		usuario.procesoMultiple(terminal_ID);
		System.out.println();
		return null;
	}

	@Override
	public void mostrarOpcion() {
		// TODO Auto-generated method stub
		System.out.println("-->	DISPARAR PROCESO MULTIPLE");
	}
}
