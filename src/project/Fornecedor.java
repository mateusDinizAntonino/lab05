package project;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
/**
 * classe que define um fornecedor no qual guarda consigo um HashMap de produtos.
 *
 */

public class Fornecedor {
	private String nome;
	private String email;
	private String telefone;
	/**
	 * um HashMap de produtos no qual � utilizado seu nome e descricao como chave.
	 */
	HashMap<String,Produto> produtos = new HashMap<String,Produto>();
	HashMap<String,Combo> combos = new HashMap<String,Combo>();
 	/**
	 * construtor da classe fornecedor,que tem como construtores o nome,email e telefone do mesmo.
	 * @param nome
	 * @param email
	 * @param telefone
	 */
	Fornecedor(String nome,String email,String telefone){
		getNuloVazio(nome,"Erro no cadastro do fornecedor: nome nao pode ser vazio ou nulo.");
		this.nome = nome;
		getNuloVazio(email,"Erro no cadastro do fornecedor: email nao pode ser vazio ou nulo.");
		this.email = email;
		getNuloVazio(telefone,"Erro no cadastro do fornecedor: telefone nao pode ser vazio ou nulo.");
		this.telefone = telefone;
	}
	/**
	 * retorna o nome do fornecedor.
	 * @return
	 */
	String getNome() {
		return nome;
	}
	/**
	 * retorna o email do fornecedor.
	 * @return
	 */
	String getEmail() {
		return email;
	}
	/**
	 * retorna o telefone do fornecedor.
	 * @return
	 */
	String getTelefone() {
		return telefone;
	}
	/**
	 * edita o fornecedor que recebe como parametro o atributo a ser editado e o novo Valor para o respectivo atributo,retornando um erro caso:
	 * o usu�rio coloque nome como atributo,que nao � possivel,o usuario nao digite nada como atributo ou novo valor.
	 * 
	 * @param atributo
	 * @param novoValor
	 */
	public void editaFornecedor(String atributo,String novoValor) {
		getNuloVazio(atributo,"Erro na edicao do fornecedor: atributo nao pode ser vazio ou nulo.");
		if (atributo.equals("nome")) {
			throw new IllegalArgumentException("Erro na edicao do fornecedor: nome nao pode ser editado.");
		}
		if(atributo.equals("email")) {
			getNuloVazio(novoValor,"Erro na edicao do fornecedor: novo valor nao pode ser vazio ou nulo.");
			this.email = novoValor;
		}
		else if(atributo.equals("telefone")) {
			getNuloVazio(novoValor,"Erro na edicao do fornecedor: novo valor nao pode ser vazio ou nulo.");
			this.telefone = novoValor;
		}
		else {
			throw new IllegalArgumentException("Erro na edicao do fornecedor: atributo nao existe.");
		}
	}
	/**
	 * cria e coloca no HashMap de produtos um novo produto que recebe como parametros, o nome do produto descricao e preco,retornando erros caso o usu�rio:
	 * coloque o nome e descricao de um produto ja existente,n�o digitar nada no nome,descricao ou preco do produto.
	 * @param nomeProduto
	 * @param descricao
	 * @param preco
	 */
	public void cadastraProduto(String nomeProduto, String descricao,double preco ) {
		if(produtos.containsKey(nomeProduto+descricao)) {
			throw new IllegalArgumentException("Erro no cadastro de produto: produto ja existe.");
		}
		else {
			produtos.put(nomeProduto+descricao,new Produto(nomeProduto,descricao,preco));
		}
	}
	/**
	 * edita o preco do produto. retornando um erro caso o usuario coloque um preco negativo ou coloque o nome e descricao de um produto inexistente.
	 * @param nomeProduto
	 * @param descricao
	 * @param novoPreco
	 */
	public void editaProduto(String nomeProduto,String descricao,double novoPreco) {
		getNuloVazio(nomeProduto,"Erro na edicao de produto: nome nao pode ser vazio ou nulo.");
		getNuloVazio(descricao,"Erro na edicao de produto: descricao nao pode ser vazia ou nula.");
		if(novoPreco < 0) {
			throw new IllegalArgumentException("Erro na edicao de produto: preco invalido.");
		}
		produtos.get(nomeProduto + descricao).editaProduto(novoPreco);
	}
	/**
	 * remove o produto do HashMap e retorna um erro caso o usu�rio:
	 * n�o coloque um produto existente.
	 * @param nomeProduto
	 * @param descricao
	 */
	public void removeProduto(String nomeProduto,String descricao) {
		if(!produtos.containsKey(nomeProduto + descricao)) {
			throw new IllegalArgumentException("Erro na remocao de produto: produto nao existe.");
		}
		produtos.remove(nomeProduto + descricao);
	}
	
	/**
	 * retorna o toString do produto que contem o nome a descricao e o preco do produto,e retorna um erro caso o usu�rio:
	 * n�o colocar um produto existente.
	 * @param nomeProduto
	 * @param descricao
	 * @return
	 */
	public String exibeProduto(String nomeProduto,String descricao) {
		if(!produtos.containsKey(nomeProduto + descricao)) {
			throw new IllegalArgumentException("Erro na exibicao de produto: produto nao existe.");
		}
		else {	
			return produtos.get(nomeProduto+descricao).toString();
		}
	}
	/**
	 * retorna uma lista com todos os toString dos produtos do fornecedor em ordem alfabetica.
	 * @return
	 */
	public String exibeProdutos() {
		ArrayList<String> listaProdutos = new ArrayList<String>();
		String retorno = "";
		
		for (Produto produto: produtos.values()) {
			listaProdutos.add(nome + " - " + produto.toString());
		}
		Collections.sort(listaProdutos, String.CASE_INSENSITIVE_ORDER);
		for (int i = 0; i < listaProdutos.size()-1;i++) {
			retorno += listaProdutos.get(i) + " | ";
		}
		retorno += listaProdutos.get(listaProdutos.size()-1);
		return retorno;
	}
	/**
	 * recebe uma String e analisa se � nula ou vazia,retornando uma mensagem de erro inserida no parametro.
	 * @param string
	 * @param mensagem
	 */
	private void getNuloVazio(String string,String mensagem) {
		if(string == null || string.trim().equals("")) {
			throw new IllegalArgumentException(mensagem);
		}
	}
	/**
	 * to String do fornecedor retorna seu nome email e telefone.
	 */
	@Override
	public String toString() {
		return getNome() + " - " + getEmail() + " - " + getTelefone();
	}
}
