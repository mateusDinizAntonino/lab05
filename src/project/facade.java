package project;

import easyaccept.EasyAccept;
/**
 * facade do sistema SAGA
 *
 */
public class facade {
	/**
	 * cria um CRUD Fornecedores e um CRUD Clientes.
	 */
	private CrudFornecedores crudFornecedores = new CrudFornecedores();
	private CrudClientes crudClientes = new CrudClientes();
  /**
   * cria e adiciona um Cliente no CrudCLientes e retorna o cpf. 
   */
	public String adicionaCliente(String cpf,String nome,String email,String localizacao){
		crudClientes.cadastraCliente(cpf, nome, email, localizacao);
		return cpf;
	}
	/**
	 * edita um Cliente no CrudClientes com parametros um atributo a ser editado o novo a ser mudado,retorna o cpf.
	 * @param cpf
	 * @param atributo
	 * @param novoAtributo
	 * @return
	 */
	public String editaCliente(String cpf,String atributo,String novoAtributo) {
		crudClientes.editaCliente(cpf,atributo,novoAtributo);
		return cpf;
	}
	/**
	 * retorna o toString de cliente a partir de seu cpf.
	 * @param cpf
	 * @return
	 */
	public String exibeCliente(String cpf) {
		return crudClientes.exibeCliente(cpf);	
	}
	/**
	 * remove um cliente do CrudClientes a partir do cpf e retorna o cpf.
	 * @param cpf
	 * @return
	 */
	public String removeCliente(String cpf) {
		crudClientes.removeCliente(cpf);
		return cpf;
	}
	/**
	 * retorna o toString do CrudClientes,que � uma lista em ordem Alfabetica de todos os to String de todos os clientes cadastrados.
	 * @return
	 */
	public String exibeClientes() {
		return crudClientes.toString();
	}
	/**
	 * cria e salva no CrudFornecedores um fornecedor a partir de um nome email e telefone e retorna o nome.
	 * @param nome
	 * @param email
	 * @param telefone
	 * @return
	 */
	public String adicionaFornecedor(String  nome,String email,String telefone) {
		crudFornecedores.cadastrarFornecedor(nome,email,telefone);
		return nome;
	}
	/**
	 * retorna o toString de um fornecedor cadastrado no CrudFornecedores a partir de seu nome.
	 * @param nome
	 * @return
	 */
	public String exibeFornecedor(String nome) {
		return crudFornecedores.exibeFornecedor(nome);
	}
	/**
	 * retorna o toString do CrudFornecedores que � uma String com todos os toString dos fornecedores organizados em ordem alfabetica.
	 * @return
	 */
	public String exibeFornecedores() {
		return crudFornecedores.toString();
	}
	/**
	 * edita um fornecedor a partir do seu nome,recebendo o atributo a ser editado e o novo valor a ser colocado.
	 * @param nome
	 * @param atributo
	 * @param novoValor
	 */
	public void editaFornecedor(String nome,String atributo,String novoValor) {
		crudFornecedores.editaFornecedor(nome, atributo, novoValor);	
	}
	/**
	 * remove o fornecedor do CrudClientes a partir do nome.
	 * @param nome
	 */
	public void removeFornecedor(String nome) {
		crudFornecedores.removeFornecedor(nome);
	}
	/**
	 * Cria e salva um produto em determinado Fornecedor a partir de seu nome,e cria o produto a partir de seu preco descricao e preco.
	 * @param nomeFornecedor
	 * @param nomeProduto
	 * @param descricao
	 * @param preco
	 */
	public void adicionaProduto(String nomeFornecedor,String nomeProduto,String descricao,double preco) {	
		crudFornecedores.cadastraProduto(nomeFornecedor, nomeProduto, descricao, preco);
	}
	/**
	 * retorna o toString de determinado produto a partir de seu fornecedor,nome do produto e descricao.
	 * @param nomeProduto
	 * @param descricao
	 * @param nomeFornecedor
	 * @return
	 */
	public String exibeProduto(String nomeProduto,String descricao,String nomeFornecedor) {
		return crudFornecedores.exibeProduto(nomeFornecedor, nomeProduto,descricao);
	}
	/**
	 * retorna uma lista com todos os toString dos produtos de determinado fornecedor a partir do nome do fornecedor,a lista � organizada em ordem alfabetica.
	 * @param nomeFornecedor
	 * @return
	 */
	public String exibeProdutosFornecedor(String nomeFornecedor) {
		return crudFornecedores.exibeProdutosFornecedor(nomeFornecedor);
	}
	/**
	 * exibe todos os produtos de todos os fornecedores cadastrados no sistema em ordem alfabetica.
	 * @return
	 */
	public String exibeProdutos() {
		return crudFornecedores.exibeProdutos();	
	}
	/**
	 * edita o preco de um produto a partir do nome do fornecedor,nome do produto e descricao, recebendo o novo preco.
	 * @param nomeProduto
	 * @param descricao
	 * @param nomeFornecedor
	 * @param novoPreco
	 */
	public void editaProduto(String nomeProduto,String descricao,String nomeFornecedor,double novoPreco) {
		crudFornecedores.editaProduto(nomeProduto, descricao, nomeFornecedor, novoPreco);
	}
	/**
	 * remove um determinado produto a partir do nome do fornecedor,nome do produto e descricao.
	 * @param nomeProduto
	 * @param descricao
	 * @param nomeFornecedor
	 */
	public void removeProduto(String nomeProduto,String descricao,String nomeFornecedor) {
		crudFornecedores.removeProduto(nomeProduto, descricao, nomeFornecedor);
	}
	
	public void adicionaCombo(String fornecedor,String nomeCombo ,String descricao,double fator,String produtos) {
		crudFornecedores.adicionaCombo(fornecedor,nomeCombo,descricao,fator,produtos);
	}
	public void exibeCombo(String nomeCombo,String descricao,String fornecedor) {
		crudFornecedores.exibeCombo(nomeCombo,descricao,fornecedor);
	}
	public void 	
	
	
	
	
	
	
	public static void main(String[] args) {
		args = new String[] { "project.facade", "easytest/use_case_1.txt","easytest/use_case_2.txt","easytest/use_case_3.txt","easytest/use_case_4.txt","easytest/use_case_5.txt"};
		EasyAccept.main(args);
	}								
}