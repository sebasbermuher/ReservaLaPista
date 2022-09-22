package org.iesalixar.servidor.controller;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.iesalixar.servidor.dto.UsuarioDTO;
import org.iesalixar.servidor.model.Usuario;
import org.iesalixar.servidor.services.UsuarioServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

	@Autowired
	UsuarioServiceImpl usuarioService;

//	@RequestMapping("/")
//	public String home(Model model) {
//		model.addAttribute("contenido", "INICIO");
//		return "index";
//	}

//	@GetMapping("/register")
//	public String registerGet(Model model) {
//
//		UsuarioDTO userDTO = new UsuarioDTO();
//		model.addAttribute("userDTO", userDTO);
//
//		return "register";
//	}
//
//	@PostMapping("/register")
//	public String registerPost(@ModelAttribute UsuarioDTO usuario) {
//
//		Usuario userBD = new Usuario();
//		userBD.setNif(usuario.getNif());
//		userBD.setNombre(usuario.getNombre());
//		userBD.setApellido1(usuario.getApellido1());
//		userBD.setApellido2(usuario.getApellido2());
//		userBD.setEmail(usuario.getEmail());
//		userBD.setUsername(usuario.getUsername());
//		userBD.setPassword(new BCryptPasswordEncoder(15).encode(usuario.getPassword()));
//		userBD.setLocalidad(usuario.getLocalidad());
//		userBD.setProvincia(usuario.getProvincia());
//		userBD.setTelefono(usuario.getTelefono());
//		userBD.setSexo(usuario.getSexo());
//		userBD.setRole("ROLE_USER");
//		userBD.setFecha_nacimiento(usuario.getFecha_nacimiento());
//		
//		String fechaActual = new SimpleDateFormat("yyyy/MM/dd").format(Calendar.getInstance().getTime());
//		userBD.setFecha_registro(fechaActual);
//
//		userBD = usuarioService.insertUsuario(userBD);
//
//		if (userBD == null) {
//			return "redirect:/register";
//		}
//
//		return "redirect:/";
//
//	}

}
