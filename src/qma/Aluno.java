package qma;

public class Aluno {
	private Tutoria tutoria;
	private String nome, matricula, telefone, email;
	private int codigoCurso, nota;
	
	public Aluno(String nome, String matricula, int codigoCurso, String telefone, String email) {
		this.nome = nome;
		this.matricula = matricula;
		this.codigoCurso = codigoCurso;
		this.telefone = telefone;
		this.email = email;
		this.tutoria = new Tutoria();
	}
	
	public String getInfoAluno(String atributo) {		
		switch(atributo) {
			case "email":
				return this.email;
			case "nome":
				return this.nome;
			case "telefone":
				return this.telefone;
      default:
				throw new IllegalArgumentException("Atributo inexistente.");
		}
	}
	
	/**
	 * Método utilizado para checar se o aluno em
	 * questão possui ou não ao menos uma tutoria.
	 * 
	 * @return true, caso o aluno possua ao menos uma tutoria
	 */
	public boolean possuiTutoria() {
		return this.tutoria.possuiDisciplina();
	}
	
	public void adicionarTutoria(String disciplina, int proficiencia) {
		this.tutoria.cadastrarDisciplina(disciplina, proficiencia);
	}
	
	public void cadastrarHorarioDeAtendimento(String horario, String dia) {
		this.tutoria.cadastrarHorarioDeAtendimento(horario, dia);
	}

	public void cadastrarLocalDeAtendimento(String local) {
		this.tutoria.cadastrarLocalDeAtendimento(local);
	}

	public boolean consultaLocal(String local) {
		return this.tutoria.consultaLocal(local);
	}
	
	public boolean consultaHorario(String horario, String dia) {
		return this.tutoria.consultaHorario(horario, dia);
	}
	
	@Override
	public String toString() {
		String info = String.format("%s - %s - %d", this.matricula, this.nome, this.codigoCurso);
		
		if( !this.telefone.equals("") ) info += String.format(" - %s", this.telefone);
		info += String.format(" - %s", this.email);
		
		return info;
	}
}