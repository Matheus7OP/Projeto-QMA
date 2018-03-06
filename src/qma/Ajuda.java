package qma;

public abstract class Ajuda {
	private String matriculaAluno, matriculaTutor;
	private String disciplina;
	
	public Ajuda(String matriculaAluno, String matriculaTutor, String disciplina){
		this.matriculaAluno = matriculaAluno;
		this.matriculaTutor = matriculaTutor;
		this.disciplina = disciplina;
	}
	
	public abstract String getInfoAjuda(String atributo);
	
	public String getDisciplina() {
		return this.disciplina;
	}
	
	public String pegarTutor() {
		return this.matriculaTutor;
	}
}
