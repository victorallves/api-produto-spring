package br.com.magnasistemas.projetospring.dto;

public class ProdutoDto {

	private Long id;
	private String nomeDoProduto;
	private String descricaoDoProduto;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNomeDoProduto() {
		return nomeDoProduto;
	}
	public void setNomeDoProduto(String nomeDoProduto) {
		this.nomeDoProduto = nomeDoProduto;
	}
	public String getDescricaoDoProduto() {
		return descricaoDoProduto;
	}
	public void setDescricaoDoProduto(String descricaoDoProduto) {
		this.descricaoDoProduto = descricaoDoProduto;
	}
	
}
