package ddsgrupo3;

public class CGP extends Local{
	//private Servicio[] servicios;
	private Byte numeroCGP;
	
	//----------
	//Metodos
	//----------
		
	public String conocerTipo(){
		return "Centro De Gestión y Participación";
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
	
}
