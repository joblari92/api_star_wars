package com.apirest.star.wars.apireststarwars.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apirest.star.wars.apireststarwars.models.entity.Nave;
import com.apirest.star.wars.apireststarwars.models.services.INaveService;

@RestController
@RequestMapping("/api/")
public class NaveRestController {

	/*@Autowired
	private INaveService naveService;
	
	@GetMapping("/naves")
	public List<Nave> index(){
		return naveService.findAll();
	}*/
}
