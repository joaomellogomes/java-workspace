package br.com.prontuario.model;

import java.time.LocalDateTime;

public class Paciente {
	
	//Atributos
	private int id;
	private String nome;
	private String telefone;
	private String rg;
	private String cpf;
	private String sexo;
	private String ala;
	private int quarto;
	private int leito;
	private String historico;
	private String dataNascimento;
	
	//Construtores
	public Paciente() {
		this(0, "", "", "", "", "", "", 0, 0, "", "");
	}

	public Paciente(int id, String nome, String telefone, String rg, String cpf, String sexo, String ala, int quarto,
			int leito, String historico, String dataNascimento) {
		this.id = id;
		this.nome = nome;
		this.telefone = telefone;
		this.rg = rg;
		this.cpf = cpf;
		this.sexo = sexo;
		this.ala = ala;
		this.quarto = quarto;
		this.leito = leito;
		this.historico = historico;
		this.dataNascimento = dataNascimento;
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

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getAla() {
		return ala;
	}

	public void setAla(String ala) {
		this.ala = ala;
	}

	public int getQuarto() {
		return quarto;
	}

	public void setQuarto(int quarto) {
		this.quarto = quarto;
	}

	public int getLeito() {
		return leito;
	}

	public void setLeito(int leito) {
		this.leito = leito;
	}

	public String getHistorico() {
		return historico;
	}

	public void setHistorico(String historico) {
		this.historico = historico;
	}

	public String getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
}
