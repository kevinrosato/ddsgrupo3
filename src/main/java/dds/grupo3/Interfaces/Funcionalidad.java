package dds.grupo3.Interfaces;

import java.util.List;

public interface Funcionalidad 
//TODO: Cambiar el nombre de realizar funcion con POI ya que puede ser otro tipo de funcionalidades
//TODO:List POIGral deberia ser List Object
{
	public Object	realizarFuncionConPOI(List<POIGral> listaPois,Object poi);
	public void		setParametro(Object obj);
}
