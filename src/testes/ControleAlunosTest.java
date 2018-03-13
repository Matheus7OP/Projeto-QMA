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
		this.ctrlAlunos.cadastrarAluno("Matheus", "923123324", 4234, "2532352", "dae@gmail.com");
		this.ctrlAlunos.cadastrarAluno("Cláudio", "523531323", 123122, "5345353", "yoo@bol.com");
		this.ctrlAlunos.cadastrarAluno("Amantaio", "4124323", 52452, "432423", "nhonho@uol.com.br");
		this.ctrlAlunos.cadastrarAluno("Tchalala", "42342342", 3242, "45343534", "olar@hotmail.com");
		
		this.ctrlAlunos.adicionarTutoria("117110655", "AA", 4);
		this.ctrlAlunos.adicionarTutoria("923123324", "Matemática", 3);
		this.ctrlAlunos.adicionarTutoria("4124323", "Cálculo", 5);
		this.ctrlAlunos.adicionarTutoria("523531323", "Linear", 4);
		this.ctrlAlunos.adicionarTutoria("42342342", "Programação", 3);
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
		assertEquals(5, this.ctrlAlunos.getQuantidadeAlunos());
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
	
	@Test(expected=IllegalArgumentException.class)
	public void configurarOrdemErrorTest() {
		this.ctrlAlunos.configurarOrdem("AKSJCNsdh");
	}
	
	@Test
	public void configurarOrdemTest() {
		assertEquals( "117110655 - Gabriel - 33443 - 899988767 - oi@hotmail.com, 923123324 - Matheus - 4234 - 2532352 - "
				+ "dae@gmail.com, 523531323 - Cláudio - 123122 - 5345353 - yoo@bol.com, 4124323 - Amantaio - 52452 -"
				+ " 432423 - nhonho@uol.com.br, 42342342 - Tchalala - 3242 - 45343534 - olar@hotmail.com", this.ctrlAlunos.listarTutores() );
		this.ctrlAlunos.configurarOrdem("NOME");
		assertEquals( "4124323 - Amantaio - 52452 - 432423 - nhonho@uol.com.br, 523531323 - Cláudio - 123122 - 5345353 -"
				+ " yoo@bol.com, 117110655 - Gabriel - 33443 - 899988767 - oi@hotmail.com, 923123324 - Matheus - 4234 - "
				+ "2532352 - dae@gmail.com, 42342342 - Tchalala - 3242 - 45343534 - olar@hotmail.com", this.ctrlAlunos.listarTutores() );
	}
}
