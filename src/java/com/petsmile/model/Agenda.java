package com.petsmile.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Time;
import java.util.Date;


/**
 * The persistent class for the agenda database table.
 * 
 */
@Entity
@NamedQuery(name="Agenda.findAll", query="SELECT a FROM Agenda a")
public class Agenda implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="AGENDA_ID_GENERATOR" )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="AGENDA_ID_GENERATOR")
	private int id;

	@Temporal(TemporalType.DATE)
	private Date fecha;

	private Time hora;

	private String nombreMascota;

	//bi-directional many-to-one association to Mascota
	@ManyToOne
	@JoinColumn(name="idMascota")
	private Mascota mascota;

	//bi-directional many-to-one association to Dueno
	@ManyToOne
	@JoinColumn(name="rutDueno")
	private Dueno dueno;

	public Agenda() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Time getHora() {
		return this.hora;
	}

	public void setHora(Time hora) {
		this.hora = hora;
	}

	public String getNombreMascota() {
		return this.nombreMascota;
	}

	public void setNombreMascota(String nombreMascota) {
		this.nombreMascota = nombreMascota;
	}

	public Mascota getMascota() {
		return this.mascota;
	}

	public void setMascota(Mascota mascota) {
		this.mascota = mascota;
	}

	public Dueno getDueno() {
		return this.dueno;
	}

	public void setDueno(Dueno dueno) {
		this.dueno = dueno;
	}

}