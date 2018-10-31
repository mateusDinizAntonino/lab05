package project;

import easyaccept.EasyAccept;

public class facade {
	private CrudFornecedores crudFornecedores = new CrudFornecedores();
	private CrudClientes crudClientes = new CrudClientes();

	
	public String adicionaCliente(String cpf,String nome,String email,String localizacao){
		crudClientes.cadastraCliente(cpf, nome, email, localizacao);
		return cpf;
	}
	public String editaCliente(String cpf,String atributo,String novoAtributo) {
		crudClientes.editaCliente(cpf,atributo,novoAtributo);
		return cpf;
	}
	public String exibeCliente(String cpf) {
		return crudClientes.exibeCliente(cpf);
		
	}
	public String removeCliente(String cpf) {
		crudClientes.removeCliente(cpf);
		return cpf;
	}

	public static void main(String[] args) {
		args = new String[] { "project.facade", "easytest/use_case_1.txt" };
		EasyAccept.main(args);
	}								
	public String exibeClientes() {
		return crudClientes.toString();
	}



}

