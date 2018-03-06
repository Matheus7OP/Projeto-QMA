package testes;

import static org.junit.Assert.*;

import org.junit.*;

import qma.Caixa;

public class CaixaTest {
	private Caixa caixa;
	
	@Before
	public void inicializar() {
		this.caixa = new Caixa();
	}
	
	@Test
	public void adicionarDinheiroTest() {
		assertTrue( this.caixa.getDinheiro() == 0 );
		this.caixa.adicionarDinheiro(12345);
		assertTrue( this.caixa.getDinheiro() == 12345 );
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void adicionarDinheiroErrorTest() {
		this.caixa.adicionarDinheiro(-9434235);
	}
}
