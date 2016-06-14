package dds.grupo3.DTOs;

import java.util.Arrays;

public class CentroDTO {
	
// atts
	int 	numComuna;
	String	zonasIncluidas;
	String	nombreDirector;
	String	domicilioCompleto;
	ServDTO[]	servicios;

@Override
	public String toString() {
		return "CentroDTO [numComuna=" + numComuna + ", zonasIncluidas=" + zonasIncluidas + ", nombreDirector="
				+ nombreDirector + ", domicilioCompleto=" + domicilioCompleto + ", servicios="
				+ Arrays.toString(servicios) + "]";
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
	public ServDTO[] getServicios() {
		return servicios;
	}
	public void setServicios(ServDTO[] servicion) {
		this.servicios = servicion;
	}
}
