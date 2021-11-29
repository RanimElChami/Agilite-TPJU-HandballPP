package cucumber_test_classes; 
 
import org.junit.Assert;

import cucumber.api.java.en.Given;  
import cucumber.api.java.en.Then;  
import cucumber.api.java.en.When;
import electronics_classes.Ordinateur;
import electronics_classes.Peripherique;

public class ElectronicsStepDefs {
	
	private Peripherique logitech;
	private Ordinateur ord;
	private Peripherique cherry;
	
	@Given("un collaborateur a demande un nouveau (.*)")
	public void un_collaborateur_a_demande_un_nouveau(String peripherique) {
		this.logitech = new Peripherique(peripherique);
	}
	
	
	@When("le collaborateur le recoit pour son (.*)")
	public void le_collaborateur_le_recoit_pour_son(String ordinateur) {
		String[] words = ordinateur.split(" ");
		ord = new Ordinateur(words[0], words[1]);
	}

	@Then("le peripherique est affecte")
	public void le_peripherique_est_affecte(){
		ord.addPeripherique(this.logitech);
		String expected= this.logitech.getType() + " de "+ord.getType()+" "+ord.getBrand()+"\nPeripheriques : \n"+this.logitech.getType()+"\n";
        String  result= logitech.sampleMethod();
        Assert.assertTrue(expected.equals(result));
	}
	
	
	@Given("le responsable veut faire l'inventaire des (.*) et (.*)")
	public void le_responsable_veut_faire_l_inventaire_des_et(String ordinateur, String peripherique) {
		String[] words = ordinateur.split(" ");
		ord = new Ordinateur(words[0], words[1]);
		words = peripherique.split(" ");
		logitech = new Peripherique(words[0]);
		cherry = new Peripherique(words[1]);
		
	}

	@When("le responsable exporte l'etat de suivi du materiel")
	public void le_responsable_exporte_l_etat_de_suivi_du_materiel() {	
		ord.addPeripherique(logitech);
		ord.addPeripherique(cherry);
	}

	@Then("chaque ordinateur est affiche avec ses peripheriques")
	public void chaque_ordinatuer_est_affiche_avec_ses_peripheriques() {
		String expected= ord.getType()+" "+ord.getBrand()+"\nPeripheriques : \n"+logitech.getType()+"\n"+cherry.getType()+"\n";
        String  result= ord.sampleMethod();
        Assert.assertTrue(expected.equals(result));
	}

}