package ddsgrupo3;


public class CGP extends Local{
	private Byte numeroCGP;
	private Byte comuna;
	
	//----------
	//Constructor
	//----------
	public CGP(String name)
	{
		this.setNombre(name);
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
				||	(super.serviciosTienenLaClave(clave));
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
}
