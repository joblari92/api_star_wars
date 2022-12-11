package com.apirest.star.wars.apireststarwars.models.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="naves")
public class Nave {
	
	@Id
	private Long id;
	
	private String name;
		
	private Long crew;
	
	private Long passengers;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getCrew() {
		return crew;
	}

	public void setCrew(Long crew) {
		this.crew = crew;
	}

	public Long getPassengers() {
		return passengers;
	}

	public void setPassengers(Long passengers) {
		this.passengers = passengers;
	}
	
	

}
