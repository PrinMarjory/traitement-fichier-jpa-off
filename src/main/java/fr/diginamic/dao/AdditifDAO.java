package fr.diginamic.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import fr.diginamic.entites.Categorie;
import fr.diginamic.entites.Additif;
import fr.diginamic.entites.Produit;

/**
 * DAO de la classe Additif
 * 
 * @author Marjory PRIN
 */
public class AdditifDAO {
	
	/**
	 * Permet d'ajouter un nouvel additif dans la base à partir de son nom
	 * @param nom : le nom de l'additif
	 */
	public static void insert(EntityManager em, String nom, Produit p) {
		Additif a = new Additif();
		a.setNom(nom);
		em.persist(a);
		a.getProduits().add(p);
	}
	
	/**
	 * Permet de récupérer un additif dans la base à partir de son nom
	 * @param em : l'entityManager
	 * @param nom : le nom de l'additif
	 * @return l'additif ou null si il n'existe pas
	 */
	public static Additif getByNom(EntityManager em, String nom) {
		TypedQuery<Additif> query = em.createQuery("SELECT a FROM Additif a WHERE a.nom=:param", Additif.class);
		query.setParameter("param", nom);
		List<Additif> additif = query.getResultList();
		if (additif.size()>0) {
			return additif.get(0);
		}
		return null;
	}
}
