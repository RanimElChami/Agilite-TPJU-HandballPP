#Author: Samia et Yassine
Feature: US_002_SuiviDuMateriels
  En tant que responsable du materiels
  Je veux enregistrer tous les ordinateurs et leurs peripheriques attaches et les peripheriques en stock
  Afin d'avoir un suivi sur l'ensemble du materiels informatiques et faciliter l'inventaire annuelle
  
  Scenario Outline: Affecter un peripherique a un ordinateur
    Given un collaborateur a demande un nouveau <peripherique>
    When le collaborateur le recoit pour son <ordinateur>
    Then le peripherique est affecte 
   
    Examples: 
      | peripherique    | ordinateur   |
      | "Souris"        | "Desktop HP" |
      | "Clavier"       | "Laptop mac" |

    Scenario Outline: Consulter l'ensemble des peripheriques d'un ordinateur
    Given le responsable veut faire l'inventaire des <ordinateur> et <peripherique>
    When le responsable exporte l'etat de suivi du materiel
    Then chaque ordinateur est affiche avec ses peripheriques
   
    Examples: 
      | peripherique     | ordinateur   |
      | "Souris Clavier" | "Desktop HP" |
      | "Clavier Webcam" | "Laptop mac" |