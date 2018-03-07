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
	private Caixa caixa;
	
	/**
	 * Construtor do objeto Sistema.
	 */
	public Sistema() {
		this.controleAlunos = new ControleAlunos();
		this.controleAjudas = new ControleAjudas();
		this.caixa = new Caixa();
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
     * 
     * @param idAjuda id da ajuda.
     * @param nota nota de 0 a 5 dada ao tutor.
     * @return o novo nível do tutor.
     */
	public void avaliarTutor(int idAjuda, int nota) {
		String matriculaTutor = this.controleAjudas.getMatriculaTutor(idAjuda);
		
		this.controleAlunos.avaliarTutor(matriculaTutor, nota);
	}

    /**
     * Recupera a nota do tutor.
     * 
     * @param matriculaTutor matrícula do tutor.
     * @return a nota do tutor.
     */
	public String pegarNota(String matriculaTutor) {
		return this.controleAlunos.pegarNota(matriculaTutor);
	}

    /**
     * Retorna o nível do tutor. Pode ser "TOP", "Tutor" ou "Aprendiz".
     * 
     * @param matriculaTutor matrícula do tutor.
     * @return o nível do tutor, estabelecido conforme a nota do mesmo.
     */	
	public String pegarNivel(String matriculaTutor) {
		return this.controleAlunos.pegarNivel(matriculaTutor);
	}
	
	/**
	 * Método utilizado para recuperar a matrícula do melhor
	 * tutor disponível, naquele momento, para tutorar a 
	 * disciplina designada.
	 * 
	 * @param disciplina a disciplina a ser tutorada
	 * @return a matricula do tutor mais apto a tutorar a disciplina
	 */
	public String getMelhorTutorDisponivel(String disciplina) {
		return this.controleAlunos.getMelhorTutorDisponivel(disciplina);
	}
	
	/**
     * Método utilizado para que um aluno cadastre um
     * pedido de ajuda presencial no sistema.
     * 
     * @param matrAluno a matricula do aluno que precisa de ajuda
     * @param disciplina a disciplina que o aluno precisa ser ajudado
     * @param horario o horario em que o aluno tem interesse em ser atendido
     * @param dia o dia em que o aluno tem interesse em ser atendido
     * @param localInteresse o local que o aluno tem interesse em ser atendido
     * @return o id do pedido de ajuda
     */
	public int pedirAjudaPresencial(String matriculaAluno, String disciplina, String horario, String dia, String localInteresse) {
		if (matriculaAluno.trim().equals("")) {
			throw new IllegalArgumentException("Erro no pedido de ajuda presencial: matricula de aluno nao pode ser vazio ou em branco");
		}
		if (disciplina.trim().equals("")) {
			throw new IllegalArgumentException("Erro no pedido de ajuda presencial: disciplina nao pode ser vazio ou em branco");
		}
		if (horario.trim().equals("")) {
			throw new IllegalArgumentException("Erro no pedido de ajuda presencial: horario nao pode ser vazio ou em branco");
		}
		if (dia.trim().equals("")) {
			throw new IllegalArgumentException("Erro no pedido de ajuda presencial: dia nao pode ser vazio ou em branco");
		}
		if (localInteresse.trim().equals("")) {
			throw new IllegalArgumentException("Erro no pedido de ajuda presencial: local de interesse nao pode ser vazio ou em branco");
		}
		
		String matriculaTutor = getMelhorTutorDisponivel(disciplina);
		
		return this.controleAjudas.pedirAjudaPresencial(matriculaAluno, matriculaTutor, disciplina, horario, dia, localInteresse);
	}
	
	/**
     * Método utilizado para que um aluno cadastre um
     * pedido de ajuda online no sistema.
     * 
     * @param matrAluno a matricula do aluno que precisa de ajuda
     * @param disciplina a disciplina que o aluno precisa ser ajudado
     * @return o id do pedido de ajuda
     */
    public int pedirAjudaOnline (String matriculaAluno, String disciplina) {
		if (matriculaAluno.trim().equals("")) {
			throw new IllegalArgumentException("Erro no pedido de ajuda online: matricula de aluno nao pode ser vazio ou em branco");
		}
		if (disciplina.trim().equals("")) {
			throw new IllegalArgumentException("Erro no pedido de ajuda online: disciplina nao pode ser vazio ou em branco");
		}
    	String matriculaTutor = getMelhorTutorDisponivel(disciplina);
    	
    	return this.controleAjudas.pedirAjudaOnline(matriculaAluno, matriculaTutor, disciplina);
    }
    
    /**
     * Método utilizado para recuperar o tutor
     * que está associado ao pedido de ajuda
     * designado na chamada.
     * 
     * @param idAjuda o id da ajuda
     * @return a matricula do tutor que está encarregado da ajuda
     * especificada, bem como a disciplina que o mesmo tem prodificiencia
     */
	public String pegarTutor(int idAjuda) {
		return this.controleAjudas.pegarTutor(idAjuda);
	}
	
	/**
     * Método utilizado para recuperar alguma
     * informação específica da ajuda solicitada.
     * 
     * @param idAjuda o id da ajuda solicitada
     * @param atributo o atributo que se deseja recuperar
     * @return o valor do atributo desejado
     */
	public String getInfoAjuda(int idAjuda, String atributo) { 		
		return this.controleAjudas.getInfoAjuda(idAjuda, atributo);
	}
	
	/**
     * Retorna a quantidade de dinheiro que o tutor
     * ganhou do sistema até o momento
     * 
     * @param emailTutor o email do tutor que deseja-se verificar
     * @return a quantia em dinheiro que ele ganhou até o momento
     */
	public int totalDinheiroTutor() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	/**
     * Método utilizado para doar quantias em
     * dinheiro para o tutor especificado. Dessa quantia,
     * uma certa taxa é retirada para o sistema, dependendo
     * da avaliação atual do tutor.
     * 
     * @param matriculaTutor a matricula do tutor que se deseja doar
     * @param totalCentavos o total de dinheiro (em centavos) que se deseja doar ao tutor
     */
	public void doar(String matriculaTutor, int totalCentavos) {
		double taxaTutor = this.controleAlunos.taxaTutor(matriculaTutor), parteDoSistema;
		
		parteDoSistema = (1.0 - taxaTutor) * ((double) totalCentavos);
		parteDoSistema = Math.floor(parteDoSistema);
		
		this.caixa.adicionarDinheiro( ((int) parteDoSistema) );
		this.controleAlunos.doarAoTutor(matriculaTutor, totalCentavos - ((int) parteDoSistema));
	}
	
	/**
     * Retorna a quantidade total de dinheiro
     * presente em sistema.
     * 
     * @return quantidade de dinheiro em sistema
     */
	public int totalDinheiroSistema() {
		return this.caixa.getDinheiro();
	}
}