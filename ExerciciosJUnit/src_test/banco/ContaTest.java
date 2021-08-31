package banco;

import static org.junit.Assert.*;

import org.junit.Test;

public class ContaTest{

	@Test
	public void testDebitarSucesso() throws OperacaoIlegalException{
		Conta c = new Conta("123", 20);
		c.debitar(10);
		assertEquals(10,c.getSaldo(),10.0);
	} 

	@Test
	public void deveNaoDebitarNada() throws OperacaoIlegalException {
		Conta conta = new Conta("001", 20);
		conta.debitar(-1d);
		assertEquals(20, conta.getSaldo(), 0);
	}
	
	@Test(expected = OperacaoIlegalException.class)
	public void transferirWithoutFunds() throws OperacaoIlegalException {
		Conta c1 = new Conta("1", 100f);
		Conta c2 = new Conta("2", 0f);
		c1.transferir(c2, 200);
	}
	
	@Test
	public void transferirHappyPath() throws OperacaoIlegalException {
		Conta c1 = new Conta("1", 100f);
		Conta c2 = new Conta("2", 0);
		c1.transferir(c2, 100f);
	}
	
	@Test(expected = OperacaoIlegalException.class)
	public void transferirNegativeNumbers() throws OperacaoIlegalException {
		Conta c1 = new Conta("1", 100f);
		Conta c2 = new Conta("2", 0f);
		c1.transferir(c2, -1f);
	}
	
}
