package testes;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import qma.ControleAlunos;

public class ControleAlunosTest {

	private ControleAlunos ctrlAlunos;
	
	@Before
	public void inicializar() {
		this.ctrlAlunos = new ControleAlunos();
		this.ctrlAlunos.cadastrarAluno("Gabriel", "117110655", 33443, "899988767", "oi@hotmail.com");
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void cadastraAlunoNomeVazioTest() {
		this.ctrlAlunos.cadastrarAluno("  ", "1234", 223344, "898449399", "asdf@asdf");
	}

	@Test(expected=IllegalArgumentException.class)
	public void cadastraAlunoMatriculaVaziaTest() {
		this.ctrlAlunos.cadastrarAluno("bruno", "  ", 223344, "898449399", "asdf@asdf");
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void cadastraAlunoVazioTest() {
		this.ctrlAlunos.cadastrarAluno("bruno", "  ", 223344, "898449399", "asdf@asdf");
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void cadastraEmailVazioTest() {
		this.ctrlAlunos.cadastrarAluno("bruno", "1234", 223344, "898449399", "  ");
	}

	@Test(expected=IllegalArgumentException.class)
	public void cadastraEmailInvalido1Test() {
		this.ctrlAlunos.cadastrarAluno("bruno", "1234", 223344, "898449399", "@teste.com");
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void cadastraEmailInvalido2Test() {
		this.ctrlAlunos.cadastrarAluno("bruno", "1234", 223344, "898449399", "teste.com@");
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void cadastraEmailInvalido3Test() {
		this.ctrlAlunos.cadastrarAluno("bruno", "1234", 223344, "898449399", "@");
	}
	
	@Test
	public void quantidadeAlunosTest() {
		assertEquals(1, this.ctrlAlunos.getQuantidadeAlunos());
	}
	
	@Test
	public void getInfoAlunoNomeTest() {
		assertEquals("Gabriel", this.ctrlAlunos.getInfoAluno("117110655", "Nome"));
	}
	
	@Test
	public void getInfoAlunoEmailTest() {
		assertEquals("oi@hotmail.com", this.ctrlAlunos.getInfoAluno("117110655", "Email"));
	}
	
	@Test
	public void recuperaAlunoTest() {
		assertEquals("117110655 - Gabriel - 33443 - 899988767 - oi@hotmail.com", this.ctrlAlunos.recuperaAluno("117110655"));
	}
	
	
	
}
