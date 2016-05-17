package ddsgrupo3;


import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

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
	Servicio 		rubroM,servicio1,servicio2,servicio3;
	Integer 		comunaActual;
	Ubicacion 		ubicacionActual;
	Horario 		horario,horario1,horario2;
	
	@Before
	public void init() {
		mapa		= new Mapa();
		sucursal 	= new SucursalBanco("Galicia Microcentro");
		sucursal2 	= new SucursalBanco("Santander Rio");
		local 		= new Local("Lo de Carlos");
		local2 		= new Local("Rio");
		
		
		parada	= new ParadaColectivo();
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
		
		cgp	= new CGP("Sede Medrano",(byte) 5);
		
		servicio1=new Servicio("Asesoramiento Contable");
		servicio2=new Servicio("Rentas");
		horario1=new Horario(); horario1.setDiaInicio(2);horario1.setDiaFinal(6);
		horario1.setHorarioInicio(10);horario1.setHorarioCierre(15);
		List<Horario> lista3=new ArrayList<Horario>();
		lista3.add(horario1);
		servicio2.setHorario(lista3);
			
			cgp.setServicio(servicio1);
			cgp.setServicio(servicio2);
			cgp.setComuna(5);

		cgp2 = new CGP("Sede Caballito",(byte) 6);
		servicio3=new Servicio("Asesoramiento Legal");
			cgp2.setServicio(servicio3);
		
		cgp3 = new CGP("Sede Lugano",(byte) 8);
		
		rubroM = new Servicio("Muebleria");
		rubroM.setRadioCercania(100.0);
		
		ubicacionActual = new Ubicacion(1.00, 1.00);
			ubicacionActual.setComuna(5);
		
		calendario= Calendar.getInstance();
		calendario.set(2016,2,22); //Meses empiezan en 0, por lo que esto es 19/5/2016
		calendario.set(Calendar.HOUR_OF_DAY, 19);
		calendario.set(Calendar.MINUTE, 59);
		horario = new Horario();
	}
	
	//-----------------
	//Tests de Cercania
	//-----------------
	
	@Test //Test de cercania con una sucursal. Distancia aproximada 448mts
	public void pruebaCercaniaSucursal() {
		sucursal.setLatitud(1.00);
		sucursal.setLongitud(1.00);
		Assert.assertTrue(sucursal.estaCercaDe(ubicacionActual));
	}
	@Test //Test de cercania con una parada de colectivo. Distancia aproximada 88mts
	public void pruebaCercaniaParadaColectivo() {
		parada.setLatitud(1.0008);
		parada.setLongitud(1.00);
		Assert.assertTrue(parada.estaCercaDe(ubicacionActual));
	}
	@Test //Test de cercania con CGP
	public void pruebaCercaniaCGP(){	
		Assert.assertTrue(cgp.estaCercaDe(ubicacionActual));
	}
	@Test //Test de cercania con Local. Distancia aproximada 77mts
	public void pruebaCercaniaLocal() {	
		local.setRubro("");
		local.getRubro().setRadioCercania(78.00);
		local.setLatitud(1.0007);
		local.setLongitud(1.00);
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
	
	@Test //Test de disponibilidad de CGP
	public void pruebaDispCGP() {	
		Assert.assertFalse(cgp.estaDisponible(calendario,"Asesoramiento Contable"));
	}
	
	
	//-----------------
	//Tests de Busqueda
	//-----------------
	
	//Falta Assert para los tests involucrando mapa?
	
	@Test //Test de Muestra de las paradas de una linea de colectivos
	public void pruebaMuestraParadasDeUnaLinea() {
		mapa.agregarPoi(parada);
		mapa.agregarPoi(parada2);
		mapa.mostrarPOIS("151");
		mapa.mostrarPOIS("106");
		mapa.mostrarPOIS("7");
		System.out.println("");
	}	

	@Test //Test de Muestra de los pois etiquetados con una palabra clave
	public void pruebaMuestraPoisConPalabraClave() {
		mapa.agregarPoi(parada);
		mapa.agregarPoi(local);
		mapa.agregarPoi(local2);
		mapa.agregarPoi(sucursal);
		mapa.agregarPoi(sucursal2);
		mapa.mostrarPOIS("Rio");
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
		local.setRubro("Muebleria");
		Assert.assertTrue(local.tieneLaClave("Muebleria"));
	}
	@Test //Test de Reconocimiento de un Local por su Rubro
	public void pruebaReconoceBancox1Servicio() {
		sucursal.setServicio(new Servicio("Deposito"));
		sucursal.setServicio(new Servicio("Extracciones"));
		sucursal.setServicio(new Servicio("Prestamos"));
		
		Assert.assertTrue(sucursal.tieneLaClave("Prestamo"));
	}
	@Test //Test de Muestra de los CGPs con detereminado servicio
	public void pruebaMuestraCGPconUnServicio() {
		mapa.agregarPoi(cgp);
		mapa.agregarPoi(cgp2);
		mapa.agregarPoi(cgp3);
		mapa.mostrarPOIS("Asesoramiento");
		System.out.println("");
	}

}
