package fr.diginamic.entites;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import fr.diginamic.utils.Format;

/**
 * Représente les informations de nutritions d'un produit (nutriscore, energie, protéines, graisses, vitamines, etc.)
 * 
 * @author Marjory PRIN
 */
@Embeddable
public class Nutrition {
	
	/** le nutriscore d'un produit */
	@Column(name = "NUTRISCORE", nullable = false)
	private String nutriscore;
	
	/** énergie pour 100g (en joules) */
	@Column(name = "ENERGIE_100g", nullable = true)
	private double energie;
	
	/** graisse pour 100g (en gramme) */
	@Column(name = "GRAISSE_100g", nullable = true)
	private double graisse;	
	
	/** sucre pour 100g (en gramme) */
	@Column(name = "SUCRE_100g", nullable = true)
	private double sucre;	
	
	/** fibre pour 100g (en gramme) */
	@Column(name = "FIBRE_100g", nullable = true)
	private double fibre;	
	
	/** protéine pour 100g (en gramme) */
	@Column(name = "PROTEINE_100g", nullable = true)
	private double proteine;	
	
	/** sel pour 100g (en gramme) */
	@Column(name = "SEL_100g", nullable = true)
	private double sel;	
	
	/** vitamine A pour 100g (en gramme) */
	@Column(name = "VITAMINE_A_100g", nullable = true)
	private double vitamineA;	
	
	/** vitamine D pour 100g (en gramme) */
	@Column(name = "VITAMINE_D_100g", nullable = true)
	private double vitamineD;	
	
	/** vitamine E pour 100g (en gramme) */
	@Column(name = "VITAMINE_E_100g", nullable = true)
	private double vitamineE;	
	
	/** vitamine K pour 100g (en gramme) */
	@Column(name = "VITAMINE_K_100g", nullable = true)
	private double vitamineK;	
	
	/** vitamine C pour 100g (en gramme) */
	@Column(name = "VITAMINE_C_100g", nullable = true)
	private double vitamineC;	
	
	/** vitamine B1 pour 100g (en gramme) */
	@Column(name = "VITAMINE_B1_100g", nullable = true)
	private double vitamineB1;	
	
	/** vitamine B2 pour 100g (en gramme) */
	@Column(name = "VITAMINE_B2_100g", nullable = true)
	private double vitamineB2;	
	
	/** vitamine PP pour 100g (en gramme) */
	@Column(name = "VITAMINE_PP_100g", nullable = true)
	private double vitaminePP;	
	
	/** vitamine B6 pour 100g (en gramme) */
	@Column(name = "VITAMINE_B6_100g", nullable = true)
	private double vitamineB6;	
	
	/** vitamine B9 pour 100g (en gramme) */
	@Column(name = "VITAMINE_B9_100g", nullable = true)
	private double vitamineB9;	
	
	/** vitamine B12 pour 100g (en gramme) */
	@Column(name = "VITAMINE_B12_100g", nullable = true)
	private double vitamineB12;	
	
	/** calcium pour 100g (en gramme) */
	@Column(name = "CALCIUM_100g", nullable = true)
	private double calcium;	
	
	/** magnesium pour 100g (en gramme) */
	@Column(name = "MAGNESIUM_100g", nullable = true)
	private double magnesium;	
	
	/** fer pour 100g (en gramme) */
	@Column(name = "FER_100g", nullable = true)
	private double fer;	
	
	/** beta carotène pour 100g (en gramme) */
	@Column(name = "BETA_CAROTENE_100g", nullable = true)
	private double betaCarotene;	
	
	/** présence huile de palme */
	@Column(name = "PRESENCE_HUILE__PALME", nullable = false)
	private boolean presenceHuilePalme;	
	
	/** Constructeur pour JPA */
	public Nutrition() {
		super();
	}

	@Override
	public String toString() {
		return "Nutrition [nutriscore=" + nutriscore + ", energie=" + Math.round(energie) + ", graisse=" + Format.roundDouble(graisse, 1) + ", sucre="
				+ Format.roundDouble(sucre, 1) + ", fibre=" + Format.roundDouble(fibre, 1) + ", proteine=" + Format.roundDouble(proteine, 1) + "]";
	}

	/** Getter
	 * @return the nutriscore
	 */
	public String getNutriscore() {
		return nutriscore;
	}

	/** Setter
	 * @param nutriscore the nutriscore to set
	 */
	public void setNutriscore(String nutriscore) {
		this.nutriscore = nutriscore;
	}

	/** Getter
	 * @return the energie
	 */
	public double getEnergie() {
		return energie;
	}

	/** Setter
	 * @param energie the energie to set
	 */
	public void setEnergie(double energie) {
		this.energie = energie;
	}

	/** Getter
	 * @return the graisse
	 */
	public double getGraisse() {
		return graisse;
	}

	/** Setter
	 * @param graisse the graisse to set
	 */
	public void setGraisse(double graisse) {
		this.graisse = graisse;
	}

	/** Getter
	 * @return the sucre
	 */
	public double getSucre() {
		return sucre;
	}

	/** Setter
	 * @param sucre the sucre to set
	 */
	public void setSucre(double sucre) {
		this.sucre = sucre;
	}

	/** Getter
	 * @return the fibre
	 */
	public double getFibre() {
		return fibre;
	}

	/** Setter
	 * @param fibre the fibre to set
	 */
	public void setFibre(double fibre) {
		this.fibre = fibre;
	}

	/** Getter
	 * @return the proteine
	 */
	public double getProteine() {
		return proteine;
	}

	/** Setter
	 * @param proteine the proteine to set
	 */
	public void setProteine(double proteine) {
		this.proteine = proteine;
	}

	/** Getter
	 * @return the sel
	 */
	public double getSel() {
		return sel;
	}

	/** Setter
	 * @param sel the sel to set
	 */
	public void setSel(double sel) {
		this.sel = sel;
	}

	/** Getter
	 * @return the vitamineA
	 */
	public double getVitamineA() {
		return vitamineA;
	}

	/** Setter
	 * @param vitamineA the vitamineA to set
	 */
	public void setVitamineA(double vitamineA) {
		this.vitamineA = vitamineA;
	}

	/** Getter
	 * @return the vitamineD
	 */
	public double getVitamineD() {
		return vitamineD;
	}

	/** Setter
	 * @param vitamineD the vitamineD to set
	 */
	public void setVitamineD(double vitamineD) {
		this.vitamineD = vitamineD;
	}

	/** Getter
	 * @return the vitamineE
	 */
	public double getVitamineE() {
		return vitamineE;
	}

	/** Setter
	 * @param vitamineE the vitamineE to set
	 */
	public void setVitamineE(double vitamineE) {
		this.vitamineE = vitamineE;
	}

	/** Getter
	 * @return the vitamineK
	 */
	public double getVitamineK() {
		return vitamineK;
	}

	/** Setter
	 * @param vitamineK the vitamineK to set
	 */
	public void setVitamineK(double vitamineK) {
		this.vitamineK = vitamineK;
	}

	/** Getter
	 * @return the vitamineC
	 */
	public double getVitamineC() {
		return vitamineC;
	}

	/** Setter
	 * @param vitamineC the vitamineC to set
	 */
	public void setVitamineC(double vitamineC) {
		this.vitamineC = vitamineC;
	}

	/** Getter
	 * @return the vitamineB1
	 */
	public double getVitamineB1() {
		return vitamineB1;
	}

	/** Setter
	 * @param vitamineB1 the vitamineB1 to set
	 */
	public void setVitamineB1(double vitamineB1) {
		this.vitamineB1 = vitamineB1;
	}

	/** Getter
	 * @return the vitamineB2
	 */
	public double getVitamineB2() {
		return vitamineB2;
	}

	/** Setter
	 * @param vitamineB2 the vitamineB2 to set
	 */
	public void setVitamineB2(double vitamineB2) {
		this.vitamineB2 = vitamineB2;
	}

	/** Getter
	 * @return the vitaminePP
	 */
	public double getVitaminePP() {
		return vitaminePP;
	}

	/** Setter
	 * @param vitaminePP the vitaminePP to set
	 */
	public void setVitaminePP(double vitaminePP) {
		this.vitaminePP = vitaminePP;
	}

	/** Getter
	 * @return the vitamineB6
	 */
	public double getVitamineB6() {
		return vitamineB6;
	}

	/** Setter
	 * @param vitamineB6 the vitamineB6 to set
	 */
	public void setVitamineB6(double vitamineB6) {
		this.vitamineB6 = vitamineB6;
	}

	/** Getter
	 * @return the vitamineB9
	 */
	public double getVitamineB9() {
		return vitamineB9;
	}

	/** Setter
	 * @param vitamineB9 the vitamineB9 to set
	 */
	public void setVitamineB9(double vitamineB9) {
		this.vitamineB9 = vitamineB9;
	}

	/** Getter
	 * @return the vitamineB12
	 */
	public double getVitamineB12() {
		return vitamineB12;
	}

	/** Setter
	 * @param vitamineB12 the vitamineB12 to set
	 */
	public void setVitamineB12(double vitamineB12) {
		this.vitamineB12 = vitamineB12;
	}

	/** Getter
	 * @return the calcium
	 */
	public double getCalcium() {
		return calcium;
	}

	/** Setter
	 * @param calcium the calcium to set
	 */
	public void setCalcium(double calcium) {
		this.calcium = calcium;
	}

	/** Getter
	 * @return the magnesium
	 */
	public double getMagnesium() {
		return magnesium;
	}

	/** Setter
	 * @param magnesium the magnesium to set
	 */
	public void setMagnesium(double magnesium) {
		this.magnesium = magnesium;
	}

	/** Getter
	 * @return the fer
	 */
	public double getFer() {
		return fer;
	}

	/** Setter
	 * @param fer the fer to set
	 */
	public void setFer(double fer) {
		this.fer = fer;
	}

	/** Getter
	 * @return the betaCarotene
	 */
	public double getBetaCarotene() {
		return betaCarotene;
	}

	/** Setter
	 * @param betaCarotene the betaCarotene to set
	 */
	public void setBetaCarotene(double betaCarotene) {
		this.betaCarotene = betaCarotene;
	}

	/** Getter
	 * @return the presenceHuilePalme
	 */
	public boolean isPresenceHuilePalme() {
		return presenceHuilePalme;
	}

	/** Setter
	 * @param presenceHuilePalme the presenceHuilePalme to set
	 */
	public void setPresenceHuilePalme(boolean presenceHuilePalme) {
		this.presenceHuilePalme = presenceHuilePalme;
	}
	
	
}
