package ddsgrupo3;

import java.util.ArrayList;
import java.util.List;

import dds.grupo3.POIsSistem.POI;

public class Rol{

	private List<POI> permisos=new ArrayList<POI>();
	
	public Boolean verificarPermisos(Funcionalidad funcionalidad){
		return permisos.contains(funcionalidad);
	}

	
}
