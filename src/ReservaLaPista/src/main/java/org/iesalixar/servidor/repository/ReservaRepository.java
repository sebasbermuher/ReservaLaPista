package org.iesalixar.servidor.repository;

import java.util.Date;
import java.util.List;

import org.iesalixar.servidor.model.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservaRepository extends JpaRepository<Reserva, Long> {

//	public Usuario findByUsername(String username);
//	public Usuario findByEmail(String email);
	public Reserva save(Reserva reserva);

	public List<Reserva> findReservasByIdAndFecha(Long id, Date fecha);

//	public Reserva findByUsuarioPista(Usuario id, Pista id1);

}
