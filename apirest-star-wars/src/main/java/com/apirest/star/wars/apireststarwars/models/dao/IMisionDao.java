package com.apirest.star.wars.apireststarwars.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.apirest.star.wars.apireststarwars.models.entity.Mision;

public interface IMisionDao extends CrudRepository<Mision, Long>{

}
