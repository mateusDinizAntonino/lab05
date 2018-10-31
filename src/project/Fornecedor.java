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
	void editaFornecedor(String atributo,String novoValor) {
		getNuloVazio(atributo,"Erro na edicao do fornecedor: atributo nao pode ser vazio ou nulo");
		if (atributo.equals("nome")) {
			throw new IllegalArgumentException("Erro na edicao do fornecedor: nome nao pode ser editado.");
		}
		if(atributo.equals("email")) {
			this.email = novoValor;
		}
		else if(atributo.equals("telefone")) {
			this.telefone = novoValor;
			
		}
		else {
			throw new IllegalArgumentException("Erro na edicao do fornecedor: atributo nao existe.");
		}
	}
	
	void CadastraProduto(String nomeProduto,int preco,String descricao) {
		if(!produtos.containsKey(nomeProduto)) {
			produtos.put(nomeProduto,new Produto(nomeProduto,preco,descricao));
		}
		else {
			throw new IllegalArgumentException("produto ja cadastrado!");
		}

	}
	void editaPrecoProduto(String nomeProduto,int preco) {
		if(produtos.containsKey(nome)) {
			produtos.get(nome).editaPreco(preco);
		}
	}
	void removeProduto(String nome) {
		if(produtos.containsKey(nome)) {
			produtos.remove(nome);
		}
		else {
			throw new IllegalArgumentException("Produto não existe");
		}
	}
	private void getNuloVazio(String string,String mensagem) {
		if(string == null || string.trim().equals("")) {
			throw new IllegalArgumentException(mensagem);
		}
	}
	@Override
	public String toString() {
		return "nome: " + getNome() + "- Email: " + getEmail() + "- Telefone: " + getTelefone();
	}
	
}
