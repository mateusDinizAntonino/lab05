package project;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Collections;
/**
  * Sistema responsavel pela administracao dos fornecedores.
 *
 */
public class CrudFornecedores {
	/**
	 * HashMap de fornecedores no qual a chave � seu nome.
	 */
	private HashMap<String,Fornecedor> fornecedores = new HashMap<String,Fornecedor>();
	/**
	 * cadastra um Fornecedor criando o mesmo a partir dos parametros e adicionando no HashMap,retorna erro caso o usu�rio:
	 * coloque o nome de um fornecedor j� cadastrado.
	 * @param nome
	 * @param email
	 * @param telefone
	 */
	void cadastrarFornecedor(String nome,String email,String telefone) {
		if(!fornecedores.containsKey(nome)) {
			fornecedores.put(nome,new Fornecedor(nome,email,telefone));	
		}
		else {
			throw new IllegalArgumentException("Erro no cadastro de fornecedor: fornecedor ja existe.");
		}
	}
/**
 * Edita o fornecedor recebendo o nome para a localizac�o do mesmo,o atributo a ser editado e o novo valor do atributo,retorna um erro caso o usu�rio:
 * coloque um nome de um fornecedor n�o cadastrado.
 * @param nome
 * @param atributo
 * @param novoValor
 */
	void editaFornecedor(String nome,String atributo,String novoValor) {
		if(fornecedores.containsKey(nome)) {
			fornecedores.get(nome).editaFornecedor(atributo, novoValor);
		}
		else {
			throw new IllegalArgumentException("Erro na edicao do fornecedor: fornecedor nao existe.");
		}
	}
	/**
	 * retorna um fornecedor a partir de seu nome.
	 * @param nome
	 * @return
	 */
	public Fornecedor getFornecedor(String nome) {
		return fornecedores.get(nome);
	}
	
	/**
	 * retorna o toString do fornecedor que � o seu nome,email e telefone e retorna um erro caso o usu�rio:
	 * coloque o nome de um fornecedor nao cadastrado.
	 * @param nome
	 * @return
	 */
	String exibeFornecedor(String nome) {
		if(fornecedores.containsKey(nome)) {
			return fornecedores.get(nome).toString();		
			}
		else {
			throw new IllegalArgumentException("Erro na exibicao do fornecedor: fornecedor nao existe.");
		}
	}
	/**
	 * Remove um fornecedor a partir de seu nome e retorna um erro caso o usu�rio:
	 * coloque um nome vazio ou nulo.
	 * @param nome
	 */
	void removeFornecedor(String nome) {
		getNuloVazio(nome,"Erro na remocao do fornecedor: nome do fornecedor nao pode ser vazio.");
		if(fornecedores.containsKey(nome)) {
			fornecedores.remove(nome);
		}
		else {
			throw new IllegalArgumentException("Erro na remocao do fornecedor: fornecedor nao existe.");
		}
	}
	/**
	 * cria e guarda um produto no fornecedor,cada fornecedor possui um HashMap de produtos no qual a chave � o nome do produto e a descricao retorna um erro caso o usu�rio:
	 * coloque o nome do fornecedor a guardar o produto vazio ou nulo.
	 * coloque o nome do produto vazio ou nulo.
	 * coloque a descricao do produto vazia ou nula.
	 * coloque um preco para produto negativo.
	 * @param nomeFornecedor
	 * @param nomeProduto
	 * @param descricao
	 * @param preco
	 */
	public void cadastraProduto(String nomeFornecedor,String nomeProduto,String descricao,double preco) {
		getNuloVazio(nomeFornecedor,"Erro no cadastro de produto: fornecedor nao pode ser vazio ou nulo.");
		if(!fornecedores.containsKey(nomeFornecedor)) {
			throw new IllegalArgumentException("Erro no cadastro de produto: fornecedor nao existe.");
		}
		else {
			getNuloVazio(nomeProduto,"Erro no cadastro de produto: nome nao pode ser vazio ou nulo.");
			getNuloVazio(descricao,"Erro no cadastro de produto: descricao nao pode ser vazia ou nula.");
			if(preco < 0) {
				throw new IllegalArgumentException("Erro no cadastro de produto: preco invalido.");
			}
			fornecedores.get(nomeFornecedor).cadastraProduto(nomeProduto, descricao,preco);	
		}
	}
	/**
	 * edita o preco de um produto e retorna um erro caso o usu�rio:
	 * coloque um fornecedor nao cadastrado.
	 * @param nomeProduto
	 * @param descricao
	 * @param nomeFornecedor
	 * @param novoPreco
	 */
	public void editaProduto(String nomeProduto,String descricao,String nomeFornecedor,double novoPreco) {
		getNuloVazio(nomeFornecedor,"Erro na edicao de produto: fornecedor nao pode ser vazio ou nulo.");
		if(!fornecedores.containsKey(nomeFornecedor)) {
			throw new IllegalArgumentException("Erro na edicao de produto: fornecedor nao existe.");
		}
		else {
			fornecedores.get(nomeFornecedor).editaProduto(nomeProduto, descricao, novoPreco);
		}
	}
	/**
	 * remove um produto de determinado usu�rio, e retorna um erro caso o usu�rio:
	 * coloque um fornecedor nulo ou vazio.
	 * coloque um fornecedor nao cadastrado.
	 * coloque um nome do produto vazio ou nulo.
	 * coloque a descricao do produto vazia ou nula.
	 * @param nomeProduto
	 * @param descricao
	 * @param nomeFornecedor
	 */
	public void removeProduto(String nomeProduto,String descricao,String nomeFornecedor) {
		getNuloVazio(nomeFornecedor,"Erro na remocao de produto: fornecedor nao pode ser vazio ou nulo.");
		if(!fornecedores.containsKey(nomeFornecedor)) {
			throw new IllegalArgumentException("Erro na remocao de produto: fornecedor nao existe.");	
		}
		getNuloVazio(nomeProduto,"Erro na remocao de produto: nome nao pode ser vazio ou nulo.");
		getNuloVazio(descricao,"Erro na remocao de produto: descricao nao pode ser vazia ou nula.");
		fornecedores.get(nomeFornecedor).removeProduto(nomeProduto, descricao);
	}
	/**
	 * exibe um produto de determinado fornecedor,e retorna um erro caso o usu�rio:
	 * nao coloque um fornecedor cadastrado.
	 * coloque o nome do fornecedor nulo ou vazio.
	 * coloque o nome do produto vazio ou nulo.
	 * coloque a descri��o vazia ou nula.
	 * @param nomeFornecedor
	 * @param nomeProduto
	 * @param descricao
	 * @return
	 */
	public String exibeProduto(String nomeFornecedor,String nomeProduto,String descricao) {
		getNuloVazio(nomeFornecedor,"Erro na exibicao de produto: fornecedor nao pode ser vazio ou nulo.");
		if(!fornecedores.containsKey(nomeFornecedor)) {
			throw new IllegalArgumentException("Erro na exibicao de produto: fornecedor nao existe.");
		}
		else {
			getNuloVazio(nomeProduto,"Erro na exibicao de produto: nome nao pode ser vazio ou nulo.");
			getNuloVazio(descricao,"Erro na exibicao de produto: descricao nao pode ser vazia ou nula.");
			return fornecedores.get(nomeFornecedor).exibeProduto(nomeProduto,descricao).toString();			
		}
	}
	/**
	 * retorna uma String com todos toString de todos os produtos de um fornecedor em ordem alfabetica
	 * @param nomeFornecedor
	 * @return
	 */
	public String exibeProdutosFornecedor(String nomeFornecedor) {
		return fornecedores.get(nomeFornecedor).exibeProdutos();
	}
	/**
	 * retorna todos os toString de todos os produtos de todos os fornecedores cadastrados no sistema.
	 * @return
	 */
	public String exibeProdutos() {
		ArrayList<String> listaTodosProdutos = new ArrayList<String>();
		String retorno = "";
		for (Fornecedor fornecedor: fornecedores.values()) {
			listaTodosProdutos.add(fornecedor.exibeProdutos());
		}
		Collections.sort(listaTodosProdutos,String.CASE_INSENSITIVE_ORDER);
		for(int i = 0; i< listaTodosProdutos.size()-1 ;i++) {
			retorno += listaTodosProdutos.get(i) + " | ";
		}
		retorno += listaTodosProdutos.get(listaTodosProdutos.size()-1);
		return retorno;
	}
	/**
	 * recebe uma String e analisa se ela � nula ou vazia retornando um erro como mensagem de entrada no parametro.
	 * @param string
	 * @param mensagem
	 */
	private void getNuloVazio(String string,String mensagem) {
		if(string == null || string.trim().equals("")) {
			throw new IllegalArgumentException(mensagem);
		}
	}
	/**
	 * toString retorna todos os toString dos fornecedores cadastrados no sistema em ordem alfabetica.
	 */
	@Override
	public String toString() {
		ArrayList<String> listaFornecedores = new ArrayList<String>();
		String retorno = "";
		
		for (Fornecedor fornecedor: fornecedores.values()) {
			listaFornecedores.add(fornecedor.toString());
		}
		Collections.sort(listaFornecedores, String.CASE_INSENSITIVE_ORDER);
		for (int x =0; x <listaFornecedores.size()-1;x++) {
			retorno += listaFornecedores.get(x)  + " | ";
		}
		retorno += listaFornecedores.get(listaFornecedores.size()-1);
		return retorno;
	}

}
