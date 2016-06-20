package dds.grupo3.DTOs;

import java.util.List;

public class ServDTO {

//	atts
	String			nombreServ;
	List<HorariosServDTO>	horarios;
	
	@Override
	public String toString() {
	return "ServDTO [nombreServ=" + nombreServ + "]";
	}
	
	//	GyS
	public String getNombreServ() {
		return nombreServ;
	}
	public void setNombreServ(String nombreServ) {
		this.nombreServ = nombreServ;
	}
	public List<HorariosServDTO> getHorarios() {
		return horarios;
	}
	public void setHorarios(List<HorariosServDTO> horarios) {
		this.horarios = horarios;
	}
}
