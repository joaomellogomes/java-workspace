package br.com.prontuario.model;

public class Enfermeiro extends Funcionario{

	//Construtores
	public Enfermeiro() {
		this(0, "", "", "");
	}

	public Enfermeiro(int id, String nome, String coren, String senha) {
		super(id, nome, coren, senha);
	}

}
