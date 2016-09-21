package dds.grupo3.Control;

public class OpcionDelMenu {

	private String archivo;
	private String titulo;
	
	public OpcionDelMenu(String archivo,String titulo){
		this.archivo=archivo;
		this.titulo=titulo;
	}

	public String getArchivo() {
		return archivo;
	}

	public void setArchivo(String archivo) {
		this.archivo = archivo;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
}
