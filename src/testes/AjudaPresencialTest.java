package testes;

import static org.junit.Assert.assertEquals;

import org.junit.*;

import qma.AjudaPresencial;

public class AjudaPresencialTest {
	private AjudaPresencial ajudaPresencial;
	
	@Before
	public void inicializar() {
		this.ajudaPresencial = new AjudaPresencial("123", "321", "Cálculo 2", "15:00", "seg", "CAA 404");
	}
	
	@Test
	public void getInfoAjudaTest() {
		assertEquals( this.ajudaPresencial.getInfoAjuda("disciplina"), "Cálculo 2" );
	}
	
	@Test
	public void getInfoAjudaTest2() {
		assertEquals( this.ajudaPresencial.getInfoAjuda("horario"), "15:00" );
	}
	
	@Test
	public void getInfoAjudaTest3() {
		assertEquals( this.ajudaPresencial.getInfoAjuda("dia"), "seg" );
	}
	
	@Test
	public void getInfoAjudaTest4() {
		assertEquals( this.ajudaPresencial.getInfoAjuda("local"), "CAA 404" );
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void getInfoAjudaIllegalArgTest() {
		this.ajudaPresencial.getInfoAjuda("nomeAluno");
	}
}
