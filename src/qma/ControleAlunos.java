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
	
	private Aluno getAluno(String desejado, String atributo) {
		int quantidadeAlunos = this.getQuantidadeAlunos();
		
		for(int i = 0; i < quantidadeAlunos; i++) {
			if( this.conjuntoAlunos.get(i).getInfoAluno(atributo).equals(desejado) ) {
				return this.conjuntoAlunos.get(i);
			}
		}
		
		throw new IllegalArgumentException("Matricula não cadastrada no sistema.");
	}
	
	public void adicionarTutoria(String matricula, String disciplina, int proficiencia) {
		this.getAluno(matricula, "matricula").adicionarTutoria(disciplina, proficiencia);
	}

	public String listarTutores() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public int getQuantidadeAlunos() {
		return this.conjuntoAlunos.size();
	}
	
	public String recuperaAluno(String matricula) {
		return this.getAluno(matricula, "matricula").toString();
	}

	public String recuperaTutor(String matricula) {
		// TODO Auto-generated method stub
		return null;
	}

	public void cadastrarHorario(String email, String horario, String dia) {
		this.getAluno(email, "email").cadastrarHorarioDeAtendimento(horario, dia);	
	}
}
