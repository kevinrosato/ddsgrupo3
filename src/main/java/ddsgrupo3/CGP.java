package ddsgrupo3;

import java.util.List;

public class CGP extends Local{
	private List<Servicio> servicios;
	private Byte numeroCGP;
	private Byte comuna;
	//----------
	//Metodos
	//----------
		
	public String conocerTipo(){
		return "Centro De Gestion y Participacion";
	}
	
	public Boolean estaCercaDe(Byte comuna){
		return (this.comuna == comuna);		
	}

	//----------
	//Getters y Setters
	//----------

	public Byte getNumeroCGP() {
		return numeroCGP;
	}
	public void setNumeroCGP(Byte numeroCGP) {
		this.numeroCGP = numeroCGP;
	}
	public Byte getComuna() {
		return comuna;
	}
	public void setComuna(Byte comuna) {
		this.comuna = comuna;
	}
	public List<Servicio> getServicios() {
		return servicios;
	}
	public void setServicios(List<Servicio> servicios) {
		this.servicios = servicios;
	}
	
}
