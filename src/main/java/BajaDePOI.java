import dds.grupo3.Interfaces.POIGral;
import dds.grupo3.User.BorrarPOI;
import ddsgrupo3.Mapa;

public class BajaDePOI {

	private POIGral poi;
	private Mapa mapa=new Mapa();
	public BajaDePOI(Mapa mapa){
		this.mapa=mapa;
	}
	public void execute(){
		mapa.realizarFuncConPoi(new BorrarPOI(), poi);
	}
}
