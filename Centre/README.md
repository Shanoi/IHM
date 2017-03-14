## Notes présentation

##### Par rapport à un MVC "classique"
   * Trop d'intelligence dans les controlleurs, handicap si on multiplie les vues. Risque de duplication de code

##### Force de l'implem
* Le singleton facilement évoluable vers une BD
* Grande utilisation de l'héritage 

##### Faiblesse
* Intelligence dans les controlleurs
* Répétition des évenement. Un include pour le header de info et magasin ?
* La detection de la taille des images dans le showcase
    
##### Idées d'améliorations

* Localiser un magasin choisi dans l'index:
    * Faire des numéros d'emplacement
    * Faire saisir le numéro de l'emplacement lors de l'ajout d'un magasins
* Insérer le logo du magasin sur la carte automatiquement
* Voir pour mettre en plein ecran
* un bouton pour pouvoir choisir son style
* Traduire le texte saisi par l'administrateur:
    * Modifier directement les properties
    * Lui faire saisir un id



## TODO

* Admin
    * S'occuper de l'exception dans AddStore#sumbit
* Index
    * Clé qui disparait en big
* Info
* Divers
    * S'occuper des exceptions
    
