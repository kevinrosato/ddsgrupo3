package dds.grupo3.POIsSistem;

import javax.persistence.*;
import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;

@SuppressWarnings("serial")
@Entity
@Table(name = "Ubicacion")
public class Ubicacion implements Serializable{
	
	@Id 
	@GeneratedValue(strategy = IDENTITY)
    @Column(name="ubicacion_id")
    private int ubicacion_id;
	@Column(name="latitud")
	private Double latitud;
	@Column(name="longitud")
	private Double longitud;
	@Column(name="comuna")
	private Integer comuna;
	
	//----------
	//Constructor
	//----------
	
	public Ubicacion()
	{
		latitud = 0.0;
		longitud = 0.0;
		this.comuna=0;
	}
	public Ubicacion(Double lat, Double lon)
	{
		latitud = lat;
		longitud = lon;
		comuna=0;
	}
	//----------
	//Metodos
	//----------
	
	public Boolean mismaComuna(Ubicacion comuna2)
	{
		return this.getComuna().equals(comuna2.getComuna());
	}
	
	public Boolean seEncuentraAMenosDe(Ubicacion posicion, Double dist)
	{
		final int R = 6371; // Radio de la tierra
	    Double latDistance = Math.toRadians(posicion.getLatitud() - this.getLatitud());
	    Double lonDistance = Math.toRadians(posicion.getLongitud() - this.getLongitud());
	    
	    Double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
	            + Math.cos(Math.toRadians(this.getLatitud())) * Math.cos(Math.toRadians(this.getLatitud()))
	            * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
	    
	    Double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
	    Double distancia = R * c * 1000; // Convertir a Metros
	    return distancia<dist;
	}	
	public Boolean esValido() {
		return (latitud!=null && longitud!=null);
	}

	//----------------
	//Getters y Setters
	//----------------
	public Integer getComuna() {
		return comuna;
	}
	public void setComuna(Integer comuna) 
	{
		this.comuna = comuna;
	}
	public void setLatitud(Double latitud) {
		this.latitud = latitud;
	}
	public Double getLatitud(){
		return latitud;
	}
	public Double getLongitud() {
		return longitud;
	}
	public void setLongitud(Double longitud) {
		this.longitud = longitud;
	}
}
