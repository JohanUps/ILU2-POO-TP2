package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Village;

class ControlLibererEtalTest {
	private Village village;
	private ControlLibererEtal controlLibererEtal;
	private ControlTrouverEtalVendeur controlTrouverEtalVendeur;
	
	@BeforeEach
	void init() {
		village = new Village("Eulalie", 10, 5);
		Chef chef = new Chef("Brave", 5, village);
		village.setChef(chef);
		
		controlTrouverEtalVendeur = new ControlTrouverEtalVendeur(village);
		controlLibererEtal = new ControlLibererEtal(controlTrouverEtalVendeur);
	}

	@Test
	void testIsVendeur() {
		String nomVendeur = "Jean";
		String nomProduit = "Orange";
		assertFalse(controlLibererEtal.isVendeur(nomVendeur));
		Gaulois jean = new Gaulois(nomVendeur, 5);
		village.ajouterHabitant(jean);
		village.installerVendeur(jean, nomProduit, 5);
		assertTrue(controlLibererEtal.isVendeur(nomVendeur));
	}
	
	@Test
	void testLibererEtalInfo(){
		String nomVendeur = "Jean";
		String nomProduit = "Orange";
		Gaulois jean = new Gaulois(nomVendeur, 5);
		village.ajouterHabitant(jean);
		village.installerVendeur(jean, nomProduit, 5);
		String[] infoEtal = controlLibererEtal.libererEtal(nomVendeur);
		String[] infoEtalAttendu = {"true",nomVendeur,nomProduit,"5","0"};
		assertArrayEquals(infoEtalAttendu, infoEtal);
	}
	
	@Test
	void testLibererEtalLiberation() {
		String nomVendeur = "Jean";
		String nomProduit = "Orange";
		Gaulois jean = new Gaulois(nomVendeur, 5);
		village.ajouterHabitant(jean);
		village.installerVendeur(jean, nomProduit, 5);
		assertNotNull(village.rechercherEtal(jean));
		
		String[] infoEtal = controlLibererEtal.libererEtal(nomVendeur);
		assertN
	}
	



}
