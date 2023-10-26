package fr.diginamic.entites;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Représente un produit alimentaire avec son identifient, ses données de nutrition 
 * et les listes de ses marques, ingrédients, allergènes et additifs 
 * 
 * @author Marjory PRIN
 */
@Entity
@Table(name = "PRODUIT")
public class Produit {
	
	/** l'identifiant du produit */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	/** le nom du produit */
	@Column(name = "NOM", length = 100, nullable = false, unique = true)
	private String nom;
	
	/** les informations nutritionnelles du produit */
	@Embedded
	private Nutrition nutrition;
	
	/** la catégorie du produit */
	@ManyToOne
	@JoinColumn(name = "CATEGORIE_ID")
	private Categorie categorie;
	
	/** la(les) marques(s) du produit */
	@ManyToMany
	@JoinTable(name = "MARQUE_PRODUIT",
				joinColumns = @JoinColumn(name = "ID_PRODUIT", referencedColumnName = "ID"),
				inverseJoinColumns = @JoinColumn(name = "ID_MARQUE", referencedColumnName = "ID")
	)
	private Set<Marque> marques;
	
	/** les ingrédients du produit */
	@ManyToMany
	@JoinTable(name = "INGREDIENT_PRODUIT",
				joinColumns = @JoinColumn(name = "ID_PRODUIT", referencedColumnName = "ID"),
				inverseJoinColumns = @JoinColumn(name = "ID_INGREDIENT", referencedColumnName = "ID")
	)
	private Set<Ingredient> ingredients;
	
	/** les allergènes du produit */
	@ManyToMany
	@JoinTable(name = "ALLERGENE_PRODUIT",
				joinColumns = @JoinColumn(name = "ID_PRODUIT", referencedColumnName = "ID"),
				inverseJoinColumns = @JoinColumn(name = "ID_ALLERGENE", referencedColumnName = "ID")
	)
	private Set<Allergene> allergenes;
	
	/** les additifs du produit */
	@ManyToMany
	@JoinTable(name = "ADDITIF_PRODUIT",
				joinColumns = @JoinColumn(name = "ID_PRODUIT", referencedColumnName = "ID"),
				inverseJoinColumns = @JoinColumn(name = "ID_ADDITIF", referencedColumnName = "ID")
	)
	private Set<Additif> additifs;
	
	/** Constructeur pour JPA */
	public Produit() {
		super();
		marques = new HashSet<Marque>();
		ingredients = new HashSet<Ingredient>();
		allergenes = new HashSet<Allergene>();
		additifs = new HashSet<Additif>();
	}

	@Override
	public String toString() {
		return "Produit [id=" + id + ", nom=" + nom + ", nutrition=" + nutrition + ", categorie=" + categorie
				+ ", marques=" + marques + ", ingredients=" + ingredients + ", allergenes=" + allergenes + ", additifs="
				+ additifs + "]";
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
	 * @return the nutrition
	 */
	public Nutrition getNutrition() {
		return nutrition;
	}

	/** Setter
	 * @param nutrition the nutrition to set
	 */
	public void setNutrition(Nutrition nutrition) {
		this.nutrition = nutrition;
	}

	/** Getter
	 * @return the categorie
	 */
	public Categorie getCategorie() {
		return categorie;
	}

	/** Setter
	 * @param categorie the categorie to set
	 */
	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

	/** Getter
	 * @return the marques
	 */
	public Set<Marque> getMarques() {
		return marques;
	}

	/** Setter
	 * @param marques the marques to set
	 */
	public void setMarques(Set<Marque> marques) {
		this.marques = marques;
	}

	/** Getter
	 * @return the ingredients
	 */
	public Set<Ingredient> getIngredients() {
		return ingredients;
	}

	/** Setter
	 * @param ingredients the ingredients to set
	 */
	public void setIngredients(Set<Ingredient> ingredients) {
		this.ingredients = ingredients;
	}

	/** Getter
	 * @return the allergenes
	 */
	public Set<Allergene> getAllergenes() {
		return allergenes;
	}

	/** Setter
	 * @param allergenes the allergenes to set
	 */
	public void setAllergenes(Set<Allergene> allergenes) {
		this.allergenes = allergenes;
	}

	/** Getter
	 * @return the additifs
	 */
	public Set<Additif> getAdditifs() {
		return additifs;
	}

	/** Setter
	 * @param additifs the additifs to set
	 */
	public void setAdditifs(Set<Additif> additifs) {
		this.additifs = additifs;
	}
	
}
