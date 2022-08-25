package com.Bartolome.Roig.tareas.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
//import java.time.format.DateTimeFormatter;

@Entity
@Table(name="TAREAS", catalog="TAREAS_APP",schema="")
public class Tarea {

	@Id
	@Column (name = "IDENTIFICADOR")
	private Integer identificador;
	
	@Column (name = "DESCRIPCION")
	private String descripcion;
	
	@Column (name = "FECHA_CREACION")
	private String fechaCreacion;
	
	@Column (name = "VIGENTE")
	private Boolean vigente;
	
	

	public Integer getIdentificador() {
		return identificador;
	}

	public void setIdentificador(Integer identificador) {
		this.identificador = identificador;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(String fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public Boolean getVigente() {
		return vigente;
	}

	public void setVigente(Boolean vigente) {
		this.vigente = vigente;
	}

	@Override
	public String toString() {
		return "Tarea [identificador=" + identificador + ", descripcion=" + descripcion + ", fechaCreacion="
				+ fechaCreacion + ", vigente=" + vigente + "]";
	}
	
	
	
	
}
