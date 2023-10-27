package fr.diginamic.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import fr.diginamic.entites.Erreur;

/**
 * DAO de la classe Erreur
 * 
 * @author Marjory PRIN
 */
public class ErreurDAO {
	
	/**
	 * Permet d'ajouter une nouvelle erreur à partir de son n°de ligne et d'un tableau de son contenu
	 * @param em : l'entityManager
	 * @param numero : le numero de ligne en erreur
	 * @param tabContenu : le tableau de donnée de la ligne en erreur
	 * @return la catégorie qui vient d'être créée
	 */
	public static void insert(EntityManager em, int numero, String[] tabContenu) {
		Erreur e = new Erreur();
		e.setNumero(numero);
		String contenu = "|";
		for (String s: tabContenu) {
			contenu += " " + s + " |";
		}
		e.setContenu(contenu);
		em.persist(e);
	}
	
}
