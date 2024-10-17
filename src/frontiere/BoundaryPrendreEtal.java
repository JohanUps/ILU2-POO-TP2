package frontiere;

import java.util.Scanner;

import controleur.ControlPrendreEtal;

public class BoundaryPrendreEtal {
	private ControlPrendreEtal controlPrendreEtal;
	private Scanner scan = new Scanner(System.in);

	public BoundaryPrendreEtal(ControlPrendreEtal controlChercherEtal) {
		this.controlPrendreEtal = controlChercherEtal;
	}

	public void prendreEtal(String nomVendeur) {
		StringBuilder message = new StringBuilder();
		
		if(!controlPrendreEtal.verifierIdentite(nomVendeur)) {
			message.append("Je suis désolé ");
			message.append(nomVendeur);
			message.append(" mais il faut être un habitant du village pour commercer ici.");
			System.out.println(message.toString());
		}
		else {
			message.append("Bonjour ");
			message.append(nomVendeur);
			message.append(", je vais regarder si je peux vous trouver un étal. ");
			System.out.println(message.toString());
			message.setLength(0);
			if(!controlPrendreEtal.resteEtals()) {
				message.append("Désolée ");
				message.append(nomVendeur);
				message.append("je n'ai pas d'étal qui ne soit pas déja occupé.");
				System.out.println(message.toString());
			}
			else {
				installerVendeur(nomVendeur);
				
			}	
		}	
	}

	private void installerVendeur(String nomVendeur) {
		StringBuilder message = new StringBuilder();
		message.append("C'est parfait, il me reste un étal pour vous !\n");
		message.append("Il me faudrait quelques renseignements :");
		System.out.println(message.toString());
		message.setLength(0);
		
		String produit = Clavier.entrerChaine("Quelle produit souhaitez-vous vendre");
		int quantite = Clavier.entrerEntier("Combien souhaitez-vous en vendre ?");
		int numEtal  = controlPrendreEtal.prendreEtal(nomVendeur, produit, quantite);
		message.append("Le vendeur ");
		message.append(nomVendeur);
		message.append(" s'est installé à l'étal n°");
		message.append(numEtal);
		System.out.println(message.toString());
	
	}
	
}
