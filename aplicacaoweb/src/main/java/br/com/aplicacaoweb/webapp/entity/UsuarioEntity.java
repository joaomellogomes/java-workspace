package br.com.aplicacaoweb.webapp.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Table(name="usuario", schema="applicationspring")
@Entity
public class UsuarioEntity implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="usuId")
	private Long id;
	
	@Column(name="usuNome")
	private String nome;
	
	@Column(name="usuLogin")
	private String login;
	
	@Column(name="usuSenha")
	private String senha;
	
	@Column(name="usuAtivo")
	private boolean ativo;
	
	@JoinTable(name="usuarioGrupo",
			joinColumns = {@JoinColumn(name = "usuId", referencedColumnName = "usuId")},
			inverseJoinColumns = {@JoinColumn(name = "gruId", referencedColumnName = "gruId")})
	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	private List<GrupoEntity> grupos;
	
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
	
	public String getLogin() {
		return login;
	}
	
	public void setLogin(String login) {
		this.login = login;
	}
	
	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public boolean isAtivo() {
		return ativo;
	}
	
	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}
	
	public List<GrupoEntity> getGrupos(){
		return grupos;
	}
	
	public void setGrupos(List<GrupoEntity> grupos) {
		this.grupos = grupos;
	}
}









