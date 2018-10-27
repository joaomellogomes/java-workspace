package br.com.livraria.model;

public class Jogo extends Produto {

	// Atributo
	public String desenvolvedor;
	public String plataforma;
	
    // M�todos de acesso
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

	
	// Sobrescrita obrigat�ria de m�todo abstrato
	@Override
	public String identificar() {
		return "Descri��o: " + this.getDescricao() + 
			   "\nPlataforma: " + this.getPlataforma() +
			   "\nPre�o de custo: " + this.getPrecoCusto() +
			   "\nPre�o de venda: " + this.calcularPrecoVenda();		
	}

	// Sobrescrita obrigat�ria de m�todo abstrato
	@Override
	public double calcularPrecoVenda() {
		return this.getPrecoCusto() + (this.getPrecoCusto() * 0.12);
	}

}
