package com.sporify.service;

import java.util.List;
import java.util.Optional;

import com.sporify.models.Musica;

public interface IMusicaService {
 public List<Musica> findAll();
 public Optional<Musica> get(Integer id);

 Musica save(Musica musica);
}
