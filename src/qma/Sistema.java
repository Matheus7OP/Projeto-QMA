package qma;

public class Sistema {
	
	public void cadastrarAluno(String nome, String matricula, int codigoCurso, String telefone, String email) {
		Funcao funcao = new Aluno(nome, matricula, codigoCurso, telefone, email);
		
	}
}
