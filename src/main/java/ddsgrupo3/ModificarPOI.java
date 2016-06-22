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
		int i=0;
		while(i<listaPois.size()&&(listaPois.get(i)!=poi)){
			if(listaPois.get(i)!=poi)i++;
		}
		if(i!=listaPois.size()) listaPois.set(i,this.poiNuevo);
	}
	


	
}
