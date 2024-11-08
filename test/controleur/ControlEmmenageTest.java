package controleur;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Village;



class ControlEmmenageTest {
	private Village village;
	private ControlEmmenager controlEmmenager;
	
	@BeforeEach
	void initVillage() {
		village = new Village("Rochefort", 10, 5);
		Chef chef = new Chef("Jaque", 2, village);
		village.setChef(chef);
		controlEmmenager = new ControlEmmenager(village);
	}

	
	@Test
	void testIsHabitantFalse() {
		String nom = "Solange";
		assertFalse(controlEmmenager.isHabitant(nom));
	}
	
	@Test
	void testIsHabitantTrue() {
		String nom = "Solange";
		Gaulois solange = new Gaulois(nom, 5);
		village.ajouterHabitant(solange);
		assertTrue(controlEmmenager.isHabitant(nom));
	}
	
	@Test
	void testAjouterDruide() {
		String nom = "Jean";
		controlEmmenager.ajouterDruide(nom, 6, 8, 10);
		assertTrue(controlEmmenager.isHabitant(nom));
	}
	
	@Test
	void testAjouterGaulois() {
		String nom = "Jeanne";
		controlEmmenager.ajouterGaulois(nom, 5);
		assertTrue(controlEmmenager.isHabitant(nom));
	}
	
	
}
