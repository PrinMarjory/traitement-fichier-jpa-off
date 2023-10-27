package fr.diginamic.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import fr.diginamic.entites.Categorie;
import fr.diginamic.entites.Ingredient;
import fr.diginamic.entites.Produit;

/**
 * DAO de la classe Ingredient
 * 
 * @author Marjory PRIN
 */
public class IngredientDAO {
	
	/**
	 * Permet d'ajouter un nouvel ingrédient dans la base à partir de son nom
	 * @param nom : le nom de l'ingrédient
	 */
	public static void insert(EntityManager em, String nom, Produit p) {
		Ingredient i = new Ingredient();
		i.setNom(nom);
		em.persist(i);
		i.getProduits().add(p);
	}
	
	/**
	 * Permet de récupérer un ingrédient dans la base à partir de son nom
	 * @param em : l'entityManager
	 * @param nom : le nom de l'ingrédient
	 * @return l'ingrédient ou null si il n'existe pas
	 */
	public static Ingredient getByNom(EntityManager em, String nom) {
		TypedQuery<Ingredient> query = em.createQuery("SELECT i FROM Ingredient i WHERE i.nom=:param", Ingredient.class);
		query.setParameter("param", nom);
		List<Ingredient> ingredient = query.getResultList();
		if (ingredient.size()>0) {
			return ingredient.get(0);
		}
		return null;
	}
}
