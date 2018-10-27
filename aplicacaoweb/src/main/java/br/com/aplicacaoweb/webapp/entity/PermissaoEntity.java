package br.com.aplicacaoweb.webapp.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Table(name="permissao", schema="applicationspring")
@Entity
public class PermissaoEntity {
	
	@Id
	@Column(name="perId")
	private int id;
	
	@Column(name="perPermissao")
	private String permissao;
	
	@Column(name="perDescricao")
	private String descricao;
	
	@ManyToMany(mappedBy="permissoes")
	private List<GrupoEntity> grupos;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public String getPermissao() {
		return permissao;
	}
	
	public void setPermissao(String permissao) {
		this.permissao = permissao;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public List<GrupoEntity> getGrupos(){
		return grupos;
	}
	
	public void setGrupos(List<GrupoEntity> grupos) {
		this.grupos = grupos;
	}
	
}
