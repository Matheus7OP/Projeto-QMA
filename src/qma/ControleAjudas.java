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
		this.validarIdAjuda(idAjuda, "Erro ao tentar recuperar tutor ");
		return this.conjuntoAjudas.get(idAjuda - 1).pegarTutor();
	}
	
	public String getMatriculaTutor(int idAjuda) {
		this.validarIdAjuda(idAjuda, "Erro na avaliacao de tutor");
		return this.conjuntoAjudas.get(idAjuda - 1).getMatriculaTutor();
	}
	
	public String getInfoAjuda(int idAjuda, String atributo) {		
		this.validarIdAjuda(idAjuda, "Erro ao tentar recuperar info da ajuda ");
		if (atributo.trim().equals("")) {
			throw new IllegalArgumentException("Erro ao tentar recuperar info da ajuda : atributo nao pode ser vazio ou em branco");
		}
		return this.conjuntoAjudas.get(idAjuda - 1).getInfoAjuda(atributo);
	}
	
	private void validarIdAjuda(int id, String mensagemErro) {
		if (id < 0) {
			throw new IllegalArgumentException(mensagemErro + ": id nao pode menor que zero ");
		}
		if (id > this.getQuantidadeAjudas()) {
			throw new IllegalArgumentException(mensagemErro + ": id nao encontrado ");
		}
	}

	public boolean getFoiAvaliada(int idAjuda) {
		return this.conjuntoAjudas.get(idAjuda - 1).getFoiAvaliada();
	}

	public void avaliar(int idAjuda) {
		this.conjuntoAjudas.get(idAjuda - 1).avaliar();
	}
	
}
