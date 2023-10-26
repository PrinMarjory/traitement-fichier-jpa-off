package fr.diginamic.entites;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * Représente un allergène alimentaire par son identifiant, son nom et la liste des produits qui en contiennent
 * 
 * @author Marjory PRIN
 */
@Entity
@Table(name = "ALLERGENE")
public class Allergene {
	
	/** l'identifiant de l'allergène*/
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	/** le nom de l'allergène*/
	@Column(name = "NOM", length = 50, nullable = false, unique = true)
	private String nom;
	
	/** la liste des produits */
	@ManyToMany(mappedBy = "allergenes")
	private Set<Produit> produits;
	
	/** Constructeur pour JPA */
	public Allergene() {
		super();
		produits = new HashSet<Produit>();
	}

	@Override
	public String toString() {
		return nom;
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
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/** Setter
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/** Getter
	 * @return the produits
	 */
	public Set<Produit> getProduits() {
		return produits;
	}

	/** Setter
	 * @param produits the produits to set
	 */
	public void setProduits(Set<Produit> produits) {
		this.produits = produits;
	}
}
