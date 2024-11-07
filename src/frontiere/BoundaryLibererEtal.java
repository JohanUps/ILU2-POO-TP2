package frontiere;

import controleur.ControlLibererEtal;


public class BoundaryLibererEtal {
	private ControlLibererEtal controlLibererEtal;

	public BoundaryLibererEtal(ControlLibererEtal controlLibererEtal) {
		this.controlLibererEtal = controlLibererEtal;
	}

	public void libererEtal(String nomVendeur){
		if(!controlLibererEtal.isVendeur(nomVendeur)) {
			System.out.println("Mais vous n'êtes pas inscrit sur notre marché aujourd'hui");
		}else {
			String[]donneesEtal = controlLibererEtal.libererEtal(nomVendeur);
			StringBuilder affichageDonnees = new StringBuilder();
			affichageDonnees.append("Vous avez vendu ");
			affichageDonnees.append(donneesEtal[4]);
			affichageDonnees.append(" sur");
			affichageDonnees.append(donneesEtal[3]);
			affichageDonnees.append(" ");
			affichageDonnees.append(donneesEtal[2]);
			System.out.println(affichageDonnees.toString());
		}
		
	}

}
