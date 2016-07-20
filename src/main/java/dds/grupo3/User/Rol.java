package dds.grupo3.User;

import java.util.ArrayList;
import java.util.List;

import dds.grupo3.Interfaces.Funcionalidad;

public class Rol{

	private List<Funcionalidad> permisos = new ArrayList<Funcionalidad>();
	private String nombre;
	
	
	public Boolean verificarPermisos(Funcionalidad funcionalidad){
		Boolean valor=false;
		for(Funcionalidad i:permisos){
			if(i.getClass()==funcionalidad.getClass()) valor=true; 
		}
		return valor;
	}

	public List<Funcionalidad> getPermisos() {
		return permisos;
	}

	public void setPermisos(List<Funcionalidad> permisos) {
		this.permisos = permisos;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
