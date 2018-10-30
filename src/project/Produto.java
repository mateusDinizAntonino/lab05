package project;

public class Produto {
	String nome;
	int preco;
	String descricao;
	
	Produto(String nome,int preco){
		this.nome = nome;
		editaPreco(preco);
	}
	void editaPreco(int preco) {
		this.preco = preco;
		
	}
	void editaDescricao(String descricao) {
		this.descricao = descricao;
	}
}
