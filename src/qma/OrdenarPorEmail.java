package qma;

import java.util.Comparator;

/**
 * Classe utilizada para implementar o método
 * de comparação entre Alunos pelo seu atributo
 * email.
 * 
 * @author Matheus Oliveira Pereira
 * @author Gabriel Alves Tavares
 */
public class OrdenarPorEmail implements Comparator<Aluno> {
	@Override
	public int compare(Aluno primeiro, Aluno segundo) {
		String emailPrimeiro = primeiro.getInfoAluno("Email");
		String emailSegundo = segundo.getInfoAluno("Email");
		
		if( emailPrimeiro.compareTo(emailSegundo) == 0 ) {
			String matriculaPrimeiro = primeiro.getInfoAluno("Matricula");
			String matriculaSegundo = segundo.getInfoAluno("Matricula");
			
			return matriculaPrimeiro.compareTo(matriculaSegundo);
		}
		
		return emailPrimeiro.compareTo(emailSegundo);
	}
}
