package dds.grupo3.POIsSistem;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import dds.grupo3.Interfaces.POI;
public class ParadaColectivo extends POI{
	private String[] lineas;

	//----------
	//Metodos
	//----------
	
	public String conocerTipo(){
		return "Parada";
	}
	
	public Boolean estaCercaDe(Ubicacion lugar)
	{
		return this.seEncuentraAMenosDe(lugar, 100.00);
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
	public List<String> mostrarInformacionAvanzada(){
		List<String> informacion=new ArrayList<String>();
		String lineas="";
		for(int i=0;i<this.getLineas().length;i++){
			if(lineas!=""){lineas=lineas+"-"+this.getLineas()[i];}
			else{lineas=this.getLineas()[i];}
		}
		informacion.add("Lineas de colectivo="+lineas);
		return informacion;
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