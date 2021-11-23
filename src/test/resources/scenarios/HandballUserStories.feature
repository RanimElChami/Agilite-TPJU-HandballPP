#Création d'une équipe
Feature: US_001_CreationEquipe
	En tant que coach, 
	Je veux créer mon équipe de handball,
	Afin de pouvoir m'inscrire dans une compétition

	Scenario Outline: Estelle veut créer son équipe
		Given une envie
			When Estelle choisit un nom d'equipe
			Then L'équipe <equipe> est créée

			Examples : 
			| 			nom 			        |
			| "PSG Handball"					|
			| "HBC Nantes"						|
			| "Montpellier Handball"	|

#Création d'une joueur
Feature: US_002_CreationJoueur
	En tant que coach, 
	Je veux former des joueur
	Afin d'avoir les meilleurs joueurs

	Scenario Outline: Estelle recrute un joueur dans son équipe
		Given une équipe
			When Estelle saisit le nom, le prénom et le numéro du joueur
			Then le joueur <nom>, <prenom>, <numero> est créé

			Examples : 
			| nom 				  | prenom 		  | numero |
			| "Karabatic"		| "Nikola"		| 13		|
			| "Karabatic"		| "Luka"			| 22		|
			| "Porte"				| "Valentin"	| 28		|
			| "Lassource"		| "Coralie"		| 8			|

#Affectation d'un joueur à une équipe
Feature: US_003_AffectationJoueurEquipe
	En tant que coach,
	Je veux recruter des joueurs
	Afin de constituer mon équipe

	Scenario Outline: Estelle veut recruter un joueur qui n'appartient à aucune équipe
		Given une équipe et un joueur
		When le joueur est ajouté à l'équipe
		Then la liste des joueurs de l'équipe est affiché

		Examples: 
			| equipe										  | joueur 	|
			| "Montpellier Handball"      | j1			|
			| "Montpellier Handball"      | j2			|

	Scenario Outline: Estelle veut recruter un joueur qui appartient déjà à une équipe
		Given une équipe et un joueur
		When le joueur est ajouté à l'équipe
		Then Un message d'erreur s'affiche
		
		Examples:
		
			| equipe										  | joueur 	|
			| "Montpellier Handball"      | j1			|
			| "Montpellier Handball"      | j2			|

#Création d'un maillot = affecté à un joueur
Feature: US_004_CreationMaillot
	En tant que coach, 
	Je veux un maillot pour un des mes joueurs
	Afin qu'il puisse participer aux compétitions

	Scenario Outline: Estelle crée un maillot et l'affecte à un joueur
		Given un maillot et un joueur
		When Estelle saisit la taille <taille>, le marque <marque> et le joueur <joueur>
		Then le maillot est créé avec la taille <taille>, la marque <marque> et le joueur <joueur

			Examples: 
			| taille	  | marque 	  | joueur 	|
			| "L" 			| "Hummel"	| j1			|
			| "L" 			| "Hummel"	| j2			|
			| "XXL" 		| "Hummel"	| j3			|
			| "M" 			| "Adidas"	| j4			|

	Scenario Outline: Estelle crée un maillot et ne l'affecte pas à un joueur
		Given un maillot et un joueur
		When Estelle saisit la taille <taille>, le marque <marque> 
		Then un message d'erreur s'affiche

		Examples: 
			| taille	  | marque 	|
			| "L" 			| "Hummel"	|
			| "L" 			| "Hummel"	|
			| "XXL" 		| "Hummel"	|
			| "M" 			| "Adidas"	| 

# Suppression d'un joueur
Feature: US_005_SupprimerUnJoueur
  En tant que coach, je veux supprimer un joueur de mon équipe pour des raisons particulières
  afin de bien organiser mon équipe et de ne garder que les joueurs actifs.

  Scenario: Supression joueur
    Given un joueur
    And une equipe
    When l appartenance du joueur à l equipe est vérifiée
    Then Le joueur sera supprimé et la nouvelle liste de joueur sera renvoyée

  Scenario Outline: Refus de supprimer le joueur
   Given le joueur
   And une equipe
   And le joueur ne fait pas partie de l equipe
   When l appartenance du joueur à l equipe est vérifiée
   Then Le système refuse et affiche un message