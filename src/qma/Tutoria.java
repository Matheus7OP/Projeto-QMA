package qma;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.Map;

public class Tutoria {
	private int nota, dinheiro;
	private Set<String> locaisDeAtendimento;
	private Map<String, String> horariosDeAtendimento;
	private Map<String, Integer> disciplinas;
	
	public Tutoria() {
		this.dinheiro = 0;
		this.nota = 4;
		this.horariosDeAtendimento = new HashMap<String, String>();
		this.locaisDeAtendimento = new HashSet<String>();
		this.disciplinas = new HashMap<String, Integer>();
	}
	
	public void cadastrarLocalDeAtendimento(String local) {
		this.locaisDeAtendimento.add(local);
	}
	
	public void cadastrarHorarioDeAtendimento(String horario, String dia) {}
}
