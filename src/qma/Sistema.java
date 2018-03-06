package qma;

/**
 * Classe que representa o sistema, em sua
 * ideia mais geral.
 * 
 * @author Matheus Oliveira Pereira
 * @author Gabriel Alves Tavares
 */
public class Sistema {
	private ControleAlunos controleAlunos;
	private ControleAjudas controleAjudas;
	
	/**
	 * Construtor do objeto Sistema.
	 */
	public Sistema() {
		this.controleAlunos = new ControleAlunos();
		this.controleAjudas = new ControleAjudas();
	}
	
	/**
	 * Recupera a representação textual de um aluno.
	 * 
	 * @param matricula matrícula do aluno.
	 * @return toString do aluno com a matrícula dada.
	 */
	public String recuperaAluno(String matricula) {
		return this.controleAlunos.recuperaAluno(matricula);
	}
	
	/**
	 * Retorna a representação textual de um tutor a partir de sua matrícula.
	 * 
	 * @param matricula matricula do tutor.
	 * @return toString do tutor.
	 */
	public String recuperaTutor(String matricula) {
		return this.controleAlunos.recuperaTutor(matricula);
	}
	
	/**
	 * Cadastra um novo aluno no sistema.
	 * 
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
     * @return toString de todos os tutores, separados por linha.
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
     * 
     * @param email email do tutor.
     * @param local local disponível para atendimento.
     */
	public void cadastrarLocalDeAtendimento(String email, String local) {
		this.controleAlunos.cadastrarLocalDeAtendimento(email, local);
	}

	/**
     * Consulta se um horário do tutor está disponível para atendimento.
     * 
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
     * 
     * @param email email do tutor.
     * @param local local de atendimento consultado.
     * @return true de o local estiver disponível para o tutor especificado.
     */
	public boolean consultaLocal(String email, String local) {
		return this.controleAlunos.consultaLocal(email, local);
	}

	/**
	 * Método utilizado para recuperar alguma informação
	 * específica relacionada à algum aluno cadastrado no sistema.
	 * 
	 * @param matricula a matricula do aluno requisitado
	 * @param atributo o atributo desejado
	 * @return o atributo requisitado de aluno
	 */
	public String getInfoAluno(String matricula, String atributo) {
		return this.controleAlunos.getInfoAluno(matricula, atributo);
	}

	/**
     * Lista todos os alunos cadastrados.
     * 
     * @return toString de todos os alunos, separados por vírgula.
     */
	public String listarAlunos() {		
		return this.controleAlunos.listarAlunos();
	}

	/**
     * Adiciona uma nota ao tutor designado para determinada ajuda.
     * @param idAjuda id da ajuda.
     * @param nota nota de 0 a 5 dado ao tutor.
     * @return o novo nível do tutor.
     */
	public String avaliarTutor(int idAjuda, int nota) {
		String matriculaTutor = this.controleAjudas.pegarTutor(idAjuda);
		this.controleAlunos.avaliarTutor(matriculaTutor, nota);
		return "";
	}

    /**
     * Recupera a nota do tutor.
     * @param matriculaTutor matrícula do tutor.
     * @return a nota do tutor.
     */
	public double pegarNota(String matriculaTutor) {
		return this.controleAlunos.pegarNota(matriculaTutor);
	}

    /**
     * Retorna o nível do tutor. Pode ser "TOP", "Tutor" ou "Aprendiz".
     * @param matriculaTutor matrícula do tutor.
     * @return o nível do tutor, estabelecido conforme a nota do mesmo.
     */	
	public String pegarNivel(String matriculaTutor) {
		return this.controleAlunos.pegarNivel(matriculaTutor);
	}

}