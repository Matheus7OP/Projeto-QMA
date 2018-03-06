package qma;

import java.util.ArrayList;
import java.util.List;

public class ControleAjudas {
	private List<Ajuda> conjuntoAjudas;
	
	public ControleAjudas () {
		this.conjuntoAjudas = new ArrayList <Ajuda>();
	}
	
	private void inserirNovaAjuda(Ajuda ajuda) {
		this.conjuntoAjudas.add(ajuda);
	}
	
	private int getQuantidadeAjudas() {
		return this.conjuntoAjudas.size();
	}
	
	public int pedirAjudaPresencial(String matriculaAluno, String matriculaTutor, String disciplina, String horario, String dia, String localInteresse) {
		Ajuda novaAjuda = new AjudaPresencial(matriculaAluno, matriculaTutor, disciplina, horario, dia, localInteresse);
		this.inserirNovaAjuda(novaAjuda);
		
		return (this.getQuantidadeAjudas());
	}
	
	public int pedirAjudaOnline(String matriculaAluno, String matriculaTutor, String disciplina) {
		Ajuda novaAjuda = new AjudaOnline(matriculaAluno, matriculaTutor, disciplina);
		this.inserirNovaAjuda(novaAjuda);
		
		return (this.getQuantidadeAjudas());
	}
	
	public String pegarTutor(int idAjuda) {
		return this.conjuntoAjudas.get(idAjuda - 1).pegarTutor();
	}
	
	public String getInfoAjuda(int idAjuda, String atributo) {
		return this.conjuntoAjudas.get(idAjuda - 1).getInfoAjuda(atributo);
	}
	
}