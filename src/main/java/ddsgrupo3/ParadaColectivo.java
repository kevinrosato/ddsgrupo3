package ddsgrupo3;

import java.util.Calendar;
public class ParadaColectivo extends POI{
	private String[] lineas;

	//----------
	//Metodos
	//----------
	
	public String conocerTipo(){
		return "Parada De Colectivos";
	}
	
	public Boolean estaCercaDe(Ubicacion lugar)
	{
		return this.seEncuentraAMenosDe(lugar, 100);
	}
	
	@Override
	public	Boolean	tieneLaClave(String clave){
		return	(super.tieneLaClave(clave))
				||	(this.contieneLaLinea(clave));
	}
	
	public	Boolean	contieneLaLinea(String clave){
		Boolean valorDeVerdad=false;
		for(int i=0; i<lineas.length; i++){
			if(lineas[i].equals(clave)){
				valorDeVerdad=true;
			}
		}
		return valorDeVerdad;
	}	
	
	@Override
	public void mostrarInformacion(){
		System.out.println("Parada en la calle "+super.getCalle()+", entre las calles "+super.getCallesPerpenDer()+" y "+super.getCallesPerpenIzq());
	}
	
	public Boolean estaDisponible (Calendar horario){
		return (true);
	}
	//----------
	//Getters y Setters
	//----------

	public String[] getLineas() {
		return lineas;
	}
	public void setLineas(String[] lineas) {
		this.lineas=lineas;
	}
}