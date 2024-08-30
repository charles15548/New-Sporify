package com.sporify.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sporify.models.Usuario;

@Repository
public interface IRepositoryUsuario extends JpaRepository<Usuario, Integer>{

}
