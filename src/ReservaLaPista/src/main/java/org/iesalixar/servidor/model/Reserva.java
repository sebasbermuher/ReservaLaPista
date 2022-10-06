package org.iesalixar.servidor.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "reserva")
@IdClass(Reserva_id.class)
public class Reserva implements Serializable {

	@Id
	@ManyToOne
	@JoinColumn(name = "id_usuario", insertable = false, updatable = false)
	private Usuario usuario;

	@Id
	@ManyToOne
	@JoinColumn(name = "id_pista", insertable = false, updatable = false)
	private Pista pista;

	private String fecha;

	private String hora_inicio;

	private String hora_fin;

	public Reserva() {
	}

	public Reserva(Usuario usuario, Pista pista, String fecha, String hora_inicio, String hora_fin) {
		this.usuario = usuario;
		this.pista = pista;
		this.fecha = fecha;
		this.hora_inicio = hora_inicio;
		this.hora_fin = hora_fin;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Pista getPista() {
		return pista;
	}

	public void setPista(Pista pista) {
		this.pista = pista;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getHora_inicio() {
		return hora_inicio;
	}

	public void setHora_inicio(String hora_inicio) {
		this.hora_inicio = hora_inicio;
	}

	public String getHora_fin() {
		return hora_fin;
	}

	public void setHora_fin(String hora_fin) {
		this.hora_fin = hora_fin;
	}

	@Override
	public int hashCode() {
		return Objects.hash(fecha, hora_fin, hora_inicio, pista, usuario);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Reserva other = (Reserva) obj;
		return Objects.equals(fecha, other.fecha) && Objects.equals(hora_fin, other.hora_fin)
				&& Objects.equals(hora_inicio, other.hora_inicio) && Objects.equals(pista, other.pista)
				&& Objects.equals(usuario, other.usuario);
	}

}
