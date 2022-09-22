package org.iesalixar.servidor.repository;

import org.iesalixar.servidor.model.Reserva;
import org.iesalixar.servidor.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservaRepository extends JpaRepository<Usuario,Long> {

	public Usuario findByUsername(String username);
	public Usuario findByEmail(String email);
	public Reserva save(Reserva reserva);
}
