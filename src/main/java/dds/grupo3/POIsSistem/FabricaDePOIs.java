package dds.grupo3.POIsSistem;

public class FabricaDePOIs {


	private String[] campos;
	private String[] camposPOI;
	
	/* METODOS  */
	
	//"comuna,latitud,longitud,nombre,calle,altura,callesPerpenIzq,callesPerpenDer,barrio,localidad
	//,provincia,pais"
	public void cargarPOI(POI poi,String[] campos){
		poi.setComuna(Integer.parseInt(campos[0]));
		poi.setLatitud(Double.parseDouble(campos[1]));
		poi.setLongitud(Double.parseDouble(campos[2]));
		poi.setNombre(campos[3]);
		poi.setCalle(campos[4]);
		poi.setAltura(Integer.parseInt(campos[5]));
		poi.setCallesPerpenIzq(campos[6]);
		poi.setCallesPerpenDer(campos[7]);
		poi.setBarrio(campos[8]);
		poi.setLocalidad(campos[9]);
		poi.setProvincia(campos[10]);
		poi.setPais(campos[11]);
	}
	
	public void cargarLocal(Local local,String[] campos){
		local.setCodigoPostal(Integer.parseInt(campos[0]));
		local.setDepartamento(Byte.parseByte(campos[1]));
		local.setPiso(Byte.parseByte(campos[2]));
		local.setUnidad(Byte.parseByte(campos[3]));
	}
	
	public POI crearLocal(String campos,String camposPOI){
		camposPOI=camposPOI.trim();
		campos=campos.trim();
		this.campos=campos.split(campos,',');
		this.camposPOI=camposPOI.split(camposPOI,',');
		//campos= "codigoPostal,departamento,piso,unidad,rubro"
		//Faltaria ver rubro
		Local local=new Local(this.camposPOI[3]);
		this.cargarLocal(local, this.campos);
		this.cargarPOI(local,this.camposPOI);
		return local;
	}
	
	public POI crearCGP(String campos,String camposPOI){
		camposPOI=camposPOI.trim();
		campos=campos.trim();
		this.campos=campos.split(campos,',');
		this.camposPOI=camposPOI.split(camposPOI,',');
		//campos= "cp,departamento,piso,unidad,numeroCGP,servicios"
		//Faltaria ver servicios
		CGP cgp=new CGP(this.camposPOI[3],Byte.parseByte(this.campos[4]));
		this.cargarLocal(cgp, this.campos);
		this.cargarPOI(cgp,this.camposPOI);
		return cgp;
	}
	
	public POI crearSucursalDeBanco(String campos,String camposPOI){
		camposPOI=camposPOI.trim();
		campos=campos.trim();
		this.campos=campos.split(campos,',');
		this.camposPOI=camposPOI.split(camposPOI,',');
		//campos= "cp,departamento,piso,unidad,servicios"
		//Faltaria ver servicios
		SucursalBanco banco=new SucursalBanco(this.camposPOI[3]);
		this.cargarLocal(banco, this.campos);
		this.cargarPOI(banco,this.camposPOI);
		return banco;
	}
	
	public POI crearParadaDeColectivo(String campo,String camposPOI){
		camposPOI=camposPOI.trim();
		campo=campo.trim();
		this.camposPOI=camposPOI.split(camposPOI,',');
		//campo= "lineas"
		//Faltaria ver lineas
		ParadaColectivo parada=new ParadaColectivo();
		this.cargarPOI(parada,this.camposPOI);
		return parada;
	}

	
}
