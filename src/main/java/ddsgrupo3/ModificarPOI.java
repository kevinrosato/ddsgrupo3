package ddsgrupo3;

import java.util.List;

import dds.grupo3.POIsSistem.POI;

public class ModificarPOI implements Funcionalidad{

	private POI poiNuevo; //ver como seria pasarle solo los campos
	public ModificarPOI(POI poiNuevo){
		this.poiNuevo=poiNuevo;
	}
	
	@Override
	public void realizarFuncionConPOI(List<POI> listaPois, POI poi) {
		// TODO Auto-generated method stub
		int i;
		for(i=0;i<listaPois.size();i++){
			if(listaPois.get(i).equals(poi))break;
		}
		listaPois.set(i,this.poiNuevo);
	}
	


	
}
