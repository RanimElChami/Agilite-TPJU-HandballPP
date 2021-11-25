package handball_classes;

import handball_classes.Joueur;

public class Maillot {
	// Variables d'instance
	// Taille du maillot
    private String taille;
    // Marque du maillot
    private String marque;
    // Instance de la classe Joueur
    private Joueur joueur;

    /**
     * Constructeur d'objets de la classe Maillot
     * @param taille : taille du maillot
     * @param marque : marque du maillot
     * @param joueur : instance du joueur associée au maillot correspondant
     */
    public Maillot(String taille, String marque, Joueur joueur){
        // Initialisation des variables d'instance
        this.taille = taille;
        this.marque = marque;
        this.joueur = joueur;
    }

    // Les accesseurs des attributs de la classe Maillot
    public String getTaille(){
        return this.taille;
    }
    public void setTaille(String t){
        this.taille = t;
    }
    public String getMarque(){
        return this.marque;
    }
    public void setMarque(String m){
        this.marque = m;
    }
    public Joueur getJoueur(){
        return this.joueur;
    }
    private void setJoueur(Joueur j){
        this.joueur = j;
    }
    // Verifier si un joueur peut etre ajouté à une équipe sans un maillot
    // Méthodes
    /**
     * Méthode affichant les détails du maillot, taille et marque, en les fusionnant avec les informations du jour
     * Pour afficher les détails du joueur, la méthode details de la classe Joueur est appelée à partir de l'insctance de Joueur
     * @return détails du joueur et du maillot du joueur
     */
    public String afficherDetailsJoueur(){
        return this.joueur.afficherDetailsJoueur() + " Mon maillot a pour marque " + this.marque + ". Ma taille est " + this.taille + ".";
    }
    
	// Redéfinition de la méthode toString() pour afficher le nom de l'équipe au lieu de l'identifiant de l'instance
    @Override
	public String toString(){ 
		  return this.getMarque() + " " + this.getTaille();  
	} 
}