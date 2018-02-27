package qma;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.Map;

/**
 * Classe que guarda informações a respeito da
 * tutoria de um aluno, tais como os locais de atendimento,
 * horários disponíveis, dinheiro recebido através das tutorias
 * até o momento e a nota que o tutor recebeu como avaliação de outros
 * alunos.
 * 
 * @author Matheus Oliveira Pereira
 * @author Gabriel Alves Tavares
 */
public class Tutoria {
	private int nota, dinheiro;
	private Set<String> locaisDeAtendimento;
	private Map<String, Integer> disciplinas;
	
	/**
	 * Construtor do objeto Tutoria.
	 */
	public Tutoria() {
		// criar classe Agenda
		this.dinheiro = 0;
		this.nota = 4;
		this.locaisDeAtendimento = new HashSet<String>();
		this.disciplinas = new HashMap<String, Integer>();
	}
	
	/**
	 * Método utilizado para checar se já existe
	 * alguma disciplina cadastrada nessa tutoria.
	 * 
	 * @return true, caso haja ao menos uma disciplina cadastrada
	 */
	public boolean possuiDisciplina() {
		return !(this.disciplinas.size() == 0);
	}
	
	/**
	 * Método utilizado para cadastrar novas disciplinas à tutoria.
	 * 
	 * @param disciplina a disciplina que o aluno deseja cadastrar à tutoria
	 * @param proficiencia a proficiencia do aluno na disciplina
	 */
	public void cadastrarDisciplina(String disciplina, int proficiencia) {
		this.disciplinas.put(disciplina, proficiencia);
	}
	
	/**
	 * Cadastra um novo local de atendimento para o tutor.
	 * 
	 * @param local o local a ser adicionado
	 */
	public void cadastrarLocalDeAtendimento(String local) {
		this.locaisDeAtendimento.add(local);
	}
	
	/**
	 * Cadastra um novo horário de atendimento para o tutor.
	 * 
	 * @param horario horário de atendimento.
	 * @param dia dia da semana disponível para o horário de atendimento.
	 */
	public void cadastrarHorarioDeAtendimento(String horario, String dia) {
		// criar classe Agenda
	}
	
	 /**
     * Consulta se um local de atendimento está cadastrado.
     * 
     * @param local local de atendimento consultado.
     * @return true, caso o local estiver disponível para o tutor.
     */
	public boolean consultaLocal(String local) {
		return ( this.locaisDeAtendimento.contains(local) );
	}
	
	 /**
     * Consulta se determinado horário do tutor está
     * disponível para atendimento.
     * 
     * @param horario o horário de atendimento a ser consultado.
     * @param dia o dia da semana a ser consultado.
     * @return true, caso o horário consultado esteja disponível.
     */
	public boolean consultaHorario(String horario, String dia) {
		// criar classe Agenda, coloquei return true só para compilar
		return true;
	}
}
