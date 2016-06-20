package ddsgrupo3;

import java.util.List;

import dds.grupo3.POIsSistem.POI;

public class AgregarPOI implements Funcionalidad {

	
	@Override
	public void realizarFuncionConPOI(List<POI> listaPois,POI poi){
		listaPois.add(poi);
	};
}
