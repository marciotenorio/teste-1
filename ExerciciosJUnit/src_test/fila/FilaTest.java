package fila;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;


public class FilaTest {
	
	private Fila fila;

	
	@Before
	public void setUp() throws Exception{
		
		fila = new Fila();
	}
		
	@Test
	public void filaEmpty() {
		assertEquals(fila.estaVazia(), true);
	}
	
	@Test
	public void filaEmptyEndPositionHasNegative() {
		assertEquals(fila.getFim(), -1);
	}
	
	@Test
	public void inserir() {
		fila.insereNaFila(1);
		assertEquals(0, 0);
	}

}
