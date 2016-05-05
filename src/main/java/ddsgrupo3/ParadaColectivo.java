package ddsgrupo3;

public class ParadaColectivo extends POI{
	private String[] lineas;

	//----------
	//Metodos
	//----------
	
	public String conocerTipo(){
		return "Parada De Colectivos";
	}
	public Boolean estaCercaDe(Double latitud, Double longitud){
		return this.seEncuentraAMenosDe(latitud, longitud, 100.00);
	}
	public	Boolean	tieneLaClave(String clave)
	{
		Boolean valorVerdad;
		valorVerdad = super.tieneLaClave(clave);
		valorVerdad = (this.contieneLaLinea(clave)) || valorVerdad;
		return valorVerdad;
	}
	public	Boolean	contieneLaLinea(String clave)
	{
		return this.getLineas().equals(clave);
	}	
	//----------
	//Getters y Setters
	//----------

	public String[] getLineas() {
		return lineas;
	}
	public void setLineas(String[] lineas) {
		this.lineas = lineas;
	}
}