package org.iesalixar.servidor.model;

import java.io.Serializable;
import java.util.Objects;

public class Reserva_id implements Serializable {

	private Long usuario;
	private Long pista;

	public Reserva_id() {
	}

	public Long getUsuario() {
		return usuario;
	}

	public void setUsuario(Long usuario) {
		this.usuario = usuario;
	}

	public Long getPista() {
		return pista;
	}

	public void setPista(Long pista) {
		this.pista = pista;
	}

	@Override
	public int hashCode() {
		return Objects.hash(pista, usuario);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Reserva_id other = (Reserva_id) obj;
		return Objects.equals(pista, other.pista) && Objects.equals(usuario, other.usuario);
	}

	

}
