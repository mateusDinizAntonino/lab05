package project;
import java.util.HashMap;


public class Fornecedor {
	private String nome;
	private String email;
	private String telefone;
	HashMap<String,Produto> produtos = new HashMap<String,Produto>();
	
	Fornecedor(String nome,String email,String telefone){
		this.nome = nome;
		editaFornecedorEmail(email);
		editaFornecedorTelefone(telefone);
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
	void editaFornecedorEmail(String email) {
		this.email = email;
	}
	void editaFornecedorTelefone(String telefone) {
		this.telefone = telefone;
	}
	void CadastraProduto(String nomeProduto,String preco) {
		if(!produtos.containsKey(nomeProduto)) {
			produtos.put(nomeProduto,new Produto(nomeProduto,preco));
		}
		else {
			throw new IllegalArgumentException("produto ja cadastrado!");
		}

	}
	void editaPrecoProduto(String nomeProduto,String preco) {
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
	
	
	@Override
	public String toString() {
		return "nome: " + getNome() + "- Email: " + getEmail() + "- Telefone: " + getTelefone();
	}
	
}
