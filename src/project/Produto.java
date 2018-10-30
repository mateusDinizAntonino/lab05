package project;

public class Produto {
	String nome;
	double preco;
	String descricao;
	
	Produto(String nome,double preco,String descricao){
		this.nome = nome;
		editaPreco(preco);
		editaDescricao(descricao);
	}
	void editaPreco(double preco) {
		this.preco = preco;
		
	}
	void editaDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	String getNome() {
		return nome;
	}
	String getDescricao() {
		return descricao;
	}
	double getPreco() {
		return preco;
	}
	
	@Override
	public String toString() {
		return getNome() + "-" + getDescricao() + "-R$:" + getPreco(); 

	}

}
