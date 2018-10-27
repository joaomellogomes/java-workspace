package br.com.aplicacaoweb.webapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.aplicacaoweb.webapp.entity.GrupoEntity;
import br.com.aplicacaoweb.webapp.entity.UsuarioEntity;

public interface GrupoRepository extends JpaRepository<GrupoEntity, Long>{
	
	List<GrupoEntity> findByUsuariosIn(UsuarioEntity usuarioEntity);

}
