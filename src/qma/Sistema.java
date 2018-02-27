package qma;

public class Sistema {
	private ControleAlunos controleAlunos;
	
	public Sistema() {
		this.controleAlunos = new ControleAlunos();
	}
	
	public String recuperaTutor(String matricula) {
		return this.controleAlunos.recuperaTutor(matricula);
	}

	public void cadastrarAluno(String nome, String matricula, int codigoCurso, String telefone, String email) {
		this.controleAlunos.cadastrarAluno(nome, matricula, codigoCurso, telefone, email);
	}

	public String listarTutores() {
		return this.controleAlunos.listarTutores();
	}

	public void adicionarTutoria(String matricula, String disciplina, int proficiencia) {
		this.controleAlunos.adicionarTutoria(matricula, disciplina, proficiencia);
	}

	public void cadastrarHorario(String email, String horario, String dia) {
		this.controleAlunos.cadastrarHorario(email, horario, dia);
	}

	public void cadastrarLocalDeAtendimento(String email, String local) {
		// TODO Auto-generated method stub
		
	}

	public boolean consultaHorario(String email, String horario, String dia) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean consultaLocal(String email, String local) {
		// TODO Auto-generated method stub
		return false;
	}
}