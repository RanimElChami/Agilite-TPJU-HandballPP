package junit_test_classes;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import handball_classes.Joueur;
import handball_classes.Maillot;

public class MaillotTest {
	Joueur newJoueur;
	Maillot newMaillot;

	// Common fixture for running tests
	@Before
	public void setUp() throws Exception {
		newJoueur = new Joueur("Micheal", "Jordan", 45);
		newMaillot = new Maillot("L", "Addidas", newJoueur);
	}

	@Test
	public void testVerificationProprietesMaillot() {
		// Vérifier que la marque du maillot est Addidas
		assertEquals(newMaillot.getMarque(), "Addidas");
		// Vérifier que le taille du maillot est L
		assertEquals(newMaillot.getTaille(), "L");
		// Vérifier que le maillot appartient à un joueur
		assertNotNull(newMaillot.getJoueur());
		// Vérifier que le joueur qui possède le maillot en cours est Micheal Jordan
		assertEquals(newMaillot.getJoueur(), newJoueur);

		// Vérifier que deux joueurs ne peuvent pas avoir le meme maillot
		Joueur secondNewJoueur = new Joueur("Mike", "Will", 12);
		Maillot newMaillot2 = new Maillot("L", "Addidas", secondNewJoueur);

		// Verifier que deux joueurs ne peuvent pas avoir le meme numéro dans une meme equipe
	}

	@Test
	public void testAffichageDetailsMaillot() {
		// Vérifier que le résultat renvoyer par la méthode details()
		assertEquals(newMaillot.afficherDetailsJoueur(), "Hello, je m'appelle " + newJoueur.getPrenom() + 
				" " + newJoueur.getNom() + ". Mon numéro est " + 
				newJoueur.getNumero() + ", je n'ai pas encore d'équipe." + 
				" Mon maillot a pour marque " + newMaillot.getMarque() + ". Ma taille est " + 
				newMaillot.getTaille() + ".");
	}
}
