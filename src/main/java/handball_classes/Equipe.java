package handball_classes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;

import exceptions.JoueurDejaMembreException;
import exceptions.JoueurNonMembreException;

public class Equipe {
	// Variables d'instance
	// Le nom de l'équipe
	private String nom;
	// La liste des joueurs
	private ArrayList<Joueur> listeJoueurs;

	// Constructeurs
	/**
	 * Constructeur d'objets de la classe Equipe
	 * @param n : nom de l'équipe
	 */
	public Equipe(String n) {
		this.nom = n;
		this.listeJoueurs = new ArrayList<Joueur>();
	}

	// Accesseurs
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public ArrayList<Joueur> getListeJoueurs() {
		return (ArrayList<Joueur>) Collections.unmodifiableList(listeJoueurs);
	}
	public void setListeJoueurs(ArrayList<Joueur> listeJoueurs) {
		this.listeJoueurs = listeJoueurs;
	}

	// Méthodes
	// Cette nouvelle version permet d'ajouter plusieurs joueurs à l'équipe en appellant la méthode une seule fois
	public ArrayList<Joueur> ajouterJoueur(Joueur...joueurs){
		//System.out.println("Ajout d'un nouveau joueur");
		// Vérifier si l'argument reçu est un paramètre de la classe Joueur et n'est pas vide
		for (Joueur joueur : joueurs) { 
			// Vérifier si le joueur reçu n'existe pas déjà dans la liste
			// Vérifier si le joueur ne fait pas partie d'une autre équipe
			if (listeJoueurs.contains(joueur)) {
				// Throw an exception
				try {
					throw new JoueurDejaMembreException("Le joueur est déjà un membre de cette équipe! Il ne sera pas ajouté à nouveau");
				} catch (JoueurDejaMembreException e) {
					e.printStackTrace();
				}
			} else if(joueur.getEquipe() != null) {
				// Throw an exception
				try {
					throw new JoueurDejaMembreException("Le joueur est déjà un membre de l'équipe " + joueur.getEquipe());
				} catch (JoueurDejaMembreException e) {
					e.printStackTrace();
				}
			} else {
				this.listeJoueurs.add(joueur);
				// Modifier la valeur de l'attribut equipe du joueur, où celle-ci deviendra une instance de la classe en cours
				joueur.setEquipe(this);
			}
		} 

		return this.listeJoueurs;
	}

	public ArrayList<Joueur> supprimerJoueur(Joueur nouveauJoueur) throws JoueurNonMembreException{
		// Vérifier si le joueur reçu existe dans la liste
		if (listeJoueurs.contains(nouveauJoueur)) {
			this.listeJoueurs.remove(nouveauJoueur);
			// Modifier la valeur de l'attribut equipe du joueur, où celle-ci deviendra égale à null
			// puisque le joueur n'appartient plus à une équipe
			nouveauJoueur.setEquipe(null);
		} else {
			// Throw an exception
			throw new JoueurNonMembreException("Le joueur n'appartient pas à cette équipe! L'opération d'ajout ne sera pas réalisée");
		}

		return listeJoueurs;
	}

	public int nombreDeJoueurs() {
		return this.listeJoueurs.size();
	}

	@Override
	public String toString(){ 
		return this.getNom();  
	} 
}