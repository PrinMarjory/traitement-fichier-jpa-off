package fr.diginamic.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import fr.diginamic.entites.Categorie;
import fr.diginamic.entites.Marque;
import fr.diginamic.entites.Produit;

/**
 * DAO de la classe Marque
 * 
 * @author Marjory PRIN
 */
public class MarqueDAO {
	
	/**
	 * Permet d'ajouter une nouvelle marque dans la base à partir de son nom
	 * @param nom : le nom de la marque
	 */
	public static void insert(EntityManager em, String nom, Produit p) {
		Marque m = new Marque();
		m.setNom(nom);
		em.persist(m);
		m.getProduits().add(p);
	}
	
	/**
	 * Permet de récupérer une marque dans la base à partir de son nom
	 * @param em : l'entityManager
	 * @param nom : le nom de la marque
	 * @return la marque ou null si elle n'existe pas
	 */
	public static Marque getByNom(EntityManager em, String nom) {
		TypedQuery<Marque> query = em.createQuery("SELECT m FROM Marque m WHERE m.nom=:param", Marque.class);
		query.setParameter("param", nom);
		List<Marque> marque = query.getResultList();
		if (marque.size()>0) {
			return marque.get(0);
		}
		return null;
	}
}
