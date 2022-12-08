//package org.iesalixar.servidor.controller;
//
//import java.security.Principal;
//import java.util.Set;
//
//import org.iesalixar.servidor.model.Reserva;
//import org.iesalixar.servidor.model.Usuario;
//import org.iesalixar.servidor.services.PistaServiceImpl;
//import org.iesalixar.servidor.services.ReservaService;
//import org.iesalixar.servidor.services.UsuarioServiceImpl;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.servlet.mvc.support.RedirectAttributes;
//
//@Controller
//public class PruebaController {
//
//	@Autowired
//	PistaServiceImpl pistaService;
//
//	@Autowired
//	UsuarioServiceImpl usuarioService;
//
//	@Autowired
//	ReservaService reService;
//
//	@GetMapping("/usuarios/edit")
//	public String editUsuarioGet(@RequestParam(name = "user") String user,
//			@RequestParam(required = false, name = "errorEmail") String errorEmail, Model model, Principal principal) {
//
//		// Para mostrar nombre y apellidos del usuario que ha iniciado sesion
//		Usuario user2 = usuarioService.getUsuarioByUserName(principal.getName());
//		model.addAttribute("user", user2);
//		// -------------------------------------
//
//		Usuario usuario = usuarioService.findUsuarioByIdModel(Long.parseLong(user));
//		model.addAttribute("usuario", usuario);
//
//		model.addAttribute("errorEmail", errorEmail);
//
//		return "usuario/editar";
//	}
//
//	@PostMapping("/usuarios/edit")
//	public String updateUsuarioPost(@ModelAttribute Usuario usu, RedirectAttributes atribute) {
//
//		Set<Reserva> re = reService.ReservaUsuario(usu);
//
//		Usuario usuario = new Usuario();
//		usuario.setId(usu.getId());
//		usuario.setNombre(usu.getNombre());
//		usuario.setApellido1(usu.getApellido1());
//		usuario.setApellido2(usu.getApellido2());
//		usuario.setUsername(usu.getUsername());
//		usuario.setPassword(usu.getPassword());
//		usuario.setEmail(usu.getEmail());
//		usuario.setRole(usu.getRole());
//		usuario.setNif(usu.getNif());
//		usuario.setLocalidad(usu.getLocalidad());
//		usuario.setProvincia(usu.getProvincia());
//		usuario.setTelefono(usu.getTelefono());
//		usuario.setSexo(usu.getSexo());
//		usuario.setFecha_nacimiento(usu.getFecha_nacimiento());
//		usuario.setFecha_registro(usu.getFecha_registro());
//		usuario.setReserva(re);
//
//		if (usuarioService.actualizarUsuario(usuario) == null) {
//			return "redirect:/usuarios/edit?error=error&user" + usu.getId();
//		}
//
//		atribute.addFlashAttribute("edit", "Usuario ''" + usu.getUsername() + "'' editado con éxito.");
//		return "redirect:/usuarios";
//	}
//}
