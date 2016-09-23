package dds.grupo3.JSON;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import dds.grupo3.Interfaces.POI;
import dds.grupo3.Interfaces.POIGral;
import dds.grupo3.POIsSistem.Ubicacion;

public class SucursalBancoJSON  implements POIGral { //POI del tipo SucursalBanco generado desde una consulta JSON 
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
	public List<String> mostrarInformacionAvanzada() {
		List<String> informacion=new ArrayList<String>();
		informacion.add("Banco="+this.getBanco());
		informacion.add("Gerente="+ this.getGerente());
		informacion.add("Sucursal="+this.getSucursal());
		String servicios="";
		for(int i=0;i<this.getServicios().length;i++){
			if(!servicios.equals("")){servicios=servicios+", "+this.getServicios()[i];}
			else {servicios=this.getServicios()[i];}
		}
		informacion.add("Servicios="+servicios);
		return informacion;
	}
	
	@Override
	public String[] mostrarInformacion(){
		String[] info=new String[2];
		info[0]=banco;
		info[1]=sucursal;
		return info;
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
	@Override
	public String getImagen() {
		// TODO Auto-generated method stub
		return null;
	}
}
