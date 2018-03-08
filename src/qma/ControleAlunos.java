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
		Aluno aluno = new Aluno(nome, matricula, codigoCurso, telefone, email, this.getQuantidadeAlunos());
		
		if( this.containsAluno(matricula, "Matricula") ) {
			throw new IllegalArgumentException("Erro no cadastro de aluno: Aluno de mesma matricula ja cadastrado");
		}
		
		this.conjuntoAlunos.add(aluno);
	}
	
	/**
	 * Método utilizado para recuperar determinado aluno
	 * que está presente no controle, a partir de um de seus
	 * atributos (email, nome ou telefone).
	 * 
	 * @param desejado o valor que é desejado encontrar em determinado atributo do aluno
	 * @param atributo o atributo do aluno a ser verificado
	 * @param a mensagem de erro a ser retornada
	 * @return o objeto aluno que possui valor desejado para o atributo designado
	 */
	private Aluno getAluno(String desejado, String atributo, String mensagemErro) {

		for (Aluno aluno : this.conjuntoAlunos) {
			if( aluno.getInfoAluno(atributo).equals(desejado) ) {
				return aluno;
			}
		}
		
		throw new IllegalArgumentException(mensagemErro);
	}
	
	/**
	 * Método utilizado para verificar se aluno com determinado
	 * atributo está cadastrado no controle.
	 * 
	 * @param desejado o atributo desejado na busca
	 * @param atributo o tipo de atributo a ser procurado
	 * @return true, caso o aluno esteja presente no controle
	 */
	private boolean containsAluno(String desejado, String atributo) {
		int quantidadeAlunos = this.getQuantidadeAlunos();
		
		for(int i = 0; i < quantidadeAlunos; i++) {
			if( this.conjuntoAlunos.get(i).getInfoAluno(atributo).equals(desejado) ) {
				return true;
			}
		}
		
		return false;
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
		this.getAluno(matricula, "Matricula", "Erro na definicao de papel: Tutor nao encontrado").adicionarTutoria(disciplina, proficiencia);
	}
	
	
	/**
     * Lista todos os tutores cadastrados.
     * 
     * @return toString de todos os tutores, separados por linha.
     */
	public String listarTutores() {
		String info = "";
		
		int quantidadeAlunos = this.getQuantidadeAlunos();
		
		for(int i = 0; i < quantidadeAlunos; i++) {
			if( this.conjuntoAlunos.get(i).possuiTutoria() ) {
				if (!info.equals("")) info += ", ";
				info += this.conjuntoAlunos.get(i).toString();
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
		return this.getAluno(matricula, "Matricula", "Erro na busca por aluno: Aluno nao encontrado").toString();
	}
	
	/**
	 * Retorna a representação textual de um tutor a partir de sua matrícula.
	 * 
	 * @param matricula matricula do tutor.
	 * @return toString do tutor.
	 */
	public String recuperaTutor(String matricula) {
		Aluno aluno = this.getAluno(matricula, "Matricula", "Erro na busca por tutor: Tutor nao encontrado");
		
		if (!aluno.possuiTutoria()) {
			throw new IllegalAccessError("Erro ao recuperar tutor: Aluno não é um tutor");
		}
		
		return aluno.toString();
	}
	
	/**
	 * Cadastra um novo horário de atendimento para um tutor.
	 * 
	 * @param email email do tutor.
	 * @param horario horário de atendimento.
	 * @param dia dia da semana disponível para o horário de atendimento.
	 */
	public void cadastrarHorario(String email, String horario, String dia) {
		if (email.trim().equals("")) {
			throw new IllegalArgumentException("Erro no cadastrar horario: email nao pode ser vazio ou em branco");
		}
		this.getAluno(email, "Email", "Erro no cadastrar horario: tutor nao cadastrado").cadastrarHorarioDeAtendimento(horario, dia);	
	}
	
	/**
     * Cadastra um novo local de atendimento para o tutor.
     * 
     * @param email email do tutor.
     * @param local local disponível para atendimento.
     */
	public void cadastrarLocalDeAtendimento(String email, String local) {
		if (email.trim().equals("")) {
			throw new IllegalArgumentException("Erro no cadastrar local de atendimento: email nao pode ser vazio ou em branco");
		}
		if (local.trim().equals("")) {
			throw new IllegalArgumentException("Erro no cadastrar local de atendimento: local nao pode ser vazio ou em branco");
		}
		this.getAluno(email, "Email", "Erro no cadastrar local de atendimento: tutor nao cadastrado").cadastrarLocalDeAtendimento(local);
	}
	
	/**
     * Consulta se um local de atendimento está cadastrado para determinado tutor. 
     * 
     * @param email email do tutor.
     * @param local local de atendimento consultado.
     * @return true, caso o local estiver disponível para o tutor especificado.
     */
	public boolean consultaLocal(String email, String local) {
		if( !this.containsAluno(email, "Email") ) return false;
		return this.getAluno(email, "Email", "Erro na consulta de local: Aluno nao encontrado").consultaLocal(local);
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
		if( !this.containsAluno(email, "Email") ) return false;
		return this.getAluno(email, "Email", "Erro na consulta de horario: Aluno nao encontrado").consultaHorario(horario, dia);
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
		
		return this.getAluno(matricula, "Matricula", "Erro na obtencao de informacao de aluno: Aluno nao encontrado").getInfoAluno(atributo);
	}

	/**
     * Lista todos os alunos cadastrados.
     * 
     * @return toString de todos os alunos, separados por vírgula.
     */
	public String listarAlunos() {
		ArrayList <Aluno> listaOrdenada = new ArrayList <Aluno> (this.conjuntoAlunos); 
		
		listaOrdenada.sort(null);
		
		String listaAlunos = "";		
		int quantidadeAlunos = this.getQuantidadeAlunos();
		
		for(int i = 0; i < quantidadeAlunos; i++) {
			if (i > 0) listaAlunos += ", ";
			listaAlunos += listaOrdenada.get(i).toString();
		}
		
		return listaAlunos;
	}

	/**
	 * Recupera a nota de um tutor.
	 * 
	 * @param matriculaTutor matrícula do tutor.
	 * @return string formatada com duas casas decimais: a nota do tutor.
	 */
	public String pegarNota(String matriculaTutor) {
		return this.getAluno(matriculaTutor, "Matricula", "Erro no pegar nivel: Tutor nao encontrado").pegarNota();
	}

    /**
     * Retorna o nível do tutor. Pode ser "TOP", "Tutor" ou "Aprendiz".
     * 
     * @param matriculaTutor matrícula do tutor.
     * @return o nível do tutor, estabelecido conforme a nota do mesmo.
     */	
	public String pegarNivel(String matriculaTutor) {
		return this.getAluno(matriculaTutor, "Matricula", "Erro no pegar nivel: Tutor nao encontrado.").pegarNivel(); 
	}

	/**
     * Adiciona uma nota ao tutor designado para determinada ajuda.
     * 
     * @param idAjuda id da ajuda.
     * @param nota nota de 0 a 5 dada ao tutor.
     */
	public void avaliarTutor(String matriculaTutor, int nota) {
		int idTutor = this.getAluno(matriculaTutor, "Matricula", "Erro no avaliar tutor: Tutor nao cadastrado.").getId();
		
		this.conjuntoAlunos.get(idTutor).avaliarTutor(nota);
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
		Aluno melhorTutor = null;
		
		for(Aluno aluno : this.conjuntoAlunos) {
			if( melhorTutor == null && aluno.possuiTutoriaNaDisciplina(disciplina) ) {
				melhorTutor = aluno;
				continue;
			}
			
			if( aluno.possuiTutoria() ) {
				if( aluno.possuiTutoriaNaDisciplina(disciplina) ) {
					
					if( melhorTutor.getNotaTutoria() == aluno.getNotaTutoria() ) {
						if( melhorTutor.getId() > aluno.getId() ) {
							melhorTutor = aluno;
						}
					}
					else {
						if( melhorTutor.getNotaTutoria() < aluno.getNotaTutoria() ) {
							melhorTutor = aluno;
						}
					}
				}
			}
		}
		
		if(melhorTutor == null) {
			throw new IllegalArgumentException("Não existe tutor disponível");
		}
		
		return melhorTutor.getInfoAluno("Matricula");
	}

	/**
	 * Calcula a taxa (a porcentagem) que será destinada ao tutor 
	 * da doação àquela tutoria. O cálculo é baseado no nível do tutor:
	 * Se "TOP", o total recebido é 90% da doação + 1% por décimo acima de 4.5 (ex.: nota 4.7, ele recebe 92%).
	 * Se "Tutor", o total recebido é 80% da doação 
	 * Se "Aprendiz", o total recebido 40% da doação subtraido de 1% por décimo abaixo de 3.0 (exemplo, nota 2 ele recebe 30%) 
	 * 
	 * @param matriculaTutor matrícula do tutor
	 * @return a taxa (a porcentagem) que será destinada ao tutor 
	 */
	public double taxaTutor(String matriculaTutor) {
		Aluno tutor = this.getAluno(matriculaTutor, "Matricula", "Erro na doacao para tutor: Tutor nao encontrado");
		double taxaTutor, adicional, notaTutoria;
		
		String classificacaoTutor;
		classificacaoTutor = tutor.pegarNivel();
		
		notaTutoria = tutor.getNotaTutoria();
		
		if( classificacaoTutor.equals("TOP") ) {
			adicional = (notaTutoria - 4.5);
			adicional *= 10.0;
			
			adicional = Math.round(adicional);
			adicional /= 10.0;
			
			taxaTutor = 0.9 + adicional;
		}
		else {
			if( classificacaoTutor.equals("Tutor") ) {
				taxaTutor = 0.8;
			}
			else {
				adicional = (3.0 - notaTutoria);
				adicional -= 0.2;
				
				taxaTutor = 0.4 - adicional;
			}
		}
		
		return taxaTutor;
	}
	
	/**
     * Método utilizado para doar quantias em
     * dinheiro para o tutor especificado.
     * 
     * @param matriculaTutor a matricula do tutor que se deseja doar
     * @param dinheiro o total de dinheiro (em centavos) que se deseja doar ao tutor
     */
	public void doarAoTutor(String matriculaTutor, int dinheiro) {
		int idAluno = this.getAluno(matriculaTutor, "Matricula", "Erro na doacao para tutor: Tutor nao encontrado").getId();
		this.conjuntoAlunos.get(idAluno).receberDoacaoTutoria(dinheiro);
	}


	/**
     * Retorna a quantidade de dinheiro que o tutor
     * ganhou do sistema até o momento
     * 
     * @param emailTutor o email do tutor que deseja-se verificar
     * @return a quantia em dinheiro que ele ganhou até o momento
     */
	public int totalDinheiroTutor(String emailTutor) {
		if (emailTutor.trim().equals("")) {
			throw new IllegalArgumentException("Erro na consulta de total de dinheiro do tutor: emailTutor nao pode ser vazio ou nulo");
		}
		return this.getAluno(emailTutor, "Email", "Erro na consulta de total de dinheiro do tutor: Tutor nao encontrado").getDinheiroTutoria();
	}
}
