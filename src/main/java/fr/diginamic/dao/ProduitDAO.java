package fr.diginamic.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import fr.diginamic.entites.Categorie;
import fr.diginamic.entites.Nutrition;
import fr.diginamic.entites.Produit;

/**
 * DAO de la classe Produit
 * 
 * @author Marjory PRIN
 */
public class ProduitDAO {
	
	/**
	 * Permet d'ajouter une nouveau produit dans la base à partir de son nom
	 * @param em : l'entityManager
	 * @param ligne : la ligne du tableau csv
	 * @param cat : sa catégorie
	 * @return le produit qui vient d'être créé
	 */
	public static Produit insert(EntityManager em, String[] lignePropre, Categorie cat) {
		
		// Création des données de nutritions (à mettre dans DAO Produit)
		Nutrition nutrition = new Nutrition();
		nutrition.setNutriscore(lignePropre[3]);
		nutrition.setEnergie(Double.parseDouble(lignePropre[5]));				
		nutrition.setGraisse(Double.parseDouble(lignePropre[6]));
		nutrition.setSucre(Double.parseDouble(lignePropre[7]));
		nutrition.setFibre(Double.parseDouble(lignePropre[8]));
		nutrition.setProteine(Double.parseDouble(lignePropre[9]));
		nutrition.setSel(Double.parseDouble(lignePropre[10]));
		nutrition.setVitamineA(Double.parseDouble(lignePropre[11]));
		nutrition.setVitamineD(Double.parseDouble(lignePropre[12]));
		nutrition.setVitamineE(Double.parseDouble(lignePropre[13]));
		nutrition.setVitamineK(Double.parseDouble(lignePropre[14]));
		nutrition.setVitamineC(Double.parseDouble(lignePropre[15]));
		nutrition.setVitamineB1(Double.parseDouble(lignePropre[16]));
		nutrition.setVitamineB2(Double.parseDouble(lignePropre[17]));
		nutrition.setVitaminePP(Double.parseDouble(lignePropre[18]));
		nutrition.setVitamineB6(Double.parseDouble(lignePropre[19]));
		nutrition.setVitamineB9(Double.parseDouble(lignePropre[20]));
		nutrition.setVitamineB12(Double.parseDouble(lignePropre[21]));
		nutrition.setCalcium(Double.parseDouble(lignePropre[22]));
		nutrition.setMagnesium(Double.parseDouble(lignePropre[23]));
		nutrition.setFer(Double.parseDouble(lignePropre[25]));
		nutrition.setBetaCarotene(Double.parseDouble(lignePropre[26]));
		if (lignePropre[27].equals("1")) {
			nutrition.setPresenceHuilePalme(true);
		} else {
			nutrition.setPresenceHuilePalme(false);
		}
		
		// Création du produit
		Produit p = new Produit();
		p.setNom(lignePropre[2]);
		p.setCategorie(cat);
		p.setNutrition(nutrition);
		em.persist(p);
		p = getByNom(em, lignePropre[2]);
		return p;
	}
	
	/**
	 * Permet de récupérer un produit dans la base à partir de son nom
	 * @param em : l'entityManager
	 * @param nom : le nom du produit
	 * @return le produit ou null si il n'existe pas
	 */
	public static Produit getByNom(EntityManager em, String nom) {
		TypedQuery<Produit> query = em.createQuery("SELECT p FROM Produit p WHERE p.nom=:param", Produit.class);
		query.setParameter("param", nom);
		List<Produit> produits = query.getResultList();
		if (produits.size()>0) {
			return produits.get(0);			
		}
		return null;
	}
	
}
