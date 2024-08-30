package com.sporify.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sporify.models.Musica;
import com.sporify.repository.IRepositoryMusica;

@Service
public class IMusicaServiceImp implements IMusicaService{

	@Autowired
	private IRepositoryMusica repositoryMusica;
	@Override
	public Musica save(Musica musica) {
		
		return repositoryMusica.save(musica);
	}
	@Override
	public List<Musica> findAll() {
		// TODO Auto-generated method stub
		return repositoryMusica.findAll();
	}
	@Override
	public Optional<Musica> get(Integer id) {
		// TODO Auto-generated method stub
		return repositoryMusica.findById(id);
	}

}
