package org.iesalixar.servidor.controller;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

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
public class UsuariosController {

	@Autowired
	UsuarioServiceImpl usuarioService;

	@RequestMapping("/usuarios")
	public String usuarios(Model model) {

		List<Usuario> usuario = usuarioService.getAllUsuarios();

		model.addAttribute("usuario", usuario);
		return "usuario/usuarios";
	}

	@GetMapping("/usuarios/edit")
	public String editUsuarioGet(@RequestParam(name = "user") String user, Model model) {

		Usuario usuario = usuarioService.findUsuarioByIdModel(Long.parseLong(user));
		model.addAttribute("usuario", usuario);

		return "usuario/editUsuario";
	}

	@PostMapping("/usuarios/edit")
	public String updateUsuarioPost(@ModelAttribute Usuario usu) {

		if (usuarioService.actualizarUsuario(usu) == null) {
			return "redirect:/usuarios/edit?error=error&user" + usu.getId();
		}
		return "redirect:/usuarios";
	}

	@GetMapping("/usuarios/delete")
	public String eliminarUsuario(@RequestParam(required = true, name = "user") String user, Model model) {

		Usuario usuario = usuarioService.findUsuarioByIdModel(Long.parseLong(user));

		if (usuario != null) {
			usuarioService.eliminarUsuario(usuario);
			return "redirect:/usuarios?codigo=" + user;
		} else {
			return "redirect:/usuarios/";
		}
	}

	@GetMapping("/usuarios/addUsuario")
	public String addUsuarioGet(@RequestParam(required = false, name = "error") String error, Model model) {

		UsuarioDTO usuarioDTO = new UsuarioDTO();
		model.addAttribute("usuarioDTO", usuarioDTO);
		model.addAttribute("error", error);

		return "usuario/addUsuario";
	}

	@PostMapping("/usuarios/addUsuario")
	public String addUsuarioPost(@ModelAttribute UsuarioDTO usuarioDTO) {

		Usuario usuario = new Usuario();
		usuario.setNif(usuarioDTO.getNif());
		usuario.setNombre(usuarioDTO.getNombre());
		usuario.setApellido1(usuarioDTO.getApellido1());
		usuario.setApellido2(usuarioDTO.getApellido2());
		usuario.setEmail(usuarioDTO.getEmail());
		usuario.setUsername(usuarioDTO.getUsername());
		usuario.setPassword(new BCryptPasswordEncoder(15).encode(usuarioDTO.getPassword()));
		usuario.setLocalidad(usuarioDTO.getLocalidad());
		usuario.setProvincia(usuarioDTO.getProvincia());
		usuario.setTelefono(usuarioDTO.getTelefono());
		usuario.setSexo(usuarioDTO.getSexo());
		usuario.setRole(usuarioDTO.getRole());
		usuario.setFecha_nacimiento(usuarioDTO.getFecha_nacimiento());
//		usuario.setFecha_registro(usuarioDTO.getFecha_registro());
		
		String fechaActual = new SimpleDateFormat("yyyy/MM/dd").format(Calendar.getInstance().getTime());
		usuario.setFecha_registro(fechaActual);

		if (usuarioService.insertUsuario(usuario) == null) {
			return "redirect:/usuarios/addUsuario?error=Existe&Usuario=" + usuarioDTO.getUsername();
		}

		return "redirect:/usuarios";

	}

}
