package dds.grupo3.Control;

public class InformacionPoi {

	private String campo;
	private String informacion;
	
	public InformacionPoi(String campo,String informacion){
		this.campo=campo;
		this.informacion=informacion;
	}
	
	public String getCampo() {
		return campo;
	}
	public void setCampo(String campo) {
		this.campo = campo;
	}
	public String getInformacion() {
		return informacion;
	}
	public void setInformacion(String informacion) {
		this.informacion = informacion;
	}
	
}
