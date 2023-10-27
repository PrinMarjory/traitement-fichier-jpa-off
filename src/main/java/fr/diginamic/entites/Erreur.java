package fr.diginamic.entites;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Table contenant les lignes en erreur du fichier csv
 * 
 * @author Marjory PRIN
 */
@Entity
@Table(name = "ERREUR")
public class Erreur {
	
	/** l'identifiant de l'erreur*/
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	/** le n° de ligne de l'erreur dans le fichier csv */
	@Column(name = "NUMERO_LIGNE", nullable = false)
	private int numero;
	
	/** le contenu de ligne en erreur dans le fichier csv */
	@Column(name = "CONTENU", length = 500, nullable = false)
	private String contenu;
	
	/** Constructeur pour JPA */
	public Erreur() {
		super();
	}

	/** Getter
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/** Setter
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/** Getter
	 * @return the numero
	 */
	public int getNumero() {
		return numero;
	}

	/** Setter
	 * @param numero the numero to set
	 */
	public void setNumero(int numero) {
		this.numero = numero;
	}

	/** Getter
	 * @return the contenu
	 */
	public String getContenu() {
		return contenu;
	}

	/** Setter
	 * @param contenu the contenu to set
	 */
	public void setContenu(String contenu) {
		this.contenu = contenu;
	}
}
