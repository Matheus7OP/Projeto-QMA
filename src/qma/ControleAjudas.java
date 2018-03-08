package qma;

import java.util.ArrayList;
import java.util.List;

/**
 * Controller de ajudas armazena, administra e retorna informações
 * sobre as ajudas cadastradas no sistema.
 * 
 * @author Matheus Oliveira Pereira
 * @author Gabriel Alves Tavares
 *
 */
public class ControleAjudas {
	private List<Ajuda> conjuntoAjudas;
	
	public ControleAjudas () {
		this.conjuntoAjudas = new ArrayList <Ajuda>();
	}
	
	private void inserirNovaAjuda(Ajuda ajuda) {
		this.conjuntoAjudas.add(ajuda);
	}
	
	private int getQuantidadeAjudas() {
		return this.conjuntoAjudas.size();
	}
	
    /**
     * Método utilizado para que um aluno cadastre um
     * pedido de ajuda presencial no sistema.
     * 
     * @param matriculaAluno a matricula do aluno que precisa de ajuda
     * @param matriculaTutor matricula do tutor que ajudará
     * @param disciplina a disciplina que o aluno precisa ser ajudado
     * @param horario o horario em que o aluno tem interesse em ser atendido
     * @param dia o dia em que o aluno tem interesse em ser atendido
     * @param localInteresse o local que o aluno tem interesse em ser atendido
     * @return o id do pedido de ajuda
     */
	public int pedirAjudaPresencial(String matriculaAluno, String matriculaTutor, String disciplina, String horario, String dia, String localInteresse) {
		Ajuda novaAjuda = new AjudaPresencial(matriculaAluno, matriculaTutor, disciplina, horario, dia, localInteresse);
		this.inserirNovaAjuda(novaAjuda);
		
		return (this.getQuantidadeAjudas());
	}
	
	/**
     * Método utilizado para que um aluno cadastre um
     * pedido de ajuda online no sistema.
     * 
     * @param matriculaAluno a matricula do aluno que precisa de ajuda
     * @param matriculaTutor matricula do tutor que ajudará
     * @param disciplina a disciplina que o aluno precisa ser ajudado
     * @return o id do pedido de ajuda
     */
	public int pedirAjudaOnline(String matriculaAluno, String matriculaTutor, String disciplina) {
		
		Ajuda novaAjuda = new AjudaOnline(matriculaAluno, matriculaTutor, disciplina);
		this.inserirNovaAjuda(novaAjuda);
		
		return (this.getQuantidadeAjudas());
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
		this.validarIdAjuda(idAjuda, "Erro ao tentar recuperar tutor ");
		return this.conjuntoAjudas.get(idAjuda - 1).pegarTutor();
	}
	
	/**
	 * Recupera a matrícula do tutor a partir do id da ajuda
	 * a qual ele está tutorando.
	 * 
	 * @param idAjuda o id da ajuda
	 * @return matrícula do tutor responsável pela ajuda
	 */
	public String getMatriculaTutor(int idAjuda) {
		this.validarIdAjuda(idAjuda, "Erro na avaliacao de tutor");
		return this.conjuntoAjudas.get(idAjuda - 1).getMatriculaTutor();
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
		this.validarIdAjuda(idAjuda, "Erro ao tentar recuperar info da ajuda ");
		if (atributo.trim().equals("")) {
			throw new IllegalArgumentException("Erro ao tentar recuperar info da ajuda : atributo nao pode ser vazio ou em branco");
		}
		return this.conjuntoAjudas.get(idAjuda - 1).getInfoAjuda(atributo);
	}

	/**
	 * Método utilizado apra verificação se essa tutoria já foi avaliada.
	 * 
	 * @param idAjuda id da ajuda
	 * @return true, se foi avaliada.
	 */
	public boolean getFoiAvaliada(int idAjuda) {
		return this.conjuntoAjudas.get(idAjuda - 1).getFoiAvaliada();
	}

	/**
	 * Método que determina como true o atributo que indica se essa
	 * tutoria foi avaliada ou não.
	 * 
	 * @param idAjuda id da ajuda
	 */
	public void avaliar(int idAjuda) {
		this.conjuntoAjudas.get(idAjuda - 1).confirmarAvaliacao();
	}

	private void validarIdAjuda(int id, String mensagemErro) {
		if (id < 0) {
			throw new IllegalArgumentException(mensagemErro + ": id nao pode menor que zero ");
		}
		if (id > this.getQuantidadeAjudas()) {
			throw new IllegalArgumentException(mensagemErro + ": id nao encontrado ");
		}
	}
	
}
