package dds.grupo3.Interfaces;

public interface BusquedaDTO {
	
	public void setCantRespuestas(Integer cantRespuestas);
	public void setRetardo(Long l);
	public void setTerminal(String terminal);
	public void setParametro(String parametro);
	public void setFecha(String fecha);
	public Integer getCantRespuestas();
	public Long getRetardo();
	public String getTerminal();
	public String getParametro();
	public String getFecha();
}
