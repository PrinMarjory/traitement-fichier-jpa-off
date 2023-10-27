package fr.diginamic.exception;

/**
 * Permet de récupérer les lignes en erreur du fichier csv pour traitement
 * @author Marjory PRIN
 */
public class ErreurDonneesCSV extends Exception {
	
	/** le contenu de la ligne en erreur */
	private String[] ligneErreur;
	
	/** le numéro de la ligne en erreur */
	private int numeroLigne;
	
	/**
	 * Constructeur
	 * @param message : le message d'erreur système
	 * @param ligneErreur : le contenu de la ligne en erreur
	 * @param numeroLigne : le numéro de la ligne en erreur
	 */
	public ErreurDonneesCSV(String message, String[] ligneErreur, int numeroLigne) {
		super(message);
		this.ligneErreur = ligneErreur;
		this.numeroLigne = numeroLigne;
	}

	@Override
	public String toString() {
		String messageErreur = getMessage();
		String contenu = "|";
		for (String s: ligneErreur) {
			contenu += " " + s + " |";
		}
		messageErreur += "\nLa ligne n°" + numeroLigne + " du fichier csv n'a pas pu être traitée :\n"
				+ "Ligne: " + contenu;
		return messageErreur;
	}

	/** Getter
	 * @return the ligneErreur
	 */
	public String[] getLigneErreur() {
		return ligneErreur;
	}

	/** Getter
	 * @return the numeroLigne
	 */
	public int getNumeroLigne() {
		return numeroLigne;
	}
	
	
}
