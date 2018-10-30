package project;

public class Cliente {
	private String cpf;
	private String nome;
	private String email;
	private String localizacao;

	Cliente(String cpf,String nome,String email,String localizacao){
		this.cpf = cpf;
		EditaClienteNome(nome);
		EditaClienteEmail(email);
		EditaClienteLocalizacao(localizacao);
	}
	
	private String getCpf() {
		return cpf;
	}
	
	private String getNome() {
		return nome;
	}
	
	private String getEmail() {
		return email;
	}
	
	private String getLocalizacao() {
		return localizacao;
	}
	
	public void EditaClienteNome(String nome) {
		this.nome = nome;
		
	}
	public void EditaClienteEmail(String email) {
		this.email = email;
	}
	
	public void EditaClienteLocalizacao(String localizacao) {
		this.localizacao = localizacao;
	}
	

	@Override
	public String toString() {
		return "Nome: "  + getNome() + "- Email: " + getEmail() + "- Localização: " + getLocalizacao() + "- CPF: " + getCpf();
	}

}