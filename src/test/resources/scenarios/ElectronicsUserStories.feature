#Author: Samia et Yassine

@tag1
Feature: Suivi du materiels
  En tant que responsable du materiels
  Je veux enregistrer tous les ordinateurs et leurs peripheriques attaches et les peripheriques en stock
  Afin d'avoir un suivi sur l'ensemble du materiels informatiques et faciliter l'inventaire annuelle
  
  Scenario Outline: Affecter un peripherique a un ordinateur
    Given un collaborateur a demande un nouveau <peripherique>
    When le collaborateur le recoit
    Then le peripherique est affecter a son <ordinateur>
   
    Examples: 
      | peripherique  | ordinateur |
      | Souris        | Desktop HP |
      | Clavier       | Laptop mac |

    Scenario Outline: Consulter l'ensemble des peripheriques d'un ordinateur
    Given le responsable veut faire l'inventaire 
    When le responsable exporte l'etat de suivi du materiel
    Then chaque <ordinateur> est affiche avec ses peripheriques
   
    Examples: 
      | ordinateur |
      | Desktop HP |
      | Laptop mac |
      