package junit_test_classes;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import electronics_classes.Ordinateur;
import exceptions.JoueurDejaMembreException;
import exceptions.JoueurNonMembreException;
import handball_classes.Equipe;
import handball_classes.Joueur;
import handball_classes.JoueurVirtuel;
import handball_classes.Maillot;
import junit.framework.Assert;

public class JoueurVirtuelTest {
	JoueurVirtuel newJoueurVirtuel, secondNewJoueurVirtuel;
	Ordinateur newOrdinateur;
	Maillot newMaillot;
	Equipe equipeVirtuelle;
	
	// Common fixture for running tests
	@Before
	public void setUp() throws Exception {
		newOrdinateur = new Ordinateur("Desktop", "Apple");
		newJoueurVirtuel = new JoueurVirtuel("Kobe", "Bryant", 24);
		secondNewJoueurVirtuel = new JoueurVirtuel("Nicholas", "Pierre", 24);
		newMaillot = new Maillot("XL", "Nike", newJoueurVirtuel);
		equipeVirtuelle = new Equipe("Equipe de France");
	}
	
	@Test
	public void testProprietesJoueurVirtuel() {
		// Vérifier que le nom du joueur est égal à Micheal
		assertEquals(newJoueurVirtuel.getNom(), "Kobe");
		// Vérifier que le prénom du joueur est égal à Jordan
		assertEquals(newJoueurVirtuel.getPrenom(), "Bryant");
		// Vérifier que le numéro du joueur est égal à 45
		assertEquals(newJoueurVirtuel.getNumero(), 24);
		// Vérifier que l'équipe de ce nouveau joueur est null
		assertNull(newJoueurVirtuel.getEquipe());
	}
	
	@Test
	public void testAjoutDeJoueursVirtuelsEquipeVirtuelle() throws JoueurDejaMembreException {
		// Ajouter le joueur à cette équipe
		ArrayList<Joueur> nouvelleListeJoueurs = equipeVirtuelle.ajouterJoueur(newJoueurVirtuel);
		// Vérifier qu'après l'ajout du joueur à la liste, l'équipe de ce joueur n'est pas null
		assertNotNull(newJoueurVirtuel.getEquipe());
		// Vérifier si l'équipe du joueur en question est la meme equipe à laquelle le joueur a été ajouté
		assertEquals(newJoueurVirtuel.getEquipe(), equipeVirtuelle);
		// Vérifier si la liste de joueur contient le joueur qui a été ajouté
		assertTrue(nouvelleListeJoueurs.contains(newJoueurVirtuel));
	}
	
	@Test
	public void testAjoutDePlusieursJoueursVirtuelsEquipeVirtuelle() throws JoueurDejaMembreException {
		// Ajouter plusieurs joueurs en meme temps
		ArrayList<Joueur> nouvelleListeJoueurs = equipeVirtuelle.ajouterJoueur(newJoueurVirtuel, secondNewJoueurVirtuel);
		assertEquals(nouvelleListeJoueurs.size(), 2);
	}

	@Test(expected = JoueurDejaMembreException.class)
	public void testJoueurVirtuelDejaMembreException() throws JoueurDejaMembreException {
		// Ajouter le joueur à cette équipe
		ArrayList<Joueur> nouvelleListeJoueurs = equipeVirtuelle.ajouterJoueur(newJoueurVirtuel);
		nouvelleListeJoueurs = equipeVirtuelle.ajouterJoueur(newJoueurVirtuel);
	}

	@Test(expected = JoueurDejaMembreException.class)
	public void testJoueurVirtuelDejaMembreAutreEquipeException() throws JoueurDejaMembreException {
		// Ajouter le joueur à cette équipe
		ArrayList<Joueur> nouvelleListeJoueurs = equipeVirtuelle.ajouterJoueur(secondNewJoueurVirtuel);
		// Vérifier si on arrive à ajouter un joueur de l'équipe PSG à l'équipe Marseille
		Equipe equipe2 = new Equipe("Marseille");
		ArrayList<Joueur> deuxiemeNouvelleListeJoueurs = equipe2.ajouterJoueur(secondNewJoueurVirtuel);
		assertEquals(deuxiemeNouvelleListeJoueurs.size(), 0);
	}

	@Test
	public void testSuppressionDeJoueursVirtuelsEquipe() throws JoueurNonMembreException, JoueurDejaMembreException {
		ArrayList<Joueur> nouvelleListeJoueurs = equipeVirtuelle.ajouterJoueur(newJoueurVirtuel, secondNewJoueurVirtuel);
		// Vérifier que les deux joueurs ont bien été ajoutés, si c'est le cas la taille de la liste doit etre égale à 2
		assertEquals(nouvelleListeJoueurs.size(), 2);
		// Créer une nouvelle liste qui sera égale à la liste renvoyée lorsqu'un joueur est supprimé d'une équipe
		ArrayList<Joueur> nouvelleListeSupression = equipeVirtuelle.supprimerJoueur(newJoueurVirtuel);
		// Vérifier si le joueur ne fait plus partie de l'équipe
		assertFalse(nouvelleListeSupression.contains(newJoueurVirtuel));
		// Vérifier que le joueur n'a plus d'équipe et l'attribut équipe est null
		assertNull(newJoueurVirtuel.getEquipe());
	}

	@Test(expected = JoueurNonMembreException.class)
	public void testJoueurVirtuelNonMembreException() throws JoueurNonMembreException {
		ArrayList<Joueur> nouvelleListeSupression;
		nouvelleListeSupression = equipeVirtuelle.supprimerJoueur(newJoueurVirtuel);
		// Vérifier si le joueur ne fait plus partie de l'équipe
		assertFalse(nouvelleListeSupression.contains(newJoueurVirtuel));
		// Vérifier que le joueur n'a plus d'équipe et l'attribut équipe est null
		assertNull(newJoueurVirtuel.getEquipe());
	}
	
	// Tests des liens entre joueur virtuel et ordinateur
	@Test
	public void testAttributionOrdinateurAJoueurVirtuel() {
		//newJoueurVirtuel.attribuerOrdinateurAuJoueurVirtuel(newOrdinateur);
		// Vérifier que l'ordinateur a bien été attribué au joueur virtuel en question
		assertNotNull(newJoueurVirtuel.getOrdinateur());
		assertEquals(newJoueurVirtuel.getOrdinateur(), newOrdinateur);
	}
	
}
