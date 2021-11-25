#Recrutement d'un joueur et création d'une équipe
Feature: US_001_RecrutementEquipe
	En tant que coach, 
	Je veux créer mon équipe de handball,
	Afin de pouvoir m'inscrire dans une compétition

	Scenario Outline: Estelle recrute un joueur dans son équipe
		Given une équipe
		When Estelle choisit le nom <nom>, le prénom <prenom> et le numéro <numero> du joueur
		Then le joueur est créé

		Examples: 
		| nom 			| prenom 	  	| numero	|
		| "Karabatic"		| "Nikola"		| 13		|
		| "Karabatic"		| "Luka"		| 22		|
		| "Porte"				| "Valentin"		| 28		|
		| "Lassource"		| "Coralie"		| 8		|
		
	Scenario Outline: Estelle veut créer son équipe
		Given une envie
		When Estelle choisit un nom d'equipe <equipe>
		Then l'équipe est créée

		Examples: 
		| 		nom 	        |
		| "PSG Handball"		|
		| "HBC Nantes"			|
		| "Montpellier Handball"	|

	Scenario Outline: Estelle veut recruter un joueur qui n'appartient à aucune équipe
		Given une équipe et un joueur
		When le joueur est ajouté à l'équipe <equipe>
		Then la liste des joueurs de l'équipe est affiché

	Examples: 
			| equipe												| joueur 	|
			| "Montpellier Handball"      	| j1			|
			| "Montpellier Handball"      	| j2			|

	Scenario Outline: Estelle veut recruter un joueur qui appartient déjà à une équipe
		Given une équipe et un joueur
		When le joueur ne sera pas ajouté à <equipe>
		Then Un message d'erreur s'affiche
		
		Examples:
			| equipe												| joueur 	|
			| "Montpellier Handball"      	| j1		|
			| "Montpellier Handball"      	| j2		|