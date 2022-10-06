package org.iesalixar.servidor.services;

import java.util.ArrayList;
import java.util.List;

import org.iesalixar.servidor.model.Reserva;
import org.iesalixar.servidor.repository.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservaServiceImpl implements ReservaService {

	@Autowired
	ReservaRepository reservaRepo;

	@Override
	public Reserva insertReserva(Reserva reserva) {
		if (reserva != null) {
			Reserva reser = reservaRepo.save(reserva);
			return reser;
		}

		return null;

	}

	@Override
	public List<Reserva> getAllReservas() {
		List<Reserva> reserva = reservaRepo.findAll();
		if (reserva != null && reserva.size() > 0) {
			return reserva;
		}
		return new ArrayList<Reserva>();
	}

}