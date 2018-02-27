package qma;

import java.util.ArrayList;
import java.util.List;

public class ControleAlunos {
	private List<Aluno> conjuntoAlunos;
	
	public ControleAlunos() {
		this.conjuntoAlunos = new ArrayList<Aluno>();
	}
	
	public void cadastrarAluno(String nome, String matricula, int codigoCurso, String telefone, String email) {
		Aluno aluno = new Aluno(nome, matricula, codigoCurso, telefone, email);
		this.conjuntoAlunos.add(aluno);
	}
	
	public void adicionarTutoria(String matricula, String disciplina, int proficiencia) {}
}
