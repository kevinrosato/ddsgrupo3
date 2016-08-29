package dds.grupo3.JSON;

import java.util.Calendar;

import dds.grupo3.Interfaces.POI;
import dds.grupo3.Interfaces.POIGral;
import dds.grupo3.POIsSistem.Servicio;
import dds.grupo3.POIsSistem.Ubicacion;

public class SucursalBancoJSON extends POI implements POIGral { //POI del tipo SucursalBanco generado desde una consulta JSON 
	//----------
	//Parametros
	//----------
	
	private String banco;
	private Double x;
	private Double y;
	private String sucursal;
	private String gerente;
	private String[] servicios;
	//----------------------
	//Metodos de la interfaz
	//----------------------
	@Override
	public Boolean estaDisponible(Calendar horario) {
		Integer diaSolicitado = horario.get(Calendar.DAY_OF_WEEK);
		Integer horaSolicitada= horario.get(Calendar.HOUR_OF_DAY)*100+horario.get(Calendar.MINUTE);
		return((diaSolicitado>=2)&&(diaSolicitado<=6) && horaSolicitada>=1000 && horaSolicitada<=1500);
	}
//	@Override
//	public void mostrarInformacion() {
//		System.out.println(this.getBanco());
//		
//	}
	@Override
	public String conocerTipo() {
		return "Sucursal De Banco";
	}

	@Override
	public String mostrarInformacionAvanzada() {
		String servicios="";
		for(String s:this.getServicios()){
			if(!servicios.equals("")){servicios=servicios+", "+s;}
			else {servicios=s;}
		}
		return " Banco= "+this.getBanco()+" "+ "\n Gerente= "+ this.getGerente()+"\n Sucursal="+this.getSucursal()+"\n Servicios="+servicios;
	}

	@Override
	public Boolean estaCercaDe(Ubicacion ubicacion) {
		return (ubicacion.seEncuentraAMenosDe(ubicacion, 500.00));
	}

	@Override
	public Boolean tieneLaClave(String clave) {
		for (String s: this.getServicios())
		{
			if (s.contains(clave)){
				return true;
			}
		}
		return	(this.getBanco().contains(clave))
				||	(this.getGerente().contains(clave))
				||	(this.conocerTipo().contains(clave));
	}

	@Override
	public Boolean esValido() {
		return (this.banco!="" && this.x!=null && this.y!=null);
	}

	//-----------------
	//Getters y Setters
	//-----------------
	public String getBanco() {
		return banco;
	}
	
	public void setBanco(String banco) {
		this.banco = banco;
	}
	
	public double getX() {
		return x;
	}
	
	public void setX(double x) {
		this.x = x;
	}
	
	public double getY() {
		return y;
	}
	
	public void setY(double y) {
		this.y = y;
	}
	
	public String getSucursal() {
		return sucursal;
	}
	
	public void setSucursal(String sucursal) {
		this.sucursal = sucursal;
	}
	
	public String getGerente() {
		return gerente;
	}
	
	public void setGerente(String gerente) {
		this.gerente = gerente;
	}
	
	public String[] getServicios() {
		return servicios;
	}
	
	public void setServicios(String[] servicios) {
		this.servicios = servicios;
	}
}
