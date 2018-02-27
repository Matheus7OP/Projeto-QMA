package qma;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Agenda {
	
	private Map <String, Set <String> > horariosDisponiveis;
	
	public Agenda() {
		this.horariosDisponiveis = new HashMap <String, Set <String> >();
		this.horariosDisponiveis.put("seg", new HashSet <String> ());
		this.horariosDisponiveis.put("ter", new HashSet <String> ());
		this.horariosDisponiveis.put("qua", new HashSet <String> ());
		this.horariosDisponiveis.put("qui", new HashSet <String> ());
		this.horariosDisponiveis.put("sex", new HashSet <String> ());
		this.horariosDisponiveis.put("sab", new HashSet <String> ());
		this.horariosDisponiveis.put("dom", new HashSet <String> ());
	}
	
	
	/**
	 * Cadastra um novo horário de atendimento na Agenda.
	 * @param horario horario cadastrado.
	 * @param dia dia da semana (tres primeiras letras; i.e terça = "ter").
	 */
	public void cadastrarHorarioDeAtendimento(String horario, String dia) {
		if (dia.trim().equals("")) {
			throw new IllegalArgumentException("Erro no cadastrar horario: dia nao pode ser vazio ou em branco");
		}
		if (horario.trim().equals("")) {
			throw new IllegalArgumentException("Erro no cadastrar horario: horario nao pode ser vazio ou em branco");
		}
		this.horariosDisponiveis.get(dia).add(horario);
	}
	
	/**
	 * Consulta se há um determinado horário cadastrado.
	 * @param horario horário consultado.
	 * @param dia dia da semana.
	 * @return true, se o horário estiver cadastrado.
	 */
	public boolean consultaHorario(String horario, String dia) {
		return this.horariosDisponiveis.get(dia).contains(horario);
	}
	
		
}
