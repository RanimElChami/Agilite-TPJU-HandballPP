#Author: Samia, Yassine, Ranim et Estelle
Feature: US_003_CompetitionIntergalactique
  En tant que coach de l'equipe de Handball de la planete terre 
  Je veux creer une equipe virtuelle et faire les changements necessaires durant la competition
  Afin de pouvoir remporter la coupe intergalactique du Handball
  
  
  Scenario Outline: Coach recrute des nouveaux joueurs virtuels dans l'equipe
    Given une equipe
		When coach choisit le nom <nom>, le prenom <prenom> et le numero <numero> du joueur virtuel
		Then le joueur virtuel est cree et il reçoit un <ordinateur> avec ses <peripherique>
		
		  Examples: 
      | nom          | prenom    | numero | ordinateur              | peripherique        |
      | "ALAMMASSE"  | "Samia"   | 12     | "XboxOnex Microsoft"    | "CasqueVR GantsVR" |
      | "BENISSA"    | "Yassine" | 7      | "PS5 Sony"              | "CasqueVR GantsVR" |
      | "EL CHAMI"   | "Ranim"   | 1      | "PS4 Sony"              | "CasqueVR GantsVR" |
      | "GRAU-FARRE" | "Estelle" | 11     | "XboxSeriesX Microsoft" | "CasqueVR GantsVR" |

  
  Scenario Outline: Coach veut faire un changement de joueurs virtuels
    Given le joueur virtuel numero <numero1> au banc 
    When le coach decide de changer le joueur virtuel nuemro <numero2>
    Then la machine va passer au joueur choisi par le coach

    Examples:     
      | numero1 | numero2 |
      | 12      | 10      |
      | 11      | 13      |
      
   Scenario Outline: Coach veut integrer un joueuer ordinaire a son equipe virtuel  
    Given un joueur ordinaire avec le nom <nom>, le prenom <prenom> et le numero <numero>
    When le coach veut le recruter dans son equipe virtuelle
    Then le coach va le transformer en joueur virtuelle 

    Examples:
      | nom       | prenom      | numero | 
      | "Messi"   | "Lionel"    |  10    |
      | "Ronaldo" | "Cristiano" |  7     |