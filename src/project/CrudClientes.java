package project;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.Collections;

public class CrudClientes {
	private HashMap<String, Cliente> clientes = new HashMap<String, Cliente>();

	void cadastraCliente(String cpf, String nome, String email, String localizacao) {
		if (clientes.containsKey(cpf)) {
			throw new IllegalArgumentException("Erro no cadastro do cliente: cliente ja existe.");
		}
		clientes.put(cpf, new Cliente(cpf, nome, email, localizacao));
	}

	void editaCliente(String cpf,String atributo,String novoValor) {
		if (clientes.containsKey(cpf)) {
			clientes.get(cpf).editaCliente(atributo,novoValor);
		} else {
			throw new IllegalArgumentException("Erro na edicao do cliente: cliente nao existe.");
		}
	}

	void removeCliente(String cpf) {
		if (clientes.containsKey(cpf)) {
			clientes.remove(cpf);
		} else {
			throw new IllegalArgumentException("Erro na remocao de cpf.");
		}
	}
	String exibeCliente(String cpf) {
		if(clientes.containsKey(cpf)) {
		return clientes.get(cpf).toString();
		}
		else {
			throw new IllegalArgumentException("Erro na exibicao do cliente: cliente nao existe.");
		}
	}
	
	
	@Override
	public String toString() {
		ArrayList<String> listaClientes = new ArrayList<String>();
		String retorno = "";

		for (Cliente cliente : clientes.values()) {
			listaClientes.add(cliente.toString());
		}
		Collections.sort(listaClientes, String.CASE_INSENSITIVE_ORDER);
		for (int i = 0; i < listaClientes.size() -1; i++) {
			
			retorno += listaClientes.get(i) + " | ";
		}
		retorno += listaClientes.get(listaClientes.size()-1);
		
		return retorno;
	}
}
