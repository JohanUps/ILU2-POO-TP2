package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Village;

class ControlAcheterProduitTest {
	private ControlAcheterProduit controlAcheterProduit;
	private ControlVerifierIdentite controlVerifierIdentite;
	private ControlTrouverEtalVendeur controlTrouverEtalVendeur;
	private Village village;
	
	
	
	@BeforeEach
	void init() {
		village = new Village("Eulalie", 5, 10);
		Chef chef = new Chef("Tintin", 6, village);
		village.setChef(chef);
		controlVerifierIdentite = new ControlVerifierIdentite(village);
		controlTrouverEtalVendeur = new ControlTrouverEtalVendeur(village);
		controlAcheterProduit = new ControlAcheterProduit(controlVerifierIdentite, controlTrouverEtalVendeur, village);
	}
	
	@Test
	void testIsResident() {
		String nom = "Jean";
		assertFalse(controlAcheterProduit.isResident(nom));
		Gaulois jean = new Gaulois(nom, 5);
		village.ajouterHabitant(jean);
		assertTrue(controlAcheterProduit.isResident(nom));
	}
	
	@Test
	void testVendeursProduit() {
		String produit = "Orange";
		assertNull(controlAcheterProduit.vendeursProduit(produit));
		Gaulois jean = new Gaulois("Jean", 5);
		village.installerVendeur(jean, produit, 5);
		String[] vendeurs = {"Jean"};
		assertArrayEquals(vendeurs, controlAcheterProduit.vendeursProduit(produit));
	}
	
	@Test
	void testAcheterProduit(){
		String nomVendeur = "Jean";
		String produit = "Orange";
		Gaulois jean = new Gaulois(nomVendeur, 5);
		village.ajouterHabitant(jean);
		village.installerVendeur(jean, produit, 5);
		assertEquals(4, controlAcheterProduit.acheterProduit(4, nomVendeur));
		assertEquals(1, controlAcheterProduit.acheterProduit(2, nomVendeur));
		assertEquals(0,controlAcheterProduit.acheterProduit(2, nomVendeur));
	}

}
