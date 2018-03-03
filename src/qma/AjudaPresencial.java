package qma;

public class AjudaPresencial extends Ajuda {
	
	private String horario;
	private String dia;
	private String localInteresse;
	
	public AjudaPresencial(String matricula, String disciplina, String horario, String dia, String localInteresse) {
		super(matricula, disciplina);
		this.horario = horario;
		this.dia = dia;
		this.localInteresse = localInteresse;
	}

}
