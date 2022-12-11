package com.apirest.star.wars.apireststarwars.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.apirest.star.wars.apireststarwars.models.entity.Nave;

public interface INaveDao extends CrudRepository<Nave, Long> {

}
