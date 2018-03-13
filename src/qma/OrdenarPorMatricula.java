package qma;

import java.util.Comparator;

/**
 * Classe utilizada para implementar o método
 * de comparação entre Alunos pelo seu atributo
 * matricula.
 * 
 * @author Matheus Oliveira Pereira
 * @author Gabriel Alves Tavares
 */
public class OrdenarPorMatricula implements Comparator<Aluno> {
	@Override
	public int compare(Aluno primeiro, Aluno segundo) {
		String matriculaPrimeiro = primeiro.getInfoAluno("Matricula");
		String matriculaSegundo = segundo.getInfoAluno("Matricula");
		
		return matriculaPrimeiro.compareTo(matriculaSegundo);
	}
}
