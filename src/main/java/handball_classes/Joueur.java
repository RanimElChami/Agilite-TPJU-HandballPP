package handball_classes;

import java.util.Objects;

public class Joueur implements IJoueur {
	// Variables d'instance
	// Nom du joueur
    private String nom;  
    // Prénom du joueur
    private String prenom;   
    // Numéro du joueur
    private int numero;
    // L'équipe du joueur
    private Equipe equipe = null;

    /**
     * Constructeur d'objets de classe Joueur
     * @param n : nom du joueur
     * @param p : prénom du joueur
     * @param num : numéro du joueur
     */
    public Joueur(String nom, String prenom, int num){
        // Initialisation des variables d'instance
        this.nom = nom;
        this.prenom = prenom;
        this.numero = num;
    }
    
    public Joueur(){}
    
    // Les accesseurs des attributs de la classe Joueur
    public String getNom(){
        return this.nom;
    }
    public void setNom(String n){
        this.nom = n ;
    }
    public String getPrenom(){
        return this.prenom;
    }
    public void setPrenom(String p){
        this.prenom = p;
    }
    public int getNumero(){
        return this.numero;
    }
    public void setNumero(int n){
        this.numero = n;
    }
    public Equipe getEquipe() {
		return equipe;
	}
	public void setEquipe(Equipe equipe) {
		this.equipe = equipe;
	}

	// Méthodes
    /**
     * Méthode affichant les informations du joueur : nom, prénom et son numéro
     * Si le joueur est membre d'une équipe, le nom de l'équipe sera affiché avec les informations
     * générales du joueur, sinon, le message affiché indiquera que le joueur n'a pas d'équipe
     * @return les informations générales du joueur
     */
    public String afficherDetailsJoueur(){
    	if(Objects.nonNull(this.equipe)) {
    		return "Hello, je m'appelle " + prenom + " " + nom + ". Mon numéro est " +
    	numero + ", je fait partie de l'équipe " + this.equipe.getNom() + ".";
    	} else {
    		return "Hello, je m'appelle " + this.prenom + " " + this.nom + ". Mon numéro est " + 
    	this.numero + ", je n'ai pas encore d'équipe.";
    	}
    }
    
	// Redéfinition de la méthode toString() pour afficher le nom de l'équipe au lieu de l'identifiant de l'instance
    @Override
	public String toString(){ 
		  return this.getPrenom() + " " + this.getNom();  
	}

    public void typeDuJoueur() {
		System.out.println("Je suis un joueur de handball");
	}
}