package project;

/**
 * 
 *Classe Cliente que representa um cliente do sistema SAGA.
 */
public class Cliente {
	private String cpf;
	private String nome;
	private String email;
	private String localizacao;

	/**
	 * construtor do Cliente,que recebe:
	 * @param cpf
	 * @param nome
	 * @param email
	 * @param localizacao
	 */
	
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
	/**
	 * retorna o nome do cliente
	 * @return
	 */
	
	private String getNome() {
		return nome;
	}
	/**
	 * retorna o email do cliente.
	 * @return
	 */
	private String getEmail() {
		return email;
	}
	/**
	 * retorna a localizacao do cliente.
	 * @return
	 */
	private String getLocalizacao() {
		return localizacao;
	}
	/**
	 * método que edita o cliente no qual recebe o atributo do cliente a ser editado e o seu respectivo novo valor, pegando um erro caso o usuário não insira um atributo existente.
	 * @param atributo
	 * @param novoValor
	 */
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
	/**
	 * Recebe uma String e analisa se ela é nula ou vazia, caso seja retorna um erro com a mensagem inserida no parâmetro.
	 * @param string
	 * @param mensagem
	 */
	
	private void getNuloVazio(String string,String mensagem) {
		if(string == null || string.trim().equals("")) {
			throw new IllegalArgumentException(mensagem);
		}
	}
	@Override
	/**
	 * toString da Classe Cliente.
	 */
	public String toString() {
		return getNome() + " - " + getLocalizacao() + " - " + getEmail();
	}

}