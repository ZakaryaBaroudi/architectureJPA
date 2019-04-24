package com.infotel.presentation;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.infotel.metier.Adresse;
import com.infotel.metier.Client;
import com.infotel.metier.Employe;
import com.infotel.metier.Personne;
import com.infotel.service.Iservice;
import com.infotel.service.ServiceImpl;

public class Lanceur {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//EntityManagerFactory emf = Persistence.createEntityManagerFactory("demojpa-pu");  uniquement pour créer les tables
		
		
		Iservice service = new ServiceImpl();
		/*Personne p = new Personne();
		p.setNom("Bonjourmamaman");
		p.setPrenom("remi");
		p.setAge(20);
		service.ajouterPersonne(p);*/
		
		/*Employe e = new Employe();
		e.setNom("toto");
		e.setPrenom("Jojo");
		e.setAge(100);
		e.setSalaire (2000);
		service.ajouterEmploye(e);*/
		
		/*Client c = new Client();
		c.setNom("titi");
		c.setPrenom("lili");
		c.setAge(200);
		c.setNumeroAdherent(12);
		service.ajouterClient(c);*/
		
		Personne p = new Personne();
		Adresse a = new Adresse();
		a.setNumRue("11");
		a.setNomRue("de l'esperance");
		a.setCp("75013");
		a.setVille("Paris");
		
		
		p.setNom("Baroudi");
		p.setPrenom("Zakarya");
		p.setAge(20);
		p.setAdresse(a);
		service.ajouterPersonne(p);
		service.ajouterAdresse(a);
		
	/* Adresse a = new Adresse();
	 a = service.getAdresse(2);
	 service.supprimerAdresse(a);*/
	}

}
