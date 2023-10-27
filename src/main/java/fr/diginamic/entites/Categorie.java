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
 * Représente une catégorie de produit alimentaire par son identifiant, son nom et la liste de ses produits
 * 
 * @author Marjory PRIN
 */
@Entity
@Table(name = "CATEGORIE")
public class Categorie {
	
	/** l'identifiant de la catégorie*/
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	/** le nom de la catégorie */
	@Column(name = "NOM", length = 150, nullable = false, unique = true)
	private String nom;
	
	/** la liste des produits */
	@OneToMany(mappedBy = "categorie")
	private Set<Produit> produits;
	
	/** Constructeur pour JPA */
	public Categorie() {
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
