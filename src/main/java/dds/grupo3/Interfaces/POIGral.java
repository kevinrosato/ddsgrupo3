package dds.grupo3.Interfaces;

import java.util.Calendar;

import dds.grupo3.POIsSistem.Ubicacion;

public interface POIGral
{
	void	mostrarInformacionAvanzada();
	void	mostrarInformacion();
	Boolean	estaCercaDe(Ubicacion ubicacion);
	Boolean	tieneLaClave(String clave);
	Boolean	estaDisponible(Calendar horaActual);
	Boolean	esValido();
	String	conocerTipo();
}