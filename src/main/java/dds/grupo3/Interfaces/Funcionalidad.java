package dds.grupo3.Interfaces;

import java.util.List;

public interface Funcionalidad 
{
	public Integer	desplegarConsola(User usuario, String terminal_ID);
	public void		mostrarOpcion();
	public Object	realizarFuncion(List<POIGral> listaPois,Object poi);
	public void		setParametro(Object obj);
}
