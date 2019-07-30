package com.training.spring.restapi.mysql.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.training.spring.restapi.mysql.model.Participant;
import com.training.spring.restapi.mysql.model.Session;

public interface ParticipantRepository extends CrudRepository<Participant, Long> {
	List<Session> findByName(String name);

	Participant findById(long id);
	@Query("SELECT p.id, p.name, p.lastname, p.adress, p.email, p.tel "	+ "FROM Participant p")
    List<Participant> fetchAllParticipant();
}
