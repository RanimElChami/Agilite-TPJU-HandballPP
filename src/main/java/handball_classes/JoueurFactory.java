package handball_classes;

public class JoueurFactory {
	public IJoueur getJoueur(String joueurType) {	
		if(joueurType.equalsIgnoreCase("Joueur")){
			return new Joueur();
		} else if(joueurType.equalsIgnoreCase("JoueurVirtuel")){
			return new JoueurVirtuel();
		} else {
			return null;
		}
	}
}
