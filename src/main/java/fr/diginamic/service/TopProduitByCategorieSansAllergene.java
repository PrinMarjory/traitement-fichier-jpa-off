package fr.diginamic.service;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import fr.diginamic.entites.Produit;

/**
 * Représente la recherche des 10 premiers produits les mieux notées d'une catégorie sans un allergène donné
 * 
 * @author Marjory PRIN
 */
public class TopProduitByCategorieSansAllergene extends MenuService {
	
	/**
	 * Traite la demande de recherche et affiche le résultat
	 * @param scanner : le scanner pour les choix de l'utilisateur
	 */
	@Override
	public void traiter(Scanner scanner) {
		
		// Connexion à la base de donnée
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("open_food_facts");
		EntityManager em = emf.createEntityManager();

		// Demande du nom de la catégorie et l'allergène à exclure à l'utilisateur
		System.out.println("\n/////////////////////////////////////////\n");
		System.out.println("Saisir ci-dessous le nom de la catégorie recherchée :");
		String scan1 = scanner.next();
		System.out.println("\nSaisir ci-dessous le nom de l'allergène à exclure :");
		String scan2 = scanner.next();
		
		// Extraction des produits de la catégorie recherchée sans l'allergène
		TypedQuery<Produit> query = em.createQuery("SELECT DISTINCT p FROM Produit p JOIN p.categorie c WHERE c.nom=:param1 "
				+ "AND p.id NOT IN(SELECT DISTINCT p.id FROM Produit p JOIN p.categorie c JOIN p.allergenes a WHERE c.nom=:param1 AND a.nom=:param2) "
				+ "ORDER BY p.nutrition.nutriscore", Produit.class);
		query.setParameter("param1", scan1);
		query.setParameter("param2", scan2);
		List<Produit> produits = query.getResultList();		
		
		// Affichage des produits avec le meilleur nutriscore pour la catégorie sans un allergène donnée
		if (produits.size()==0) {
			System.out.println("\nCette catégorie n'existe pas ou il n'y a pas de produit dans cette catégorie sans l'allergène demandé !");
		} 
		else if (produits.size()<10) {
			System.out.println("\n/////////////////////////////////////////\n");
			System.out.println("Top des produits avec le meilleur nutriscore de la catégorie " + scan1 + " sans " + scan2 + " :\n");
			Produit p = null;
			for(int i = 0; i<produits.size(); i++) {
				p = produits.get(i);
					System.out.println((i+1) + ": " + p.getNom() + " " + p.getMarques() + " - Nutriscore " + p.getNutrition().getNutriscore().toUpperCase() + " - Allergènes : " + p.getAllergenes());
			}
		} 
		else {
			System.out.println("\n/////////////////////////////////////////\n");
			System.out.println("Top 10 des produits avec le meilleur nutriscore de la catégorie " + scan1 + " sans " + scan2 + " :\n");
			Produit p = null;
			for(int i = 0; i<10; i++) {
				p = produits.get(i);
					System.out.println((i+1) + ": " + p.getNom() + " " + p.getMarques() + " - Nutriscore "  + p.getNutrition().getNutriscore().toUpperCase() + " - Allergènes : " + p.getAllergenes());
			}
		}
		
	}

}
