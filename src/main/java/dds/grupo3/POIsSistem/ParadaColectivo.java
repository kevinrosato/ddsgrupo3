package dds.grupo3.POIsSistem;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import dds.grupo3.Interfaces.POI;

@Entity
@Table(name="ParadaColectivo")
@PrimaryKeyJoinColumn(name="poi_id")
public class ParadaColectivo extends POI implements Serializable{
	
	@Column(name="lineas")
	private String lineas;

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
		return lineas.contains(clave);
	}	
	@Override
	public List<String> mostrarInformacionAvanzada(){
		List<String> informacion=new ArrayList<String>();
		informacion.add("Lineas de colectivo="+this.lineas);
		return informacion;
	}
	
	public Boolean estaDisponible (Calendar horario){
		return (true);
	}
	//----------
	//Getters y Setters
	//----------

	public String getLineas() {
		return lineas;
	}
	public void setLineas(String lineas) {
		this.lineas=lineas;
	}
}