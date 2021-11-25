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
		Given une équipe <equipe> et un joueur <nom>, <prenom>, <numero>
		When le joueur est ajouté à l'équipe
		Then la liste des joueurs de l'équipe est affiché

	Examples: 
			| equipe			| nom		| prenom 	| numéro	|
			| "Montpellier Handball"      	| "Karabatic"	|"Nikola"	|33		|
			| "Montpellier Handball"      	| "Karabatic"	|"Luka	"	|11		|

	Scenario Outline: Estelle veut recruter un joueur qui appartient déjà à une équipe
		Given une équipe <equipe> et un joueur <nom>, <prenom>, <numero> de l'équipe <equipeJoueur>
		When le joueur ne sera pas ajouté à l'équipe
		Then Un message d'erreur s'affiche
		
		Examples:
			| equipe			| nom		| prenom 	| numéro	| equipeJoueur 	|
			| "Montpellier Handball"      	| "Karabatic"	|"Nikola"	|33		|"PSG Handball"	|
			| "Montpellier Handball"      	| "Karabatic"	|"Luka	"	|11		|"HBC Nantes"	|
