package org.iesalixar.servidor.dto;

import org.springframework.format.annotation.DateTimeFormat;

public class ReservaDTO {
	private int id_usuario;
	private int id_pista;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private String fecha;
	@DateTimeFormat(pattern = "hh:mm tt")
	private String hora_inicio;
	@DateTimeFormat(pattern = "hh:mm tt")
	private String hora_fin;

	public ReservaDTO() {
		// TODO Auto-generated constructor stub
	}

	public int getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
	}

	public int getId_pista() {
		return id_pista;
	}

	public void setId_pista(int id_pista) {
		this.id_pista = id_pista;
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

}
