package com.training.spring.restapi.mysql.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.training.spring.restapi.mysql.dto.AdresseCompleteFormateurDTO;
import com.training.spring.restapi.mysql.dto.FormateurSessionDTO;
import com.training.spring.restapi.mysql.model.Formateur;
import com.training.spring.restapi.mysql.model.Session;

public interface FormateurRepository extends CrudRepository<Formateur, Long> {
	
	List<Session> findByName(String name);

	Formateur findById(long id);
	@Query("SELECT f.id, f.name, f.lastname, f.adress, f.email, f.tel "
	+ "FROM Formateur f")
    List<Formateur> fetchAllFormateur();

	
	/*
	 * @Query("SELECT new com.training.spring.restapi.mysql.dto.FormateurAdresseCompleteDTO (f.id, f.name, f.lastname, f.adress, f.email, f.tel, a.id, a.complementAdresse1, a.complementAdresse2, a.cp, a.nomVoie, a.num, a.pays, a.typeVoie, a.ville) "
	 * + " FROM AdresseComplete a INNER JOIN a.Formateur f")
	 * List<FormateurAdresseCompleteDTO> fetchAdresseCompleteByFormateur();
	 */
	
	
	  @Query("SELECT new com.training.spring.restapi.mysql.dto.AdresseCompleteFormateurDTO (f.id, f.name, f.lastname, a.id, a.complementAdresse1, a.complementAdresse2, a.cp, a.nomVoie, a.num, a.pays, a.typeVoie, a.ville) "
	  + " FROM AdresseComplete a INNER JOIN a.formateurs f")
	  List<AdresseCompleteFormateurDTO> fetchAdresseCompleteByFormateur();
	 
	 
	 
	 
	 
	
	
}
