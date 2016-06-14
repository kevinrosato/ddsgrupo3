package dds.grupo3.DTOs;

public class ServDTO {

//	atts
	String			nombreServ;
	HorariosServDTO[]	horarios;
	
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
	public HorariosServDTO[] getHorarios() {
		return horarios;
	}
	public void setHorarios(HorariosServDTO[] horarios) {
		this.horarios = horarios;
	}
}
