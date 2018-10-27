package br.com.prontuario.model;

public class Administrador extends Funcionario{

	//Construtores
	public Administrador() {
		this(0, "", "", "");
	}

	public Administrador(int id, String nome, String coren, String senha) {
		super(id, nome, coren, senha);

	}

}
