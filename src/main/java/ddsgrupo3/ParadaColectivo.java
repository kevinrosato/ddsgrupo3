package ddsgrupo3;

public class ParadaColectivo implements TipoDePoi{
	private String[] lineas;

	//----------
	//Metodos
	//----------
	
	public String conocerTipo(){
		
		return "Parada De Colectivos";
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
