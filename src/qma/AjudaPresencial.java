package qma;

public class AjudaPresencial extends Ajuda {
	private String horario, dia;
	private String localInteresse;
	
	public AjudaPresencial(String matriculaAluno, String matriculaTutor, String disciplina, String horario, String dia, String localInteresse) {
		super(matriculaAluno, matriculaTutor, disciplina);
		this.horario = horario;
		this.dia = dia;
		this.localInteresse = localInteresse;
	}

	@Override
	public String getInfoAjuda(int idAjuda, String atributo) {
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
}
