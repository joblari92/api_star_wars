package com.apirest.star.wars.apireststarwars.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.apirest.star.wars.apireststarwars.models.dao.IMisionDao;
import com.apirest.star.wars.apireststarwars.models.entity.Mision;
import com.fasterxml.jackson.databind.util.JSONPObject;

@Service 
public class MisionService implements IMisionService{

	@Autowired
	private IMisionDao misionDao;
	@Override
	@Transactional(readOnly = true)
	public List<Mision> findAll() {
		return (List<Mision>) misionDao.findAll();
	}
	@Override
	@Transactional
	public Mision save(Mision mision) {
		return misionDao.save(mision);
	}
	@Override
	@Transactional
	public void delete(Long id) {
		misionDao.deleteById(id);
		
	}
	@Override
	@Transactional(readOnly = true)
	public Mision findById(Long id) {
		return misionDao.findById(id).orElse(null);
	}

}
