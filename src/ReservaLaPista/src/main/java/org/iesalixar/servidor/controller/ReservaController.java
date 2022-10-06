package org.iesalixar.servidor.controller;

import java.security.Principal;
import java.util.List;

import org.iesalixar.servidor.dto.ReservaDTO;
import org.iesalixar.servidor.model.Pista;
import org.iesalixar.servidor.model.Reserva;
import org.iesalixar.servidor.model.Usuario;
import org.iesalixar.servidor.services.PistaServiceImpl;
import org.iesalixar.servidor.services.ReservaServiceImpl;
import org.iesalixar.servidor.services.UsuarioServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ReservaController {

	@Autowired
	ReservaServiceImpl reservaService;

	@Autowired
	UsuarioServiceImpl usuarioService;

	@Autowired
	PistaServiceImpl pistaService;

	@GetMapping("/reservar")
	public String reservarGet(@RequestParam(required = false, name = "error") String error, Model model,
			Principal principal) {

		// Para mostrar nombre y apellidos del usuario que ha iniciado sesion
		Usuario user = usuarioService.getUsuarioByUserName(principal.getName());
		model.addAttribute("user", user);
		// -------------------------------------

		List<Usuario> usuario = usuarioService.getAllUsuarios();
		model.addAttribute("usuario", usuario);

		List<Pista> pista = pistaService.getAllPistas();
		model.addAttribute("pista", pista);

		ReservaDTO reservaDTO = new ReservaDTO();
		model.addAttribute("reservaDTO", reservaDTO);
		model.addAttribute("error", error);

		return "reserva/reservar";
	}

//	@PostMapping("/reservar")
//	public String reservarPost(@ModelAttribute ReservaDTO reservaDTO) {
//
//		Reserva reserva = new Reserva();
//		reserva.setId_usuario(reserva.getId_usuario());
//		reserva.setId_pista(reserva.getId_pista());
//		reserva.setFecha(reserva.getFecha());
//		reserva.setHora_inicio(reserva.getHora_inicio());
//		reserva.setHora_fin(reserva.getHora_fin());
//
//		if (reservaService.insertReserva(reserva) == null) {
//			return "redirect:/reservar?error=Existe&Reserva=" + reservaDTO.getId_usuario() + reservaDTO.getId_pista();
//		}
//
//		return "redirect:/menu";
//
//	}

	@RequestMapping("/reservas")
	public String todasReservas(Model model, Principal principal) {

		// Para mostrar nombre y apellidos del usuario que ha iniciado sesion
		Usuario user = usuarioService.getUsuarioByUserName(principal.getName());
		model.addAttribute("user", user);
		// -------------------------------------

//		List<Reserva> reservas = reservaService.getAllReservas();
//		model.addAttribute("reservas", reservas);
//		
//		List<Usuario> usuario = usuarioService.getAllUsuarios();
//		model.addAttribute("usuario", usuario);
//
//		List<Pista> pista = pistaService.getAllPistas();
//		model.addAttribute("pista", pista);
//		
//		
//		ReservaDTO reservaDTO = new ReservaDTO();
//		model.addAttribute("reservaDTO", reservaDTO);

		List<Reserva> reserva = reservaService.getAllReservas();

		model.addAttribute("reserva", reserva);
		
		return "reserva/totalReservas";
	}

}
