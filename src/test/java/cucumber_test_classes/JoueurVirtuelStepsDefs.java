package cucumber_test_classes;

import org.junit.Assert;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class JoueurVirtuelStepsDefs {

	@Given("un collaborateur a demande un nouveau {string}")
	public void un_collaborateur_a_demande_un_nouveau(String string) {
	    // Write code here that turns the phrase above into concrete actions
	}

	@Then("le peripherique est affecté à son {string}")
	public void le_peripherique_est_affecté_à_son(String string) {
	    // Write code here that turns the phrase above into concrete actions
	}

	@Then("chaque {string} est affiché avec ses peripheriques")
	public void chaque_est_affiché_avec_ses_peripheriques(String string) {
	    // Write code here that turns the phrase above into concrete actions
	}

	@Given("une equipe")
	public void une_equipe() {
	    // Write code here that turns the phrase above into concrete actions
	}

	@When("coach choisit le nom <nom>, le prenom {string} et le numero {int} du joueur virtuel")
	public void coach_choisit_le_nom_nom_le_prenom_et_le_numero_du_joueur_virtuel(String string, Integer int1) {
	    // Write code here that turns the phrase above into concrete actions
	}

	@Then("le joueur virtuel est cree et il reçoit un {string} avec ses {string}")
	public void le_joueur_virtuel_est_cree_et_il_reçoit_un_avec_ses(String string, String string2) {
	    // Write code here that turns the phrase above into concrete actions
	}

	@Given("le joueur virtuel numero {int} au banc")
	public void le_joueur_virtuel_numero_au_banc(Integer int1) {
	    // Write code here that turns the phrase above into concrete actions
	}

	@When("le coach decide de changer le joueur virtuel nuemro {int}")
	public void le_coach_decide_de_changer_le_joueur_virtuel_nuemro(Integer int1) {
	    // Write code here that turns the phrase above into concrete actions
	}

	@Then("la machine va passer au joueur choisi par le coach")
	public void la_machine_va_passer_au_joueur_choisi_par_le_coach() {
	    // Write code here that turns the phrase above into concrete actions
	}

	@Given("un joueur ordinaire avec le nom {string}, le prenom {string} et le numero {int}")
	public void un_joueur_ordinaire_avec_le_nom_le_prenom_et_le_numero(String string, String string2, Integer int1) {
	    // Write code here that turns the phrase above into concrete actions
	}

	@When("le coach veut le recruter dans son equipe virtuelle")
	public void le_coach_veut_le_recruter_dans_son_equipe_virtuelle() {
	    // Write code here that turns the phrase above into concrete actions
	}

	@Then("le coach va le transformer en joueur virtuelle")
	public void le_coach_va_le_transformer_en_joueur_virtuelle() {
	    // Write code here that turns the phrase above into concrete actions
	}


}
