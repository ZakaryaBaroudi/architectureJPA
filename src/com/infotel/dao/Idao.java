package com.infotel.dao;

import java.util.List;

import com.infotel.metier.Adresse;
import com.infotel.metier.Personne;

public interface Idao {
 
	public int ajouterPersonne(Personne p);
	public Personne getPersonne (int idPersonne);
	public int supprimerPersonne(Personne p);
	public int modifierPersonne (Personne p);
	public List<Personne>findAll();
	
	public int ajouterAdresse(Adresse a);
	public Adresse getAdresse (int idAdresse);
	public int supprimerAdresse(Adresse a);
	public int modifierAdresse (Adresse a);
	
	
	public List<Personne> findAllPersonnesAdresse();
	
	
}
