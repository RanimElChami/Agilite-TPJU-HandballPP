package handball_classes;

public class Main {

	public static void main(String[] args) {
		JoueurFactory shapeFactory = new JoueurFactory();

		IJoueur joueur1 = shapeFactory.getJoueur("Joueur");
		
		IJoueur joueur2 = shapeFactory.getJoueur("JoueurVirtuel");
	
	}

}
