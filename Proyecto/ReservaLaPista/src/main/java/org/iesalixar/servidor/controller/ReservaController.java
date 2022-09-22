package org.iesalixar.servidor.controller;

import org.iesalixar.servidor.dto.ReservaDTO;
import org.iesalixar.servidor.model.Reserva;
import org.iesalixar.servidor.services.ReservaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ReservaController {

	@Autowired
	ReservaServiceImpl reservaService;
	
	
	@GetMapping("/reservar")
	public String reservarGet(@RequestParam(required = false, name = "error") String error, Model model) {

		ReservaDTO reservaDTO = new ReservaDTO();
		model.addAttribute("reservaDTO", reservaDTO);
		model.addAttribute("error", error);

		return "reserva/reservar";
	}

	@PostMapping("/reservar")
	public String reservarPost(@ModelAttribute ReservaDTO reservaDTO) {

		Reserva reserva = new Reserva();
		reserva.setId_usuario(reserva.getId_usuario());
		reserva.setId_pista(reserva.getId_pista());
		reserva.setFecha(reserva.getFecha());
		reserva.setHora_inicio(reserva.getHora_inicio());
		reserva.setHora_fin(reserva.getHora_fin());

		if (reservaService.insertReserva(reserva) == null) {
			return "redirect:/reservar?error=Existe&Reserva=" + reservaDTO.getId_usuario()+ reservaDTO.getId_pista();
		}

		return "redirect:/menu";

	}


	
}
