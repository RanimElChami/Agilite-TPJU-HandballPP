package cucumber_test_classes;

import java.util.ArrayList;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import exceptions.JoueurDejaMembreException;
import handball_classes.Equipe;
import handball_classes.Joueur;

public class HandballStepDefs {
	private Equipe equipe;
	private Equipe equipe2;
	private Joueur joueur;
	private ArrayList<Joueur> listeJoueur = new ArrayList<Joueur>();
	private String nomEquipe;
	private String nomJoueur;
	private String prenomJoueur;
	private int numeroJoueur;

	@Given("une équipe")
	public void une_équipe() {
		this.equipe = new Equipe (nomEquipe);
	}

	@When("^Estelle choisit le nom (.*), le prénom (.*) et le numéro (\\d+) du joueur$")
	public void choixNomPrenomNumero(String n, String p, int num) throws Throwable {
		this.nomJoueur = n;
		this.prenomJoueur = p;
		this.numeroJoueur = num;
	}

	@Then("^le joueur est créé$")
	public void creerJoueur() throws Throwable {
		this.joueur = new Joueur (nomJoueur, prenomJoueur, numeroJoueur);
	}

	@Given("^une envie$")
	public void uneEnvie () throws Throwable {
	}

	@When("^Estelle choisit un nom d'equipe (.*)$")
	public void choixNomEquipe(String n) throws Throwable {
		this.nomEquipe = n;
	}

	@Then("^l'équipe est créée$")
	public void creerEquipe() throws Throwable {
		this.equipe = new Equipe (nomEquipe);
	}

	@Given("une équipe (.*) et un joueur (.*), (.*), (\\d+)")
	public void une_équipe_et_un_joueur(String nEquipe, String nJoueur, String pJoueur, int nuJoueur) {
		this.equipe = new Equipe(nEquipe);
		this.joueur = new Joueur(nJoueur, pJoueur, nJoueur);
	}
	
	@Given("une équipe (.*) et un joueur (.*), (.*), (\\d+) de l'équipe (.*)")
	public void une_équipe_et_un_joueur_d_une_equipe(String nEquipe, String nJoueur, String pJoueur, int nuJoueur, String eJoueur) {
		this.equipe = new Equipe(nEquipe);
		this.equipe2 = new Equipe(eJoueur);
		this.joueur = new Joueur(nJoueur, pJoueur, nJoueur);
		this.equipe2.ajouterJoueur(joueur);
	}
	
	@When("le joueur ne sera pas ajouté à l'équipe")
	public void le_joueur_ne_sera_pas_ajouté_à() throws JoueurDejaMembreException {
		this.listeJoueur = this.equipe.ajouterJoueur(joueur);
	}
	
	@When("^le joueur est ajouté à l'équipe$")
	public void ajoutJoueurEquipe() throws Throwable {
		this.listeJoueur = this.equipe.ajouterJoueur(joueur);
	}

	@Then("^la liste des joueurs de l'équipe est affiché$")
	public void afficheListeJoueur() throws Throwable {
		System.out.println("La liste des joueurs est la suivante : " + this.listeJoueur + ", Elle contient " + this.listeJoueur.size() + " joueurs");
	}

	@Then("^Un message d'erreur s'affiche$")
	public void messageErreur() throws Throwable {
		System.out.println("Le joueur appartient déjà à une équipe");
	}

}
