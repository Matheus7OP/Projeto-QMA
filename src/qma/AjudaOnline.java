package qma;

public class AjudaOnline extends Ajuda{
	public AjudaOnline(String matriculaAluno, String matriculaTutor, String disciplina) {
		super(matriculaAluno, matriculaTutor, disciplina);
	}

	@Override
	public String getInfoAjuda(int idAjuda, String atributo) {
		switch(atributo) {
			case "disciplina":
				return this.getDisciplina();
			default:
				throw new IllegalArgumentException("Atributo inexistente!");
		}
	}
}
