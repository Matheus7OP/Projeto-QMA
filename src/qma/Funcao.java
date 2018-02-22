package qma;

public class Funcao <Abstract> {
	private String nome, matricula, telefone, email;
	private int codigoCurso;
	
	public Funcao(String nome, String matricula, int codigoCurso, String telefone, String email) {
		this.nome = nome;
		this.matricula = matricula;
		this.codigoCurso= codigoCurso;
		this.telefone = telefone;
		this.email = email;		
	}
}
