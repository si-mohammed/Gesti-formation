package com.training.spring.restapi.mysql.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

import com.training.spring.restapi.mysql.model.Formateur;
import com.training.spring.restapi.mysql.repo.FormateurRepository;
import com.training.spring.restapi.mysql.model.Participant;
import com.training.spring.restapi.mysql.repo.ParticipantRepository;
import java.util.*;
import java.text.*;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/apip/")
public class ParticipantController {

	/**
	 *
	 */
	
	@Autowired
	ParticipantRepository repository;



	@GetMapping("/participants")
	public ResponseEntity<List<Participant>> getAllParticipans() {
		List<Participant> participants = new ArrayList<>();
		try {
			//participants = repository.findAll();
			//repository.findAll().forEach(participants::add);
			repository.findAll().forEach(participant ->
			{
				participants.add(new Participant (participant.getId(), participant.getName(), participant.getLastname(), participant.getEmail(), participant.getAdress(), participant.getTel()));
			});

			if (participants.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(participants, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@RequestMapping("/save")
    public String process(){
        repository.save(new Participant("Walid", "Saad", "walid@gmail.com", "Lille", 11111));
        repository.save(new Participant("Walid", "Saad", "walid@gmail.com", "Lille", 11111));
        return "Done";
    }



	@GetMapping("/oneparticipant/{id}")
	public ResponseEntity<Participant> getParticipantById(@PathVariable("id") long id) {
		Participant ParticipantData = repository.findById(id);
        
		if (repository.existsById(id)) {
			return new ResponseEntity<>(new Participant (ParticipantData.getName(), ParticipantData.getLastname(), ParticipantData.getEmail(), ParticipantData.getAdress(), ParticipantData.getTel()), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping(value = "/participant")
	public ResponseEntity<Participant> postSession(@RequestBody Participant participant) {
		try {
			//Formateur _formateur = repository.save(new Formateur(formateur.getName(), formateur.getLastname(), formateur.getEmail(), formateur.getAdress(), formateur.getTel()));
			Participant _participant = repository.save(participant);
			return new ResponseEntity<>(_participant, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
		}
	}
	@GetMapping("/nombreparticipants/")
	public ResponseEntity<Long> getNombreParticipants() {
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
