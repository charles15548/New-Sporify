package com.sporify.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sporify.models.Usuario;
import com.sporify.repository.IRepositoryUsuario;

@Service
public class IUsuarioServiceImp implements IUsuarioService {

	@Autowired
	private IRepositoryUsuario repoUsua;

	@Override
	public List<Usuario> findAll() {
		// TODO Auto-generated method stub
		return repoUsua.findAll();
	}

	@Override
	public Optional<Usuario> findById(Integer id) {
		// TODO Auto-generated method stub
		return repoUsua.findById(id);
	}

	@Override
	public Usuario save(Usuario usuario) {
		// TODO Auto-generated method stub
		return repoUsua.save(usuario);
	}

	
	
}
