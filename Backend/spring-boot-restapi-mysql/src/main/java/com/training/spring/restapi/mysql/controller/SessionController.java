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

import com.training.spring.restapi.mysql.dto.FormateurSessionDTO;
import com.training.spring.restapi.mysql.dto.ParticipantSessionDTO;
import com.training.spring.restapi.mysql.model.Formateur;
import com.training.spring.restapi.mysql.model.Participant;
import com.training.spring.restapi.mysql.model.Session;
import com.training.spring.restapi.mysql.repo.FormateurRepository;
import com.training.spring.restapi.mysql.repo.ParticipantRepository;
import com.training.spring.restapi.mysql.repo.SessionRepository;

//import com.training.spring.restapi.mysql.dto.FormateurParticipantSessionDTO;

//import java.util.*;
//import java.text.*;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class SessionController {

	/**
	 *
	 */
	
	@Autowired
	SessionRepository repository;

	@Autowired
	FormateurRepository repositoryformateur;
	
	@Autowired
	ParticipantRepository repositoryparticipant;

	@GetMapping("/sessions/list") // get la liste de toutes les sessions
	
	public ResponseEntity<List<Session>> getAllSessions() {
		List<Session> sessions = new ArrayList<>();
		try {
			//repository.findAll().forEach(sessions::add);
			repository.findAll().forEach(session ->
			{
				sessions.add(new Session (session.getId(), session.getName(), session.getTrack(), session.getDate(), session.getDuree(), session.getAdress(), session.getParticipants(), session.getIsCompleted()));
			});
			if (sessions.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(sessions, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}


	@GetMapping("/sessionsf/list") // get la liste de toutes les sessions avec formateur
	
	public ResponseEntity<List<FormateurSessionDTO>> getAllSessionsf() {
		//List<FormateurSessionDTO> sessions = new ArrayList<>();
		try {
		//	repository.fetchFormateurBySession().forEach(sessions::add);
		List<FormateurSessionDTO> sessions=repository.fetchFormateurBySession();
			if (sessions.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(sessions, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping("/sessionf/add") // post une session avec formateur, accepte également une session sans formateur
	 
	public ResponseEntity<Session> postSessionf(@RequestBody Session session) { 
		 try { 
			 //Session _session = repository.save(new Session(session.getName(), session.getTrack(), null, 0, null, 0, false));
			 //Participant p = repositoryparticipant.findById(id);
			 //session.setParticipant(p); 
			 Session _session = repository.save(session);
			 return new ResponseEntity<>(_session, HttpStatus.CREATED); 
			 } catch (Exception e) { 
				 return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED); 
				 } 
		 }
	
	@GetMapping("/sessionsp/list") // get la liste de toutes les session avec participant
	
	public ResponseEntity<List<ParticipantSessionDTO>> getAllSessionsp() {
		//List<FormateurSessionDTO> sessions = new ArrayList<>();
		try {
		//	repository.fetchFormateurBySession().forEach(sessions::add);
		List<ParticipantSessionDTO> sessions=repository.fetchParticipantBySession();
			if (sessions.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(sessions, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	/*
	 * @GetMapping("/sessionsfp") public
	 * ResponseEntity<List<FormateurParticipantSessionDTO>> getAllSessionsfp() {
	 * //List<FormateurSessionDTO> sessions = new ArrayList<>(); try {
	 * //repository.fetchFormateurBySession().forEach(sessions::add);
	 * List<FormateurParticipantSessionDTO>
	 * sessions=repository.fetchFormateurParticipantBySession(); if
	 * (sessions.isEmpty()) { return new ResponseEntity<>(HttpStatus.NO_CONTENT); }
	 * return new ResponseEntity<>(sessions, HttpStatus.OK); } catch (Exception e) {
	 * return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR); } }
	 */
	 
	
	/*
	 * @RequestMapping("/save") public String process(){ 
	 * repository.save(new
	 * Session("Web", "NodeJS", null, 10, "Lille", 5, false ));
	 * repository.save(new Session("Web", "NodeJS", null, 10, "Lille", 5, false
	 * )); return "Done"; }
	 */



	@GetMapping("/onesession/{id}") // get une session avec un id
	
	public ResponseEntity<Session> getSessionById(@PathVariable("id") long id) {
		Session sessionData = repository.findById(id);

		if (repository.existsById(id)) {
			return new ResponseEntity<>(new Session (sessionData.getId(), sessionData.getName(), sessionData.getTrack(), sessionData.getDate(), sessionData.getDuree(), sessionData.getAdress(), sessionData.getParticipants(), sessionData.getIsCompleted()), HttpStatus.OK);
			
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		
		
	}

	@GetMapping("/nombresessions/") //get le nombre de session
	
	public ResponseEntity<Long> getNombreSessions() {
		try {
			if (repository.count()==0) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(repository.count(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
		}
	}

	@PostMapping("/sessionf/{formateur_id}") // post une session avec un formateur: fournir l'id du formateur.
	
	public ResponseEntity<Session> postSessionf(@PathVariable("formateur_id") long id, @RequestBody Session session) {
		try {
			//Session _session = repository.save(new Session(session.getName(), session.getTrack(), null, 0, null, 0, false));
			Formateur f = repositoryformateur.findById(id);
			session.setFormateur(f);
			Session _session = repository.save(session);
			return new ResponseEntity<>(_session, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
		}
	}
	
	 @PostMapping("/sessionp/{participant_id}") // post une session avec un formateur: fournir l'id du participant.
	 
	 public ResponseEntity<Session> postSessionp(@PathVariable("participant_id") long id, @RequestBody Session session) { 
		 try { 
			 //Session _session = repository.save(new Session(session.getName(), session.getTrack(), null, 0, null, 0, false));
			 Participant p = repositoryparticipant.findById(id);
			 session.setParticipant(p); 
			 Session _session = repository.save(session);
			 return new ResponseEntity<>(_session, HttpStatus.CREATED); 
			 } catch (Exception e) { 
				 return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED); 
				 } 
		 }
	 @PostMapping("/session/add") //post une session sans formateur possible redondance avec sessionf/add
	 
	 public ResponseEntity<Session> postSessionp(@RequestBody Session session) { 
		 try { 
			 //Session _session = repository.save(new Session(session.getName(), session.getTrack(), null, 0, null, 0, false));
			 //Participant p = repositoryparticipant.findById(id);
			 //session.setParticipant(p); 
			 Session _session = repository.save(session);
			 return new ResponseEntity<>(_session, HttpStatus.CREATED); 
			 } catch (Exception e) { 
				 return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED); 
				 } 
		 }

	@DeleteMapping("/session/delete/{id}") // Supprime une session fournir l'id de la session
	
	public ResponseEntity<HttpStatus> deleteSession(@PathVariable("id") long id) {
		try {
			repository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
		}
	}

	@DeleteMapping("/sessions") //Supprime toutes les sessions
	
	public ResponseEntity<HttpStatus> deleteAllSession() {
		try {
			repository.deleteAll();
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
		}

	}

	@GetMapping(value = "nombreTracks/{track}") // donne le nombre qu'un {Track} est enregistré 
	
	public ResponseEntity<Integer> countByTrack(@PathVariable String track) {
		try {
			List<Session> sessions = repository.findByTrack(track);

			if (sessions.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(sessions.size(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
		}
	}

	@PutMapping("/session/update/{id}") // update une session fournir id de la session
	
	public ResponseEntity<Session> updateSession(@PathVariable("id") long id, @RequestBody Session session) {
		Session sessionData = repository.findById(id);

		if (repository.existsById(id)) {
			Session _session = sessionData;
			_session.setName(session.getName());
			_session.setTrack(session.getTrack());
			_session.setDate(session.getDate());
			_session.setDuree(session.getDuree());
			_session.setParticipants(session.getParticipants());
			_session.setDuree(session.getDuree());
			_session.setIsCompleted(session.getIsCompleted());
			return new ResponseEntity<>(repository.save(_session), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}
