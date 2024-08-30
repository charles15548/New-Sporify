package com.sporify.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name= "musica")
public class Musica {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idmusica;
	private String nombre;
	private String audio;
	
	@ManyToOne 
	@JoinColumn(name = "idusuario") // Nombre de la columna en la tabla musica   
	private Usuario usuario;
	
	
	public Musica(Integer idmusica, String nombre, String audio, Usuario usuario) {
		super();
		this.idmusica = idmusica;
		this.nombre = nombre;
		this.audio = audio;
		this.usuario = usuario;
	}

	public Musica() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Musica [idmusica=" + idmusica + ", nombre=" + nombre + ", audio=" + audio + ", usuario=" + usuario
				+ "]";
	}

	public Integer getIdmusica() {
		return idmusica;
	}

	public void setIdmusica(Integer idmusica) {
		this.idmusica = idmusica;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getAudio() {
		return audio;
	}

	public void setAudio(String audio) {
		this.audio = audio;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	
	
	
}
