package test_classes;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import handball_classes.Equipe;
import handball_classes.Joueur;

public class HandballStepDefs {
	private Equipe equipe;
	private Joueur joueur;

	private ArrayList<Joueur> listeJoueur = new ArrayList<Joueur>();

	private String nomEquipe;

	private String nomJoueur;
	private String prenomJoueur;
	private int numeroJoueur;

	@Given("^une equipe$")
	public void uneEquipe () throws Throwable {

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

	@Given("^une equipe et une joueur$")
	public void uneEquipeEtUnJoueur () throws Throwable {
	}

	@When("^le joueur est ajouté à l'équipe (.*)$")
	public void ajoutJoueurEquipe(String e) throws Throwable {
		if(equipe.getNom() == e ){
			this.listeJoueur = this.equipe.ajouterJoueur(joueur);
		}
		
	}

	@Then("^la liste des joueurs de l'équipe est affiché$")
	public void afficheListeJoueur() throws Throwable {
		System.out.println(this.listeJoueur);
	}

	@Then("^Un message d'erreur s'affiche$")
	public void messageErreur() throws Throwable {
		System.out.println("Le joueur appartient déjà à une équipe");
	}

}
