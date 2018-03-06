package qma;

/**
 * Classe que representa, no sistema,
 * um pedido de ajuda do tipo presencial.
 * 
 * @author Matheus Oliveira Pereira
 * @author Gabriel Alves Tavares
 */
public class AjudaPresencial extends Ajuda {
	private String horario, dia;
	private String localInteresse;
	
	/**
	 * Construtor do objeto AjudaPresencial.
	 * 
	 * @param matriculaAluno a matricula do aluno que requer ajuda
	 * @param matriculaTutor a matricula do tutor que irá fornecer ajuda
	 * @param disciplina a disciplina que será tutorada
	 * @param horario o provável horário em que ocorrerá o atendimento
	 * @param dia o provável dia em que ocorrerá o atendimento
	 * @param localInteresse o provável local em que ocorrerá o atendimento
	 */
	public AjudaPresencial(String matriculaAluno, String matriculaTutor, String disciplina, String horario, String dia, String localInteresse) {
		super(matriculaAluno, matriculaTutor, disciplina);
		this.horario = horario;
		this.dia = dia;
		this.localInteresse = localInteresse;
	}

	@Override
	public String getInfoAjuda(String atributo) {
		switch(atributo) {
			case "disciplina":
				return this.getDisciplina();
			case "horario":
				return this.horario;
			case "dia":
				return this.dia;
			case "localInteresse":
				return this.localInteresse;
			default:
				throw new IllegalArgumentException("Atributo inexistente!");
		}
	}

	@Override
	public String pegarTutor() {
		String info = String.format("Tutor - %s, horario - %s, dia - %s, local - %s, disciplina - %s", 
		this.getMatriculaTutor(), this.getInfoAjuda("horario"), this.getInfoAjuda("dia"), this.getInfoAjuda("localInteresse"), this.getDisciplina());
		return info;
	}
}
