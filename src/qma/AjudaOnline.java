package qma;

/**
 * Classe que representa, no sistema,
 * um pedido de ajuda do tipo online.
 * 
 * @author Matheus Oliveira Pereira
 * @author Gabriel Alves Tavares
 */
public class AjudaOnline extends Ajuda{
	/**
	 * Construtor do objeto AjudaOnline.
	 * 
	 * @param matriculaAluno a matricula do aluno que requisitou a ajuda
	 * @param matriculaTutor a matricula do tutor que está responsável pela ajuda
	 * @param disciplina a disciplina que será tutorada
	 */
	public AjudaOnline(String matriculaAluno, String matriculaTutor, String disciplina) {
		super(matriculaAluno, matriculaTutor, disciplina);
	}

	@Override
	public String getInfoAjuda(String atributo) {
		switch(atributo) {
			case "disciplina":
				return this.getDisciplina();
			default:
				throw new IllegalArgumentException("Erro ao tentar recuperar info da ajuda : atributo nao encontrado");
		}
	}

	@Override
	public String pegarTutor() {
		String info = String.format("Tutor - %s, disciplina - %s", this.getMatriculaTutor(), this.getDisciplina());
		return info;
	}
}
