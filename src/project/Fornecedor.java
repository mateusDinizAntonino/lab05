package project;
import java.util.HashMap;


public class Fornecedor {
	private String nome;
	private String email;
	private String telefone;
	HashMap<String,Produto> produtos = new HashMap<String,Produto>();
	
	Fornecedor(String nome,String email,String telefone){
		getNuloVazio(nome,"Erro no cadastro do fornecedor: nome nao pode ser vazio ou nulo.");
		this.nome = nome;
		getNuloVazio(email,"Erro no cadastro do fornecedor: email nao pode ser vazio ou nulo.");
		this.email = email;
		getNuloVazio(telefone,"Erro no cadastro do fornecedor: telefone nao pode ser vazio ou nulo.");
		this.telefone = telefone;
	}
	String getNome() {
		return nome;
	}
	String getEmail() {
		return email;
	}
	String getTelefone() {
		return telefone;
	}
	public void editaFornecedor(String atributo,String novoValor) {
		getNuloVazio(atributo,"Erro na edicao do fornecedor: atributo nao pode ser vazio ou nulo.");
		if (atributo.equals("nome")) {
			throw new IllegalArgumentException("Erro na edicao do fornecedor: nome nao pode ser editado.");
		}
		if(atributo.equals("email")) {
			getNuloVazio(novoValor,"Erro na edicao do fornecedor: novo valor nao pode ser vazio ou nulo.");
			this.email = novoValor;
		}
		else if(atributo.equals("telefone")) {
			getNuloVazio(novoValor,"Erro na edicao do fornecedor: novo valor nao pode ser vazio ou nulo.");
			this.telefone = novoValor;
		}
		else {
			throw new IllegalArgumentException("Erro na edicao do fornecedor: atributo nao existe.");
		}
	}
	public void cadastraProduto(String nomeProduto,String descricao,double preco) {
		if(produtos.containsKey(nomeProduto)) {
			throw new IllegalArgumentException("Erro no cadastro do produto: produto produto ja existe.");
		}
		else {
			getNuloVazio(nomeProduto,"Erro no cadastro do produto: nome nao pode ser vazio ou nulo.");
			getNuloVazio(descricao,"Erro no cadastro do produto: ")
		}
	}
	
	
	private void getNuloVazio(String string,String mensagem) {
		if(string == null || string.trim().equals("")) {
			throw new IllegalArgumentException(mensagem);
		}
	}
	@Override
	public String toString() {
		return getNome() + " - " + getEmail() + " - " + getTelefone();
	}
	
}
