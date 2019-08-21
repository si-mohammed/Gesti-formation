package com.training.spring.restapi.mysql.model;

import java.util.Set;

import javax.persistence.*;

//import com.fasterxml.jackson.annotation.JsonBackReference ;


/**
 * The persistent class for the adresse database table.
 * 
 */
@Entity
@Table(name = "adresse")

public class AdresseComplete {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;

	@Column(name="complement_adresse_1")
	private String complementAdresse1;

	@Column(name="complement_adresse_2")
	private String complementAdresse2;
	
	@Column(name="cp")
	private String cp;

	@Column(name="nom_voie")
	private String nomVoie;
	
	@Column(name="num")
	private String num;
	
	@Column(name="pays")
	private String pays;
	
	@Column(name="type_voie")
	private String typeVoie;
	
	@Column(name="ville")
	private String ville;
	
	/*
	 * @Column(name="Utilisateur_idUtilisateur") int Utilisateur_idUtilisateur;
	 */
	/*
	 * @JsonBackReference
	 * 
	 * @ManyToOne(fetch = FetchType.EAGER)
	 * 
	 * @JoinColumn(name="Utilisateur_idUtilisateur") private Utilisateur
	 * utilisateur;
	 */

	 @OneToMany(targetEntity = Formateur.class, mappedBy = "adresseComplete", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
		private Set<Formateur> formateurs;
	 
	 public AdresseComplete() {
		}
	 
	 public AdresseComplete(long _id, String _complementAdresse1, String _complementAdresse2, String _cp, String _nomVoie, String _num, String _pays, String _typeVoie, String _ville )
	 {
	    this.id = _id;
		this.complementAdresse1 = _complementAdresse1;
		this.complementAdresse2 = _complementAdresse2;
		this.cp = _cp;
		this.nomVoie= _nomVoie;
		this.num=_num;
		this.pays = _pays;
		this.typeVoie=_typeVoie;
		this.ville=_ville;
	}
	
	 public AdresseComplete(String _complementAdresse1, String _complementAdresse2, String _cp, String _nomVoie, String _num, String _pays, String _typeVoie, String _ville )
	 {
		this.complementAdresse1 = _complementAdresse1;
		this.complementAdresse2 = _complementAdresse2;
		this.cp = _cp;
		this.nomVoie= _nomVoie;
		this.num=_num;
		this.pays = _pays;
		this.typeVoie=_typeVoie;
		this.ville=_ville;
	}
	 public AdresseComplete(long _id, String _pays )
	 {
		 this.id = _id;
		 //this.complementAdresse1 = _complementAdresse1;
		//this.complementAdresse2 = _complementAdresse2;
		//this.cp = _cp;
		//this.nomVoie= _nomVoie;
		//this.num=_num;
		this.pays = _pays;
		//this.typeVoie=_typeVoie;
		//this.ville=_ville;
	}
	 
	 
	 public AdresseComplete(long _id, String _pays, String _ville )
	 {
		 this.id = _id;
		 //this.complementAdresse1 = _complementAdresse1;
		//this.complementAdresse2 = _complementAdresse2;
		//this.cp = _cp;
		//this.nomVoie= _nomVoie;
		//this.num=_num;
		this.pays = _pays;
		//this.typeVoie=_typeVoie;
		this.ville=_ville;
	}
	 
	 public AdresseComplete(long _id, String _pays, String _typeVoie, String _ville )
	 {
		 this.id = _id;
		 //this.complementAdresse1 = _complementAdresse1;
		//this.complementAdresse2 = _complementAdresse2;
		//this.cp = _cp;
		//this.nomVoie= _nomVoie;
		//this.num=_num;
		this.pays = _pays;
		this.typeVoie=_typeVoie;
		this.ville=_ville;
	}
	 public AdresseComplete(long _id, String _nomVoie, String _pays, String _typeVoie, String _ville )
	 {
		 this.id = _id;
		 //this.complementAdresse1 = _complementAdresse1;
		//this.complementAdresse2 = _complementAdresse2;String _pays,
		//this.cp = _cp;
		this.nomVoie= _nomVoie;
		//this.num=_num;
		this.pays = _pays;
		this.typeVoie=_typeVoie;
		this.ville=_ville;
	}
	 public AdresseComplete(long _id,  String _nomVoie, String _num, String _pays, String _typeVoie, String _ville )
	 {
		 this.id = _id;
		 //this.complementAdresse1 = _complementAdresse1;
		//this.complementAdresse2 = _complementAdresse2;
		//this.cp = _cp;
		this.nomVoie= _nomVoie;
		this.num=_num;
		this.pays = _pays;
		this.typeVoie=_typeVoie;
		this.ville=_ville;
	} 

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getComplementAdresse1() {
		return this.complementAdresse1;
	}

	public void setComplementAdresse1(String complementAdresse1) {
		this.complementAdresse1 = complementAdresse1;
	}

	public String getComplementAdresse2() {
		return this.complementAdresse2;
	}

	public void setComplementAdresse2(String complementAdresse2) {
		this.complementAdresse2 = complementAdresse2;
	}

	public String getCp() {
		return this.cp;
	}

	public void setCp(String cp) {
		this.cp = cp;
	}

	public String getNomVoie() {
		return this.nomVoie;
	}

	public void setNomVoie(String nomVoie) {
		this.nomVoie = nomVoie;
	}

	public String getNum() {
		return this.num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public String getPays() {
		return this.pays;
	}

	public void setPays(String pays) {
		this.pays = pays;
	}

	public String getTypeVoie() {
		return this.typeVoie;
	}

	public void setTypeVoie(String typeVoie) {
		this.typeVoie = typeVoie;
	}

	public String getVille() {
		return this.ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}
	
	public Set<Formateur> getFormateurs()
    {
        return formateurs;
    }

    public void setFormateurs(Set<Formateur> formateurs)
    {
        this.formateurs = formateurs;
    }

	/*
	 * public Utilisateur getUtilisateur() { return this.utilisateur; }
	 * 
	 * public void setUtilisateur(Utilisateur utilisateur) { this.utilisateur =
	 * utilisateur; }
	 */
    
    @Override
	public String toString() {
		return "AdresseComplete [id=" + id + ", complementAdresse1=" + complementAdresse1 + ", complementAdresse2=" + complementAdresse2 + ", cp=" + cp + ", nomVoie=" +nomVoie+", num=" +num+",pays="+pays+",typeVoie="+typeVoie+",ville="+ville+"]";
	}
    
}