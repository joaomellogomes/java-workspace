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

	// Métodos de acesso
	public String getDiretor() {
		return diretor;
	}

	public void setDiretor(String diretor) {
		this.diretor = diretor;
	}

	// Funcionalidades
	
	// Sobrescrita obrigatória de método abstrato
	public String identificar(){
		return "Descrição: " + this.getDescricao() + 
			   "\nOrigem: " + this.getOrigem() + 
			   "\nDiretor: " + this.getDiretor() + 
			   "\nPreço de custo: " + this.getPrecoCusto() +
			   "\nPreço de venda: " + this.calcularPrecoVenda();		
	}
	
	// Sobrescrita obrigatória de método abstrato
	public double calcularPrecoVenda(){		
		return this.getPrecoCusto() + (this.getPrecoCusto() * 0.1);
	}

}
