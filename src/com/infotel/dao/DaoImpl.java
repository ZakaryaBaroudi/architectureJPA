package com.infotel.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.infotel.metier.Adresse;
import com.infotel.metier.Personne;

public class DaoImpl implements Idao{

	
	     // unité de persistance 
	EntityManagerFactory emf;
	// porteur de requette 
	EntityManager em;
	
	@Override
	public int ajouterPersonne(Personne p) {
		// TODO Auto-generated method stub
		
		// ouverture de l'unité de persistance et transaction
		
	emf= Persistence.createEntityManagerFactory("demojpa-pu");
	em=emf.createEntityManager();
	EntityTransaction tx = em.getTransaction();
	 try {
		 //1 ouvrir la transaction
		 tx.begin();
		 
		 //2 effectuer la requete 
		 em.persist(p);
		 //3 valider la transaction
		 tx.commit();
		 //4 fermer l'unité de persistence
		 em.close();
		 emf.close();
		
	} catch (Exception e) {
		// TODO: handle exception
		tx.rollback();
	}
	 
	 return 0;
	}

	@Override
	public Personne getPersonne(int idPersonne) {
		emf= Persistence.createEntityManagerFactory("demojpa-pu");
		em=emf.createEntityManager();
		Personne p = new Personne();
		
		try {
			p=em.find(Personne.class, idPersonne);
			em.close();
			emf.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return p;
	}

	@Override
	public int supprimerPersonne(Personne p) {
		// TODO Auto-generated method stub
		emf= Persistence.createEntityManagerFactory("demojpa-pu");
		em=emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		 try {
			 //1 ouvrir la transaction
			 tx.begin();
			 
			 //2 effectuer la requete 
			 em.remove(p);
			 //3 valider la transaction
			 tx.commit();
			 //4 fermer l'unité de persistence
			 em.close();
			 emf.close();
			
		} catch (Exception e) {
			// TODO: handle exception
			tx.rollback();
		}
		
		return 0;
	}

	@Override
	public int modifierPersonne(Personne p) {
		// TODO Auto-generated method stub
		emf= Persistence.createEntityManagerFactory("demojpa-pu");
		em=emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		 try {
			 //1 ouvrir la transaction
			 tx.begin();
			 
			 //2 effectuer la requete 
			 em.merge(p);
			 //3 valider la transaction
			 tx.commit();
			 //4 fermer l'unité de persistence
			 em.close();
			 emf.close();
			
		} catch (Exception e) {
			// TODO: handle exception
			tx.rollback();
		}
		
		return 0;
	}

	@Override
	public int ajouterAdresse(Adresse a) {
		// TODO Auto-generated method stub
		
		emf= Persistence.createEntityManagerFactory("demojpa-pu");
		em=emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		 try {
			 //1 ouvrir la transaction
			 tx.begin();
			 
			 //2 effectuer la requete 
			 em.persist(a);
			 //3 valider la transaction
			 tx.commit();
			 //4 fermer l'unité de persistence
			 em.close();
			 emf.close();
			
		} catch (Exception e) {
			// TODO: handle exception
			tx.rollback();
		}
		
		
		return 0;
	}

	@Override
	public Adresse getAdresse(int idAdresse) {
		// TODO Auto-generated method stub
		emf= Persistence.createEntityManagerFactory("demojpa-pu");
		em=emf.createEntityManager();
		Adresse a = new Adresse();
		try {
			a=em.getReference(Adresse.class, idAdresse);
			em.close();
			emf.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return a;
	}

	@Override
	public int supprimerAdresse(Adresse a) {
		// TODO Auto-generated method stub
		emf= Persistence.createEntityManagerFactory("demojpa-pu");
		em=emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		 try {
			 //1 ouvrir la transaction
			 tx.begin();
			 
			 //2 effectuer la requete 
			 em.remove(a);
			 //3 valider la transaction
			 tx.commit();
			 //4 fermer l'unité de persistence
			 em.close();
			 emf.close();
			
		} catch (Exception e) {
			// TODO: handle exception
			tx.rollback();
		}
		return 0;
	}

	@Override
	public int modifierAdresse(Adresse a) {
		// TODO Auto-generated method stub

		return 0;
	}

	@Override
	public List<Personne> findAllPersonnesAdresse() {
		// TODO Auto-generated method stub
		
		emf= Persistence.createEntityManagerFactory("demojpa-pu");
		em=emf.createEntityManager();
		
		Query q = null;
		
		List<Personne> l = new ArrayList<Personne>();
		
		try {
			q=em.createQuery("SELECT p FROM Personne p join p.connexion");
					l=q.getResultList();
			
			em.close();
			 emf.close();
			 
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		
		}
		
		return null;
	}

	@Override
	public List<Personne> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
