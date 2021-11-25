#Author: Samia, Yassine, Ranim et Estelle


Feature: CompetitionIntergalactique
  En tant que coach de l'equipe de Handball de la planete terre 
  Je veux creer une equipe virtuelle et faire les changements necessaires durant la competition
  Afin de pouvoir remporter la coupe intergalactique du Handball
  
  
  Scenario Outline: Coach recrute des nouveaux joueurs virtuels dans l'equipe
    Given une equipe
		When coach choisit le nom <nom>, le prenom <prenom> et le numero <numero> du joueur virtuel
		Then le joueur virtuel est cree et il reçoit un <ordinateur> avec ses <peripherique>
		
		  Examples: 
      | name         | prenom    | numero | ordinateur              | peripherique        |
      | "Alammasse"  | "Samia"   | 12     | "XboxOnex Microsoft"    | "CasqueVR, GantsVR" |
      | "BENISSA"    | "Yassine" | 7      | "PS5 Sony"              | "CasqueVR, GantsVR" |
      | "El Chami"   | "Ranim"   | 1      | "PS4 Sony"              | "CasqueVR, GantsVR" |
      | "GRAU-FARRE" | "Estelle" | 11     | "XboxSeriesX Microsoft" | "CasqueVR, GantsVR" |

  
  Scenario Outline: Coach veut faire un changement de joueurs viruels
    Given le joueur virtuel numero <numero> au banc 
    When le coach decide de changer le joueur virtuel nuemro <numero>
    Then la machine va passer au joueur choisi par le coach

    Examples:     
      | numero1 | numero2 |
      | 12      | 10      |
      
   Scenario Outline: Coach veut integrer un joueuer ordinaire a son equipe virtuel  
    Given un joueur ordinaire avec le nom <nom>, le prenom <prenom> et le numero <numero>
    When le coach veut le recruter dans son equipe virtuelle
    Then le coach va le transformer en joueur virtuelle 

    Examples:     
      | nom     | prenom   | numero | 
      | "Messi" | "Lionel" |  10    |
     
      
