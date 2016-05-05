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
	Double latitudActual, longitudActual;
	Byte comunaActual;
	
	@Before
	public void init(){
		sucursal= new SucursalBanco();
		local= new Local();
		parada= new ParadaColectivo();
		cgp= new CGP();
		latitudActual=1.00;
		longitudActual=1.00;
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
		local.setRubro(new Service());
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
}
