package qma;

/**
 * Classe que representa um Aluno no sistema,
 * sendo possível adicionar tutorias ao mesmo.
 * 
 * @author Matheus Oliveira Pereira
 * @author Gabriel Alves Tavares
 */
public class Aluno implements Comparable {
	private Tutoria tutoria;
	private String nome, matricula, telefone, email;
	private int codigoCurso, nota, id;

	/**
	 * Construtor do objeto Aluno.
	 * 
	 * @param nome o nome do aluno
	 * @param matricula a matricula do aluno
	 * @param codigoCurso o código do curso que o aluno está
	 * @param telefone o telefone do aluno
	 * @param email o email do aluno
	 */
	public Aluno(String nome, String matricula, int codigoCurso, String telefone, String email, int id) {
		if (nome.trim().equals("") || nome == null) {
			throw new IllegalArgumentException("Erro no cadastro de aluno: Nome nao pode ser vazio ou nulo");
		}
		this.validarParamAlunos(nome, matricula, codigoCurso, telefone, email);
		this.nome = nome;
		this.matricula = matricula;
		this.codigoCurso = codigoCurso;
		this.telefone = telefone;
		this.email = email;
		this.id = id;
		this.tutoria = new Tutoria();
	}
	
	/**
	 * Validador de parâmetros do construtor de Aluno.
	 * Checa se algum deles é vazio ou null.
	 * 
	 * @param nome o nome do aluno
	 * @param matricula a matricula do aluno
	 * @param codigoCurso o código do curso que o aluno está
	 * @param telefone o telefone do aluno
	 * @param email o email do aluno
	 */
	private void validarParamAlunos(String nome, String matricula, int codigoCurso, String telefone, String email) {
		if (matricula == null || telefone == null || email == null) {
			throw new NullPointerException("Parâmetro para construir Aluno não pode ser null");
		}
		if (matricula.trim().equals("") || email.trim().equals("")) {
			throw new IllegalArgumentException("Parâmetro para construir Aluno não pode ser vazio");
		}
		
		int indexArroba = email.indexOf("@"); 
		if (indexArroba == -1 || indexArroba == email.length() - 1 || indexArroba == 0) {
			throw new IllegalArgumentException("Erro no cadastro de aluno: Email invalido");
		}
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
			case "Email":
				return this.email;
			case "Nome":
				return this.nome;
			case "Telefone":
				return this.telefone;
			case "Matricula":
				return this.matricula;
			default:
				throw new IllegalArgumentException("Atributo inexistente.");
		}
	}
	
	/**
	 * Retorna o id do aluno.
	 * 
	 * @return o id do aluno
	 */
	public int getId() {
		return this.id;
	}
	
	/**
	 * Retorna a nota da tutoria do objeto aluno,
	 * caso o mesmo possua ao menos uma tutoria.
	 * 
	 * @return a nota da tutoria do aluno
	 */
	public double getNotaTutoria() {
		if( !(this.possuiTutoria()) ) {
			throw new IllegalArgumentException("O aluno não possui tutoria! Por isso, não possui nota de sua Tutoria.");
		}
		
		return this.tutoria.getNota();
	}
	
	/**
	 * Método utilizado para checar se o aluno em
	 * questão possui ou não ao menos uma tutoria.
	 * 
	 * @return true, caso o aluno possua ao menos uma tutoria
	 */
	public boolean possuiTutoria() {
		return this.tutoria.possuiAlgumaDisciplina();
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
	
	public boolean possuiTutoriaNaDisciplina(String discipĺina) {
		return this.tutoria.possuiDisciplina(discipĺina);
	}
	
    /**
     * Retorna o nível da tutoria desse aluno. Pode ser "TOP", "Tutor" ou "Aprendiz".
     * 
     * @return o nível do tutor, estabelecido conforme a nota do mesmo.
     */	
	public String pegarNivel() {
		return this.tutoria.pegarNivel();
	}	


	/**
     * Adiciona uma nota ao tutor designado para determinada ajuda.
     * 
     * @param nota nota de 0 a 5 dada ao tutor.
     */
	public void avaliarTutor(int nota) {
		this.tutoria.avaliarTutor(nota);		
	}
	
	/**
	 * Recupera a nota de um tutor.
	 * @param matriculaTutor matrícula do tutor.
	 * @return string formatada com duas casas decimais: a nota do tutor.
	 */
	public String pegarNota() {
		if (!this.possuiTutoria()) {
			throw new IllegalAccessError("Erro no pegar nota: Aluno não é tutor");
		}
		return String.format("%.2f", this.tutoria.getNota());
	}
	
	/**
     * Método utilizado para doar quantias em
     * dinheiro para o tutor especificado.
     * 
     * @param dinheiro o total de dinheiro (em centavos) que se deseja doar ao tutor
     */
	public void receberDoacaoTutoria(int dinheiro) {
		this.tutoria.receberDoacao(dinheiro);
	}
	
	/**
     * Retorna a quantidade de dinheiro que o tutor
     * ganhou do sistema até o momento
     * 
     * @return a quantia em dinheiro que ele ganhou até o momento
     */
	public int getDinheiroTutoria() {
		return this.tutoria.getDinheiro();
	}
		
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((matricula == null) ? 0 : matricula.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Aluno other = (Aluno) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (matricula == null) {
			if (other.matricula != null)
				return false;
		} else if (!matricula.equals(other.matricula))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		String info = String.format("%s - %s - %d", this.matricula, this.nome, this.codigoCurso);
		
		if( !this.telefone.equals("") ) info += String.format(" - %s", this.telefone);
		info += String.format(" - %s", this.email);
		
		return info;
	}

	@Override
	public int compareTo(Object outro) {
		Aluno comparado = (Aluno) outro;
		return this.nome.compareTo(comparado.nome);
	}
}