package com.apirest.star.wars.apireststarwars.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.apirest.star.wars.apireststarwars.models.dao.INaveDao;
import com.apirest.star.wars.apireststarwars.models.entity.Nave;

public class NaveService implements INaveService {

	@Autowired
	private INaveDao naveDao;
	@Override
	@Transactional(readOnly = true)
	public List<Nave> findAll() {
		return (List<Nave>) naveDao.findAll();
	}

	@Override
	@Transactional
	public Nave save(Nave nave) {
		return naveDao.save(nave);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		naveDao.deleteById(id);

	}

	@Override
	@Transactional(readOnly = true)
	public Nave findById(Long id) {
		return naveDao.findById(id).orElse(null);
	}

}
