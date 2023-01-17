package com.petsmile.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the mascota database table.
 * 
 */
@Entity
@NamedQuery(name="Mascota.findAll", query="SELECT m FROM Mascota m")
public class Mascota implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="MASCOTA_IDMASCOTA_GENERATOR" )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="MASCOTA_IDMASCOTA_GENERATOR")
	private int idMascota;

	private int edad;

	private String nombreMascota;

	private String tipoMascota;

	@OneToMany(mappedBy="mascota")
	private List<Agenda> agendas;

	@ManyToOne
	@JoinColumn(name="rutDueno")
	private Dueno dueno;

	public Mascota() {
	}

	public int getIdMascota() {
		return this.idMascota;
	}

	public void setIdMascota(int idMascota) {
		this.idMascota = idMascota;
	}

	public int getEdad() {
		return this.edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getNombreMascota() {
		return this.nombreMascota;
	}

	public void setNombreMascota(String nombreMascota) {
		this.nombreMascota = nombreMascota;
	}

	public String getTipoMascota() {
		return this.tipoMascota;
	}

	public void setTipoMascota(String tipoMascota) {
		this.tipoMascota = tipoMascota;
	}

	public List<Agenda> getAgendas() {
		return this.agendas;
	}

	public void setAgendas(List<Agenda> agendas) {
		this.agendas = agendas;
	}

	public Agenda addAgenda(Agenda agenda) {
		getAgendas().add(agenda);
		agenda.setMascota(this);

		return agenda;
	}

	public Agenda removeAgenda(Agenda agenda) {
		getAgendas().remove(agenda);
		agenda.setMascota(null);

		return agenda;
	}

	public Dueno getDueno() {
		return this.dueno;
	}

	public void setDueno(Dueno dueno) {
		this.dueno = dueno;
	}

}