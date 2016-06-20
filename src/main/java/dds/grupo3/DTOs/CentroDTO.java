package dds.grupo3.DTOs;

import java.util.List;

public class CentroDTO {
	
// atts
	int 	numComuna;
	String	zonasIncluidas;
	String	nombreDirector;
	String	domicilioCompleto;
	List<ServDTO>	servicios;

	public String mostrar()
	{
		return "CentroDTO [zonasIncluidas=" + zonasIncluidas + ", nombreDirector="
				+ nombreDirector + ", domicilioCompleto=" + domicilioCompleto + "]";	
	}
	@Override
	public String toString() {
		return "CentroDTO [numComuna=" + numComuna + ", zonasIncluidas=" + zonasIncluidas + ", nombreDirector="
				+ nombreDirector + ", domicilioCompleto=" + domicilioCompleto + ", servicios=" + servicios + "]";
	}
	//	GyS	
	public int getNumComuna() {
		return numComuna;
	}
	public void setNumComuna(int numComuna) {
		this.numComuna = numComuna;
	}
	public String getZonasIncluidas() {
		return zonasIncluidas;
	}
	public void setZonasIncluidas(String zonasIncluidas) {
		this.zonasIncluidas = zonasIncluidas;
	}
	public String getNombreDirector() {
		return nombreDirector;
	}
	public void setNombreDirector(String nombreDirector) {
		this.nombreDirector = nombreDirector;
	}
	public String getDomicilioCompleto() {
		return domicilioCompleto;
	}
	public void setDomicilioCompleto(String domicilioCompleto) {
		this.domicilioCompleto = domicilioCompleto;
	}
	public List<ServDTO> getServicios() {
		return servicios;
	}
	public void setServicios(List<ServDTO> servicios) {
		this.servicios = servicios;
	}
}
