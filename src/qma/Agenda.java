package qma;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Classe que administra os horários diponibilizados
 * por um tutor.
 * 
 * @author Matheus Oliveira Pereira
 * @author Gabriel Alves Tavares
 */
public class Agenda {
	
	private Map <String, Set <String> > horariosDisponiveis;
	
	/**
	 * Construtor de Agenda que inicia o HashMap de horários disponíveis
	 * e inicia as chaves que representam os dias da semana.
	 */
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
		this.validarArgumentos(horario, dia, "Erro no cadastrar horario");
		this.horariosDisponiveis.get(dia).add(horario);
	}
	
	/**
	 * Consulta se há um determinado horário cadastrado.
	 * @param horario horário consultado.
	 * @param dia dia da semana.
	 * @return true, se o horário estiver cadastrado.
	 */
	public boolean consultaHorario(String horario, String dia) {
		this.validarArgumentos(horario, dia, "Erro na consulta de horario");
		return this.horariosDisponiveis.get(dia).contains(horario);
	}
	
	/**
	 * Validador dos parâmetroes de horário e dia que verifica se são
	 * Strings vazias.
	 * @param horario horário de atendimento. 
	 * @param dia dia de atendimento.
	 * @param mensagemErro mensagem de erro caso o teste falhe.
	 */
	private void validarArgumentos(String horario, String dia, String mensagemErro) {
		if (dia.trim().equals("")) {
			throw new IllegalArgumentException(mensagemErro + ": dia nao pode ser vazio ou em branco");
		}
		if (horario.trim().equals("")) {
			throw new IllegalArgumentException(mensagemErro + ": horario nao pode ser vazio ou em branco");
		}
	}
	
		
}
