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
	
	
	public String exibeClientes() {
		return crudClientes.toString();
	}
	
	public String adicionaFornecedor(String  nome,String email,String telefone) {
		crudFornecedores.cadastrarFornecedor(nome,email,telefone);
		return nome;
	}
	public String exibeFornecedor(String nome) {
		return crudFornecedores.exibeFornecedor(nome);
	}
	public String exibeFornecedores() {
		return crudFornecedores.toString();
	}
	public void editaFornecedor(String nome,String atributo,String novoValor) {
		crudFornecedores.editaFornecedor(nome, atributo, novoValor);	
	}
	public void removeFornecedor(String nome) {
		crudFornecedores.removeFornecedor(nome);
	}
	public void adicionaProduto(String fornecedor,String nomeProduto,String descricao ,double preco) {
		crudFornecedores.getFornecedor(fornecedor).cadastraProduto(nomeProduto, descricao, preco);
	}
		
	
	
	
	public static void main(String[] args) {
		args = new String[] { "project.facade", "easytest/use_case_1.txt","easytest/use_case_2.txt","easytest/use_case_3.txt"};
		EasyAccept.main(args);
	}								
	



}

