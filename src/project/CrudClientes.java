package project;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Collections;

public class CrudClientes {
	private HashMap<String,Cliente> clientes = new HashMap<String,Cliente>();

	void CadastraCliente(String cpf,String nome,String email,String localizacao) {
		if(!clientes.containsKey(cpf)) {
			clientes.put(cpf,new Cliente(cpf,nome,email,localizacao));
		}
		else {
			throw new IllegalArgumentException("Cpf j� cadastrado!");
		}
	}

	void editaClienteEmail(String cpf,String email) {
		if(clientes.containsKey(cpf)) {
		clientes.get(cpf).EditaClienteEmail(email);
	}
		else {
			throw new IllegalArgumentException("Cpf n�o cadastrado!");
		}
	}	
	void editaClienteNome(String cpf,String nome) {
		if(clientes.containsKey(cpf)) {
		clientes.get(cpf).EditaClienteNome(nome);
	}
		else {
			throw new IllegalArgumentException("Cpf n�o cadastrado!");

		}
	}
	void editaClienteLocalizacao(String cpf,String localizacao) {
		if(clientes.containsKey(cpf)) {
		clientes.get(cpf).EditaClienteLocalizacao(localizacao);
	}
		else {
			throw new IllegalArgumentException("Cpf n�o cadastrado!");
		}
	}
	void removeCliente(String cpf) {
		if(clientes.containsKey(cpf)) {
			clientes.remove(cpf);
		}
		else {
			throw new IllegalArgumentException("n�o � poss�vel remover um cpf n�o cadastrado!");
		}
	}

	@Override
	public String toString() {
		ArrayList<String> listaClientes = new ArrayList<String>();
		String retorno = "";
		
		for(Cliente cliente: clientes.values()) {
			listaClientes.add(cliente.toString());
		}
		Collections.sort(listaClientes,String.CASE_INSENSITIVE_ORDER);
		for (String cliente : listaClientes) {
			retorno += cliente + "|";
		}
		return retorno;
	}
	
}
