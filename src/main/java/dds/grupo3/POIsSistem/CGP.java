package dds.grupo3.POIsSistem;

import java.util.Calendar;
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
		return "CGP";
	}
	
	@Override
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
	
	// Disponibilidad para CGP
	public Boolean estaDisponible (Calendar horario, String nombreServicio){
		Servicio servicio=getServicios().get(0);
		for(int i=0;!servicio.tieneLaClave(nombreServicio);i++){
			servicio=getServicios().get(i);
		}
		return servicio.atendesEnEsteHorario(horario);
	}
	
	public Boolean estaDisponible (Calendar horario){
		// tiene que mostrar al menos 1 servicio en el CGP que este atendiendo a esa hora
		return this.getServicios().stream().anyMatch(unServicio->unServicio.atendesEnEsteHorario(horario));
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
	public void setServicio(Servicio servicio)
	{
		getServicios().add(servicio);
	}
	public Byte getNumeroCGP() {
		return numeroCGP;
	}
	public void setNumeroCGP(Byte numeroCGP) {
		this.numeroCGP = numeroCGP;
	}
}
