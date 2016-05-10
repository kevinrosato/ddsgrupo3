package ddsgrupo3;


public class CGP extends Local{
	private Byte numeroCGP;
	private Byte comuna=0;
	
	//----------
	//Constructor
	//----------
	public CGP(String name,Byte numeroCGP) {
		this.setNombre(name);
		this.setNumeroCGP(numeroCGP);
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

	public	Boolean	tieneLaClave(String clave) {
		return	(super.tieneLaClave(clave))
				||	(this.getComuna().toString().contains(clave))
				||	(this.getNumeroCGP().toString().contains(clave))
				||	(super.serviciosTienenLaClave(clave));
	}
	
	@Override
	public void mostrarInformacion() {
		System.out.println("CGP N°"+this.getNumeroCGP()+", "+this.getNombre());
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
