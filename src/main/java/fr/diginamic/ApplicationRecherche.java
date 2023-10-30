package fr.diginamic;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

import fr.diginamic.service.MenuService;
import fr.diginamic.service.TopProduitByCategorie;
import fr.diginamic.service.TopProduitByCategorieSansAllergene;
import fr.diginamic.service.TopProduitByCategorieSansIngredient;
import fr.diginamic.service.TopProduitByMarque;
import fr.diginamic.service.TopProduitByMarqueSansAllergene;
import fr.diginamic.service.TopProduitByMarqueSansIngredient;


public class ApplicationRecherche {

	public static void main(String[] args) {
		
		// Connexion à la base de donnée
		Scanner scanner = new Scanner(System.in);
		MenuService recherche = null;
		int option = 0;
		
		
		
		// Boucle de retour au menu
		while (option != 7) {
			
			// Affichage du menu
			System.out.println("\n/////////////////////////////////////////\n\n"
					+ "                   MENU\n"
					+ "-----------------------------------------\n"
					+ "1. Affichez les 10 produits les mieux notés d’une catégorie donnée\n"
					+ "2. Affichez les 10 produits les mieux notés d’une marque donné\n"
					+ "3. Affichez les 10 produits les mieux notés d’une catégorie et qui ne contiennent pas un ingrédient donné\n"
					+ "4. Affichez les 10 produits les mieux notés d’une marque et qui ne contiennent pas un ingrédient donné\n"
					+ "5. Affichez les 10 produits les mieux notés d’une catégorie et qui ne contiennent pas un allergène donné\n"
					+ "6. Affichez les 10 produits les mieux notés d’une marque et qui ne contiennent pas un allergène donné\n"
					+ "7. Sortir\n\n"
					+ "Saisir le numéro de l'option voulue :");
			
			option = scanner.nextInt();	
			while (option > 7 || option < 1) {
				System.out.println("\nLe numéro saisi ne correspond pas à une option du menu, veuillez saisir un chiffre entre 1 et 7 :");
				option = scanner.nextInt();	
			}
			
			// Choix de l'utilisateur
			switch (option) {
				case 1:
					recherche = new TopProduitByCategorie();
					recherche.traiter(scanner);
					break;
				case 2:
					recherche = new TopProduitByMarque();
					recherche.traiter(scanner);
					break;
				case 3:
					recherche = new TopProduitByCategorieSansIngredient();
					recherche.traiter(scanner);
					break;
				case 4:
					recherche = new TopProduitByMarqueSansIngredient();
					recherche.traiter(scanner);
					break;
				case 5:
					recherche = new TopProduitByCategorieSansAllergene();
					recherche.traiter(scanner);
					break;
				case 6:
					recherche = new TopProduitByMarqueSansAllergene();
					recherche.traiter(scanner);
					break;
				case 7:
					System.out.println("\n/////////////////////////////////////////\n\n"
							+ "                   FIN\n\n/////////////////////////////////////////");
					break;
			}
		}

	}

}
