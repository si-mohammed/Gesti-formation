package com.training.spring.restapi.mysql.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.training.spring.restapi.mysql.model.AdresseComplete;
import com.training.spring.restapi.mysql.model.Formateur;

public interface AdresseCompleteRepository extends CrudRepository<AdresseComplete, Long> {

	List<AdresseComplete> findByPays(String pays);

	AdresseComplete findById(long id);
	
	
	 @Query("SELECT a FROM AdresseComplete a "+"WHERE a.pays= :pays and a.ville= :ville") 
	 List<AdresseComplete> findByPaysAndVille( String pays, String ville);
	
		
	  @Query("SELECT a.id, a.complementAdresse1, a.complementAdresse2, a.cp, a.nomVoie, a.num, a.pays, a.typeVoie, a.ville"
	  + " FROM AdresseComplete a") 
	  List<AdresseComplete> fetchAllAdresseComplete();


	  @Query("SELECT a FROM AdresseComplete a " + "WHERE a.pays = :pays  AND  a.typeVoie = :typeVoie  AND  a.ville = :ville")
	  List<AdresseComplete> findByPaysAndVilleAndTypeVoie(String pays, String typeVoie, String ville);
	  //System.out.println("typeVoie =" + typeVoie);
	 
}
