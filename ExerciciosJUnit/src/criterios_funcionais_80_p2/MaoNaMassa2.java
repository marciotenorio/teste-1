package criterios_funcionais_80_p2;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import param.CalculoImpostoRenda;

@RunWith(Parameterized.class)
public class MaoNaMassa2 {
	
	/**
	 * a) Defina casos de testes baseado no critério Análise do Valor Limite para 
	 * o método calculaImposto da classe param.CalculoImpostoRenda do projeto da disciplina.
	 * 
	 * Teremos nosso delta de +1 e -1. Assim pegamos um valor limite, 
	 * e aplicamos o delta somando e diminuindo, então teremos os casos:
	 * valor = {0, 1, -1}
	 * valor = {1201, 1200, 1202, 5000, 5001, 4999}
	 * valor = {5001, 5000, 5002, 10000, 9999, 10001}
	 * 
	 * Aplicando o conceito de completude e disjunção, restam:
	 * valor = {-1, 0, 1201, 5001, 10001}
	 * 
	 * Crie uma classe de testes parametrizados para estes casos 
	 * de teste que atendem ao critério.
	 * 
	 */
	
	private CalculoImpostoRenda calculoImpostoRenda;
	
	@Before
	public void setUp() {
		calculoImpostoRenda = new CalculoImpostoRenda();
	}
	
	@Parameter(0)
	public Double valor;
	
	@Parameter(1)
	public Double saida;
	
	@Parameters
	public static Double[][] entry() {
		return new Double[][] {
			{-1d, 0d}, 
			{0d, 0d},
			{1201d, 120.1d}, 
			{5001d, 750.15d},
			{10001d, 2000.2d}
		};
	}
	
	@Test
	public void calculaImpostoAnaliseValorLimite() {
		assertEquals(calculoImpostoRenda.calculaPorcentagem(valor), saida, 0);
	}
	
}
