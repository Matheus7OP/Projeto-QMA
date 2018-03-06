package testes;

import static org.junit.Assert.*;

import org.junit.*;

import qma.AjudaOnline;

public class AjudaOnlineTest {
	private AjudaOnline ajudaOnline;
	
	@Before
	public void inicializar() {
		this.ajudaOnline = new AjudaOnline("123456","654321", "AA");
	}
	
	@Test
	public void getInfoAjudaTest() {
		assertEquals( this.ajudaOnline.getInfoAjuda("disciplina"), "AA" );
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void getInfoAjudaIllegalArgTest() {
		this.ajudaOnline.getInfoAjuda("nomeAluno");
	}
}
