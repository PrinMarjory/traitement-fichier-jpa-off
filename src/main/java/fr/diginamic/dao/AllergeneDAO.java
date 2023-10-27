package fr.diginamic.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import fr.diginamic.entites.Categorie;
import fr.diginamic.entites.Allergene;
import fr.diginamic.entites.Produit;

/**
 * DAO de la classe Allergene
 * 
 * @author Marjory PRIN
 */
public class AllergeneDAO {
	
	/**
	 * Permet d'ajouter un nouvel allergene dans la base à partir de son nom
	 * @param nom : le nom de l'allergene
	 */
	public static void insert(EntityManager em, String nom, Produit p) {
		Allergene a = new Allergene();
		a.setNom(nom);
		em.persist(a);
		a.getProduits().add(p);
	}
	
	/**
	 * Permet de récupérer un allergene dans la base à partir de son nom
	 * @param em : l'entityManager
	 * @param nom : le nom de l'allergene
	 * @return l'allergene ou null si il n'existe pas
	 */
	public static Allergene getByNom(EntityManager em, String nom) {
		TypedQuery<Allergene> query = em.createQuery("SELECT a FROM Allergene a WHERE a.nom=:param", Allergene.class);
		query.setParameter("param", nom);
		List<Allergene> allergene = query.getResultList();
		if (allergene.size()>0) {
			return allergene.get(0);
		}
		return null;
	}
}
