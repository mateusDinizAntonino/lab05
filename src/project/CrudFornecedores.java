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
			throw new IllegalArgumentException("Fornecedor ja cadastrado.");
		}
	}

	void editaFornecedor(String atributo) {
		
	}
	
	String exibeFornecedor(String nome) {
		if(fornecedores.containsKey(nome)) {
			return fornecedores.get(nome).toString();		
			}
		else {
			throw new IllegalArgumentException("Erro na exibicao do fornecedor: fornecedor nao existe.");
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
		for (String fornecedor : listaFornecedores) {
			retorno += fornecedor  + "|";
		}
		return retorno;
	}
	
}
