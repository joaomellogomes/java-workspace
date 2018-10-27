package br.com.aplicacaoweb.webapp.model;

public class GrupoModel {
	
	private Long id;
	private String nome;
	private String descricao;
	private boolean checked;
	
	public GrupoModel() {
		
	}
	
	public GrupoModel(Long id, String nome, String descricao, boolean checked) {
		super();
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.checked = checked;
	}
	
	public GrupoModel(Long id,String descricao) {
		super();
		this.id = id;	
		this.descricao = descricao;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public boolean isChecked() {
		return checked;
	}

	public void setChecked(boolean checked) {
		this.checked = checked;
	}

	
	
}
