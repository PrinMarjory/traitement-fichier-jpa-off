package fr.diginamic;

import java.nio.file.Path;
import java.nio.file.Paths;

import fr.diginamic.utils.OpenFoodFactsUtils;

public class TestInsertionBase {

	public static void main(String[] args) {
		
		Path path = Paths.get("C:/Users/marjo/Documents/Diginamic/Java/traitement-fichier-jpa-off/src/main/resources/open-food-facts.csv");
		OpenFoodFactsUtils.chargerMariaDB(path, 3100);

	}

}
