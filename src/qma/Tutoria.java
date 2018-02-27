package qma;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.Map;

public class Tutoria {
	private int nota, dinheiro;
	private Set<String> locaisDeAtendimento;
	private Map<String, Integer> disciplinas;
	
	public Tutoria() {
		// criar classe Agenda
		this.dinheiro = 0;
		this.nota = 4;
		this.locaisDeAtendimento = new HashSet<String>();
		this.disciplinas = new HashMap<String, Integer>();
	}
	
	public boolean possuiDisciplina() {
		return !(this.disciplinas.size() == 0);
	}
	
	public void cadastrarDisciplina(String disciplina, int proficiencia) {
		this.disciplinas.put(disciplina, proficiencia);
	}
	
	public void cadastrarLocalDeAtendimento(String local) {
		this.locaisDeAtendimento.add(local);
	}
	
	public void cadastrarHorarioDeAtendimento(String horario, String dia) {
		// criar classe Agenda
	}
	
	public boolean consultaLocal(String local) {
		return ( this.locaisDeAtendimento.contains(local) );
	}
	
	public boolean consultaHorario(String horario, String dia) {
		// criar classe Agenda, coloquei return true só para compilar
		return true;
	}
}
