package br.com.livraria.model;

abstract public class Produto {

	// Atributos
	private String descricao;
	private String genero;
	private String origem;
	private String formato;
	private double precoCusto;
	
	// Construtores
	public Produto() {
		this.descricao = "";
		this.genero = "";
		this.origem = "";
		this.formato = "";
		this.precoCusto = 0;
	}
	public Produto(String descricao, String genero, String origem, String formato, double precoCusto) {
		this.descricao = descricao;
		this.genero = genero;
		this.origem = origem;
		this.formato = formato;
		this.precoCusto = precoCusto;
	}
	
	// Métodos de acesso
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public String getOrigem() {
		return origem;
	}
	public void setOrigem(String origem) {
		this.origem = origem;
	}
	public String getFormato() {
		return formato;
	}
	public void setFormato(String formato) {
		this.formato = formato;
	}
	public double getPrecoCusto() {
		return precoCusto;
	}
	public void setPrecoCusto(double precoCusto) {
		this.precoCusto = precoCusto;
	}
		
	// Funcionalidades

	// Métodos abstratos
	abstract public String identificar();
	
	abstract public double calcularPrecoVenda();
	
}
