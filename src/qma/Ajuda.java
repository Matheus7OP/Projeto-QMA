	package qma;

/**
 * Classe abstrata que representa uma
 * ajuda, em sua forma mais geral, dentro
 * do sistema.
 * 
 * @author Matheus Oliveira Pereira
 * @author Gabriel Alves Tavares
 */
public abstract class Ajuda {
	private String matriculaAluno, matriculaTutor;
	private String disciplina;
	private boolean foiAvaliada;
	
	/**
	 * Construtor do objeto Ajuda.
	 * 
	 * @param matriculaAluno a matricula do aluno que requisitou a ajuda
	 * @param matriculaTutor a matricula do tutor que está responsável pela ajuda
	 * @param disciplina a disciplina que será tutorada
	 */
	public Ajuda(String matriculaAluno, String matriculaTutor, String disciplina){
		this.matriculaAluno = matriculaAluno;
		this.matriculaTutor = matriculaTutor;
		this.disciplina = disciplina;
		this.foiAvaliada = false;
	}
	
	public String getMatriculaTutor() {
		return this.matriculaTutor;
	}
	
	/**
	 * Método utilizado para recuperar alguma informação
	 * específica a respeito da ajuda
	 * 
	 * @param atributo o atributo desejado
	 * @return o valor do atributo desejado
	 */
	public abstract String getInfoAjuda(String atributo);
	
	/**
	 * Método utilizado para recuperar a
	 * disciplina associada à ajuda.
	 * 
	 * @return a disciplina associada à ajuda
	 */
	public String getDisciplina() {
		return this.disciplina;
	}
	
	/**
	 * Método utilizado para recuperar a matricula
	 * do tutor que está associado à ajuda
	 * 
	 * @return a matricula do tutor associado
	 */
	public abstract String pegarTutor();

	/**
	 * Método utilizado apra verificação se essa tutoria já foi avaliada.
	 * @return true, se foi avaliada.
	 */
	public boolean getFoiAvaliada() {
		return this.foiAvaliada;
	}

	/**
	 * Método que determina como true o atributo que indica se essa
	 * tutoria foi avaliada ou não.
	 */
	public void confirmarAvaliacao() {
		this.foiAvaliada = true;
	}
}
