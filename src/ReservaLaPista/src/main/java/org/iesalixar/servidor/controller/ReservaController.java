package org.iesalixar.servidor.controller;

import java.security.Principal;
import java.util.Date;
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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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

		ReservaDTO reservaDTO = new ReservaDTO();
		List<Pista> pista = pistaService.getAllPistas();

		model.addAttribute("reservaDTO", reservaDTO);
		model.addAttribute("usuario", user);
		model.addAttribute("pista", pista);
		model.addAttribute("error", error);

		return "reserva/reservar";
	}

	public List<Reserva> findReservas(Long idReserva, Date fechaReserva) {
		return reservaService.findReservasByIdAndFecha(idReserva, fechaReserva);
	}

	@PostMapping("/reservar")
	public String reservarPost(@ModelAttribute ReservaDTO reservaDTO, Model model, RedirectAttributes atribute) {

		Reserva reserva = new Reserva();
		reserva.setUsuario(reservaDTO.getId_usuario());
		reserva.setPista(reservaDTO.getId_pista());
		reserva.setFecha(reservaDTO.getFecha());
		reserva.setHora_inicio(reservaDTO.getHora_inicio());
//		reserva.setHora_fin(reservaDTO.getHora_fin());

		if (reservaService.insertReserva(reserva) == null) {
			return "redirect:/reservar?error=Existe&Reserva=" + reservaDTO.getId_usuario() + reservaDTO.getId_pista();
		}
		atribute.addFlashAttribute("success", "Reserva realizada con éxito.");
		return "redirect:/reservas";
	}

	@RequestMapping("/reservas")
	public String todasReservas(Model model, Principal principal) {

		// Para mostrar nombre y apellidos del usuario que ha iniciado sesion
		Usuario user = usuarioService.getUsuarioByUserName(principal.getName());
		model.addAttribute("user", user);
		// -------------------------------------

		List<Reserva> reserva = reservaService.getAllReservas();

		model.addAttribute("reserva", reserva);

		return "reserva/totalReservas";
	}

	@GetMapping("/reservas/addReserva")
	public String addReservaGet(@RequestParam(required = false, name = "error") String error, Model model,
			Principal principal) {

		// Para mostrar nombre y apellidos del usuario que ha iniciado sesion
		Usuario user = usuarioService.getUsuarioByUserName(principal.getName());
		model.addAttribute("user", user);
		// -------------------------------------

		ReservaDTO reservaDTO = new ReservaDTO();
		List<Usuario> usuario = usuarioService.getAllUsuarios();
		List<Pista> pista = pistaService.getAllPistas();

		model.addAttribute("reservaDTO", reservaDTO);
		model.addAttribute("usuario", usuario);
		model.addAttribute("pista", pista);
		model.addAttribute("error", error);

		return "reserva/addReserva";
	}

	@PostMapping("/reservas/addReserva")
	public String addReservaPost(@ModelAttribute ReservaDTO reservaDTO, Model model, RedirectAttributes atribute) {

		Reserva reserva = new Reserva();
		reserva.setUsuario(reservaDTO.getId_usuario());
		reserva.setPista(reservaDTO.getId_pista());
		reserva.setFecha(reservaDTO.getFecha());
		reserva.setHora_inicio(reservaDTO.getHora_inicio());
//		reserva.setHora_fin(reservaDTO.getHora_fin());

		if (reservaService.insertReserva(reserva) == null) {
			return "redirect:/reservas/addReserva?error=Existe&Reserva=" + reservaDTO.getId_usuario()
					+ reservaDTO.getId_pista();
		}
		atribute.addFlashAttribute("success", "Reserva realizada con éxito. Usuario: " + reservaDTO.getId_usuario());
		return "redirect:/reservas";
	}

//	@GetMapping("/reservas/delete")
//	public String eliminarReserva(@RequestParam(required = true, name = "pista") Pista pista,
//			@RequestParam(required = true, name = "usuario") Usuario usuario, Model model) {
//		
//		Reserva reserva = reservaService.findUsuarioPistaById(usuario, pista);
//
//		if (reserva != null) {
//			reservaService.deleteUsuarioPistaById(reserva);
//			return "redirect:/reservas";
//
//		} else {
//			return "redirect:/reservas/";
//		}
//	}

}
