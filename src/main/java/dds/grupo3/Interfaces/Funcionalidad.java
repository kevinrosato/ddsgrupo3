package dds.grupo3.Interfaces;

import java.util.List;
import java.util.Scanner;

public interface Funcionalidad 
{
	public Integer	desplegarConsola(User usuario, String terminal_ID,Scanner teclado);
	public void		mostrarOpcion();
	public Object	realizarFuncion(List<POIGral> listaPois,Object poi);
	public void		setParametro(Object obj);
}
