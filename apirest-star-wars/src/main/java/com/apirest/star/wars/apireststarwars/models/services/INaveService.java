package com.apirest.star.wars.apireststarwars.models.services;

import java.util.List;

import com.apirest.star.wars.apireststarwars.models.entity.Nave;

public interface INaveService {

	public List<Nave> findAll();

	public Nave save(Nave nave);
	
	public void delete (Long id);
	
	public Nave findById(Long id);
}
