package criterios_funcionais_80_p2;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import param.CalculoImpostoRenda;

public class MaoNaMassa1 {
	
	/**
	 * a) Defina as classes de equivalência para o método calculaImposto da classe
	 *	param.CalculoImpostoRenda do projeto da disciplina.
	 * 
	 * Teremos quatro classes de equivalência sendo elas:
	 * 1. Imposto de 0.1
	 * 2. Imposto 0.15 
	 * 3. Imposto de 0.2
	 * 4. Sem imposto
	 * 
	 * b) A partir das classes de equivalência selecione 
	 * casos de testes de forma a “cobrir” as classes.
	 * 
	 * Casos de teste para cobrir as classes de equivalência:
	 * 1. Imposto 0.1 => {valor=1201 que implica em 120.1 de imposto}
	 * 2. Imposto 0.15 => {valor=5010 que implica em 751.5 de imposto}
	 * 3. Imposto 0.2 => {valor=10001 que implica em 2000.2 de imposto}
	 * 4. Sem imposto => {valor=0 que implica em 0 de imposto
	 * 	'				  valor=-1 que implica em 0 de imposto}
	 * 
	 * c) Agora construa testes JUnit para exercitar estas entradas:
	 */
	
	private CalculoImpostoRenda calculoImpostoRenda;
	
	
	@Before
	public void setUp() {
		calculoImpostoRenda = new CalculoImpostoRenda();
	}
	
	@Test
	public void deveTerImpostoDe10Reais() {
		assertEquals(120.1, calculoImpostoRenda.calculaPorcentagem(1201), 0);
	}
	
	@Test
	public void deveTerImpostoDe015Reais() {
		assertEquals(751.5, calculoImpostoRenda.calculaPorcentagem(5010), 0);
	}
	
	@Test
	public void deveTerImpostoDe02Reais() {
		assertEquals(2000.2, calculoImpostoRenda.calculaPorcentagem(10001), 0);
	}

	@Test
	public void deveTerImpostoDe0Reais() {
		assertEquals(0, calculoImpostoRenda.calculaPorcentagem(0), 0);
	}
	
	@Test
	public void deveTerImpostoDe0ReaisComValorNegativo() {
		assertEquals(0, calculoImpostoRenda.calculaPorcentagem(-1), 0);
	}
	
	

}
