package com.sporify.models;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name= "usuario")

public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idusuario;
	private String nombre;
	private String contraseña;
	
	@OneToMany(mappedBy = "usuario")
	private List<Musica> musica;

	 
	 
	public Integer getIdusuario() {
		return idusuario;
	}

	public void setIdusuario(Integer idusuario) {
		this.idusuario = idusuario;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}

	public List<Musica> getMusica() {
		return musica;
	}

	public void setMusica(List<Musica> musica) {
		this.musica = musica;
	}

	@Override
	public String toString() {
		return "Usuario [idusuario=" + idusuario + ", nombre=" + nombre + ", contraseña=" + contraseña + ", musica="
				+ musica + "]";
	}

	public Usuario(Integer idusuario, String nombre, String contraseña, List<Musica> musica) {
		super();
		this.idusuario = idusuario;
		this.nombre = nombre;
		this.contraseña = contraseña;
		this.musica = musica;
	}

	public Usuario() {
		super();
		// TODO Auto-generated constructor stub
	}
}
