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
	Local 			local,			local2,carrousel;
	ParadaColectivo parada,			parada2;
	CGP 			cgp, 			cgp2, 			cgp3;
	Servicio 		rubroM,servicio1,servicio2,servicio3,comercial;
	Integer 		comunaActual;
	Ubicacion 		ubicacionActual;
	Horario 		horario,horario1,horario2,horario3,horario4,horario5;
	
	@Before
	public void init() {
		mapa		= new Mapa();
		sucursal 	= new SucursalBanco("Galicia Microcentro");
		servicio3= new Servicio("Transferencia");
		//horario bancario
		horario3=new Horario(); horario3.setDiaInicio(2);horario3.setDiaFinal(6);
		horario3.setHorarioInicio(1000);horario3.setHorarioCierre(1500);
		List<Horario> lista5=new ArrayList<Horario>();
		lista5.add(horario3);
		servicio3.setHorario(lista5);
		sucursal.setServicio(servicio3);
		
		sucursal2 	= new SucursalBanco("Santander Rio");
		local 		= new Local("Lo de Carlos");
		local2 		= new Local("Rio");
		
		carrousel=new Local("Carrousel");
		comercial=new Servicio("comercial");
		carrousel.setRubro(comercial);
		horario4=new Horario(); horario4.setDiaInicio(2);horario4.setDiaFinal(7);
		horario4.setHorarioInicio(1000);horario4.setHorarioCierre(1300);
		horario5=new Horario(); horario5.setDiaInicio(2);horario5.setDiaFinal(7);
		horario5.setHorarioInicio(1700);horario5.setHorarioCierre(2030);
		List<Horario> lista6=new ArrayList<Horario>();
		lista6.add(horario4);
		lista6.add(horario5);
		comercial.setHorario(lista6);
		
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
		horario2=new Horario(); horario2.setDiaInicio(7);horario2.setDiaFinal(7);
		horario2.setHorarioInicio(1100);horario2.setHorarioCierre(1200);
		List<Horario> lista3=new ArrayList<Horario>();
		lista3.add(horario2);
		servicio1.setHorario(lista3);
		
		servicio2=new Servicio("Rentas");
		horario1=new Horario(); horario1.setDiaInicio(2);horario1.setDiaFinal(6);
		horario1.setHorarioInicio(1000);horario1.setHorarioCierre(1500);
		List<Horario> lista4=new ArrayList<Horario>();
		lista4.add(horario1);
		servicio2.setHorario(lista4);
			
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
		calendario.set(2016,5,19); 
		calendario.set(Calendar.DAY_OF_WEEK, 3);
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
		local.setRubro(new Servicio(""));
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
	
	@Test //Test de disponibilidad de CGP con Nombre de Servicio
	public void pruebaDispCGP() {	
		Assert.assertFalse(cgp.estaDisponible(calendario,"Rentas"));
		calendario.set(Calendar.DAY_OF_WEEK, 3);
		calendario.set(Calendar.HOUR_OF_DAY, 11);
		calendario.set(Calendar.MINUTE, 59);
		Assert.assertTrue(cgp.estaDisponible(calendario,"Rentas"));
	}
	
	@Test //Test de disponibilidad de CGP sin Nombre de Servicio
	public void pruebaDispCGP2() {	
		calendario.set(Calendar.DAY_OF_WEEK, 7);
		calendario.set(Calendar.HOUR_OF_DAY, 11);
		calendario.set(Calendar.MINUTE, 20);
		Assert.assertTrue(cgp.estaDisponible(calendario));
	}
	
	@Test //Test de disponibilidad de Banco
	public void pruebaBanco() {	
		Assert.assertFalse(sucursal.estaDisponible(calendario));
		calendario.set(Calendar.DAY_OF_WEEK, 2);
		calendario.set(Calendar.HOUR_OF_DAY, 10);
		calendario.set(Calendar.MINUTE, 20);
		Assert.assertTrue(sucursal.estaDisponible(calendario));
	}
	
	@Test //Test de disponibilidad de Local
	public void pruebaLocal() {	
		calendario.set(Calendar.DAY_OF_WEEK, 2);
		calendario.set(Calendar.HOUR_OF_DAY, 10);
		calendario.set(Calendar.MINUTE, 20);
		Assert.assertTrue(carrousel.estaDisponible(calendario));
		calendario.set(Calendar.DAY_OF_WEEK, 3);
		calendario.set(Calendar.HOUR_OF_DAY, 15);
		calendario.set(Calendar.MINUTE, 00);
		Assert.assertFalse(carrousel.estaDisponible(calendario));
		
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
		local.setRubro(new Servicio("Muebleria"));
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
