package com.apirest.star.wars.apireststarwars.models.services;

import java.util.List;

import com.apirest.star.wars.apireststarwars.models.entity.Mision;

public interface IMisionService {

	public List<Mision> findAll();
	
	public Mision save(Mision mision);
	
	public void delete (Long id);
	
	public Mision findById(Long id);
}
