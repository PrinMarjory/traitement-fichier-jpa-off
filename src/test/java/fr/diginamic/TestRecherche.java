package fr.diginamic;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import fr.diginamic.entites.Produit;
import fr.diginamic.service.MenuService;
import fr.diginamic.service.TopProduitByCategorie;
import fr.diginamic.service.TopProduitByCategorieSansAllergene;
import fr.diginamic.service.TopProduitByCategorieSansIngredient;
import fr.diginamic.service.TopProduitByMarque;

public class TestRecherche {
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		MenuService recherche = null;
		recherche = new TopProduitByCategorieSansAllergene();
		recherche.traiter(scanner);
	
	}
}
