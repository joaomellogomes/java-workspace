package br.com.aplicacaoweb.webapp.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Table(name="grupo", schema="applicationspring")
@Entity
public class GrupoEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="gruId")
	private Long id;
	
	@Column(name="gruNome")
	private String nome;
	
	@Column(name="gruDescricao")
	private String descricao;
	
	@ManyToMany
	@JoinTable(name="usuarioGrupo",
			joinColumns=@JoinColumn(name="gruId", referencedColumnName="gruId"),
			inverseJoinColumns=@JoinColumn(name="usuId", referencedColumnName="usuId"))	
	private List<UsuarioEntity> usuarios;
	
	@ManyToMany
	@JoinTable(name="permissaoGrupo", 
			joinColumns=@JoinColumn(name="gruId", referencedColumnName="gruId"),
			inverseJoinColumns=@JoinColumn(name="perId", referencedColumnName="perId"))
	private List<PermissaoEntity> permissoes;
	
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
	
	public List<UsuarioEntity> getUsuarios(){
		return usuarios;
	}
	
	public void setUsuarios(List<UsuarioEntity> usuarios) {
		this.usuarios = usuarios;
	}
	
	public List<PermissaoEntity> getPermissoes(){
		return permissoes;
	}
	
	public void setPermissoes(List<PermissaoEntity> permissoes) {
		this.permissoes = permissoes;
	}

}
