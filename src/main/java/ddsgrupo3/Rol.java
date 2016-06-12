package ddsgrupo3;


public class Rol{


	private Funcionalidad func1;
	
	//0:Agregar 1:Borrar 2:Modificar 3:Consultar
	public void realizarFuncPoi(int num,Mapa mapa,POI poi){
		switch(num){
		case 0:
			func1=new AgregarPOI();
			break;
		case 1:
			func1=new BorrarPOI();
			break;
		case 2:
			func1=new ModificarPOI();
			break;	
		case 3:
			func1=new ConsultarPOI();
			break;		
		}	
		func1.realizarFuncionConPOI(mapa, poi);
	}

	
}
