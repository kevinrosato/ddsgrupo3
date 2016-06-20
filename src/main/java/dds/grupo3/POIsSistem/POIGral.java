package dds.grupo3.POIsSistem;

import java.util.Calendar;

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
