package ddsgrupo3;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestsEntrega0B {
	//----------
	//Parametros Iniciales
	//----------
	ParadaColectivo parada, poi, poi2;
	Local local;
	CGP cgp;
	SucursalBanco sucursal;
	@Before
	public void init(){
		poi = new ParadaColectivo();
		poi.setLatitud(40.12);
		poi.setLongitud(42.13);
		poi.setNombre("POI de prueba");
		poi.setCalle("Avenida Rivadavia");
		poi.setAltura(1456);
		poi2= new ParadaColectivo();
		poi2.setLatitud(40.9);
		poi2.setLongitud(42.12);
		parada= new ParadaColectivo();
		local= new Local();
		cgp = new CGP("");
		sucursal= new SucursalBanco ("");
		parada = new ParadaColectivo();
	}
	
	
	//----------------
	//Tests de Getters
	//----------------
	@Test //Test de latitud
	public void tieneLatitud() {
		Assert.assertEquals(40.12,poi.getLatitud(),0);
	}
	@Test //Test de longitud
	public void tieneLongitud() {
		Assert.assertEquals(42.13,poi.getLongitud(),0);
	}
	@Test //Test de nombre
	public void pruebaNombre() {
		Assert.assertEquals("POI de prueba",poi.getNombre());
	} 
	@Test //Test de calle
	public void pruebaCalle() {
		Assert.assertEquals("Avenida Rivadavia",poi.getCalle());
	}
	@Test //Test de altura
	public void pruebaAltura() {
		Assert.assertEquals(1456,poi.getAltura(),0);
	}
	
	//----------------
	//Tests de Metodos
	//----------------
	@Test //Test de validez
	public void pruebaValidez() {
		Assert.assertTrue(poi.esValido());
	}
	@Test //Test de un POI invalido
	public void pruebaValidez2() {
		Assert.assertFalse(poi2.esValido());
	}
	@Test //Test de distancia entre dos POIs los puntos probados 
		  //Los puntos deben encontrarse en 87km. Como calculamos en metros, 87000mts,
	public void pruebaDistancia() {
		Assert.assertTrue(poi.seEncuentraAMenosDe(poi2.getLatitud(),poi2.getLongitud(),87000.00));
	}
	@Test //Test de tipo de una parada de colectivos
	public void probarTipoColectivo(){
		Assert.assertEquals("Parada De Colectivos",parada.conocerTipo());
	}
	@Test //Test de tipo de un CGP
	public void probarTipoCGP(){
		Assert.assertEquals("Centro De Gestion y Participacion",cgp.conocerTipo());
	}
	@Test //Test de tipo de una sucursal
	public void probarTipoSucursal(){
		Assert.assertEquals("Sucursal De Banco",sucursal.conocerTipo());
	}
	@Test //Test de tipo de un local comercial
	public void probarTipoLocal(){
		Assert.assertEquals("Local Comercial",local.conocerTipo());
	}
	
}
