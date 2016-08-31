package dds.grupo3.Interfaces;

public interface BusquedaDTO {
	
	public void setCantRespuestas(Integer cantRespuestas);
	public void setRetardo(Integer i);
	public void setTerminal(String terminal);
	public void setParametro(String parametro);
	public void setFecha(String fecha);
	public Integer getCantRespuestas();
	public Integer getRetardo();
	public String getTerminal();
	public String getParametro();
	public String getFecha();
	public String toString();
}
