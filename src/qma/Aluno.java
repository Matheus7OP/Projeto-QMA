package qma;

/**
 * Classe que representa um Aluno no sistema,
 * sendo possível adicionar tutorias ao mesmo.
 * 
 * @author Matheus Oliveira Pereira
 * @author Gabriel Alves Tavares
 */
public class Aluno {
	private Tutoria tutoria;
	private String nome, matricula, telefone, email;
	private int codigoCurso, nota;
	
	/**
	 * Construtor do objeto Aluno.
	 * 
	 * @param nome o nome do aluno
	 * @param matricula a matricula do aluno
	 * @param codigoCurso o código do curso que o aluno está
	 * @param telefone o telefone do aluno
	 * @param email o email do aluno
	 */
	public Aluno(String nome, String matricula, int codigoCurso, String telefone, String email) {
		this.nome = nome;
		this.matricula = matricula;
		this.codigoCurso = codigoCurso;
		this.telefone = telefone;
		this.email = email;
		this.tutoria = new Tutoria();
	}
	
	/**
	 * Método utilizado para recuperar alguma
	 * informação de aluno, tal como seu email,
	 * seu nome ou seu telefone.
	 * 
	 * @param atributo o atributo a ser recuperado
	 * @return o atributo requisitado
	 */
	public String getInfoAluno(String atributo) {		
		switch(atributo) {
			case "email":
				return this.email;
			case "nome":
				return this.nome;
			case "telefone":
				return this.telefone;
			default:
				throw new IllegalArgumentException("Atributo inexistente.");
		}
	}
	
	/**
	 * Método utilizado para checar se o aluno em
	 * questão possui ou não ao menos uma tutoria.
	 * 
	 * @return true, caso o aluno possua ao menos uma tutoria
	 */
	public boolean possuiTutoria() {
		return this.tutoria.possuiDisciplina();
	}
	
	/**
	 * Método utilizado para adicionar uma nova tutoria
	 * ao aluno.
	 * 
	 * @param disciplina a disciplina desejada pelo aluno
	 * @param proficiencia sua proficiencia na disciplina
	 */
	public void adicionarTutoria(String disciplina, int proficiencia) {
		this.tutoria.cadastrarDisciplina(disciplina, proficiencia);
	}
	
	/**
	 * Cadastra um novo horário de atendimento para um tutor.
	 * 
	 * @param horario o horário de atendimento.
	 * @param dia o dia da semana disponível para o horário de atendimento.
	 */
	public void cadastrarHorarioDeAtendimento(String horario, String dia) {
		this.tutoria.cadastrarHorarioDeAtendimento(horario, dia);
	}
	
	/**
     * Cadastra um novo local de atendimento para o tutor.
     * 
     * @param local local disponível para atendimento.
     */
	public void cadastrarLocalDeAtendimento(String local) {
		this.tutoria.cadastrarLocalDeAtendimento(local);
	}
	
	/**
     * Consulta se um local de atendimento está cadastrado para determinado tutor. 
     * 
     * @param local local de atendimento consultado.
     * @return true, caso o local estiver disponível para o tutor especificado.
     */
	public boolean consultaLocal(String local) {
		return this.tutoria.consultaLocal(local);
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
		return this.tutoria.consultaHorario(horario, dia);
	}
	
	@Override
	public String toString() {
		String info = String.format("%s - %s - %d", this.matricula, this.nome, this.codigoCurso);
		
		if( !this.telefone.equals("") ) info += String.format(" - %s", this.telefone);
		info += String.format(" - %s", this.email);
		
		return info;
	}
}