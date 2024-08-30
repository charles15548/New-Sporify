package com.sporify.controller;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sporify.models.Musica;
import com.sporify.models.Usuario;
import com.sporify.service.IMusicaService;
import com.sporify.service.IUsuarioService;
import com.sporify.service.UploadService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/")
public class MusicaController {

	@Autowired
	private  IUsuarioService usuarioService;
	@Autowired
	private UploadService upload;
	private final Logger LOGGER = LoggerFactory.getLogger(MusicaController.class);
	
	@Autowired
	private IMusicaService musicaService;
	
	@GetMapping("")
	public String index(Model model) {
		model.addAttribute("musica",musicaService.findAll());
		return "index";
	}
	
	@PostMapping("/save")
	public String save(HttpSession session, Musica musica,@RequestParam("aud") MultipartFile file) throws IOException {
		LOGGER.info("Este es el objeto musica {}",musica);
		
		
		 if (musica.getIdmusica() == null) {
		        String nombreAudio = upload.saveAudio(file);
		        musica.setAudio(nombreAudio);
		    } else {
		        if (file.isEmpty()) {
		            Musica m = musicaService.get(musica.getIdmusica()).get();
		            musica.setAudio(m.getAudio());
		        } else {
		            String nombreAudio = upload.saveAudio(file);
		            musica.setAudio(nombreAudio);
		        }
		    }
		//usuario 
		 Usuario usuario = usuarioService.findById(Integer.parseInt(session.getAttribute("idusuario").toString())).get();
		//guardar el atrib. usuario
		 musica.setUsuario(usuario);
		 musicaService.save(musica);
		return "redirect:/";
	}
	
	
	 
}
