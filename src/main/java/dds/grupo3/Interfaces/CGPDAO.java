package dds.grupo3.Interfaces;

import java.util.List;
import dds.grupo3.DTOs.CentroDTO;

public interface CGPDAO {
	public	List<POIGral>	getByKey(String clave);	
	public	List<POIGral>	getAll();	
	public List<CentroDTO>	getCentros();
	public void setCentros(List<CentroDTO> Centros);
}
