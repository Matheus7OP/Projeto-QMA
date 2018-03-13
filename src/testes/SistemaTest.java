package testes;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.*;

import qma.Sistema;

public class SistemaTest {
	private Sistema sistema;
	private String rep1, rep2, rep3;
	
	@Before
	public void inicializar() {
		this.sistema = new Sistema();
		
		this.sistema.cadastrarAluno("Matheus", "123", 7, "54321", "matheus@ufcg.com");
		this.sistema.cadastrarAluno("Pigmeu", "321", 7, "52341", "pigmeu@ufcg.com");
		this.sistema.cadastrarAluno("Claudio", "213", 10, "", "claudio@ufcg.com");
		
		this.rep1 = "123 - Matheus - 7 - 54321 - matheus@ufcg.com";
		this.rep2 = "321 - Pigmeu - 7 - 52341 - pigmeu@ufcg.com";
		this.rep3 = "213 - Claudio - 10 - claudio@ufcg.com";
	}
	
	@Test
	public void recuperarAlunoTest() {
		assertEquals( this.sistema.recuperaAluno("123"), this.rep1 );
	}
	
	@Test
	public void recuperarAlunoTest2() {
		assertEquals( this.sistema.recuperaAluno("321"), this.rep2 );
	}
	
	@Test
	public void recuperarAlunoTest3() {
		assertEquals( this.sistema.recuperaAluno("213"), this.rep3 );
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void recuperarAlunoTest4() {
		this.sistema.recuperaAluno("1111111111");
	}
	
	@Test
	public void recuperaTutorTest() {
		this.sistema.adicionarTutoria("123", "AA", 2);
		assertEquals( this.sistema.recuperaTutor("123"), rep1 );
	}
	
	@Test
	public void listarTutoresTest() {
		this.sistema.adicionarTutoria("123", "AA", 2);
		this.sistema.adicionarTutoria("321", "AA", 2);
		
		assertEquals( this.sistema.listarTutores(), rep1 + ", " + rep2 );
	}
	
	@Test
	public void listarAlunosTest() {
		assertEquals( this.sistema.listarAlunos(), rep3 + ", " + rep1 + ", " + rep2 );
	}
	
	@Test
	public void getInfoAlunoTest() {
		assertEquals( this.sistema.getInfoAluno("123", "Nome"), "Matheus" );
	}
	
	@Test
	public void getInfoAlunoTest2() {
		assertEquals( this.sistema.getInfoAluno("123", "Matricula"), "123" );
	}
	
	@Test
	public void getInfoAlunoTest3() {
		assertEquals( this.sistema.getInfoAluno("123", "Telefone"), "54321" );
	}
	
	@Test
	public void getInfoAlunoTest4() {
		assertEquals( this.sistema.getInfoAluno("123", "Email"), "matheus@ufcg.com" );
	}
	
	@Test
	public void getInfoAlunoTest5() {
		assertEquals( this.sistema.getInfoAluno("123", "Nome"), "Matheus" );
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void getInfoAlunoTest6() {
		assertEquals( this.sistema.getInfoAluno("123", "Asdfjsdvjh"), "Matheus" );
	}
	
	@Test
	public void salvarERecuperarDadosTest() throws IOException, ClassNotFoundException {
		this.sistema.salvar();
		this.sistema = new Sistema();
		this.sistema.carregar();

		assertEquals( this.sistema.listarAlunos(), rep3 + ", " + rep1 + ", " + rep2 );
		assertEquals( this.sistema.getInfoAluno("123", "Nome"), "Matheus" );
		assertEquals( this.sistema.getInfoAluno("123", "Matricula"), "123" );
		assertEquals( this.sistema.getInfoAluno("123", "Email"), "matheus@ufcg.com" );
		assertEquals( this.sistema.getInfoAluno("123", "Nome"), "Matheus" );
		
		this.sistema.limpar();
	}
	
	
}
