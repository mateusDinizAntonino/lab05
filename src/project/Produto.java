package project;

public class Produto {
	String nome;
	double preco;
	String descricao;
	
	Produto(String nome,String descricao,double preco){
		this.nome = nome;
		this.preco = preco;
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
