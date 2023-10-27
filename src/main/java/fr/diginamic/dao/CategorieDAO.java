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
	 * @param em : l'entityManager
	 * @param nom : le nom de la catégorie
	 * @return la catégorie qui vient d'être créée
	 */
	public static Categorie insert(EntityManager em, String nom) {
		Categorie cat = new Categorie();
		cat.setNom(nom);
		em.persist(cat);
		cat = getByNom(em, nom);
		return cat;
	}
	
	/**
	 * Permet de récupérer une catégorie dans la base à partir de son nom
	 * @param em : l'entityManager
	 * @param nom : le nom de la catégorie
	 * @retunr la categorie ou null si elle n'existe pas
	 */
	public static Categorie getByNom(EntityManager em, String nom) {
		TypedQuery<Categorie> query = em.createQuery("SELECT c FROM Categorie c WHERE c.nom=:param", Categorie.class);
		query.setParameter("param", nom);
		List<Categorie> categorie = query.getResultList();
		if (categorie.size()>0) {
			return categorie.get(0);
		}
		return null;
	}
	
}
