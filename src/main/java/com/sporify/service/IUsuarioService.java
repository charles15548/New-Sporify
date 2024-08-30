package com.sporify.service;

import java.util.List;
import java.util.Optional;

import com.sporify.models.Usuario;

public interface IUsuarioService {
	List<Usuario> findAll();
	Optional<Usuario> findById(Integer id);
	Usuario save(Usuario usuario);

}
