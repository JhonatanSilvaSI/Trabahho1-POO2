
public class Aluno {
	
	private String Nome;
	private String Endereco;
	private String Telefone;
	private String CPF;
	private String TipoSanguineo;
	private String FatorRH;
	private String TipoCurso;
	private String ContatoEmergencia;
	private String TelefoneEmergencia;
	private int id;
	
	public Aluno(String Nome, String Endereco, String Telefone, String CPF, String TipoCurso, String ContatoEmergencia,
			String TelefoneEmeregencia, String TipoSanguineo, String FatorRH) {
		
		this.Nome = Nome;
		this.Endereco = Endereco;
		this.Telefone = Telefone;
		this.CPF = CPF;
		this.TipoSanguineo = TipoSanguineo;
		this.FatorRH = FatorRH;
		this.TipoCurso = TipoCurso;
		this.ContatoEmergencia = ContatoEmergencia;
		this.TelefoneEmergencia = TelefoneEmergencia;
		
	}

	public String getNome(){
		return Nome;
	}
	
	public String getEndereco() {
		return Endereco;
	}
	
	public String getTelefone() {
		return Telefone;
	}
	
	public String getCPF() {
		return CPF;
	}
	
	public String getTipoSanguineo() {
		return TipoSanguineo;
	}
	
	public String getFatorRH() {
		return FatorRH;
	}
	
	public String getTipoCurso() {
		return TipoCurso;
	}
	
	public String getContatoEmergencia() {
		return ContatoEmergencia;
	}
	
	public String getTelefoneEmergencia() {
		return TelefoneEmergencia;
	}

}
