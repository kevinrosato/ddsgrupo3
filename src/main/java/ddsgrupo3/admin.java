package ddsgrupo3;

import java.util.Calendar;
import java.util.List;

import dds.grupo3.Interfaces.AdministradorPOIs;
import dds.grupo3.Interfaces.CGPDAO;
import dds.grupo3.Interfaces.Funcionalidad;
import dds.grupo3.Interfaces.POIGral;
import dds.grupo3.POIsSistem.Ubicacion;

public class admin implements AdministradorPOIs {

	@Override
	public void buscarYmostrar(String clave) {
		// TODO Auto-generated method stub

	}

	@Override
	public Object realizarFuncConPoi(Funcionalidad funcionalidad, Object poi) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<POIGral> getListaPois() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setListaPois(List<POIGral> listaPois) {
		// TODO Auto-generated method stub

	}

	@Override
	public Calendar getHoraActual() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setHoraActual(Calendar horaActual) {
		// TODO Auto-generated method stub

	}

	@Override
	public Ubicacion getUbicacionActual() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setUbicacionActual(Ubicacion ubicacionActual) {
		// TODO Auto-generated method stub

	}

	@Override
	public void agregarPoi(POIGral poi) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setBaseDatosCGP(CGPDAO baseDatosCGP) {
		// TODO Auto-generated method stub

	}
}
