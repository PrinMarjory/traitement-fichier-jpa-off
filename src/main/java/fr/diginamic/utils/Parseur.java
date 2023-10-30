package fr.diginamic.utils;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
		
		// Traitement de la colonne ingredients
		String[] ingredients = morceaux[4].split(",");
		String nouveauMorceau = "";
		String s = "";
		if (ingredients.length > 0) {
			s = ingredients[0];
			s = nettoyageString(s);
			nouveauMorceau = s;
		}
		for (int i = 1; i<ingredients.length; i++) {
			s = ingredients[i];
			s = nettoyageString(s);
			nouveauMorceau += "," + s;
		}
		morceaux[4] = nouveauMorceau;
		
		// Traitement de la colonne allergène
		if (morceaux[28] != null) {
			String[] allergenes = morceaux[28].split(",");
			nouveauMorceau = "";
			s = "";
			if (allergenes.length > 0) {
				s = allergenes[0];
				s = nettoyageString(s);
				nouveauMorceau = s;
			}
			for (int i = 1; i<allergenes.length; i++) {
				s = allergenes[i];
				s = nettoyageString(s);
				nouveauMorceau += "," + s;
			}
			morceaux[28] = nouveauMorceau;
		}
		
		return morceaux;
	}
	
	public static String nettoyageString(String s) {
		
		// Supression des caractères spéciaux
		s = s.replace("_", "");
		s = s.replace("*", "");
		s = s.replace("\\", "");
		s = s.replace(".", "");
		s = s.replace("'", "");
		
		// Suppresion des pourcentages
		Pattern pattern = Pattern.compile("\\d+ ?%");
	    Matcher matcher = pattern.matcher(s);
	    s = matcher.replaceAll("");
	    
	    // Supression des doubles espaces
		s = s.replace("  ", " ");
		
		// Supression des espaces avant ou après la string
		s = s.strip();
		
		return s;
	}
}
