package ddsgrupo3;

import java.util.List;

public class CGP extends Local{
	private Byte numeroCGP;
	
	//----------
	//Constructor
	//----------
	public CGP (String name,Byte numeroCGP)
	{
		super(name);
		this.setNumeroCGP(numeroCGP);
	}
	//----------
	//Metodos
	//----------
		
	public String conocerTipo(){
		return "Centro De Gestion y Participacion";
	}
	
	public Boolean estaCercaDe(Ubicacion posicion){
		return this.getPosicion().mismaComuna(posicion);		
	}

	public	Boolean	tieneLaClave(String clave) {
		return	(super.tieneLaClave(clave))
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

	public Servicio getServicio(Integer n){
		return super.getServicio(n);
	}
	public List<Servicio> getServicios(){
		return super.getServicios();
	}
	public void setServicio(String nameServicio)
	{
		super.setServicio(nameServicio);
	}
	public Byte getNumeroCGP() {
		return numeroCGP;
	}
	public void setNumeroCGP(Byte numeroCGP) {
		this.numeroCGP = numeroCGP;
	}
}
