package br.com.livraria.model;

public class Audio extends Produto {

	// Atributos
	private String artista;
	private String gravadora;
	
	// Métodos de acesso
	public String getArtista() {
		return artista;
	}
	public void setArtista(String artista) {
		this.artista = artista;
	}
	public String getGravadora() {
		return gravadora;
	}
	public void setGravadora(String gravadora) {
		this.gravadora = gravadora;
	}

	// Funcionalidades
	
	// Sobrescrita obrigatória de método abstrato
	public String identificar(){
		return "Descrição: " + this.getDescricao() + 
			   "\nArtista: " + this.getArtista() + 
			   "\nPreço de custo: " + this.getPrecoCusto() +
			   "\nPreço de venda: " + this.calcularPrecoVenda();		
	}
	
	// Sobrescrita obrigatória de método abstrato
	public double calcularPrecoVenda(){		
		return this.getPrecoCusto() + (this.getPrecoCusto() * 0.1);
	}

	
}
