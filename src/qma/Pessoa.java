package qma;

public class Pessoa {
	private String nome, matricula, telefone, email;
	private int codigoCurso;
	private Funcao funcao;
	
	public Pessoa(String nome, String matricula, int codigoCurso, String telefone, String email, Funcao funcao) {
		this.funcao = funcao;
		this.nome = nome;
		this.matricula = matricula;
		this.codigoCurso= codigoCurso;
		this.telefone = telefone;
	}
	
	public void tornarTutor() {
		// torna tutor com excecoes se for tutor
	}
		
	// “Matricula - Nome - CódigoCurso - telefone - email”
	@Override
	public String toString() {
		String info = String.format("%s - %s - %s", this.matricula, this.nome, this.codigoCurso);
		
		if (!telefone.equals("")) info += " - " + this.telefone;
		info += " - " + this.email;
		
		return info;
	}
}
