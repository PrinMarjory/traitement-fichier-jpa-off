package fr.diginamic.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import fr.diginamic.entites.Categorie;

/**
 * DAO de la classe Categorie
 * 
 * @author Marjory PRIN
 */
public class CategorieDAO {
	
	/**
	 * Permet d'ajouter une nouvelle catégorie dans la base à partir de son nom
	 * @param nom : le nom de la catégorie
	 */
	public static void insert(EntityManager em, String nom) {
		Categorie cat = new Categorie();
		cat.setNom(nom);
		em.persist(cat);
	}
	
	/** 
	 * Permet de récupérer une catégorie donnée existe déjà dans la base
	 * @return true si la catégorie existe déja, false sinon
	 */
	public static boolean isExists(EntityManager em, String nom) {
		TypedQuery<Categorie> query = em.createQuery("SELECT c FROM Categorie c WHERE c.nom=:param", Categorie.class);
		query.setParameter("param", nom);
		List<Categorie> categorie = query.getResultList();
		if (categorie == null) {
			return false;
		}
		return true;
	}
}
