package ddsgrupo3;

import java.util.List;

public class CGP extends Local{
	private List<Servicio> servicios;
	private Byte numeroCGP;
	private Byte comuna;
	
	//----------
	//Constructor
	//----------
	public CGP(String name)
	{
		this.setNombre(name);
		servicios = null;
	}
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
		return	(super.tieneLaClave(clave))
				||	(this.getComuna().toString().contains(clave))
				||	(this.getNumeroCGP().toString().contains(clave))
				||	(this.serviciosTienenLaClave(clave));
	}
	
	public	Boolean	serviciosTienenLaClave(String clave)
	{
		Boolean valorVerdad; Integer i=0;
		valorVerdad = this.getServicio(i).tieneLaClave(clave);
		while (!valorVerdad)
			{	 
			valorVerdad = (this.getServicio(i).tieneLaClave(clave)) || valorVerdad;
			}
		return valorVerdad;
	}
	//----------
	//Getters y Setters
	//----------

	public Servicio getServicio(Integer n) 
	{
		return servicios.get(n);
	}
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
	public void setServicio(Servicio servicio) 
	{
		servicios.add(servicio);
	}
}
