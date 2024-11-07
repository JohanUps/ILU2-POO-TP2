package frontiere;

import controleur.ControlAfficherMarche;

public class BoundaryAfficherMarche {
	private ControlAfficherMarche controlAfficherMarche;

	public BoundaryAfficherMarche(ControlAfficherMarche controlAfficherMarche) {
		this.controlAfficherMarche = controlAfficherMarche;
	}

	public void afficherMarche(String nomAcheteur) {
		String[] infoMarche = controlAfficherMarche.donnerInfoMarcher();
		if(infoMarche.length == 0) {
			System.out.println("Le marcher est vide, revenez plus tard");
		}
		else {
			StringBuilder affichageInfo = new StringBuilder(nomAcheteur);
			affichageInfo.append(" vous trouverez au marché :\n");
			int i = 0;
			while(i<infoMarche.length) {
				affichageInfo.append("-");
				affichageInfo.append(infoMarche[i++]);
				affichageInfo.append(" qui vend ");
				affichageInfo.append(infoMarche[i++]);
				affichageInfo.append(" ");
				affichageInfo.append(infoMarche[i++]);
			}
			System.out.println(infoMarche.toString());
		}
	}
	
}
