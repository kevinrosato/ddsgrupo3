package dds.grupo3.Interfaces;

import java.sql.Date;
import java.util.List;

public interface BusquedaDTO {
	
	public void setCantRespuestas(Integer cantRespuestas);
	public void setRetardo(Integer i);
	public void setTerminal(String terminal);
	public void setParametro(String parametro);
	public void setFecha(Date fecha);
	public void setPOIs(List<POI> fecha);
	public Integer getCantRespuestas();
	public Integer getRetardo();
	public String getTerminal();
	public String getParametro();
	public String getFecha();
	public String toString();
	public List<POI> getPOIs();
}
