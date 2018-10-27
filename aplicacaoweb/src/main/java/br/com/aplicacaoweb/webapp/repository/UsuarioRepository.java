package br.com.aplicacaoweb.webapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.aplicacaoweb.webapp.entity.UsuarioEntity;

public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Long>{
	
	UsuarioEntity findByLogin(String login);

}
