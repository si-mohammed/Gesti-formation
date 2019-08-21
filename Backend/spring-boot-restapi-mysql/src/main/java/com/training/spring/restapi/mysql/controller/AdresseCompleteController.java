package com.training.spring.restapi.mysql.controller;

import java.util.ArrayList;
import java.util.List;
//import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.training.spring.restapi.mysql.model.AdresseComplete;
import com.training.spring.restapi.mysql.repo.AdresseCompleteRepository;

//import java.util.*;
//import java.text.*;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/apia/")
public class AdresseCompleteController {

	/**
	 *
	 */
	
	@Autowired
	AdresseCompleteRepository repository;



	@GetMapping("/adresseCompletes/list")
	public ResponseEntity<List<AdresseComplete>> getAllAdresseCompletes() {
		List<AdresseComplete> adresseCompletes = new ArrayList<>();
		try {
			//formateurs = repository.findAll();
			//repository.findAll().forEach(formateurs::add);
			repository.findAll().forEach(adresseComplete ->
			{
				adresseCompletes.add(new AdresseComplete (adresseComplete.getId(), adresseComplete.getComplementAdresse1(), adresseComplete.getComplementAdresse2(), adresseComplete.getCp(), adresseComplete.getNomVoie(), adresseComplete.getNum(), adresseComplete.getPays(), adresseComplete.getTypeVoie(), adresseComplete.getVille()));
			});

			if (adresseCompletes.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(adresseCompletes, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/adresseCompletes/pays/{pays}") // Selection par Pays : il faut fournir un pays
	public ResponseEntity<List<AdresseComplete>> getAdresseCompletesByPays(@PathVariable("pays") String pays) {
		List<AdresseComplete> adresseCompletes = new ArrayList<>();
		try {
			//formateurs = repository.findAll();
			//repository.findAll().forEach(formateurs::add);
			repository.findByPays(pays).forEach(adresseComplete ->
			{
				adresseCompletes.add(new AdresseComplete (adresseComplete.getId(), adresseComplete.getComplementAdresse1(), adresseComplete.getComplementAdresse2(), adresseComplete.getCp(), adresseComplete.getNomVoie(), adresseComplete.getNum(), adresseComplete.getPays(), adresseComplete.getTypeVoie(), adresseComplete.getVille()));
			});

			if (adresseCompletes.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(adresseCompletes, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/adresseCompletes/pays/{pays}/ville/{ville}")
public ResponseEntity<List<AdresseComplete>> getAllAdresseCompletes_pvs(@PathVariable String pays, @PathVariable String ville) {
		List<AdresseComplete> adresseCompletes = new ArrayList<>();
		try {
			//formateurs = repository.findAll();
			//repository.findAll().forEach(formateurs::add);
			repository.findByPaysAndVille(pays,ville).forEach(adresseComplete ->
			{
				adresseCompletes.add(new AdresseComplete (adresseComplete.getId(), adresseComplete.getComplementAdresse1(), adresseComplete.getComplementAdresse2(), adresseComplete.getCp(), adresseComplete.getNomVoie(), adresseComplete.getNum(), adresseComplete.getPays(), adresseComplete.getTypeVoie(), adresseComplete.getVille()));
			});

			if (adresseCompletes.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(adresseCompletes, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/adresseCompletes/pays/{pays}/ville/{ville}/typeVoie/{typeVoie}")
	public ResponseEntity<List<AdresseComplete>> getAllAdresseCompletes_pvts(@PathVariable String pays, @PathVariable String ville, @PathVariable String typeVoie) {
			List<AdresseComplete> adresseCompletes = new ArrayList<>();
			try {
				//formateurs = repository.findAll();
				//repository.findAll().forEach(formateurs::add);
				System.out.println("typeVoie = "+typeVoie);
				repository.findByPaysAndVilleAndTypeVoie(pays,typeVoie, ville).forEach(adresseComplete ->
				{
					adresseCompletes.add(new AdresseComplete (adresseComplete.getId(), adresseComplete.getComplementAdresse1(), adresseComplete.getComplementAdresse2(), adresseComplete.getCp(), adresseComplete.getNomVoie(), adresseComplete.getNum(), adresseComplete.getPays(), adresseComplete.getTypeVoie(), adresseComplete.getVille()));
				});

				if (adresseCompletes.isEmpty()) {
					return new ResponseEntity<>(HttpStatus.NO_CONTENT);
				}
				return new ResponseEntity<>(adresseCompletes, HttpStatus.OK);
			} catch (Exception e) {
				return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
	
	@GetMapping("/adresseCompletes/pays/ville/nomvoie")
	public ResponseEntity<List<AdresseComplete>> getAllAdresseCompletes_pvtns() {
		List<AdresseComplete> adresseCompletes = new ArrayList<>();
		try {
			//formateurs = repository.findAll();
			//repository.findAll().forEach(formateurs::add);
			repository.findAll().forEach(adresseComplete ->
			{
				adresseCompletes.add(new AdresseComplete (adresseComplete.getId(), adresseComplete.getNomVoie(), adresseComplete.getPays(), adresseComplete.getTypeVoie(), adresseComplete.getVille()));
			});

			if (adresseCompletes.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(adresseCompletes, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@GetMapping("/adresseCompletes/pays/ville/num")
	public ResponseEntity<List<AdresseComplete>> getAllAdresseCompletes_pvtnnums() {
		List<AdresseComplete> adresseCompletes = new ArrayList<>();
		try {
			//formateurs = repository.findAll();
			//repository.findAll().forEach(formateurs::add);
			repository.findAll().forEach(adresseComplete ->
			{
				adresseCompletes.add(new AdresseComplete (adresseComplete.getId(), adresseComplete.getNomVoie(), adresseComplete.getNum(), adresseComplete.getPays(), adresseComplete.getTypeVoie(), adresseComplete.getVille()));
			});

			if (adresseCompletes.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(adresseCompletes, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@RequestMapping("/save")
    public String process(){
        //repository.save(new AdresseComplete("Walid", "Saad", "walid@gmail.com", "Lille", 11111));
        //repository.save(new AdresseComplete("Walid", "Saad", "walid@gmail.com", "Lille", 11111));
        return "Done";
    }



	@GetMapping("/oneadresseComplete/{id}")
	public ResponseEntity<AdresseComplete> getAdresseCompleteById(@PathVariable("id") long id) {
		AdresseComplete adresseCompleteData = repository.findById(id);
        
		if (repository.existsById(id)) {
			return new ResponseEntity<>(new AdresseComplete (adresseCompleteData.getComplementAdresse1(), adresseCompleteData.getComplementAdresse2(), adresseCompleteData.getCp(), adresseCompleteData.getNomVoie(), adresseCompleteData.getNum(), adresseCompleteData.getPays(), adresseCompleteData.getTypeVoie(), adresseCompleteData.getVille()), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping(value = "/adresseComplete/add")
	public ResponseEntity<AdresseComplete> postSession(@RequestBody AdresseComplete adresseComplete) {
		try {
			//Formateur _formateur = repository.save(new Formateur(formateur.getName(), formateur.getLastname(), formateur.getEmail(), formateur.getAdress(), formateur.getTel()));
			AdresseComplete _adresseComplete = repository.save(adresseComplete);
			return new ResponseEntity<>(_adresseComplete, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
		}
	}
	@GetMapping("/nombreadresseCompletes/")
	public ResponseEntity<Long> getNombreAdresseCompletes() {
		try {
			if (repository.count()==0) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(repository.count(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
		}
	}
	

}
