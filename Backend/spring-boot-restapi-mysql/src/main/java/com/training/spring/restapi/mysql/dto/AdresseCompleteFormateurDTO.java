package com.training.spring.restapi.mysql.dto;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class AdresseCompleteFormateurDTO  {
    
    private long id;
    private String formateurname;
    private String formateurlastname;
    private long adresseCompleteid;
	private String complementAdresse1;
	private String complementAdresse2;
	private String cp;
	private String nomVoie;
	private String num;
	private String pays;
	private String typeVoie;
	private String ville;

 
	public AdresseCompleteFormateurDTO( long _id, String formateur_name, String formateur_lastname,
			long _adresseCompleteid, 
			String _complementAdresse1,
			String _complementAdresse2,
			String _cp,
			String _nomVoie,
			String _num,
			String _pays,
			String _typeVoie,
			String _ville)
			
			
	
     {		
        this.id = _id;
        this.formateurname = formateur_name;
        this.formateurlastname = formateur_lastname;        	
        this.adresseCompleteid=_adresseCompleteid;
        this.complementAdresse1=_complementAdresse1;
        this.complementAdresse2=_complementAdresse2;
        this.cp=_cp;
        this.nomVoie=_nomVoie;
        this.num=_num;
        this.pays=_pays;
        this.typeVoie=_typeVoie;
        this.ville=_ville;
	}
	 
	
	//getters and setters

	public long getid() {
		return id;
	}


	public void setid(long id) {
		this.id = id;
	}


	public String getFormateurname() {
		return formateurname;
	}


	public void setFormateurname(String formateurname) {
		this.formateurname = formateurname;
	}


	public String getFormateurlastname() {
		return formateurlastname;
	}


	public void setFormateurlastname(String formateurlastname) {
		this.formateurlastname = formateurlastname;
	}


	public long getAdresseCompleteid() {
		return adresseCompleteid;
	}


	public void setAdresseCompleteid(long adressecompleteid) {
		this.adresseCompleteid = adressecompleteid;
	}


	public String getComplementAdresse1() {
		return complementAdresse1;
	}


	public void setComplementAdresse1(String complementAdresse1) {
		this.complementAdresse1 = complementAdresse1;
	}


	public String getComplementAdresse2() {
		return complementAdresse2;
	}


	public void setComplementAdresse2(String complementAdresse2) {
		this.complementAdresse2 = complementAdresse2;
	}


	public String getCp() {
		return cp;
	}


	public void setCp(String cp) {
		this.cp = cp;
	}


	public String getNomVoie() {
		return nomVoie;
	}


	public void setNomVoie(String nomVoie) {
		this.nomVoie = nomVoie;
	}


	public String getNum() {
		return num;
	}


	public void setNum(String num) {
		this.num = num;
	}


	public String getPays() {
		return pays;
	}


	public void setPays(String pays) {
		this.pays = pays;
	}


	public String getTypeVoie() {
		return typeVoie;
	}


	public void setTypeVoie(String typeVoie) {
		this.typeVoie = typeVoie;
	}


	public String getVille() {
		return ville;
	}


	public void setVille(String ville) {
		this.ville = ville;
	}

	


        

}