package project;
/**
 * Classe que representa um produto de um fornecedor.
 * @author win10
 *
 */
public class Produto {
	String nome;
	double preco;
	String descricao;
	/**
	 * construtor de um produto que guarda o nome a descricao e o preco.
	 * @param nome
	 * @param descricao
	 * @param preco
	 */
	Produto(String nome,String descricao,double preco){
		this.nome = nome;
		this.preco = preco;
		this.descricao = descricao;
	}	
	/**
	 * retorna o nome do produto
	 * @return
	 */
	private String getNome() {
		return nome;
	}
	/**
	 * retorna a descricao do produto.
	 * @return
	 */
	private String getDescricao() {
		return descricao;
	}
	/**
	 * retorna o preco do produto formatado com duas casas decimais.
	 * @return
	 */
	private String getPreco() {
		return String.format("%.2f",preco);
	}
	/**
	 * edita o produto recebendo o novo preco e guardando.
	 * @param novoPreco
	 */
	public void editaProduto(double novoPreco) {
		preco = novoPreco;
	}
	
	/**
	 * to String de produto que retorna o nome descricao e preco do Produto.
	 */
	@Override
	public String toString() {
		return getNome() + " - " + getDescricao() + " - R$" + getPreco(); 

	}

}
