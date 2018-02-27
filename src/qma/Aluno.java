package qma;

public class Aluno {
	private Tutoria tutoria;
	private String nome, matricula, telefone, email;
	private int codigoCurso, nota;
	
	public Aluno(String nome, String matricula, int codigoCurso, String telefone, String email) {
		this.nome = nome;
		this.matricula = matricula;
		this.codigoCurso = codigoCurso;
		this.telefone = telefone;
		this.email = email;
		this.tutoria = new Tutoria();
	}

}