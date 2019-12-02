package com.SMSLATAM.app.domain.service;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;

@Entity
@Table(name = "adn")
public class AdnApi {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Long id;

	@Column(name = "dna", nullable = true)
	private String[] dna;

	@Column(name = "isMutant", nullable = true)
	private Boolean mutant;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String[] getDna() {
		return dna;
	}

	public void setDna(String[] dna) {
		this.dna = dna;
	}

	public Boolean getMutant() {
		return mutant;
	}

	public void setMutant(Boolean mutant) {
		this.mutant = mutant;
	}

	public AdnApi(Long id, String[] dna, Boolean mutant) {
		super();
		this.dna = dna;
		this.id = id;
		this.mutant = mutant;
	}

	public AdnApi() {
		super();
	}
}
