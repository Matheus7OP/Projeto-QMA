package qma;
import easyaccept.EasyAccept;

public class Facade {
	private Sistema sistema;
	
	public static void main(String[] args) {
		args = new String[] {"qma.Facade", "acceptanceTest/us1_test.txt", "acceptanceTest/us2_test.txt"};
		EasyAccept.main(args);
	}
	
	public Facade () {
		this.sistema = new Sistema();
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
		this.sistema.cadastrarAluno(nome, matricula, codigoCurso, telefone, email);
	}
    
	/**
	 * Retorna a representação textual de um tutor a partir de sua matrícula.
	 * @param matricula matricula do tutor.
	 * @return toString do tutor.
	 */
    public String recuperaTutor(String matricula) {
    	return this.sistema.recuperaTutor(matricula);
    }
    
    /**
     * Lista todos os tutores cadastrados.
     * @return toString de todos os tutores, um por linha.
     */
    public String listarTutores() {
    	return this.sistema.listarTutores();
    }
	
	
    /**
     * Torna um aluno tutor. Caso o aluno já seja um tutor lança um erro.
     * @param matricula matrícula do aluno.
     * @param disciplina disciplina da tutoria.
     * @param proficiencia proficiência do aluno na disciplina em que deseja ser tutor.
     */
	public void tornarTutor(String matricula, String disciplina, int proficiencia) {
		this.sistema.adicionarTutoria(matricula, disciplina, proficiencia);
	}
	
	/**
	 * Cadastra um novo horário de atendimento para um tutor.
	 * @param email email do tutor.
	 * @param horario horário de atendimento.
	 * @param dia dia da semana disponível para o horário de atendimento.
	 */
    public void cadastrarHorario(String email, String horario, String dia) {
    	this.sistema.cadastrarHorario(email, horario, dia);
    }
    
    /**
     * Cadastra um novo local de atendimento para o tutor.
     * @param email email do tutor.
     * @param local local disponível para atendimento.
     */
    public void cadastrarLocalDeAtendimento(String email, String local) {
    	this.sistema.cadastrarLocalDeAtendimento(email, local);
    }
    
    /**
     * Consulta se um horário do tutor está disponível para atendimento.
     * @param email email do tutor.
     * @param horario horário de atendimento consultado.
     * @param dia dia da semana consultado.
     * @return true se o horário consultado está disponível.
     */
    public boolean consultaHorario(String email, String horario, String dia) {
    	return this.sistema.consultaHorario(email, horario, dia);
    }
    
    /**
     * Consulta de um local de atendimento está cadastrado para determinado tutor. 
     * @param email email do tutor.
     * @param local local de atendimento consultado.
     * @return true de o local estiver disponível para o tutor especificado.
     */
    public boolean consultaLocal(String email, String local) {
    	return this.sistema.consultaLocal(email, local);
    }
}
