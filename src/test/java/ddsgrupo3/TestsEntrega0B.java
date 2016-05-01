package ddsgrupo3;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestsEntrega0B {
	POI poi;
	ParadaColectivo parada;
	List<TipoDePoi> pois;
	
	@Before
	public void init(){
		poi = new POI();
		poi.setLatitud(150.2);
		parada = new ParadaColectivo();
		pois = new ArrayList<TipoDePoi>();
		pois.add(parada);
	}
	
	
	@Test
	public void tieneLatitud() {
		Assert.assertEquals(140.2,poi.getLatitud(),0);
	}
	 
	@Test
	public void probarTipo(){
		poi.setPois(pois);
		
		Assert.assertEquals("Parada De Colectivos",poi.pois.get(0).conocerTipo());
	}
	
}
