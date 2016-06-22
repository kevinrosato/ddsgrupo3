package ddsgrupo3;

import java.util.ArrayList;
import java.util.List;

public class Rol{

	private List<Funcionalidad> permisos=new ArrayList<Funcionalidad>();
	
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

	
	
}
