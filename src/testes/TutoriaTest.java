package testes;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import qma.Tutoria;

public class TutoriaTest {
	private Tutoria tutoriaSimples;
	
	@Before
	public void inicializar() {
		this.tutoriaSimples = new Tutoria();
	}
	
	@Test
	public void cadastrarDisciplinaTest() {
		assertFalse( this.tutoriaSimples.possuiDisciplina() );
		this.tutoriaSimples.cadastrarDisciplina("AA", 1);
		assertTrue( this.tutoriaSimples.possuiDisciplina() );
	}
	
	@Test
	public void cadastrarHorarioDeAtendimentoTest() {
		assertFalse( this.tutoriaSimples.consultaHorario("15:00", "ter") );
		this.tutoriaSimples.cadastrarHorarioDeAtendimento("15:00", "ter");
		
		assertTrue( this.tutoriaSimples.consultaHorario("15:00", "ter") );
		assertFalse( this.tutoriaSimples.consultaHorario("12:00", "ter") );
	}
	
	@Test
	public void cadastrarHorarioDeAtendimentoTest2() {
		assertFalse( this.tutoriaSimples.consultaHorario("12:00", "seg") );
		this.tutoriaSimples.cadastrarHorarioDeAtendimento("12:40", "seg");
		assertFalse( this.tutoriaSimples.consultaHorario("12:00", "ter") );
	}
	
	@Test
	public void cadastrarLocalDeAtendimentoTest() {
		assertFalse( this.tutoriaSimples.consultaLocal("REENGE") );
		this.tutoriaSimples.cadastrarLocalDeAtendimento("REENGE");
		assertTrue( this.tutoriaSimples.consultaLocal("REENGE") );
	}
	
	@Test
	public void cadastrarLocalDeAtendimentoTest2() {
		assertFalse( this.tutoriaSimples.consultaLocal("CAA 404") );
		this.tutoriaSimples.cadastrarLocalDeAtendimento("REENGE");
		assertFalse( this.tutoriaSimples.consultaLocal("CAA 404") );
	}
}
