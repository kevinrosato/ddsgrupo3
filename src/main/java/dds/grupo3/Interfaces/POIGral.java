package dds.grupo3.Interfaces;

import java.util.Calendar;
import java.util.List;

import dds.grupo3.POIsSistem.Ubicacion;

public interface POIGral
{
	List<String>	mostrarInformacionAvanzada();
	String[]	mostrarInformacion();
	Boolean	estaCercaDe(Ubicacion ubicacion);
	Boolean	tieneLaClave(String clave);
	Boolean	estaDisponible(Calendar horaActual);
	Boolean	esValido();
	String	conocerTipo();
	String	getImagen();
	String	get_id_vista();
	void settearCampos(String[] campos);
}
