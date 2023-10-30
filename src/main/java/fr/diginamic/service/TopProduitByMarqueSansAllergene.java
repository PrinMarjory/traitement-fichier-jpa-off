package fr.diginamic.service;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import fr.diginamic.entites.Produit;

/**
 * Représente la recherche des 10 premiers produits les mieux notées d'une marque sans un allergène donné
 * 
 * @author Marjory PRIN
 */
public class TopProduitByMarqueSansAllergene extends MenuService {
	
	/**
	 * Traite la demande de recherche et affiche le résultat
	 * @param scanner : le scanner pour les choix de l'utilisateur
	 */
	@Override
	public void traiter(Scanner scanner) {
		
		// Connexion à la base de donnée
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("open_food_facts");
		EntityManager em = emf.createEntityManager();

		// Demande du nom de la marque et l'allergène à exclure à l'utilisateur
		System.out.println("\n/////////////////////////////////////////\n");
		System.out.println("Saisir ci-dessous le nom de la marque recherchée :");
		String scan1 = scanner.next();
		System.out.println("\nSaisir ci-dessous le nom de l'allergène à exclure :");
		String scan2 = scanner.next();
		
		// Extraction des produits de la marque recherchée sans l'allergène donné
		TypedQuery<Produit> query = em.createQuery("SELECT DISTINCT p FROM Produit p JOIN p.marques m WHERE m.nom=:param1 "
				+ "AND p.id NOT IN(SELECT DISTINCT p.id FROM Produit p JOIN p.marques m JOIN p.allergenes a WHERE m.nom=:param1 AND a.nom=:param2) "
				+ "ORDER BY p.nutrition.nutriscore", Produit.class);
		query.setParameter("param1", scan1);
		query.setParameter("param2", scan2);
		List<Produit> produits = query.getResultList();		
		
		// Affichage des produits avec le meilleur nutriscore pour la marque sans un allergène donnée
		if (produits.size()==0) {
			System.out.println("\nCette marque n'existe pas ou il n'y a pas de produit dans cette marque sans l'allergène demandé !");
		} 
		else if (produits.size()<10) {
			System.out.println("\n/////////////////////////////////////////\n");
			System.out.println("Top des produits avec le meilleur nutriscore de la marque " + scan1 + " sans " + scan2 + " :\n");
			Produit p = null;
			for(int i = 0; i<produits.size(); i++) {
				p = produits.get(i);
					System.out.println((i+1) + ": " + p.getNom() + " " + p.getMarques() + " - Nutriscore " + p.getNutrition().getNutriscore().toUpperCase() + " - Allergènes : " + p.getAllergenes());
			}
		} 
		else {
			System.out.println("\n/////////////////////////////////////////\n");
			System.out.println("Top 10 des produits avec le meilleur nutriscore de la marque " + scan1 + " sans " + scan2 + " :\n");
			Produit p = null;
			for(int i = 0; i<10; i++) {
				p = produits.get(i);
					System.out.println((i+1) + ": " + p.getNom() + " " + p.getMarques() + " - Nutriscore "  + p.getNutrition().getNutriscore().toUpperCase() + " - Allergènes : " + p.getAllergenes());
			}
		}
		
	}

}
