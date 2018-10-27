package br.com.livraria.model;

public class Video extends Produto {

	// Atributos
	public String diretor;
	
	// Construtor
	public Video(String descricao, String genero,
			     String diretor) {
		// Realiza uma chamada ao construtor da superclasse inicializando somente os atributos que interessam
		super(descricao, genero, "", "", 0);
		// Inicializa os atributos especificos da subclasse
		this.diretor = diretor;
	}

	// M�todos de acesso
	public String getDiretor() {
		return diretor;
	}

	public void setDiretor(String diretor) {
		this.diretor = diretor;
	}

	// Funcionalidades
	
	// Sobrescrita obrigat�ria de m�todo abstrato
	public String identificar(){
		return "Descri��o: " + this.getDescricao() + 
			   "\nOrigem: " + this.getOrigem() + 
			   "\nDiretor: " + this.getDiretor() + 
			   "\nPre�o de custo: " + this.getPrecoCusto() +
			   "\nPre�o de venda: " + this.calcularPrecoVenda();		
	}
	
	// Sobrescrita obrigat�ria de m�todo abstrato
	public double calcularPrecoVenda(){		
		return this.getPrecoCusto() + (this.getPrecoCusto() * 0.1);
	}

}
