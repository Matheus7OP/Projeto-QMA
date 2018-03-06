package testes;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import qma.Aluno;

public class AlunoTest {
	private Aluno alunoSimples;
	
	@Before
	public void inicializar() {
		this.alunoSimples = new Aluno("Matheus", "77177", 7, "991161150", "theuso@bol.com.br", 0);
	}
	
	@Test
	public void getInfoAlunoNome() {
		assertEquals( this.alunoSimples.getInfoAluno("Nome"), "Matheus" );
	}
	
	@Test
	public void getInfoAlunoTelefone() {
		assertEquals( this.alunoSimples.getInfoAluno("Telefone"), "991161150" );
	}
	
	@Test
	public void getInfoAlunoMatricula() {
		assertEquals( this.alunoSimples.getInfoAluno("Matricula"), "77177" );
	}
	
	@Test
	public void getInfoAlunoEmail() {
		assertEquals( this.alunoSimples.getInfoAluno("Email"), "theuso@bol.com.br" );
	}
	
	@Test
	public void possuiTutoriaTest() {
		assertFalse( this.alunoSimples.possuiTutoria() );
	}
	
	@Test
	public void possuiTutoriaTest2() {
		this.alunoSimples.adicionarTutoria("AA", 2);
		assertTrue( this.alunoSimples.possuiTutoria() );
	}
	
	@Test
	public void consultaHorarioDeAtendimentoTest() {
		assertFalse( this.alunoSimples.consultaHorario("15:00", "seg") );
	}
	
	@Test
	public void cadastrarHorarioDeAtendimentoTest() {
		assertFalse( this.alunoSimples.consultaHorario("15:00", "seg") );
		this.alunoSimples.cadastrarHorarioDeAtendimento("15:00", "seg");
		assertTrue( this.alunoSimples.consultaHorario("15:00", "seg") );
	}
	
	@Test
	public void consultaLocalDeAtendimentoTest() {
		assertFalse( this.alunoSimples.consultaLocal("REENGE") );
	}
	
	@Test
	public void cadastrarLocalDeAtendimentoTest() {
		assertFalse( this.alunoSimples.consultaLocal("REENGE") );
		this.alunoSimples.cadastrarLocalDeAtendimento("REENGE");
		
		assertFalse( this.alunoSimples.consultaLocal("CAA") );
		assertTrue( this.alunoSimples.consultaLocal("REENGE") );
	}
	
	@Test
	public void toStringTest() {
		assertEquals( this.alunoSimples.toString(), "77177 - Matheus - 7 - 991161150 - theuso@bol.com.br" );
	}
	
	@Test(expected=NullPointerException.class)
	public void nomeNuloTest() {
		Aluno aluno = new Aluno( null, "1234", 7, "134134", "email@email.com", 0 );
	}
	
	@Test(expected=NullPointerException.class)
	public void matriculaNulaTest() {
		Aluno aluno = new Aluno( "Nome", null, 7, "134134", "email@email.com", 0 );
	}
	
	@Test(expected=NullPointerException.class)
	public void telefoneNuloTest() {
		Aluno aluno = new Aluno( "Nome", "12344", 7, null, "email@email.com", 0 );
	}
	
	@Test(expected=NullPointerException.class)
	public void emailNuloTest() {
		Aluno aluno = new Aluno( "Nome", "12344", 7, "1341243", null, 0 );
	}
	
	@Test
	public void equalsTest() {
		Aluno aluno = new Aluno("Matheus", "77177", 7, "991161150", "theuso@bol.com.br", 0);
		Aluno aluno2 = new Aluno("Matheus", "123", 7, "991161150", "theuso@bol.com.br", 0);
		
		assertTrue( this.alunoSimples.equals(aluno) );
		assertFalse( this.alunoSimples.equals(aluno2) );
	}
}
