package ddsgrupo3;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestsEntrega1 {
	//----------
	//Parametros Iniciales
	//----------
	SucursalBanco sucursal;
	Local local;
	ParadaColectivo parada;
	CGP cgp;
	Servicio rubroM, servicio1, servicio2, servicio3;
	Double latitudActual, longitudActual;
	Byte comunaActual;
	
	@Before
	public void init()
	{
		sucursal = new SucursalBanco("Galicia Microcentro");
		local = new Local();
		local.setNombre("Lo de Carlos");
		parada = new ParadaColectivo();
		cgp = new CGP("Cede Medrano");
		rubroM = new Servicio("Muebleria");
		servicio1 = new Servicio("Deposito");
		servicio2 = new Servicio("Extracciones");
		servicio3 = new Servicio("Prestamos");
		latitudActual = 1.00;
		longitudActual = 1.00;
	}
	
	//-----------------
	//Tests de Cercania
	//-----------------
	
	@Test //Test de cercania con una sucursal. Distancia aproximada 448mts
	public void pruebaCercaniaSucursal() {
		sucursal.setLatitud(1.004);
		sucursal.setLongitud(1.00);
		Assert.assertTrue(sucursal.estaCercaDe(latitudActual, longitudActual));
	}
	@Test //Test de cercania con una parada de colectivo. Distancia aproximada 88mts
	public void pruebaCercaniaParadaColectivo() {
		parada.setLatitud(1.0008);
		parada.setLongitud(1.00);
		Assert.assertTrue(parada.estaCercaDe(latitudActual, longitudActual));
	}
	@Test //Test de cercania con CGP
	public void pruebaCercaniaCGP() {	
		comunaActual = 2;
		cgp.setComuna((byte)2);
		Assert.assertTrue(cgp.estaCercaDe(comunaActual));
	}
	@Test //Test de cercania con Local. Distancia aproximada 77mts
	public void pruebaCercaniaLocal() {	
		local.setRubro(new Servicio(""));
		local.getRubro().setRadioCercania(78.00);
		local.setLatitud(1.0007);
		local.setLongitud(1.00);
		Assert.assertTrue(local.estaCercaDe(latitudActual, longitudActual));
	}
	//-----------------------
	//Tests de Disponibilidad
	//-----------------------
	
	//-----------------
	//Tests de Busqueda
	//-----------------
@Test //Test de Reconocimiento de un Servicio por su nombre
	public void pruebaReconoceServicio()
	{
		Assert.assertTrue(rubroM.tieneLaClave("Muebleria"));
	}
@Test //Test de Reconocimiento de un Local por parte de su nombre
	public void pruebaReconoceParteNombre()
	{
		Assert.assertTrue(local.tieneLaClave("Carlos"));
	}
@Test //Test de Reconocimiento de un Local por su Rubro
	public void pruebaReconoceLocalxNombreRubro()
	{
		local.setRubro(rubroM);
		Assert.assertTrue(local.tieneLaClave("Muebleria"));
	}
@Test //Test de Reconocimiento de un Local por su Rubro
	public void pruebaReconoceBancox1Servicio()
	{
		sucursal.setServicio(servicio1);
		sucursal.setServicio(servicio2);
		sucursal.setServicio(servicio3);
		Assert.assertTrue(sucursal.tieneLaClave("Prestamo"));
	}



}
