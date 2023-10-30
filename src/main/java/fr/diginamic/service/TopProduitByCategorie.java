package fr.diginamic.service;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import fr.diginamic.entites.Produit;

/**
 * Représente la recherche des 10 premiers produits les mieux notées d'une catégorie demandée par l'utilisateur
 * 
 * @author Marjory PRIN
 */
public class TopProduitByCategorie extends MenuService {
	
	/**
	 * Traite la demande de recherche et affiche le résultat
	 * @param scanner : le scanner pour le choix de l'utilisateur
	 */
	@Override
	public void traiter(Scanner scanner) {
		
		// Connexion à la base de donnée
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("open_food_facts");
		EntityManager em = emf.createEntityManager();

		// Demande du nom de la catégorie à l'utilisateur
		System.out.println("\n/////////////////////////////////////////\n");
		System.out.println("Saisir ci-dessous le nom de la catégorie recherchée :");
		String scan = scanner.next();
		
		// Extraction des produits de la catégorie recherchée
		TypedQuery<Produit> query = em.createQuery("SELECT p FROM Produit p JOIN p.categorie c WHERE c.nom=:param ORDER BY p.nutrition.nutriscore", Produit.class);
		query.setParameter("param", scan);
		List<Produit> produits = query.getResultList();		
		
		// Affichage des produits avec le meilleur nutriscore pour la catégorie
		if (produits.size()==0) {
			System.out.println("\nCette catégorie n'existe pas !");
		} else if (produits.size()<10) {
			System.out.println("\n/////////////////////////////////////////\n");
			System.out.println("Top des produits avec le meilleur nutriscore de la catégorie " + scan + " :\n");
			Produit p = null;
			for(int i = 0; i<produits.size(); i++) {
				p = produits.get(i);
					System.out.println((i+1) + ": " + p.getNom() + " " + p.getMarques() + " - Nutriscore " + p.getNutrition().getNutriscore().toUpperCase());
			}
		} else {
			System.out.println("\n/////////////////////////////////////////\n");
			System.out.println("Top 10 des produits avec le meilleur nutriscore de la catégorie " + scan + " :\n");
			Produit p = null;
			for(int i = 0; i<10; i++) {
				p = produits.get(i);
					System.out.println((i+1) + ": " + p.getNom() + " " + p.getMarques() + " - Nutriscore "  + p.getNutrition().getNutriscore().toUpperCase());
			}
		}
		
	}

}
