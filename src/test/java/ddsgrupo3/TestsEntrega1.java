package ddsgrupo3;


import java.util.Calendar;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestsEntrega1 {
	//----------
	//Parametros Iniciales
	//----------
	Calendar 		calendario;
	Mapa 			mapa;
	SucursalBanco 	sucursal,		sucursal2;
	Local 			local,			local2;
	ParadaColectivo parada,			parada2;
	CGP 			cgp, 			cgp2, 			cgp3;
	Servicio 		rubroM;
	Integer 		comunaActual;
	Ubicacion 		ubicacionActual;
	Horario 		horario;
	
	@Before
	public void init() {
		mapa		= new Mapa();
		
		sucursal 	= new SucursalBanco("Galicia Espada");
			sucursal.setAltura(500);
			sucursal.setBarrio("Caballito");
			sucursal.setCalle("Espada");
			sucursal.setCallesPerpenDer("Escudo");
			sucursal.setCallesPerpenIzq("Peña");
			sucursal.setCodigoPostal(2524);
			sucursal.setComuna(1);
			sucursal.setLocalidad("Caballito");
			sucursal.setPais("Argentina");
			sucursal.setProvincia("CABA");
			sucursal.setLatitud(1.004);
			sucursal.setLongitud(1.00);
			sucursal.setServicio("Deposito");
			sucursal.setServicio("Extracciones");
			sucursal.setServicio("Prestamos");

		sucursal2 	= new SucursalBanco("Santander Rio");
			sucursal2.setAltura(2500);
			sucursal2.setBarrio("Lugano");
			sucursal2.setCalle("Azcuenaga");
			sucursal2.setCallesPerpenDer("Perito");
			sucursal2.setCallesPerpenIzq("Moreno");
			sucursal2.setCodigoPostal(1818);
			sucursal2.setComuna(8);
			sucursal2.setLocalidad("Lugano");
			sucursal2.setPais("Argentina");
			sucursal2.setProvincia("CABA");
			sucursal2.setLatitud(1.008);
			sucursal2.setLongitud(1.003);
			sucursal2.setServicio("Deposito");
			sucursal2.setServicio("Extracciones");
			sucursal2.setServicio("Prestamos");
		
		local 		= new Local("Lo de Carlos");
			local.setRubro("Muebleria");
			local.getRubro().setRadioCercania(3000);
			local.setAltura(345);
			local.setBarrio("Banfield");
			local.setCalle("Casares");
			local.setCallesPerpenDer("Espegazini");
			local.setCallesPerpenIzq("Pena");
			local.setCodigoPostal(1830);
			local.setLocalidad("Lomas de Zamora");
			local.setPais("Argentina");
			local.setProvincia("Buenos Aires");
			local.getRubro().setRadioCercania(78);
			local.setLatitud(1.0007);
			local.setLongitud(1.00);
			
		local2 		= new Local("Rio");
		
		parada	= new ParadaColectivo();
			parada.setLatitud(1.0008);
			parada.setLongitud(1.00);
			parada.setBarrio("Medrano");
			parada.setCalle("Cordoba");
			parada.setCallesPerpenIzq("Medrano");
			parada.setCallesPerpenDer("Figueroa");
			String[] lista = {"151","106","99"};
			parada.setLineas(lista);
		
		parada2	= new ParadaColectivo();
			parada2.setCalle("Arenal");
			parada2.setCallesPerpenIzq("Freire");
			parada2.setCallesPerpenDer("Conde");
			String[] lista2={"60","120","151"};
			parada2.setLineas(lista2);
		
		cgp	= new CGP("Sede Avellaneda",(byte) 5);
			cgp.setAltura(123);
			cgp.setBarrio("Avellaneda");
			cgp.setCalle("San Martin");
			cgp.setCallesPerpenDer("Salta");
			cgp.setCallesPerpenIzq("Jujuy");
			cgp.setCodigoPostal(1645);
			cgp.setComuna(5);
			cgp.setLocalidad("Avellaneda");
			cgp.setPais("Argentina");
			cgp.setProvincia("Buenos Aires");
			cgp.setServicio("Asesoramiento Contable");
			cgp.setServicio("Otro Servicio");

		cgp2 = new CGP("Sede Caballito",(byte) 6);
			cgp.setAltura(1234);
			cgp.setBarrio("Azul");
			cgp.setCalle("Alemania");
			cgp.setCallesPerpenDer("Espada");
			cgp.setCallesPerpenIzq("Pared");
			cgp.setCodigoPostal(2524);
			cgp.setComuna(1);
			cgp.setLocalidad("Caballito");
			cgp.setPais("Argentina");
			cgp.setProvincia("CABA");
			cgp2.setServicio("Asesoramiento Legal");
		
		cgp3 = new CGP("Sede Microcentro",(byte) 8);
			cgp.setAltura(432);
			cgp.setBarrio("Zamore");
			cgp.setCalle("Cielo");
			cgp.setCallesPerpenDer("España");
			cgp.setCallesPerpenIzq("Boedo");
			cgp.setCodigoPostal(3524);
			cgp.setComuna(4);
			cgp.setLocalidad("Microcentro");
			cgp.setPais("Argentina");
			cgp.setProvincia("CABA");
		
		rubroM = new Servicio("Muebleria");
			rubroM.setRadioCercania(2000);
			
		ubicacionActual = new Ubicacion(1.00, 1.00);
			ubicacionActual.setComuna(comunaActual);
		
		calendario= Calendar.getInstance();
		calendario.set(2016,2,22); //Meses empiezan en 0, por lo que esto es 19/5/2016
		calendario.set(Calendar.HOUR_OF_DAY, 19);
		calendario.set(Calendar.MINUTE, 59);
		horario = new Horario();
		
		mapa.agregarPoi(cgp);
		mapa.agregarPoi(cgp2);
		mapa.agregarPoi(cgp3);
		mapa.agregarPoi(parada);
		mapa.agregarPoi(local);
		mapa.agregarPoi(local2);
		mapa.agregarPoi(sucursal);
		mapa.agregarPoi(sucursal2);
		mapa.agregarPoi(parada2);
		
	}
	
	//-----------------
	//Tests de Cercania
	//-----------------
	
	@Test //Test de cercania con una sucursal. Distancia aproximada 448mts
	public void pruebaCercaniaSucursal() {
		Assert.assertTrue(sucursal.estaCercaDe(ubicacionActual));
	}
	@Test //Test de cercania con una parada de colectivo. Distancia aproximada 88mts
	public void pruebaCercaniaParadaColectivo() {
		Assert.assertTrue(parada.estaCercaDe(ubicacionActual));
	}
	@Test //Test de cercania con CGP
	public void pruebaCercaniaCGP(){	
		Assert.assertTrue(cgp.estaCercaDe(ubicacionActual));
	}
	@Test //Test de cercania con Local. Distancia aproximada 77mts
	public void pruebaCercaniaLocal() {	
		Assert.assertTrue(local.estaCercaDe(ubicacionActual));
	}
	
	//-----------------------
	//Tests de Disponibilidad
	//-----------------------
	@Test //Test de rango de horario
	public void pruebaCalendar() {	
		horario.setDiaInicio(3);
		horario.setDiaFinal(3);
		horario.setHorarioInicio(900);
		horario.setHorarioCierre(2000);
		Assert.assertTrue(horario.estaEnElRango(calendario));
	}
	
	@Test //Test de disponibilidad de la parada de colectivo
	public void pruebaDispColectivo() {	
		Assert.assertTrue(parada.estaDisponible(calendario));
	}
	
	//-----------------
	//Tests de Busqueda
	//-----------------
	
	@Test //Test de Muestra de las paradas de una linea de colectivos
	public void pruebaMuestraParadasDeUnaLinea() {
		mapa.buscarYmostrar("151");
		mapa.buscarYmostrar("106");
		mapa.buscarYmostrar("7");
		System.out.println("");
	}	

	@Test //Test de Muestra de los pois etiquetados con una palabra clave
	public void pruebaMuestraPoisConPalabraClave() {
		mapa.buscarYmostrar("Rio");
		System.out.println("");
	}
	
	@Test //Test de Reconocimiento de un Servicio por su nombre
	public void pruebaReconoceServicio() {
		Assert.assertTrue(rubroM.tieneLaClave("Muebleria"));
	}
	@Test //Test de Reconocimiento de un Local por parte de su nombre
	public void pruebaReconoceParteNombre() {
		Assert.assertTrue(local.tieneLaClave("Carlos"));
	}
	@Test //Test de Reconocimiento de un Local por su Rubro
	public void pruebaReconoceLocalxNombreRubro() {
		Assert.assertTrue(local.tieneLaClave("Muebleria"));
	}
	@Test //Test de Reconocimiento de un Local por su Rubro
	public void pruebaReconoceBancox1Servicio() {		
		Assert.assertTrue(sucursal.tieneLaClave("Prestamo"));
	}
	@Test //Test de Muestra de los CGPs con detereminado servicio
	public void pruebaMuestraCGPconUnServicio() {
		mapa.buscarYmostrar("Asesoramiento");
		System.out.println("");
	}
	@Test //Test de Uso de consola en Mapa
	public void busquedaLibreDePOIs(){
		mapa.realizarBusqueda();
		System.out.println("");
	}	
}
