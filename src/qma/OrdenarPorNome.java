package qma;

import java.util.Comparator;

/**
 * Classe utilizada para implementar o método
 * de comparação entre Alunos pelo seu atributo
 * nome.
 * 
 * @author Matheus Oliveira Pereira
 * @author Gabriel Alves Tavares
 */
public class OrdenarPorNome implements Comparator<Aluno> {
	@Override
	public int compare(Aluno primeiro, Aluno segundo) {
		String nomePrimeiro = primeiro.getInfoAluno("Nome");
		String nomeSegundo = segundo.getInfoAluno("Nome");
		
		if( nomePrimeiro.compareTo(nomeSegundo) == 0 ) {
			String matriculaPrimeiro = primeiro.getInfoAluno("Matricula");
			String matriculaSegundo = segundo.getInfoAluno("Matricula");
			
			return matriculaPrimeiro.compareTo(matriculaSegundo);
		}
		
		return nomePrimeiro.compareTo(nomeSegundo);
	}
}
