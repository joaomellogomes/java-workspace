package br.com.livraria.model;

public class Livro extends Produto {

	// atributos
	private String autor;
	private String editora;
	private int edicao;
	
	// Construtor
	public Livro() {
		super();
		this.autor = "";
		this.editora = "";
		this.edicao = 0;		
	}
	
	public Livro(String descricao, String genero, String origem, String formato, double precoCusto,
				 String autor, String editora, int edicao) {
		// Realiza uma chamada ao construtor da superclasse 
		super(descricao, genero, origem, formato, precoCusto);
		// Inicializa os atributos especificos da subclasse
		this.autor = autor;
		this.editora = editora;
		this.edicao = edicao;
	}

	
	// Métodos de acesso
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public String getEditora() {
		return editora;
	}
	public void setEditora(String editora) {
		this.editora = editora;
	}
	public int getEdicao() {
		return edicao;
	}
	public void setEdicao(int edicao) {
		this.edicao = edicao;
	}

	// Funcionalidades
	
	// Sobrescrita obrigatória de método abstrato
	public String identificar(){
		return "Descrição: " + this.getDescricao() + 
			   "\nAutor: " + this.getAutor() + 
			   "\nPreço de custo: " + this.getPrecoCusto() +
			   "\nPreço de venda: " + this.calcularPrecoVenda();		
	}
	
	// Sobrescrita obrigatória de método abstrato 
	public double calcularPrecoVenda(){
		return this.getPrecoCusto() + (this.getPrecoCusto() * 0.07);
	}

	
}
