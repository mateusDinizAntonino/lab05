package project;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Collections;

public class CrudClientes {
	private HashMap<String,Cliente> clientes = new HashMap<String,Cliente>();

	String cadastraCliente(String cpf,String nome,String email,String localizacao) {
		if(!clientes.containsKey(cpf)) {
		}		
	}

	String editaClienteEmail(String cpf,String email) {
		if(clientes.containsKey(cpf)) {
		clientes.get(cpf).EditaClienteEmail(email);
		return "Cliente editado com sucesso!";
	}
		else {
			return "cpf não cadastrado!";
		}
	}	
	String editaClienteNome(String cpf,String nome) {
		if(clientes.containsKey(cpf)) {
		return "cliente editado com sucesso!";
	}
		else {
			return "Cpf não cadastrado!";

		}
	}
	String editaClienteLocalizacao(String cpf,String localizacao) {
		if(clientes.containsKey(cpf)) {
		clientes.get(cpf).EditaClienteLocalizacao(localizacao);
		return "Cliente editado com sucesso!";
		}
		else {
			return "Cpf não cadastrado!";
		}
	}
	String removeCliente(String cpf) {
		if(clientes.containsKey(cpf)) {
			clientes.remove(cpf);
			return "Cliente removido com sucesso!";
		}
		else {
			return "Cpf não cadatrado!";
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
