package br.com.livraria.model;

public class Audio extends Produto {

	// Atributos
	private String artista;
	private String gravadora;
	
	// M�todos de acesso
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
	
	// Sobrescrita obrigat�ria de m�todo abstrato
	public String identificar(){
		return "Descri��o: " + this.getDescricao() + 
			   "\nArtista: " + this.getArtista() + 
			   "\nPre�o de custo: " + this.getPrecoCusto() +
			   "\nPre�o de venda: " + this.calcularPrecoVenda();		
	}
	
	// Sobrescrita obrigat�ria de m�todo abstrato
	public double calcularPrecoVenda(){		
		return this.getPrecoCusto() + (this.getPrecoCusto() * 0.1);
	}

	
}
