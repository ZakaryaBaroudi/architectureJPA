package com.infotel.metier;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.hibernate.annotations.ManyToAny;

@Entity
//heritage single table
@Inheritance (strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="TYPE_PERS") 
@DiscriminatorValue("PERS")

//heritage 1 table par classe 
//@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)

// heritage jointure
//@Inheritance(strategy=InheritanceType.JOINED)

public class Personne {
	@Id
	//enlever pour table per class
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	
	private int id;
	private String nom;
	private String prenom;
	private int age;
	
	@ManyToOne (cascade = {CascadeType.PERSIST})  // relation avec adresse
	private Adresse adresse;

	@OneToOne(fetch = FetchType.EAGER)
	private Connexion connexion;
	
	@ManyToMany (fetch = FetchType.LAZY)
	private List<Club> clubs=  new ArrayList<Club>();
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "Personne [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", age=" + age + "]";
	}
	
	

	public Adresse getAdresse() {
		return adresse;
	}
	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}
	public Connexion getConnexion() {
		return connexion;
	}
	public void setConnexion(Connexion connexion) {
		this.connexion = connexion;
	}
	public List<Club> getClubs() {
		return clubs;
	}
	public void setClubs(List<Club> clubs) {
		this.clubs = clubs;
	}
	

}
