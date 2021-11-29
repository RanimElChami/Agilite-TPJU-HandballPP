package cucumber_test_classes;

import org.junit.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import electronics_classes.Ordinateur;
import electronics_classes.Peripherique;
import exceptions.JoueurDejaMembreException;
import handball_classes.Equipe;
import handball_classes.Joueur;
import handball_classes.JoueurVirtuel;

public class JoueurVirtuelStepsDefs {
	private Equipe planeteTerre;
	private JoueurVirtuel joueurV1;
	private JoueurVirtuel joueurV2;
	private Joueur joueur;
	private Ordinateur ord; 
	private Peripherique oculus;
	private Peripherique joysticks;
	
	@Given("une (.*)")
	public void une(String equipe) {
		planeteTerre = new Equipe(equipe);
	}

	@When("coach choisit le nom (.*), le prenom (.*) et le numero (\\d+) du joueur virtuel et lui affecte un (.*) avec ses (.*)")
	public void coach_choisit_le_nom_le_prenom_et_le_numero_du_joueur_virtuel_et_lui_affecte_un_avec_ses
	(String nom, String prenom, Integer n,String ordinateur, String peripherique) {
		joueurV1 = new JoueurVirtuel(nom, prenom, n, null);
		String[] words = ordinateur.split(" ");
		ord = new Ordinateur(words[0], words[1]);
		words = peripherique.split(" ");
		oculus = new Peripherique(words[0]);
		joysticks = new Peripherique(words[1]);
	}

	@Then("le joueur virtuel est cree et il reçoit le materiel")
	public void le_joueur_virtuel_est_cree_et_il_reçoit_le_materiel() throws JoueurDejaMembreException {
		ord.addPeripherique(oculus);
		ord.addPeripherique(joysticks);
		joueurV1.setOrdinateur(ord);
		planeteTerre.ajouterJoueur(joueurV1);
		String expected= "Hello, je m'appelle " + joueurV1.getPrenom() + " " + joueurV1.getNom() + ". Mon numéro est " +
		    	joueurV1.getNumero() + ", je fait partie de l'équipe " + joueurV1.getEquipe().getNom() + "." + 
				ord.getType()+" "+ord.getBrand()+"\nPeripheriques : \n"+oculus.getType()+"\n"+joysticks.getType()+"\n" ;
        String  result= joueurV1.afficherDetailsJoueur();
        Assert.assertTrue(expected.equals(result));
	}

	@Given("le joueur virtuel numero (\\d+) au banc")
	public void le_joueur_virtuel_numero_au_banc(Integer n) {
		joueurV1 = new JoueurVirtuel("Messi", "Lionel", n , null); 	
	}

	@When("le coach decide de changer le joueur virtuel nuemro (\\d+)")
	public void le_coach_decide_de_changer_le_joueur_virtuel_nuemro(Integer n) {
		ord = new Ordinateur("PS5","Sony");
		oculus = new Peripherique("CasqueVR");
		joysticks = new Peripherique("GantsVR");
		ord.addPeripherique(oculus);
		ord.addPeripherique(joysticks);
		joueurV2 = new JoueurVirtuel("Ronaldo", "Cristiano", n , ord); 
	}

	@Then("la machine va passer au joueur choisi par le coach")
	public void la_machine_va_passer_au_joueur_choisi_par_le_coach() {
	    joueurV1.setOrdinateur(joueurV2.getOrdinateur());
	    joueurV2.seDeconnecter();
	    Ordinateur destination= joueurV1.getOrdinateur();
	    Ordinateur source = joueurV2.getOrdinateur();
	    Assert.assertTrue(!destination.equals(source));
	    Assert.assertNull(source);
	}

	@Given("un joueur ordinaire avec le nom (.*), le prenom (.*) et le numero (\\d+)")
	public void un_joueur_ordinaire_avec_le_nom_le_prenom_et_le_numero(String nom, String prenom, Integer n) {
		joueur = new Joueur(nom, prenom, n); 
	}

	@When("le coach veut le recruter dans son equipe virtuelle")
	public void le_coach_veut_le_recruter_dans_son_equipe_virtuelle() {
		planeteTerre = new Equipe("Planete Terre");
	}

	@Then("le coach va le transformer en joueur virtuelle")
	public void le_coach_va_le_transformer_en_joueur_virtuelle() throws JoueurDejaMembreException {
		joueurV1 = new JoueurVirtuel(joueur.getNom(), joueur.getPrenom(), joueur.getNumero(), null);
		planeteTerre.ajouterJoueur(joueurV1);
		Ordinateur expected= null ;
        Ordinateur  result= joueurV1.getOrdinateur();
        Assert.assertEquals(expected, result);
		
	}
}
