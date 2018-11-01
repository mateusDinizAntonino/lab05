package project;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Collections;

public class CrudFornecedores {
	private HashMap<String,Fornecedor> fornecedores = new HashMap<String,Fornecedor>();
	
	void cadastrarFornecedor(String nome,String email,String telefone) {
		if(!fornecedores.containsKey(nome)) {
			fornecedores.put(nome,new Fornecedor(nome,email,telefone));	
		}
		else {
			throw new IllegalArgumentException("Erro no cadastro de fornecedor: fornecedor ja existe.");
		}
	}

	void editaFornecedor(String nome,String atributo,String novoValor) {
		if(fornecedores.containsKey(nome)) {
			fornecedores.get(nome).editaFornecedor(atributo, novoValor);
		}
		else {
			throw new IllegalArgumentException("Erro na edicao do fornecedor: fornecedor nao existe.");
		}
	}
	public Fornecedor getFornecedor(String nome) {
		return fornecedores.get(nome);
	}
	
	
	String exibeFornecedor(String nome) {
		if(fornecedores.containsKey(nome)) {
			return fornecedores.get(nome).toString();		
			}
		else {
			throw new IllegalArgumentException("Erro na exibicao do fornecedor: fornecedor nao existe.");
		}
	}
	void removeFornecedor(String nome) {
		getNuloVazio(nome,"Erro na remocao do fornecedor: nome do fornecedor nao pode ser vazio.");
		if(fornecedores.containsKey(nome)) {
			fornecedores.remove(nome);
		}
		else {
			throw new IllegalArgumentException("Erro na remocao do fornecedor: fornecedor nao existe.");
		}
	}
	public void cadastraProduto(String nomeFornecedor,String nomeProduto,String descricao,double preco) {
		getNuloVazio(nomeFornecedor,"Erro no cadastro de produto: fornecedor nao pode ser vazio ou nulo.");
		if(!fornecedores.containsKey(nomeFornecedor)) {
			throw new IllegalArgumentException("Erro no cadastro de produto: fornecedor nao existe.");
		}
		else {
			getNuloVazio(nomeProduto,"Erro no cadastro de produto: nome nao pode ser vazio ou nulo.");
			getNuloVazio(descricao,"Erro no cadastro de produto: descricao nao pode ser vazia ou nula.");
			getFornecedor(nomeFornecedor).ca
		}
	}
	
	
	
	
	private void getNuloVazio(String string,String mensagem) {
		if(string == null || string.trim().equals("")) {
			throw new IllegalArgumentException(mensagem);
		}
	}
	@Override
	public String toString() {
		ArrayList<String> listaFornecedores = new ArrayList<String>();
		String retorno = "";
		
		
		for (Fornecedor fornecedor: fornecedores.values()) {
			listaFornecedores.add(fornecedor.toString());
		}
		Collections.sort(listaFornecedores, String.CASE_INSENSITIVE_ORDER);
		for (int x =0; x <listaFornecedores.size()-1;x++) {
			retorno += listaFornecedores.get(x)  + " | ";
		}
		retorno += listaFornecedores.get(listaFornecedores.size()-1);
		return retorno;
	}
	
}
