package br.com.prontuario.model;

public class Funcionario{

	//Atributos
	private int id;
	private String nome;
	private String coren;
	private String senha;
	
	//Construtores
	public Funcionario() {
		this(0, "", "", "");
	}

	public Funcionario(int id, String nome, String coren, String senha) {
		this.id = id;
		this.nome = nome;
		this.coren = coren;
		this.senha = senha;
	}

	//Métodos de acesso
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCoren() {
		return coren;
	}

	public void setCoren(String coren) {
		this.coren = coren;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	

}
