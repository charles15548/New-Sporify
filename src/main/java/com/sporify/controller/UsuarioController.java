package com.sporify.controller;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sporify.models.Usuario;
import com.sporify.service.IMusicaService;
import com.sporify.service.IUsuarioService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {


	private final Logger logger = LoggerFactory.getLogger(UsuarioController.class);

	@Autowired
	private IUsuarioService usuarioService;
	@Autowired
	private IMusicaService musicaService;
	
	
//	@GetMapping("/template")
//	public String template(Model model, HttpSession session) {
//		
//		Usuario usuario = usuarioService.findById(Integer.parseInt(session.getAttribute("idusuario").toString())).get();
//		model.addAttribute("usuario", usuario.getIdusuario());
//		return "usuario/template_usua";
//	}
	@GetMapping("/home")
	public String home(Model model,Usuario usuario) {
		model.addAttribute("usuarios",usuarioService.findAll());
		return "usuario/home";
	}
	@GetMapping("/detalle/{id}")
	public String detalle(Model model,@PathVariable Integer id) {
		
		Usuario usuario = usuarioService.findById(id).get();
		
		model.addAttribute("musica",usuario.getMusica());
		return "usuario/detalle_usu";
	}
	
	
	
	
	
	
	
	
	//  Apartado para lo que es el registro, login y validacion.
	@GetMapping("/registro")
	public String registro() {
		
		return "usuario/registros";
	}
	@GetMapping("/login")
	public String login() {
		
		return "usuario/login";
	}
	@PostMapping("/save")
	public String registroSave(Usuario usuario) {
		logger.info("Usuario registro: {}",usuario);
		usuarioService.save(usuario);
		return "redirect:/usuario/login";
	}
	
	@PostMapping("/acceder")
	public String acceder(Usuario usuario, HttpSession session,Model model) {
		
		logger.info("Accesos .{}",usuario);
		Optional<Usuario> user = usuarioService.findById(usuario.getIdusuario());
		if(user.isPresent()) {
			Usuario loggerUser = user.get();
			
			Integer idusuario = user.get().getIdusuario();
		     logger.info("ID Usuario: " + idusuario); // Verifica que no sea null
		        
			session.setAttribute("idusuario", loggerUser.getIdusuario());
			session.setAttribute("nombreUsu",loggerUser.getNombre());	
			return "redirect:/usuario/home";
		}else {
			
			logger.info("Usuario no existe");
			String men= "Usuario no existe";
			model.addAttribute("message",men);
			return "usuario/login";
		}
		
	}
	@GetMapping("/cerrar")
	public String cerrarSesion(HttpSession session) {
		session.removeAttribute("idusuario");
		return "redirect:/usuario/home";
	}
}
