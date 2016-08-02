package dds.grupo3.Interfaces;

import java.util.List;

public interface Funcionalidad 
//TODO: Cambiar el nombre de realizar funcion con POI ya que puede ser otro tipo de funcionalidades
//TODO:List POIGral deberia ser List Object
{
	public Integer	desplegarConsola(User usuario, String terminal_ID);
	public void		mostrarOpcion();
	public Object	realizarFuncion(List<POIGral> listaPois,Object poi);
	public void		setParametro(Object obj);
}
