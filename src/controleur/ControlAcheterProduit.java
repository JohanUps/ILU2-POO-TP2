package controleur;

import personnages.Gaulois;
import villagegaulois.Village;

public class ControlAcheterProduit {
	private Village village;
	private ControlTrouverEtalVendeur controlTrouverEtalVendeur;
	private ControlVerifierIdentite controlVerifierIdentite;

	public ControlAcheterProduit(ControlVerifierIdentite controlVerifierIdentite,
			ControlTrouverEtalVendeur controlTrouverEtalVendeur,
			Village village) {
		this.village = village;
		this.controlVerifierIdentite = controlVerifierIdentite;
		this.controlTrouverEtalVendeur = controlTrouverEtalVendeur;
	}

	public boolean isResident(String nom) {
		return controlVerifierIdentite.verifierIdentite(nom);
	}
	
	public String[] vendeursProduit(String produit) {
		Gaulois[] vendeurs = village.rechercherVendeursProduit(produit);
		String[] nomVendeurs = null;
		if(vendeurs != null) {
			nomVendeurs = new String[vendeurs.length];
			for(int i=0; i<vendeurs.length;i++) {
				nomVendeurs[i] = vendeurs[i].getNom();
			}
		}
	
		return nomVendeurs;
	}
	
	public int acheterProduit(int quantite, String nomVendeur) {
		Gaulois vendeur = village.trouverHabitant(nomVendeur);
		return village.rechercherEtal(vendeur).acheterProduit(quantite);
		
	}
	
}
