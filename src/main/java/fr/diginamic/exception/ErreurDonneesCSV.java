package fr.diginamic.exception;

public class ErreurDonneesCSV extends Exception {
	
	public ErreurDonneesCSV(String message, String[] ligneErreur) {
		super(message);
	}
}
