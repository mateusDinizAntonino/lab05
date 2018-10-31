package project;

public class Cliente {
	private String cpf;
	private String nome;
	private String email;
	private String localizacao;

	Cliente(String cpf,String nome,String email,String localizacao){
		if(cpf.length() != 11) {
			throw new IllegalArgumentException("Erro no cadastro do cliente: cpf invalido.");
		}
		this.cpf = cpf;
		getNuloVazio(nome,"Erro no cadastro do cliente: nome nao pode ser vazio ou nulo.");
		this.nome = nome;
		getNuloVazio(email,"Erro no cadastro do cliente: email nao pode ser vazio ou nulo.");
		this.email = email;
		getNuloVazio(localizacao,"Erro no cadastro do cliente: localizacao nao pode ser vazia ou nula.");
		this.localizacao = localizacao;
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
	
	public void editaCliente(String atributo,String novoValor) {
		getNuloVazio(atributo,"Erro na edicao do cliente: atributo nao pode ser vazio ou nulo.");
		if(atributo.equals("cpf")) {
			throw new IllegalArgumentException("cpf nao pode ser editado.");
		}
		else if(atributo.equals("nome")){
			getNuloVazio(novoValor,"Erro na edicao do cliente: novo valor nao pode ser vazio ou nulo.");
			this.nome = novoValor;
		}
		else if(atributo.equals("email")) {
			getNuloVazio(novoValor,"Erro na edicao do cliente: novo valor nao pode ser vazio ou nulo.");
			this.email = novoValor;
		}
		else if(atributo.equals("localizacao")) {
			getNuloVazio(novoValor,"Erro na edicao do cliente: novo valor nao pode ser vazio ou nulo.");
			this.localizacao =novoValor;
		}
		else {
			throw new IllegalArgumentException("Erro na edicao do cliente: atributo nao existe.");
		}
	}
	
	private void getNuloVazio(String string,String mensagem) {
		if(string == null || string.trim().equals("")) {
			throw new IllegalArgumentException(mensagem);
		}
	}
	@Override
	public String toString() {
		return getNome() + " - " + getLocalizacao() + " - " + getEmail();
	}

}