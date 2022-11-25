package org.iesalixar.servidor.controller;

import java.security.Principal;
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
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

	@Autowired
	UsuarioServiceImpl usuarioService;

	@RequestMapping({ "/", "/login" })
	public String login(Model model) {
		return "login/index";
	}

	@GetMapping("/register")
	public String registerGet(@RequestParam(required = false, name = "errorUsername") String errorUsername,
			@RequestParam(required = false, name = "errorEmail") String errorEmail,
			@RequestParam(required = false, name = "errorDNI") String errorDNI, Model model) {

		UsuarioDTO userDTO = new UsuarioDTO();
		model.addAttribute("userDTO", userDTO);
		model.addAttribute("errorUsername", errorUsername);
		model.addAttribute("errorEmail", errorEmail);
		model.addAttribute("errorDNI", errorDNI);

		return "login/register";
	}

	@PostMapping("/register")
	public String registerPost(@ModelAttribute UsuarioDTO usuario) {

		Usuario userBD = new Usuario();
		userBD.setNif(usuario.getNif());
		userBD.setNombre(usuario.getNombre());
		userBD.setApellido1(usuario.getApellido1());
		userBD.setApellido2(usuario.getApellido2());
		userBD.setEmail(usuario.getEmail());
		userBD.setUsername(usuario.getUsername());
		userBD.setPassword(new BCryptPasswordEncoder(15).encode(usuario.getPassword()));
		userBD.setLocalidad(usuario.getLocalidad());
		userBD.setProvincia(usuario.getProvincia());
		userBD.setTelefono(usuario.getTelefono());
		userBD.setSexo(usuario.getSexo());
		userBD.setRole("ROLE_USER");
		userBD.setFecha_nacimiento(usuario.getFecha_nacimiento());

		String fechaActual = new SimpleDateFormat("dd/MM/yyyy").format(Calendar.getInstance().getTime());
		userBD.setFecha_registro(fechaActual);

		userBD = usuarioService.insertUsuario(userBD);

		if (userBD == null) {
			if (usuarioService.getUsuarioByUserName(usuario.getUsername()) != null) {
				return "redirect:/register?errorUsername=Existe&usuario";
			} else if (usuarioService.getUsuarioByEmail(usuario.getEmail()) != null) {
				return "redirect:/register?errorEmail=Email&registrado";
			} else if (usuarioService.getUsuarioByNif(usuario.getNif()) != null) {
				return "redirect:/register?errorDNI=dni&registrado";
			}
		}

		return "redirect:/";
	}

	@RequestMapping({ "/menu" })
	public String menu(Model model, Principal principal) {

		// Para mostrar nombre y apellidos del usuario que ha iniciado sesion
		// http://www.it.uc3m.es/jaf/aw/practicas/5-spring/
		Usuario user = usuarioService.getUsuarioByUserName(principal.getName());
		model.addAttribute("user", user);

		return "menu/menu";
	}

}
