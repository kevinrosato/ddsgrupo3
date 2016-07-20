package dds.grupo3.User;

import java.util.List;

import dds.grupo3.Interfaces.Funcionalidad;
import dds.grupo3.Interfaces.POIGral;
import dds.grupo3.Interfaces.User;

public class ReportarPOI implements Funcionalidad {

	private User usuario;
	
	@Override
	public POIGral realizarFuncionConPOI(List<POIGral> listaPois, POIGral poi) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setParametro(Object obj) {
		usuario = (User) obj;
	}

}
