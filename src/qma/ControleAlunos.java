package qma;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe que controla os alunos cadastrados
 * no sistema.
 * 
 * @author Matheus Oliveira Pereira
 * @author Gabriel Alves Tavares
 */
public class ControleAlunos {
	private List<Aluno> conjuntoAlunos;
	
	/**
	 * Construtor do objeto ControleAlunos.
	 */
	public ControleAlunos() {
		this.conjuntoAlunos = new ArrayList<Aluno>();
	}
	
	/**
	 * Método utilizado para cadastrar um novo aluno ao
	 * controle.
	 * 
	 * @param nome o nome do aluno
	 * @param matricula a matricula do aluno
	 * @param codigoCurso o código do curso que o aluno pertence
	 * @param telefone o telefone do aluno
	 * @param email o email do aluno
	 */
	public void cadastrarAluno(String nome, String matricula, int codigoCurso, String telefone, String email) {
		Aluno aluno = new Aluno(nome, matricula, codigoCurso, telefone, email);
		this.conjuntoAlunos.add(aluno);
	}
	
	/**
	 * Método utilizado para recuperar determinado aluno
	 * que está presente no controle, a partir de um de seus
	 * atributos (email, nome ou telefone).
	 * 
	 * @param desejado o valor que é desejado encontrar em determinado atributo do aluno
	 * @param atributo o atributo do aluno a ser verificado
	 * @return o objeto aluno que possui valor desejado para o atributo designado
	 */
	private Aluno getAluno(String desejado, String atributo) {
		int quantidadeAlunos = this.getQuantidadeAlunos();
		
		for(int i = 0; i < quantidadeAlunos; i++) {
			if( this.conjuntoAlunos.get(i).getInfoAluno(atributo).equals(desejado) ) {
				return this.conjuntoAlunos.get(i);
			}
		}
		
		throw new IllegalArgumentException("Matricula não cadastrada no sistema.");
	}
	
	/**
	 * Método utilizado para adicionar uma nova tutoria
	 * a determinado aluno.
	 * 
	 * @param matricula a matricula do aluno a ser adicionada a tutoria
	 * @param disciplina a disciplina desejada pelo aluno
	 * @param proficiencia sua proficiencia na disciplina
	 */
	public void adicionarTutoria(String matricula, String disciplina, int proficiencia) {
		this.getAluno(matricula, "Matricula").adicionarTutoria(disciplina, proficiencia);
	}
	
	/**
     * Lista todos os tutores cadastrados.
     * 
     * @return toString de todos os tutores, um por linha.
     */
	public String listarTutores() {
		String info = "";
		
		int quantidadeAlunos = this.getQuantidadeAlunos();
		
		for(int i = 0; i < quantidadeAlunos; i++) {
			if( this.conjuntoAlunos.get(i).possuiTutoria() ) {
				info += this.conjuntoAlunos.get(i).toString() + System.lineSeparator();
			}
		}
		
		return info;
	}
	
	/**
	 * Método utilizado para verificar a quantidade
	 * de alunos cadastrados no controle.
	 * 
	 * @return a quantidade de alunos cadastrados até o momento
	 */
	public int getQuantidadeAlunos() {
		return this.conjuntoAlunos.size();
	}
	
	/**
	 * Recupera a representação textual de um aluno.
	 * 
	 * @param matricula matrícula do aluno.
	 * @return toString do aluno com a matrícula dada.
	 */
	public String recuperaAluno(String matricula) {
		return this.getAluno(matricula, "Matricula").toString();
	}
	
	/**
	 * Retorna a representação textual de um tutor a partir de sua matrícula.
	 * 
	 * @param matricula matricula do tutor.
	 * @return toString do tutor.
	 */
	public String recuperaTutor(String matricula) {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * Cadastra um novo horário de atendimento para um tutor.
	 * 
	 * @param email email do tutor.
	 * @param horario horário de atendimento.
	 * @param dia dia da semana disponível para o horário de atendimento.
	 */
	public void cadastrarHorario(String email, String horario, String dia) {
		this.getAluno(email, "Email").cadastrarHorarioDeAtendimento(horario, dia);	
	}
	
	/**
     * Cadastra um novo local de atendimento para o tutor.
     * 
     * @param email email do tutor.
     * @param local local disponível para atendimento.
     */
	public void cadastrarLocalDeAtendimento(String email, String local) {
		this.getAluno(email, "Email").cadastrarLocalDeAtendimento(local);
	}
	
	/**
     * Consulta se um local de atendimento está cadastrado para determinado tutor. 
     * 
     * @param email email do tutor.
     * @param local local de atendimento consultado.
     * @return true, caso o local estiver disponível para o tutor especificado.
     */
	public boolean consultaLocal(String email, String local) {
		return this.getAluno(email, "Email").consultaLocal(local);
	}
	
	/**
     * Consulta se determinado horário do tutor está
     * disponível para atendimento.
     * 
     * @param email email do tutor.
     * @param horario o horário de atendimento a ser consultado.
     * @param dia o dia da semana a ser consultado.
     * @return true, caso o horário consultado esteja disponível.
     */
	public boolean consultaHorario(String email, String horario, String dia) {
		return this.getAluno(email, "Email").consultaHorario(horario, dia);
	}

	public String getInfoAluno(String matricula, String atributo) {
		return this.getAluno(matricula, "Matricula").getInfoAluno(atributo);
	}
}
