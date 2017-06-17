package br.com.organmarket.entity;

public class DadosVenda {
	private Long id;
	private String orgao;
	private Double preco;
	private String dadosDoador;

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getOrgao() {
		return orgao;
	}
	public void setOrgao(String orgao) {
		this.orgao = orgao;
	}
	public Double getPreco() {
		return preco;
	}
	public void setPreco(Double preco) {
		this.preco = preco;
	}
	public String getDadosDoador() {
		return dadosDoador;
	}
	public void setDadosDoador(String dadosDoador) {
		this.dadosDoador = dadosDoador;
	}
	
	@Override
	public String toString() {
		return "[id = " + id + ", orgao = " + orgao + ", preco = " + preco + ", dadosDoador = " + dadosDoador + "]";
	}
}
