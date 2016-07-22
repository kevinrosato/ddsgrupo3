package dds.grupo3.Interfaces;

import java.util.Calendar;
import java.util.List;
import dds.grupo3.POIsSistem.Ubicacion;

public interface AdministradorPOIs
{
	public void buscarYmostrar(String clave);
	//----------------------------------------------
	//METODOS ABCM
	public POIGral realizarFuncConPoi(Funcionalidad funcionalidad,Object poi);
	//----------
	//Getters y Setters
	//----------
	public List<POIGral> getListaPois();
	public void setListaPois(List<POIGral> listaPois);
	public Calendar getHoraActual();
	public void setHoraActual(Calendar horaActual);
	public Ubicacion getUbicacionActual();
	public void setUbicacionActual(Ubicacion ubicacionActual);
	//VER DE SACARLO SIN QUE ROMPAN LOS TESTS
	public void agregarPoi(POIGral poi);
	public void setBaseDatosCGP(CGPDAO baseDatosCGP);	
}
