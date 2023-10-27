package fr.diginamic.utils;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import fr.diginamic.dao.*;
import fr.diginamic.entites.*;
import fr.diginamic.exception.ErreurDonneesCSV;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLIntegrityConstraintViolationException;

/**
 * Permets de lire le fichier csv open-food-facts et de remplir la base de donnée associée
 * 
 * @author Marjory PRIN
 */
public class OpenFoodFactsUtils {
	
	/**
	 * Lit le contenu du fichier en paramètre contenant des données open food facts, transforme ces données au format attendu
	 * et remplie la base de donnée mariaDB en accordance
	 * @param cheminFichier : le chemin d'accès du fichier sur le disque dur
	 * @param ligneDebut : le numéro de ligne ou commancer à charger le fichier csv
	 */
	public static void chargerMariaDB(Path cheminFichier, int ligneDebut) {
		
		try {
			long startTime = System.currentTimeMillis();
			// Lecture du fichier et suppresion de la ligne d'en-tête
			List<String> lignes = Files.readAllLines(cheminFichier);
			
			// Connexion à la base de donnée 
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("open_food_facts");
			EntityManager em = emf.createEntityManager();
			EntityTransaction transaction = em.getTransaction();
			
			// Initialisation des variables 
			String[] lignePropre = null;	
			String[] elements = null;
			
			
			// Traitement des lignes du fichier csv pour ajout dans la base
			for (int i = ligneDebut; i<(ligneDebut+100); i++) {
				transaction.begin();
				
				
				lignePropre = Parseur.TableauColonne(lignes.get(i), i+1);
				
				// Ajout de la catégorie si elle n'existe pas encore
				Categorie categorie = new Categorie();
				categorie = CategorieDAO.getByNom(em, lignePropre[0]);
				if (categorie == null) {
					categorie = CategorieDAO.insert(em, lignePropre[0]);
				}
				
				// Ajout du produit
				Produit produit = new Produit();
				produit = ProduitDAO.insert(em, lignePropre, categorie);
				
				// Ajout de la marque si elle n'existe pas encore
				elements = lignePropre[1].split(",");
				for (String s: elements) {
					Marque marque = new Marque();
					marque = MarqueDAO.getByNom(em, s);
					if (marque == null) {
						MarqueDAO.insert(em, s, produit);
					} else {
						marque.getProduits().add(produit);
					}
				}
				
				// Ajout des ingrédients si ils n'existent pas encore
				elements = lignePropre[4].split(",");
				for (String s: elements) {
					Ingredient ingredient = new Ingredient();
					ingredient = IngredientDAO.getByNom(em, s);
					if (ingredient == null) {
						IngredientDAO.insert(em, s, produit);
					} else {
						ingredient.getProduits().add(produit);
					}
				}
				
				// Ajout des allèrgènes si ils n'existent pas encore
				if(lignePropre[28]!=null && !lignePropre[28].equals("")) {
					elements = lignePropre[28].split(",");
					for (String s: elements) {
						Allergene allergene = new Allergene();
						allergene = AllergeneDAO.getByNom(em, s);
						if (allergene == null) {
							AllergeneDAO.insert(em, s, produit);
						} else {
							allergene.getProduits().add(produit);
						}
					}	
				}
			
				
				// Ajout des additifs si ils n'existent pas encore
				if(lignePropre[29]!=null && !lignePropre[29].equals("")) {
					elements = lignePropre[29].split(",");
					for (String s: elements) {
						Additif additif = new Additif();
						additif = AdditifDAO.getByNom(em, s);
						if (additif == null) {
							AdditifDAO.insert(em, s, produit);
						} else {
							additif.getProduits().add(produit);
						}
					}
				}
				
				transaction.commit();
			}
			long endTime = System.currentTimeMillis();
			System.out.println("Temps d'exécution = " + (endTime-startTime)/60000);
			
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} catch (ErreurDonneesCSV e) {
			// Ajouter le traitement des lignes en erreur vers table erreur (avec numéro de l'erreur et contenu)
			System.out.println(e);
			
			// Connexion à la base de donnée 
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("open_food_facts");
			EntityManager em = emf.createEntityManager();
			EntityTransaction transaction = em.getTransaction();
			transaction.begin();
			
			// Insertion dans le tableau erreur de la base de donnée
			ErreurDAO.insert(em, e.getNumeroLigne(), e.getLigneErreur());
			transaction.commit();
			
			chargerMariaDB(cheminFichier, e.getNumeroLigne()+1);
		}
	}
}
