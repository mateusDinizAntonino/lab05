package project;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Sistema responsavel pela adiministracao dos clientes.
 *
 */
public class CrudClientes {
	/**
	 * HashMap no qual a chave é o cpf do cliente,e guarda como valor um cliente.
	 */
	private HashMap<String, Cliente> clientes = new HashMap<String, Cliente>();
/**
 * cadastra um cliente no sistema o adicionando no hashmap,e checa se ela ja esta cadastrado retornando um erro,caso não ocorra erro é criado um cliente.
 * @param cpf
 * @param nome
 * @param email
 * @param localizacao
 */
	void cadastraCliente(String cpf, String nome, String email, String localizacao) {
		if (clientes.containsKey(cpf)) {
			throw new IllegalArgumentException("Erro no cadastro do cliente: cliente ja existe.");
		}
		clientes.put(cpf, new Cliente(cpf, nome, email, localizacao));
	}	
	/**Edita um cliente a partir de seu cpf,recebendo o atributo a ser editado e o novo valor respectivamente.
	 * 
	 * @param cpf
	 * @param atributo
	 * @param novoValor
	 */
	void editaCliente(String cpf,String atributo,String novoValor) {
		if (clientes.containsKey(cpf)) {
			clientes.get(cpf).editaCliente(atributo,novoValor);
		} else {
			throw new IllegalArgumentException("Erro na edicao do cliente: cliente nao existe.");
		}
	}
	/**
	 * remove um cliente do sistema.
	 * @param cpf
	 */
	void removeCliente(String cpf) {
		if (clientes.containsKey(cpf)) {
			clientes.remove(cpf);
		} else {
			throw new IllegalArgumentException("Erro na remocao de cpf.");
		}
	}
	/**
	 * Exibe o toString de um Cliente a partir do cpf.
	 * @param cpf
	 * @return
	 */
	String exibeCliente(String cpf) {
		if(clientes.containsKey(cpf)) {
		return clientes.get(cpf).toString();
		}
		else {
			throw new IllegalArgumentException("Erro na exibicao do cliente: cliente nao existe.");
		}
	}
	
	/**
	 * o toString do CrudClientes retorna uma lista de Clientes em ordem Alfabética.
	 */
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
