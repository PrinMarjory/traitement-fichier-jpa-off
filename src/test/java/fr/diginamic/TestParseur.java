package fr.diginamic;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import fr.diginamic.dao.AdditifDAO;
import fr.diginamic.dao.AllergeneDAO;
import fr.diginamic.dao.CategorieDAO;
import fr.diginamic.dao.ErreurDAO;
import fr.diginamic.dao.IngredientDAO;
import fr.diginamic.dao.MarqueDAO;
import fr.diginamic.dao.ProduitDAO;
import fr.diginamic.entites.Additif;
import fr.diginamic.entites.Allergene;
import fr.diginamic.entites.Categorie;
import fr.diginamic.entites.Ingredient;
import fr.diginamic.entites.Marque;
import fr.diginamic.entites.Produit;
import fr.diginamic.exception.ErreurDonneesCSV;
import fr.diginamic.utils.Parseur;

public class TestParseur {

	public static void main(String[] args) {
		
		try {
			Path path = Paths.get("C:/Users/marjo/Documents/Diginamic/Java/traitement-fichier-jpa-off/src/test/resources/ingredients.csv");

			// Lecture du fichier et suppresion de la ligne d'en-tête
			List<String> lignes = Files.readAllLines(path);
			List<String> lignePropre = new ArrayList<>();
			String l = "";
			// Traitement des lignes du fichier csv pour ajout dans la base
			for (int i = 0; i<2000; i++) {
				l = lignes.get(i);
				
				// Supression des caractères spéciaux
				l = l.replace("_", "");
				l = l.replace("*", "");
				l = l.replace("\\", "");
				l = l.replace(".", "");
				
				// Suppresion des pourcentages
				Pattern pattern = Pattern.compile("\\d+ ?%");
			    Matcher matcher = pattern.matcher(l);
			    l = matcher.replaceAll("");
			    
			    // Supression des doubles espaces
				l = l.replace("  ", " ");
				
				// Supression des espaces avant ou après le nom de l'ingrédient
				l=l.strip();
				System.out.println(l);
			}

			
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

}
