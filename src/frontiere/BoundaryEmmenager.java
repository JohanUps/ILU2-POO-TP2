package frontiere;

import controleur.ControlEmmenager;

public class BoundaryEmmenager {
	private ControlEmmenager controlEmmenager;

	public BoundaryEmmenager(ControlEmmenager controlEmmenager) {
		this.controlEmmenager = controlEmmenager;
	}

	public void emmenager(String nomVisiteur) {
		if (controlEmmenager.isHabitant(nomVisiteur)) {
			System.out.println(
					"Mais vous êtes déjà un habitant du village !");
		} else {
			StringBuilder question = new StringBuilder();
			question.append("Êtes-vous :\n");
			question.append("1 - un druide.\n");
			question.append("2 - un gaulois.\n");
			int choixUtilisateur = -1;
			do {
				choixUtilisateur = Clavier.entrerEntier(question.toString());
				switch (choixUtilisateur) {
				case 1:
					emmenagerDruide(nomVisiteur);
					break;

				case 2:
					emmenagerGaulois(nomVisiteur);
					break;

				default:
					System.out
							.println("Vous devez choisir le chiffre 1 ou 2 !");
					break;
				}
			} while (choixUtilisateur != 1 && choixUtilisateur != 2);
		}
	}

	private void emmenagerDruide(String nomVisiteur) {
		int force;
		int potionFaible;
		int potionForte;
		StringBuilder messageForce = new StringBuilder();

		messageForce.append("Bienvenue druide ");
		messageForce.append(nomVisiteur);
		messageForce.append(". ");
		messageForce.append("Quelle est votre force ? ");
		force = Clavier.entrerEntier(messageForce.toString());
		
		do {
			potionFaible = Clavier.entrerEntier("Quelle est votre potion la plus faible que vous produisez ?");
			potionForte = Clavier.entrerEntier("Quelle est votre potion la plus forte que vous produisez ? ");
			if(potionFaible>potionForte)
				System.out.println("Attention Druide, vous vous �tes tromp� entre le minimum et le maximum");
		}while(potionFaible>potionForte);
		
		controlEmmenager.ajouterDruide(nomVisiteur, force, potionFaible, potionForte);
		
	}
	
	private void emmenagerGaulois(String nomVisiteur) {
		int force;
		StringBuilder messageForce = new StringBuilder();
		
		messageForce.append("Bienvenue villageois ");
		messageForce.append(nomVisiteur);
		messageForce.append(". ");
		messageForce.append("Quelle est votre force ?");
		
		force = Clavier.entrerEntier(messageForce.toString());
		
		controlEmmenager.ajouterGaulois(nomVisiteur, force);
	}
}
