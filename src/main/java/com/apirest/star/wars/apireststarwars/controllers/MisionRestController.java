package com.apirest.star.wars.apireststarwars.controllers;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Scanner;

import org.hibernate.internal.build.AllowSysOut;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apirest.star.wars.apireststarwars.models.entity.Mision;
import com.apirest.star.wars.apireststarwars.models.services.IMisionService;

@RestController
@RequestMapping("/api")
public class MisionRestController {

	@Autowired
	private IMisionService misionService;
	
	@GetMapping("/misiones")
	public List<Mision> index()	{
		return misionService.findAll();
	}
	
	@GetMapping("/misiones/{id}")
	public Mision show(@PathVariable Long id) {
		return misionService.findById(id);
	}
	
	@PostMapping("/misiones")
	public Mision create(@RequestBody Mision mision) {
		System.out.println(mision.getNave());
		if (naveExiste(mision) && pilotoExiste(mision) 
				&& planetaExiste(mision)
				&& mision.getTripulacion() >= 0) {
			duracionMision(mision);
			return misionService.save(mision);
		}else {
			Mision misionFallida = new Mision();
			misionFallida.setLog("Misión Fallida");
			return misionFallida;
		}
		
	}
	
	@PutMapping("/misiones/{id}")
	public Mision update(@RequestBody Mision mision,@PathVariable Long id) {
		Mision misionActual = misionService.findById(id);
		misionActual.setFinalizada(mision.getFinalizada());
		
		return misionService.save(misionActual);
	}
	
	@DeleteMapping("/misiones/{id}")
	public void delete(@PathVariable Long id) {
		misionService.delete(id);
	}
	
	public boolean naveExiste(Mision mision) {
		Boolean existe = false;
		try {
			URL url = new URL("https://swapi.dev/api/starships/?format=json");

			HttpURLConnection conn = (HttpURLConnection) url.openConnection();

			conn.setRequestMethod("GET");

			conn.connect();

			int responseCode = conn.getResponseCode();

			if (responseCode != 200){
				throw new RuntimeException("Ocurrió un error: " + responseCode);
			} else {
				StringBuilder informationString = new StringBuilder();

				Scanner scanner = new Scanner(url.openStream());

				while (scanner.hasNext()){
					informationString.append(scanner.nextLine());
					System.out.println(informationString);
				}
				scanner.close();

				System.out.println(informationString);

				JSONObject jsonObject = new JSONObject(informationString.toString());
				JSONArray jsonArray = jsonObject.getJSONArray("results");
				System.out.println(jsonArray);
				for (int i = 0; i < jsonArray.length(); i++){
					try{
						JSONObject nave = jsonArray.getJSONObject(i);
						if(nave.getString("name").equals(mision.getNave())){
							System.out.println("Nave encontrada");
							existe = true;
							return existe;
						}
					}catch (Exception e){
						e.printStackTrace();
						return false;
					}
				}
			}
			return existe;

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean pilotoExiste(Mision mision) {
		Boolean existe = false;
		try {
			URL url = new URL("https://swapi.dev/api/people/?format=json");

			HttpURLConnection conn = (HttpURLConnection) url.openConnection();

			conn.setRequestMethod("GET");

			conn.connect();

			int responseCode = conn.getResponseCode();

			if (responseCode != 200){
				throw new RuntimeException("Ocurrió un error: " + responseCode);
			} else {
				StringBuilder informationString = new StringBuilder();

				Scanner scanner = new Scanner(url.openStream());

				while (scanner.hasNext()){
					informationString.append(scanner.nextLine());
					System.out.println(informationString);
				}
				scanner.close();

				System.out.println(informationString);

				JSONObject jsonObject = new JSONObject(informationString.toString());
				JSONArray jsonArray = jsonObject.getJSONArray("results");
				System.out.println(jsonArray);
				for (int i = 0; i < jsonArray.length(); i++){
					try{
						JSONObject capitan = jsonArray.getJSONObject(i);
						if(capitan.getString("name").equals(mision.getCapitan1())){
							System.out.println("Capitan1 encontrado");
							existe = true;
							for (int i1 = 0; i1 < jsonArray.length(); i1++){
								try{
									capitan = jsonArray.getJSONObject(i1);
									if(capitan.getString("name").equals(mision.getCapitan2())){
										System.out.println("Capitan2 encontrado");
										existe = true;
										break;
									}else {
										existe = false;
									}
								}catch (Exception e){
									e.printStackTrace();
								}
							}
							break;
						}
					}catch (Exception e){
						e.printStackTrace();
					}
				}
				
			}
			return existe;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return existe;
	}
	
	public boolean planetaExiste(Mision mision) {
		Boolean existe = false;
		try {
			URL url = new URL("https://swapi.dev/api/planets/?format=json");

			HttpURLConnection conn = (HttpURLConnection) url.openConnection();

			conn.setRequestMethod("GET");

			conn.connect();

			int responseCode = conn.getResponseCode();

			if (responseCode != 200){
				throw new RuntimeException("Ocurrió un error: " + responseCode);
			} else {
				StringBuilder informationString = new StringBuilder();

				Scanner scanner = new Scanner(url.openStream());

				while (scanner.hasNext()){
					informationString.append(scanner.nextLine());
					System.out.println(informationString);
				}
				scanner.close();

				System.out.println(informationString);

				JSONObject jsonObject = new JSONObject(informationString.toString());
				JSONArray jsonArray = jsonObject.getJSONArray("results");
				System.out.println(jsonArray);
				for (int i = 0; i < jsonArray.length(); i++){
					try{
						JSONObject planeta = jsonArray.getJSONObject(i);
						if(planeta.getString("name").equals(mision.getPlaneta1())){
							System.out.println("Planeta1 encontrado");
							existe = true;
							for (int i1 = 0; i1 < jsonArray.length(); i1++){
								try{
									planeta = jsonArray.getJSONObject(i1);
									if(planeta.getString("name").equals(mision.getPlaneta2())){
										System.out.println("Planeta2 encontrado");
										existe = true;
										break;
									}else {
										existe = false;
									}
								}catch (Exception e){
									e.printStackTrace();
								}
							}
							break;
						}
					}catch (Exception e){
						e.printStackTrace();
					}
				}
				
			}
			return existe;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return existe;
	}
	
	public void duracionMision(Mision mision) {
		Integer duracion = 0;
		Integer diametro1 = 0;
		Integer diametro2 = 0;
		try {
			URL url = new URL("https://swapi.dev/api/planets/?format=json");

			HttpURLConnection conn = (HttpURLConnection) url.openConnection();

			conn.setRequestMethod("GET");

			conn.connect();

			int responseCode = conn.getResponseCode();

			if (responseCode != 200){
				throw new RuntimeException("Ocurrió un error: " + responseCode);
			} else {
				StringBuilder informationString = new StringBuilder();

				Scanner scanner = new Scanner(url.openStream());

				while (scanner.hasNext()){
					informationString.append(scanner.nextLine());
					System.out.println(informationString);
				}
				scanner.close();

				System.out.println(informationString);

				JSONObject jsonObject = new JSONObject(informationString.toString());
				JSONArray jsonArray = jsonObject.getJSONArray("results");
				System.out.println(jsonArray);
				
				for (int i = 0; i < jsonArray.length(); i++){
					try{
						JSONObject planeta = jsonArray.getJSONObject(i);
						if(planeta.getString("name").equals(mision.getPlaneta1())){
							diametro1 = Integer.parseInt(planeta.getString("diameter"));
							break;
						}
					}catch (Exception e){
								e.printStackTrace();
					}
				}
				for (int i = 0; i < jsonArray.length(); i++){
					try{
						JSONObject planeta = jsonArray.getJSONObject(i);
						if(planeta.getString("name").equals(mision.getPlaneta2())){
							diametro2 = Integer.parseInt(planeta.getString("diameter"));
							break;
						}
					}catch (Exception e){
								e.printStackTrace();
					}
				}
				System.out.println(mision.getTripulacion());
				if((diametro1 + diametro2) / (mision.getTripulacion()*10) >= 1) {
					duracion = (int) (Math.ceil((diametro1 + diametro2) / (mision.getTripulacion()*10)));
				}else{
					duracion = 1;
				};
				
				mision.setDuracion(duracion);
				
			}
				
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
