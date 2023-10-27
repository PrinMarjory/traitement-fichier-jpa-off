package fr.diginamic.utils;

import java.util.Arrays;

import org.apache.commons.lang3.math.NumberUtils;

import fr.diginamic.exception.ErreurDonneesCSV;

/**
 * Permet de traiter le fichier csv Open Food Facts en chaînes de caractères exploitables
 * 
 * @author Marjory PRIN
 */
public class Parseur {
	
	/**
	 * Permet de séparer chaque ligne du fichier csv en une liste de chaîne de caractère (un item par colonne),
	 * de controler l'exploitabilité des données et de traiter les colonnes ingredients, allergene et additif 
	 * @param ligne : une ligne du fichier csv
	 * @param numeroLigne : le numéro de la ligne dans le fichier csv
	 * @return la liste des éléments de la ligne
	 */
	public static String[] TableauColonne(String ligne, int numeroLigne) throws ErreurDonneesCSV {
		String[] morceaux = ligne.split("\\|");
		if (morceaux.length<30) {
			morceaux = Arrays.copyOf(morceaux, 30);
		}
		
		// Controle des colonnes nutriton
		for (int i = 5; i <27; i++) {
			if (morceaux[i]=="") {
				morceaux[i]="-1";
			}
			if (!NumberUtils.isCreatable(morceaux[i])) {
				throw new ErreurDonneesCSV("Erreur données nutrition fichier csv", morceaux, numeroLigne);
			}
		}
		
		// Traitement des colonnes ingredients, allergenes et additifs
		
		return morceaux;
	}
}
