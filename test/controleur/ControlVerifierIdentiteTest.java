package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Village;

class ControlVerifierIdentiteTest {
	private ControlVerifierIdentite controlVerifierIdentite;
	private Village village;
	
	
	@BeforeEach
	void init(){
		village = new Village("Roche", 10, 5);
		Chef chef = new Chef("Joe", 5, village);
		village.setChef(chef);
		controlVerifierIdentite = new ControlVerifierIdentite(village);
	}
	
	@Test
	void testVerifierIdentite() {
		String nom = "Jaque";
		Gaulois jaque = new Gaulois(nom, 5);
		assertFalse(controlVerifierIdentite.verifierIdentite(nom));
		village.ajouterHabitant(jaque);
		assertTrue(controlVerifierIdentite.verifierIdentite(nom));
	}
	
}
