package cucumber_test_classes; 
 
import org.junit.Assert;

import cucumber.api.java.en.Given;  
import cucumber.api.java.en.Then;  
import cucumber.api.java.en.When;
import electronics_classes.Ordinateur;
import electronics_classes.Peripherique;

public class ElectronicsStepDefs {
	
	private Peripherique logitech;
	private Ordinateur ord1;
	private Ordinateur ord2;
	private Peripherique cherry;
	private Peripherique cherry2; 
	private Peripherique logitech2;
	
	@Given("un collaborateur a demande un nouveau Souris")
	public void un_collaborateur_a_demande_un_nouveau_Souris() {
		this.logitech = new Peripherique("Souris");
	}
	
	@Given("un collaborateur a demande un nouveau Clavier")
	public void un_collaborateur_a_demande_un_nouveau_Clavier() {
		this.cherry = new Peripherique("Clavier");
	}
	
	@When("le collaborateur le recoit")
	public void le_collaborateur_le_recoit() {
		ord1 = new Ordinateur("Desktop", "HP");
		ord2 = new Ordinateur("Laptop", "mac");
		
	}

	@Then("le peripherique est affecter a son Desktop HP")
	public void le_peripherique_est_affecter_a_son_Desktop_HP() {
		ord1.addPeripherique(this.logitech);
		String expected= "Souris de Desktop HP\nPeripheriques : \nSouris\n";
        String  result= logitech.sampleMethod();
        Assert.assertTrue(expected.equals(result));
	}
	

	@Then("le peripherique est affecter a son Laptop mac")
	public void le_peripherique_est_affecter_a_son_Laptop_mac() {
		ord2.addPeripherique(this.cherry);
		String expected= "Clavier de Laptop mac\nPeripheriques : \nClavier\n";
        String  result= cherry.sampleMethod();
        Assert.assertTrue(expected.equals(result));
	}
	
	@Given("le responsable veut faire l'inventaire")
	public void le_responsable_veut_faire_l_inventaire() {
	    logitech = new Peripherique ("Souris");
	    cherry = new Peripherique("Clavier");
	    logitech2 = new Peripherique ("Souris");
	    cherry2 = new Peripherique("Clavier");    
	    ord1 = new Ordinateur("Desktop", "HP");
	    ord2 = new Ordinateur("Laptop", "mac");
	}

	@When("le responsable exporte l'etat de suivi du materiel")
	public void le_responsable_exporte_l_etat_de_suivi_du_materiel() {	
		ord1.addPeripherique(logitech);
		ord1.addPeripherique(cherry);
		ord2.addPeripherique(logitech2);
		ord2.addPeripherique(cherry2);
	}

	@Then("chaque Desktop HP est affiche avec ses peripheriques")
	public void chaque_Desktop_HP_est_affiche_avec_ses_peripheriques() {
		String expected= "Desktop HP\nPeripheriques : \nSouris\nClavier\n";
        String  result= ord1.sampleMethod();
        Assert.assertTrue(expected.equals(result));
	}

	@Then("chaque Laptop mac est affiche avec ses peripheriques")
	public void chaque_Laptop_mac_est_affiche_avec_ses_peripheriques() {
		String expected= "Laptop mac\nPeripheriques : \nSouris\nClavier\n";
        String  result= ord2.sampleMethod();
        Assert.assertTrue(expected.equals(result));
	}

}
