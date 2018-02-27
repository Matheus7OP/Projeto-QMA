package qma;

public class Sistema {
	private ControleAlunos controleAlunos;
	
	/**
	 * Construtor do objeto Sistema.
	 */
	public Sistema() {
		this.controleAlunos = new ControleAlunos();
	}
	
	/**
	 * Recupera a representação textual de um aluno.
	 * @param matricula matrícula do aluno.
	 * @return toString do aluno com a matrícula dada.
	 */
	public String recuperaAluno(String matricula) {
		return this.controleAlunos.recuperaAluno(matricula);
	}
	
	/**
	 * Retorna a representação textual de um tutor a partir de sua matrícula.
	 * @param matricula matricula do tutor.
	 * @return toString do tutor.
	 */
	public String recuperaTutor(String matricula) {
		return this.controleAlunos.recuperaTutor(matricula);
	}
	
	/**
	 * Cadastra um novo aluno no sistema.
	 * @param nome nome do aluno.	
	 * @param matricula matrícula do aluno.
	 * @param codigoCurso código do curso do aluno.
	 * @param telefone telefone do aluno.
	 * @param email email do aluno.
	 */
	public void cadastrarAluno(String nome, String matricula, int codigoCurso, String telefone, String email) {
		this.controleAlunos.cadastrarAluno(nome, matricula, codigoCurso, telefone, email);
	}

	/**
     * Lista todos os tutores cadastrados no
     * sistema.
     * 
     * @return toString de todos os tutores, um por linha.
     */
	public String listarTutores() {
		return this.controleAlunos.listarTutores();
	}

    /**
     * Adiciona uma tutoria ao aluno designado.
     * 
     * @param matricula matrícula do aluno.
     * @param disciplina disciplina da tutoria.
     * @param proficiencia proficiência do aluno na disciplina designada.
     */
	public void adicionarTutoria(String matricula, String disciplina, int proficiencia) {
		this.controleAlunos.adicionarTutoria(matricula, disciplina, proficiencia);
	}

	/**
	 * Cadastra um novo horário de atendimento para um tutor.
	 * @param email email do tutor.
	 * @param horario horário de atendimento.
	 * @param dia dia da semana disponível para o horário de atendimento.
	 */
	public void cadastrarHorario(String email, String horario, String dia) {
		this.controleAlunos.cadastrarHorario(email, horario, dia);
	}

    /**
     * Cadastra um novo local de atendimento para o tutor.
     * @param email email do tutor.
     * @param local local disponível para atendimento.
     */
	public void cadastrarLocalDeAtendimento(String email, String local) {
		this.controleAlunos.cadastrarLocalDeAtendimento(email, local);
	}

	/**
     * Consulta se um horário do tutor está disponível para atendimento.
     * @param email email do tutor.
     * @param horario horário de atendimento consultado.
     * @param dia dia da semana consultado.
     * @return true se o horário consultado está disponível.
     */
	public boolean consultaHorario(String email, String horario, String dia) {
		return this.controleAlunos.consultaHorario(email, horario, dia);
	}

    /**
     * Consulta de um local de atendimento está cadastrado para determinado tutor. 
     * @param email email do tutor.
     * @param local local de atendimento consultado.
     * @return true de o local estiver disponível para o tutor especificado.
     */
	public boolean consultaLocal(String email, String local) {
		return this.controleAlunos.consultaLocal(email, local);
	}

}