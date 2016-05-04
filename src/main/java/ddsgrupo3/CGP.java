package ddsgrupo3;

import java.util.List;

public class CGP extends Local{
	private List<Service> servicios;
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

	public	Boolean	tieneLaClave(String clave)
	{
		Boolean valorVerdad;
		valorVerdad = super.tieneLaClave(clave);
		valorVerdad = (clave == this.getComuna().toString()) || valorVerdad;
		valorVerdad = (clave == this.getNumeroCGP().toString()) || valorVerdad;
		valorVerdad = (this.serviciosTienenLaClave(clave)) || valorVerdad;
		return valorVerdad;
	}
	
	public	Boolean	serviciosTienenLaClave(String clave)
	{
		return this.getServicios().contains();;
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
	public List<Service> getServicios() {
		return servicios;
	}
	public void setServicios(List<Service> servicios) {
		this.servicios = servicios;
	}
}
