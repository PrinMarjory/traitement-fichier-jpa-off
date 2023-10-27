package fr.diginamic.entites;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * Représente un ingrédient par son identifiant, son nom et la liste des produits qui en contienne
 * 
 * @author Marjory PRIN
 */
@Entity
@Table(name = "INGREDIENT")
public class Ingredient {
	
	/** l'identifiant de l'ingrédient*/
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	/** le nom de l'ingrédient */
	@Column(name = "NOM", length = 150, nullable = false, unique = true)
	private String nom;
	
	/** la liste des produits */
	@ManyToMany
	@JoinTable(name = "INGREDIENT_PRODUIT",
		joinColumns = @JoinColumn(name = "ID_INGREDIENT", referencedColumnName = "ID"),
		inverseJoinColumns = @JoinColumn(name = "ID_PRODUIT", referencedColumnName = "ID")
	)
	private Set<Produit> produits;
	
	/** Constructeur pour JPA */
	public Ingredient() {
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
