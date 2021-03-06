package dds.grupo3.POIsSistem;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import dds.grupo3.Interfaces.POI;

@SuppressWarnings("serial")
@Entity
@Table(name="ParadaColectivo")
@PrimaryKeyJoinColumn(name="poi_id")
public class ParadaColectivo extends POI implements Serializable{
	
	@Column(name="lineas")
	private String lineas;

	//----------
	//Metodos
	//----------
	
	public List<String> mostrarNombresCampos(){
		List<String> lista=new ArrayList<String>();
		lista.addAll(super.mostrarNombresCampos());
		lista.add("Lineas:");
		return lista;
	}
	public String[] mostrarContenidosCampos(){
		String[] lista=new String[13];
		for(int i=0; i<super.mostrarContenidosCampos().length;i++){
			lista[i]=super.mostrarContenidosCampos()[i];
		}
		lista[12]=this.getLineas();
		return lista;
	}
	public void settearCampos(String[] campos){
		super.settearCampos(campos);
		if(campos[12].length()!=0){this.setLineas(campos[12]);}
	}
	
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