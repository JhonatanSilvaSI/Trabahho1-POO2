import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ConexaoBancoDeDados {
	
	private Connection conexao;
	private final String URL_Bancodedados = "jdbc:mysql://localhost:3306/trabalho1";
	private final String usuario = "root";
	private final String senha = "admin";
	
	private void IniciarConexao() {
		try {Class.forName("com.mysql.cj.jdbc.Driver");
		conexao = DriverManager.getConnection(URL_Bancodedados,usuario,senha);
		System.out.println("Conexão realizada com sucesso");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Erro ao acessar o Banco de Dados!");
		}
	}
	
	private void EncerrarConexao() throws SQLException {
		
		if (conexao != null)
			conexao.close();
	}
	
	public String InserirDados(Aluno ObjetoAluno) throws SQLException{
		IniciarConexao();
		
		if(conexao != null) {
			
			PreparedStatement psInsert = conexao.prepareStatement("Insert into aluno(nome,endereco, telefone,cpf,tiposanguineo, contatoemergencia, telefoneemergencia, tipocurso, fatorRH) Values(?,?,?,?,?,?,?,?,?)");
			psInsert.setString(1, ObjetoAluno.getNome());
			psInsert.setString(2, ObjetoAluno.getEndereco());
			psInsert.setString(3, ObjetoAluno.getTelefone());
			psInsert.setString(4, ObjetoAluno.getCPF());
			psInsert.setString(5, ObjetoAluno.getTipoSanguineo());
			psInsert.setString(6, ObjetoAluno.getContatoEmergencia());
			psInsert.setString(7, ObjetoAluno.getTelefoneEmergencia());		
			psInsert.setString(8, ObjetoAluno.getTipoCurso());
			psInsert.setString(9, ObjetoAluno.getFatorRH());
			psInsert.execute();
			
			EncerrarConexao();
			
			return "Cadastro realizado com sucesso!";
		}
		else return "Erro ao realizar cadastro. Tente novamente!";
	}	
	
	public String AlterarDados(Aluno ObjetoAluno,int id) throws SQLException{
		
		IniciarConexao();
		
		if(conexao != null) {
			
			PreparedStatement comandoupdate = conexao.prepareStatement("UPDATE Aluno set nome = ?, endereco = ?, telefone = ?, cpf = ?, tiposanguineo = ?, contatoemergencia = ?, telefoneemergencia = ?, tipocurso = ?, fatorRH = ? WHERE id = ?");
			
			comandoupdate.setString(1, ObjetoAluno.getNome());
			comandoupdate.setString(2, ObjetoAluno.getEndereco());
			comandoupdate.setString(3, ObjetoAluno.getTelefone());
			comandoupdate.setString(4, ObjetoAluno.getCPF());
			comandoupdate.setString(5, ObjetoAluno.getTipoSanguineo());
			comandoupdate.setString(6, ObjetoAluno.getContatoEmergencia());
			comandoupdate.setString(7, ObjetoAluno.getTelefoneEmergencia());	
			comandoupdate.setString(8, ObjetoAluno.getTipoCurso());
			comandoupdate.setString(9, ObjetoAluno.getFatorRH());
			comandoupdate.setInt(9,id);
			comandoupdate.execute();
			
			EncerrarConexao();
			return "Dados alterados com sucesso!";
		}
		else return "Erro ao acessar o Banco de Dados. Tente novamente!";
	}
	
	public String RemoverDados(int id) throws SQLException{
		IniciarConexao();
		
		if(conexao != null) {
			
			PreparedStatement comandoupdate = conexao.prepareStatement("DELETE FROM aluno where id = ?");
			comandoupdate.setInt(1, id);
			comandoupdate.execute();
			
			EncerrarConexao();
			return "Remoção realizada com sucesso!";
		}
		else return "Erro, Alteração não realizada";
	}
	
	public ArrayList<String> Relatorio() throws SQLException{
		IniciarConexao();
		
		ArrayList<String> relatorioBancoDeDados = new ArrayList<String>();
		
		if(conexao != null) {
			
			Statement comandoconsulta = conexao.createStatement();
			ResultSet resultadoconsultaBD = comandoconsulta.executeQuery("SELECT * FROM aluno");
			String resultado;
			String nome;
			String endereco;
			String telefone;
			String cpf;
			String tiposanguineo;
			String contatoemergencia;
			String telefoneemergencia;
			String tipocurso;
			String fatorRH;
			String id;
			while(resultadoconsultaBD.next()) {
				
				nome = resultadoconsultaBD.getString("nome");
				endereco = resultadoconsultaBD.getString("endereco");
				telefone = resultadoconsultaBD.getString("telefone");
				cpf = resultadoconsultaBD.getString("CPF");
				tiposanguineo = resultadoconsultaBD.getString("TipoSanguineo");
				contatoemergencia = resultadoconsultaBD.getString("ContatoEmergencia");
				telefoneemergencia = resultadoconsultaBD.getString("TelefoneEmergencia");
				tipocurso = resultadoconsultaBD.getString("TipoCurso");
				fatorRH = resultadoconsultaBD.getNString("FatorRH");
				id = resultadoconsultaBD.getString("ID");
				
				resultado = "# ID: " + id + "Nome: " + nome + " Endereço: " + endereco + " Telefone: " + telefone + "CPF: " + cpf + "TipoSanguineo: " + tiposanguineo + "Contato de Emergencia: " + contatoemergencia + "Telefone de Emergencia: " + telefoneemergencia +  "Curso: " + tipocurso + "FatorRH: "+ fatorRH;
				relatorioBancoDeDados.add(resultado);
			}
			
			EncerrarConexao();
			
			return relatorioBancoDeDados;
		}
		return null;
	}
}
