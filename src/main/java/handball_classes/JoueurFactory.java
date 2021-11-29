package handball_classes;

public class JoueurFactory {
	public IJoueur getJoueur(String joueurType) {	
		if(joueurType.equalsIgnoreCase("Joueur")){
			return new Joueur(null, null, 0);
		} else if(joueurType.equalsIgnoreCase("JoueurVirtuel")){
			return new JoueurVirtuel(null, null, 0, null);
		} else {
			return null;
		}
	}
}
