package fr.diginamic.utils;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import fr.diginamic.dao.CategorieDAO;
import fr.diginamic.entites.Nutrition;
import fr.diginamic.exception.ErreurDonneesCSV;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

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
	 */
	public static void chargerMariaDB(Path cheminFichier) {
		
		Path path = Paths.get("C:/Users/marjo/Documents/Diginamic/Java/traitement-fichier-jpa-off/src/main/resources/open-food-facts.csv");
		
		try {
			// Lecture du fichier et suppresion de la ligne d'en-tête
			List<String> lignes = Files.readAllLines(path);
			lignes.remove(0);
			
			// Connexion à la base de donnée 
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("open_food_facts");
			EntityManager em = emf.createEntityManager();
			EntityTransaction transaction = em.getTransaction();
			transaction.begin();
			
			// Traitement des lignes du fichier csv pour ajout dans la base
			String[] lignePropre = null;	
			for (String ligne: lignes) {
				lignePropre = Parseur.TableauColonne(ligne);
				
				// Ajout de la catégorie si elle n'existe pas encore
				if (!CategorieDAO.isExists(em, lignePropre[0])) {
					CategorieDAO.insert(em, lignePropre[0]);
				}
				
				// Ajout de la marque si elle n'existe pas encore
				
				
				// Ajout des ingrédients si ils n'existent pas encore
				
				
				// Ajout des allèrgènes si ils n'existent pas encore
				
				
				// Ajout des additifs si ils n'existent pas encore
				
				
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
				
				// Ajout du produit
			}
			
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} catch (ErreurDonneesCSV e) {
			// Ajouter le traitement des lignes en erreur vers table erreur (avec numéro de l'erreur, et contenu)
			System.out.println(e.getMessage());
		}
	}
}
