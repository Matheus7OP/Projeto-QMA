package qma;
import easyaccept.EasyAccept;

/**
 * Classe que abstrai o sistema para facilitar
 * o uso das classes abstraídas.
 * 
 * @author Matheus Oliveira Pereira
 * @author Gabriel Alves Tavares
 */
public class Facade {
	private Sistema sistema;
	
	public static void main(String[] args) {
		args = new String[] {"qma.Facade", 
				"acceptanceTest/us1_test.txt", 
				"acceptanceTest/us2_test.txt", 
				"acceptanceTest/us3_test.txt",
				"acceptanceTest/us4_test.txt", 
				"acceptanceTest/us5_test.txt", 
				"acceptanceTest/us6_test.txt"};
		
		EasyAccept.main(args);
	}
	
	/**
	 * Método inicializador da Facade.
	 */
	public Facade () {
		this.sistema = new Sistema();
	}
	
	/**
	 * Recupera a representação textual de um aluno.
	 * 
	 * @param matricula matrícula do aluno.
	 * @return toString do aluno com a matrícula dada.
	 */
	public String recuperaAluno(String matricula) {
		return this.sistema.recuperaAluno(matricula);
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
		return this.sistema.getInfoAluno(matricula, atributo);
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
		this.sistema.cadastrarAluno(nome, matricula, codigoCurso, telefone, email);
	}
    
	/**
	 * Retorna a representação textual de um tutor a partir de sua matrícula.
	 * 
	 * @param matricula matricula do tutor.
	 * @return toString do tutor.
	 */
    public String recuperaTutor(String matricula) {
    	return this.sistema.recuperaTutor(matricula);
    }
    
    /**
     * Lista todos os tutores cadastrados no
     * sistema.
     * 
     * @return toString de todos os tutores, separados por linha.
     */
    public String listarTutores() {
    	return this.sistema.listarTutores();
    }
	
    /**
     * Torna um aluno tutor de uma disciplina. Caso o aluno já
     * seja tutor da discipina especificada, é lançado um erro.
     * 
     * @param matricula matrícula do aluno.
     * @param disciplina disciplina da tutoria.
     * @param proficiencia proficiência do aluno na disciplina em que deseja ser tutor.
     */
	public void tornarTutor(String matricula, String disciplina, int proficiencia) {
		this.sistema.adicionarTutoria(matricula, disciplina, proficiencia);
	}
	
	/**
	 * Cadastra um novo horário de atendimento para um tutor.
	 * 
	 * @param email email do tutor.
	 * @param horario horário de atendimento.
	 * @param dia dia da semana disponível para o horário de atendimento.
	 */
    public void cadastrarHorario(String email, String horario, String dia) {
    	this.sistema.cadastrarHorario(email, horario, dia);
    }
    
    /**
     * Cadastra um novo local de atendimento para um tutor.
     * 
     * @param email email do tutor.
     * @param local local disponível para atendimento.
     */
    public void cadastrarLocalDeAtendimento(String email, String local) {
    	this.sistema.cadastrarLocalDeAtendimento(email, local);
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
    	return this.sistema.consultaHorario(email, horario, dia);
    }
    
    /**
     * Consulta se um local de atendimento está cadastrado para determinado tutor. 
     * 
     * @param email email do tutor.
     * @param local local de atendimento consultado.
     * @return true, caso o local estiver disponível para o tutor especificado.
     */
    public boolean consultaLocal(String email, String local) {
    	return this.sistema.consultaLocal(email, local);
    }

	/**
     * Lista todos os alunos cadastrados.
     * 
     * @return toString de todos os alunos, separados por linha.
     */
    public String listarAlunos() {
    	return this.sistema.listarAlunos();
    }
    
    /**
     * Adiciona uma nota ao tutor designado para determinada ajuda.
     * @param idAjuda id da ajuda.
     * @param nota nota de 0 a 5 dado ao tutor.
     */
    public void avaliarTutor (int idAjuda, int nota) {
    	this.sistema.avaliarTutor(idAjuda, nota);
    }
    
    /**
     * Recupera a nota do tutor.
     * @param matriculaTutor matrícula do tutor.
     * @return a nota do tutor.
     */
    public String pegarNota(String matriculaTutor) {
    	return this.sistema.pegarNota(matriculaTutor);
    }
    
    /**
     * Retorna o nível do tutor. Pode ser "TOP", "Tutor" ou "Aprendiz".
     * @param matriculaTutor matrícula do tutor.
     * @return o nível do tutor, estabelecido conforme a nota do mesmo.
     */
    public String pegarNivel(String matriculaTutor) {
    	return this.sistema.pegarNivel(matriculaTutor);
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
    public int pedirAjudaPresencial (String matrAluno, String disciplina, String horario, String dia, String localInteresse) {
		return this.sistema.pedirAjudaPresencial(matrAluno, disciplina, horario, dia, localInteresse);
	}
    
    /**
     * Método utilizado para que um aluno cadastre um
     * pedido de ajuda online no sistema.
     * 
     * @param matrAluno a matricula do aluno que precisa de ajuda
     * @param disciplina a disciplina que o aluno precisa ser ajudado
     * @return o id do pedido de ajuda
     */
    public int pedirAjudaOnline (String matrAluno, String disciplina) {
    	// incompleto
    	return 0;
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
    	// incompleto
    	return null;
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
    	// incompleto
    	return null;
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
    	// incompleto
    }
}
