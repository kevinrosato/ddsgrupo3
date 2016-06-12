package ddsgrupo3;

public class AgregarPOI implements Funcionalidad {

	@Override
	public void realizarFuncionConPOI(Mapa mapa, POI poi){
		mapa.agregarPoi(poi);
	};
}
