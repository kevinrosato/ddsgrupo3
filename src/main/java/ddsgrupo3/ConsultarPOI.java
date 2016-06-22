package ddsgrupo3;

import java.util.List;

import dds.grupo3.POIsSistem.POI;

public class ConsultarPOI implements Funcionalidad {

	private Mapa mapa;
	public ConsultarPOI(Mapa mapa){
		this.mapa=mapa;
	}
	
	@Override
	public void realizarFuncionConPOI(List<POI> listaPois, POI poi) {
		// TODO Auto-generated method stub
		mapa.realizarBusqueda();
	}

}
