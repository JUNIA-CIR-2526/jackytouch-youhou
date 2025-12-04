[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-22041afd0340ce965d47ae6ef1cefeee28c7c493a6346c4f15d667ab976d596c.svg)](https://classroom.github.com/a/05JHkCLS)
# JackyTouch

![alt text](ressources/jackytouch.jpg)

# Made with ❤️ by [JAD](mailto:jeanaymeric@gmail.com)

## Sujet

Vous devez réaliser une application console qui affiche une voiture vue de dessus en ASCII art et permet d’ajouter des
éléments de tuning à partir de calques fournis (.txt).  
Chaque élément de tuning possède un réglage mécanique qui peut varier.  
L’application doit composer visuellement les calques et afficher les effets mécaniques choisis dans une fenêtre
TextWindow.

---

## Ressources fournies

- **Voiture de base** : fichier `car_base.txt` (ASCII art, vue de dessus).
- **Tuning ASCII** : fichiers `.txt` à superposer, alignés sur la même grille :
    - Spoiler : `spoiler.txt`
    - Neon : `neon.txt`
    - Jantes : `rims.txt`
    - Pot d’échappement : `exhaust.txt`
- **Règle de transparence** :
    - `.` = transparent
    - tout autre caractère remplace le caractère dessous.

*Pour le moment, tous les fichiers `.txt` sont dans un répertoire `ressources` à la racine. Bien entendu, vous allez
devoir
le déplacer dans votre module model de maven.*

---

## Contraintes

- **Instance unique** : l’instance de la voiture de base ne doit jamais être remplacée.
- **Superposition des calques** : les fichiers `.txt` se superposent sur une même grille.
- **Réglages mécaniques** : chaque tuning doit avoir un réglage mécanique sélectionnable et modifiable pendant
  l’exécution.
- **Extensibilité** : possibilité d’ajouter un nouveau tuning ASCII et de nouveaux réglages sans modifier les fichiers
  existants.
- **Affichage console uniquement** : pas d’interface graphique, pas de bibliothèques externes.
- **Modèle MVC** : séparation claire entre la logique métier, la gestion des données et l’affichage. Donc 5 modules
  maven minimum :
    - main : point d’entrée
    - model : gestion des données (voiture, tuning, réglages), fichiers ASCII
    - view : pilotage de l'objet TextWindow
    - controller : gestion de la logique métier (application des tuning, réglages)
    - share : classes utilitaires partagées, interfaces communes.

---

## Fonctionnalités attendues

- **Affichage** :
    - Base : afficher la voiture issue de `car_base.txt`.
    - Tuning : afficher la voiture avec un ou plusieurs calques superposés.
- **Gestion des réglages mécaniques** :
    - Sélection : choisir un réglage mécanique pour chaque tuning.
    - Interchangeabilité : pouvoir changer un réglage mécanique sans recréer la voiture.
- **Journal d’exécution** :
    - Liste des tunings appliqués.
    - Effets mécaniques : afficher pour chaque tuning son réglage actif et l’effet associé.

---

## Spécifications des réglages mécaniques imposés

- **Spoiler** :
    - Esthétique : aucun effet mécanique.
    - Aérodynamique : stabilité accrue.
    - Exagéré : vitesse max réduite, effet visuel accentué.
- **Néons** :
    - Sobre : lumière fixe.
    - Disco : clignotement simulé.
    - Aléatoire : affichage imprévisible.
- **Jantes** :
    - Performance : accélération améliorée.
    - Low-cost : aucun effet.
    - Show-off : bruit distinctif.
- **Pot d’échappement** :
    - Silencieux : bruit discret.
    - Sport : bruit puissant.
    - Drag : bruit extrême.

---

## Règles de composition ASCII

- **Grille partagée** : tous les fichiers utilisent la même largeur/hauteur.
- **Transparence** :
    - Espace : transparent.
    - Autres caractères : écrasent le caractère sous-jacent.
- **Fusion** : composer du bas vers le haut ; le premier caractère non-espace rencontré est affiché.

---

## Livrables

- **Code source** : Dépot GitHub classroom.

---

## Évaluation

- Respect des contraintes : instance unique, superposition conforme.
- Fonctionnalité : activation/désactivation tuning, réglages mécaniques.
- Robustesse : gestion des fichiers manquants, cohérence des messages.
- Extensibilité : ajout d’un tuning sans modification des fichiers existants.
- Lisibilité : code clair, séparation des responsabilités, messages compréhensibles.

## Exemple d'affichage

Voici une voiture avec un spoiler aérodynamique, des néons disco, des jantes performance et un pot d'échappement sport :

```
╺╲╲▀══╤▀╤══╮
 │║║  │ │  │
╺╱╱▄══╧▄╧══╯

> stabilité accrue
> clignotement simulé
> accélération améliorée
> bruit puissant

| Aérodynamique Spoiler
| Néons Disco Clignotants
| Jantes Performance
| Pot d'Échappement Sport
```

Il est possible de changer les réglages mécaniques à tout moment.  
Il est également possible d'ajouter de nouveaux éléments de tuning.
