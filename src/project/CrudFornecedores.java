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
			throw new IllegalArgumentException("nome já cadastrado!");
		}
	}

	void editaFornecedorTelefone(String nome,String telefone) {
		if(fornecedores.containsKey(nome)) {
			fornecedores.get(nome).editaFornecedorTelefone(telefone);
		}
		else {
			throw new IllegalArgumentException("Fornecedor não cadastrado!");
		}
	}
	void editaFornecedorEmail(String nome,String email) {
		if(fornecedores.containsKey(nome)) {
			fornecedores.get(nome).editaFornecedorEmail(email);
		}
		else {
			throw new IllegalArgumentException("Fornecedor não cadastrado!");
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
