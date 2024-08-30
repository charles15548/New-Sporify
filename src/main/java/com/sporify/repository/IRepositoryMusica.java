package com.sporify.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sporify.models.Musica;

@Repository
public interface IRepositoryMusica extends JpaRepository<Musica, Integer>{

}
