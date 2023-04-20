# Main.java
Projet Java MOLINA Lea

Des fichiers.txt sont mis à disposition pour tester le programme.

Le programme a été voulu le plus interactif possible. 
Ainsi, lors de l’exécution du code, une suite de questions vous seront posées afin de décider de l’application des méthodes. 
Les questions sont guidées.

La première de ces questions permet de déterminer si vous souhaitez le vérifier polymorphisme des méthodes : si oui, entrez 1 sur la console, sinon entrez 0.

L’étape prochaine consiste à initialiser une population de deux utilisateurs.
Deux possibilités sont proposées pour initialiser chacun des utilisateurs de la population : l’initialisation à partir d’un fichier texte ou l’initialisation manuelle (en répondant à une série de questions).
Si vous souhaitez initialiser l’utilisateur à partir d’un fichier texte :
- Tapez 0 sur la console ;
- Entrez le nom du fichier ; (parmi une liste de 10 exemples inclus dans le dossier) Si vous souhaitez initialiser un utilisateur manuellement : Tapez 1 sur la console.
Vous commencerez par initialiser le poste de consommation Alimentation :
- Entrez le taux moyen de consommation de boeuf par repas (un nombre compris entre 0 et 1)
- Entrez le taux moyen de consommation de légumes par repas (un nombre compris entre 0 et 1)

Il vous sera ensuite demandé d’initialiser la catégorie BienConso :
- Entrez le montant de vos dépenses annuelles 

Puis d’initialiser la catégorie Logements :
- Entrez le nombre de logements que vous possédez ;
- Entrez la superficie de chaque logement. 

Ensuite initialiser la catégorie Voitures :
- Entrez le nombre i de voitures que vous possédez ;
- Entrez le nombre de kilomètres parcourus en moyenne en un an avec la voiture numéro i
- Entrez l'amortissement de la voiture numéro i (sa durée de conservation en année)
  
Initialisez la catégorie Avion :
- Entrez le nombre i de trajets en avion que vous souhaitez ajouter (sachant qu’un aller correspond à un trajet);
- Entrez le nombre de kilomètres parcourus durant ce trajet ;

Initialisez la catégorie Bus :
- Entrez le nombre de kilomètres parcourus par an en bus ;
- Entrez la catégorie du bus (électrique ou à moteur)

Et pour finir vous devrez initialiser la catégorie TGV :
- Entrez le nombre i de trajets en TGV que vous souhaitez ajouter (sachant qu’un aller correspond à un trajet) ;
- Entrez le nombre de kilomètres parcourus pour le trajet numéro i ;


Après l’initialisation du premier utilisateur :
- Tapez 1 si vous souhaitez connaitre votre impact de consommation carbone sinon tapez 0 ;
- Tapez 1 si vous souhaitez avoir des conseils pour réduire votre consommation carbone sinon tapez 0 ; les recommandations ne s’affichent que si l’impact est supérieur à la moyenne d’un
français pour le poste de consommation concerné.
Il vous sera ensuite demandé d’initialiser le second utilisateur (de la même manière que pour le premier utilisateur)
Après l’initialisation des deux utilisateurs composant la population :
- Vous pouvez choisir ou non d’appliquer l’Article 125 : Si oui, tapez 1, sinon 0 ;
