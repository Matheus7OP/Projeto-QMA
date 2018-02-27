package qma;
import easyaccept.EasyAccept;

public class Facade {
	private Sistema sistema;
	
	public static void main(String[] args) {
		args = new String[] {"qma.Facade", "acceptanceTest/us1_test.txt", "acceptanceTest/us2_test.txt", "acceptanceTest/us3_test.txt"};
		EasyAccept.main(args);
	}
	
	public void inicializar() {
		this.sistema = new Sistema();
	}
	
	public void cadastrarAluno(String nome, String matricula, int codigoCurso, String telefone, String email) {
		this.sistema.cadastrarAluno(nome, matricula, codigoCurso, telefone, email);
	}
	
	public void tornarTutor(String matricula, String disciplina, int proficiencia) {
		this.sistema.adicionarTutoria(matricula, disciplina, proficiencia);
	}
}
