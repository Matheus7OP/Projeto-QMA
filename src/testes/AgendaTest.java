package testes;

import org.junit.Before;
import org.junit.Test;

import qma.Agenda;

public class AgendaTest {

	private Agenda agenda;
	
	@Before
	public void inicializar() {
		this.agenda = new Agenda();
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void cadastroHorarioDiaEspacos() {
		this.agenda.cadastrarHorarioDeAtendimento("15:00", "  ");
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void cadastroHorarioDiaVazio() {
		this.agenda.cadastrarHorarioDeAtendimento("15:00", "");
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void cadastroHorarioHorarioEspacos() {
		this.agenda.cadastrarHorarioDeAtendimento("   ", "seg");
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void cadastroHorarioHorarioVazio() {
		this.agenda.cadastrarHorarioDeAtendimento("", "seg");
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void consultaHorarioDiaEspacos() {
		this.agenda.consultaHorario("15:00", "  ");
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void consultaHorarioDiaVazio() {
		this.agenda.consultaHorario("15:00", "");
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void consultaHorarioHorarioEspacos() {
		this.agenda.consultaHorario("   ", "seg");
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void consultaHorarioHorarioVazio() {
		this.agenda.consultaHorario("", "seg");
	}
	
}
