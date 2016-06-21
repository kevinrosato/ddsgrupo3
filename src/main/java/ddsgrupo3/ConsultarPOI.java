package ddsgrupo3;

import java.util.List;

import dds.grupo3.POIsSistem.POI;

public class ConsultarPOI implements Funcionalidad {

	@Override
	public void realizarFuncionConPOI(List<POI> listaPois, POI poi) {
		// TODO Auto-generated method stub
		int i;
		for(i=0;i<listaPois.size();i++){
			if(listaPois.get(i)==poi) break;
		}
		listaPois.get(i).mostrarInformacion();
	}

}
