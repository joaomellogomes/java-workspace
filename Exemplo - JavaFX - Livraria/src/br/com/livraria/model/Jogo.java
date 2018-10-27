package br.com.livraria.model;

public class Jogo extends Produto {

	// Atributo
	public String desenvolvedor;
	public String plataforma;
	
    // Métodos de acesso
	public String getDesenvolvedor() {
		return desenvolvedor;
	}

	public void setDesenvolvedor(String desenvolvedor) {
		this.desenvolvedor = desenvolvedor;
	}

	public String getPlataforma() {
		return plataforma;
	}

	public void setPlataforma(String plataforma) {
		this.plataforma = plataforma;
	}

	
	// Sobrescrita obrigatória de método abstrato
	@Override
	public String identificar() {
		return "Descrição: " + this.getDescricao() + 
			   "\nPlataforma: " + this.getPlataforma() +
			   "\nPreço de custo: " + this.getPrecoCusto() +
			   "\nPreço de venda: " + this.calcularPrecoVenda();		
	}

	// Sobrescrita obrigatória de método abstrato
	@Override
	public double calcularPrecoVenda() {
		return this.getPrecoCusto() + (this.getPrecoCusto() * 0.12);
	}

}
