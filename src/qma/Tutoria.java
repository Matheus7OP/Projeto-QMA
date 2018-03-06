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
	private double nota;
	private int dinheiro;
	private Set<String> locaisDeAtendimento;
	private Map<String, Integer> disciplinas;
	private Agenda agenda;
	
	/**
	 * Construtor do objeto Tutoria.
	 */
	public Tutoria() {
		this.agenda = new Agenda();
		this.dinheiro = 0;
		this.nota = 4.0;
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
		if (this.disciplinas.containsKey(disciplina)) {
			throw new IllegalArgumentException("Erro na definicao de papel: Ja eh tutor dessa disciplina");
		}
		if (proficiencia <= 0) {
			throw new IllegalArgumentException("Erro na definicao de papel: Proficiencia invalida");
		}
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
		this.agenda.cadastrarHorarioDeAtendimento(horario, dia);
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
		return this.agenda.consultaHorario(horario, dia);
	}
	
	/**
	 * Define um nível para o tutor conforme a nota que ele possui: "Top", "Tutor" ou "Aprendiz".
	 * @return string com o nível correspondente a nota do tutor.
	 */
	public String pegarNivel() {
		String nivel;
		
		if (this.nota > 4.5) {
			nivel = "TOP";
		} else if (this.nota > 3) {
			nivel = "Tutor";
		} else {
			nivel = "Aprendiz";
		}
		
		return nivel;
	}

	public void avaliarTutor(int nota) {
		// pontuação_final = (pontuação_inicial*5 + pontuação_recebida) / 6.
		this.nota = (this.nota * 5 + nota) / 6;
	}

	public double getNota() {
		return this.nota;
	}
}
