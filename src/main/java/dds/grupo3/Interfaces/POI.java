package dds.grupo3.Interfaces;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import javax.persistence.*;

//import dds.grupo3.DTOs.ResultadoBusquedaDTO;
import dds.grupo3.POIsSistem.Ubicacion;

@SuppressWarnings("serial")
@Entity
@Table(name = "POI")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class POI implements POIGral, Serializable {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "poi_id")
	private int poi_id;

	@OneToOne(cascade = CascadeType.ALL)
	@PrimaryKeyJoinColumn
	private Ubicacion ubicacion;

	@Column(name = "nombre")
	private String nombre;
	@Column(name = "barrio")
	private String barrio;
	@Column(name = "calle")
	private String calle;
	@Column(name = "altura")
	private Integer altura;
	@Column(name = "callesPerpenIzq")
	private String callesPerpenIzq;
	@Column(name = "callesPerpenDer")
	private String callesPerpenDer;
	@Column(name = "localidad")
	private String localidad;
	@Column(name = "provincia")
	private String provincia;
	@Column(name = "pais")
	private String pais;
	@Column(name = "imagen")
	private String imagen;

	// ----------
	// Constructor
	// ----------

	public POI() {
		super();
		this.poi_id = 0;
		this.ubicacion = new Ubicacion();
		this.nombre = "";
		this.barrio = "";
		this.calle = "";
		this.callesPerpenIzq = "";
		this.callesPerpenDer = "";
		this.localidad = "";
		this.provincia = "";
		this.pais = "";
		this.altura = 0;
		this.imagen = "";
	}

	// ----------
	// Metodos
	// ----------

	public Boolean tieneLaClave(String clave) {
		return (this.getNombre().contains(clave)) || (this.getBarrio().contains(clave))
				|| (this.getCalle().contains(clave)) || (this.getLocalidad().contains(clave))
				|| (this.getCallesPerpenIzq().contains(clave)) || (this.getCallesPerpenDer().contains(clave))
				|| (this.getProvincia().contains(clave)) || (this.getPais().contains(clave))
				|| (this.conocerTipo().contains(clave));
	}

	public Boolean esValido() {
		return (nombre != "" && ubicacion.esValido());
	}

	public Boolean estaCercaDe(Ubicacion posicion) {
		return (this.seEncuentraAMenosDe(posicion, 500.00));
	}

	public Boolean estaCercaDePorDefecto(Ubicacion posicion) {
		return (this.seEncuentraAMenosDe(posicion, 500.00));
	}

	public abstract Boolean estaDisponible(Calendar horario);

	public Boolean seEncuentraAMenosDe(Ubicacion posicion, Double dist) {
		return this.ubicacion.seEncuentraAMenosDe(posicion, dist);
	}

	public abstract List<String> mostrarInformacionAvanzada();

	public String[] mostrarInformacion() {
		String[] informacion = new String[2];
		informacion[0] = nombre;
		informacion[1] = calle + " " + altura;
		return informacion;
	};

	public abstract String conocerTipo();

	public List<String> mostrarNombresCampos() {
		List<String> lista = new ArrayList<String>();
		lista.add("Latitud:");
		lista.add("Longitud:");
		lista.add("Comuna:");
		lista.add("Nombre:");
		lista.add("Barrio:");
		lista.add("Calle:");
		lista.add("Altura:");
		lista.add("Calle perpendicular izquierda:");
		lista.add("Calle perpendicular derecha:");
		lista.add("Localidad:");
		lista.add("Provincia:");
		lista.add("Pais:");
		return lista;
	}

	public String[] mostrarContenidosCampos() {
		String[] lista = new String[12];
		lista[0]=Double.toString(this.getLatitud());
		lista[1]=Double.toString(this.getLongitud());
		lista[2]=Integer.toString(this.getComuna());
		lista[3]=this.getNombre();
		lista[4]=this.getBarrio();
		lista[5]=this.getCalle();
		lista[6]=Integer.toString(this.getAltura());
		lista[7]=this.getCallesPerpenIzq();
		lista[8]=this.getCallesPerpenIzq();
		lista[9]=this.getLocalidad();
		lista[10]=this.getProvincia();
		lista[11]=this.getPais();
		return lista;
	}
	public void settearCampos(String[] campos) {
		if (!campos[0].isEmpty()) {
			this.setLatitud(Double.parseDouble(campos[0]));
		}
		if (!campos[1].isEmpty()) {
			this.setLongitud(Double.parseDouble(campos[1]));
		}
		if (!campos[2].isEmpty()) {
			this.setComuna(Integer.parseInt(campos[2]));
		}
		if (campos[3].length()!=0) {
			this.setNombre(campos[3]);
		}
		if (campos[4].length()!=0) {
			this.setBarrio(campos[4]);
		}
		if (campos[5].length()!=0) {
			this.setCalle(campos[5]);
		}
		if (campos[6].length()!=0) {
			this.setAltura(Integer.parseInt(campos[6]));
		}
		if (campos[7].length()!=0) {
			this.setCallesPerpenIzq(campos[7]);
		}
		if (campos[8].length()!=0) {
			this.setCallesPerpenDer(campos[8]);
		}
		if (campos[9].length()!=0) {
			this.setLocalidad(campos[9]);
		}
		if (campos[10].length()!=0) {
			this.setProvincia(campos[10]);
		}
		if (campos[11].length()!=0) {
			this.setPais(campos[11]);
		}
	}

	// ----------------
	// Getters y Setters
	// ----------------

	public Ubicacion getPosicion() {
		return this.ubicacion;
	}

	public void setComuna(Integer comuna) {
		this.ubicacion.setComuna(comuna);
	}
	
	public Integer getComuna() {
		return this.ubicacion.getComuna();
	}

	public Double getLongitud() {
		return this.ubicacion.getLongitud();
	}

	public void setLongitud(Double longitud) {
		this.ubicacion.setLongitud(longitud);
	}

	public Double getLatitud() {
		return this.ubicacion.getLatitud();
	}

	public void setLatitud(Double latitud) {
		this.ubicacion.setLatitud(latitud);
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getBarrio() {
		return barrio;
	}

	public void setBarrio(String barrio) {
		this.barrio = barrio;
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public String getLocalidad() {
		return localidad;
	}

	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}

	public Integer getAltura() {
		return altura;
	}

	public void setAltura(Integer altura) {
		this.altura = altura;
	}

	public String getCallesPerpenIzq() {
		return callesPerpenIzq;
	}

	public String getCallesPerpenDer() {
		return callesPerpenDer;
	}

	public void setCallesPerpenIzq(String callesPerpenIzq) {
		this.callesPerpenIzq = callesPerpenIzq;
	}

	public void setCallesPerpenDer(String callesPerpenDer) {
		this.callesPerpenDer = callesPerpenDer;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public String getImagen() {
		return imagen;
	}

	public int getPoi_id() {
		return poi_id;
	}

	public void setPoi_id(int id) {
		this.poi_id = id;
	}

	public String get_id_vista() {
		return Integer.toString(this.getPoi_id());
	}
}