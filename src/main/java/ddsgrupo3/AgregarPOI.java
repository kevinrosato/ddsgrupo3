package ddsgrupo3;

import dds.grupo3.POIsSistem.POI;

public class AgregarPOI implements Funcionalidad {

	@Override
	public void realizarFuncionConPOI(Mapa mapa, POI poi){
		mapa.agregarPoi(poi);
	};
}
