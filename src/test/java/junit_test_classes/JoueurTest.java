package junit_test_classes;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import handball_classes.Joueur;

public class JoueurTest {

	Joueur newJoueur;

	// Common fixture for running tests
	@Before
	public void setUp() throws Exception {
		newJoueur = new Joueur("Micheal", "Jordan", 45);
	}

	@Test
	public void testVerificationProprietesJoueur() {
		// Vérifier que le nom du joueur est égal à Micheal
		assertEquals(newJoueur.getNom(), "Micheal");
		// Vérifier que le prénom du joueur est égal à Jordan
		assertEquals(newJoueur.getPrenom(), "Jordan");
		// Vérifier que le numéro du joueur est égal à 45
		assertEquals(newJoueur.getNumero(), 45);
		// Vérifier que l'équipe de ce nouveau joueur est null
		assertNull(newJoueur.getEquipe());
	}
	@Test
	public void testAffichageDetailsJoueur() {
		// Vérifier que le résultat renvoyer par la méthode details()
		assertEquals(newJoueur.afficherDetailsJoueur(), "Hello, je m'appelle " + newJoueur.getPrenom() + 
				" " + newJoueur.getNom() + ". Mon numéro est " + 
				newJoueur.getNumero() + ", je n'ai pas encore d'équipe.");
	}

}
