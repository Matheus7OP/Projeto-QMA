package testes;

import static org.junit.Assert.*;

import org.junit.*;

import qma.ControleAjudas;

public class ControleAjudasTest {
	private ControleAjudas controleAjudas;
	
	@Before
	public void inicializar() {
		this.controleAjudas = new ControleAjudas();
		this.controleAjudas.pedirAjudaOnline("123", "321", "Matemática");
		this.controleAjudas.pedirAjudaPresencial("12345", "54321", "Física", "12:00", "seg", "Biblioteca");
	}
	
	@Test
	public void pegarTutorTest1() {
		assertEquals( this.controleAjudas.pegarTutor(1), "Tutor - 321, disciplina - Matemática" );
	}
	
	@Test
	public void pegarTutorTest2() {
		assertEquals( this.controleAjudas.pegarTutor(2), "Tutor - 54321, horario - 12:00, dia - seg, local - Biblioteca, disciplina - Física" );
	}
	
	@Test
	public void getInfoAjudaTest1() {
		assertEquals( this.controleAjudas.getInfoAjuda(1, "disciplina"), "Matemática" );
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void getInfoAjudaTest2() {
		this.controleAjudas.getInfoAjuda(1, "matriculaTutor");
	}
	
	@Test
	public void getInfoAjudaTest3() {
		assertEquals( this.controleAjudas.getInfoAjuda(2, "disciplina"), "Física" );
	}
	
	@Test
	public void getInfoAjudaTest4() {
		assertEquals( this.controleAjudas.getInfoAjuda(2, "localInteresse"), "Biblioteca" );
	}
	
	@Test
	public void getInfoAjudaTest5() {
		assertEquals( this.controleAjudas.getInfoAjuda(2, "horario"), "12:00" );
	}
	
	@Test
	public void getInfoAjudaTest6() {
		assertEquals( this.controleAjudas.getInfoAjuda(2, "dia"), "seg" );
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void getInfoAjudaTest7() {
		this.controleAjudas.getInfoAjuda(2, "matriculaAluno");
	}
}
