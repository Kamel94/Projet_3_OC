# Projet_3_OC
Projet 3 OPENCLASSROOMS - Escape Game Online

## Présentation de l’application

Je vous présente une application qui permet de jouer à 3 modes de jeu : 

- Challenger :  L’IA génère une combinaison et vous devez trouver la bonne combinaison en un nombre d’essai définit. L’IA indique pour chaque chiffre de la combinaison proposée si le chiffre de sa combinaison est plus grand (+), plus petit (-) ou si c’est le bon (=).

- Défenseur : Vous choisissez une combinaison et l’ordinateur doit trouver la bonne combinaison en un nombre d’essai définit. Le joueur indique pour chaque chiffre de la combinaison proposée si le chiffre de sa combinaison est plus grand (+), plus petit (-) ou si c’est le bon (=). L’IA fait une autre proposition en se basant sur la réponse fournit par le joueur.

- Duel : Vous et l’IA jouerez à tour de rôle, le premier qui trouvera la combinaison de l'autre aura gagné.

Il y a également un mode développeur pour tester le bon fonctionnement de l'application.


## Récupération du code 

Afin de récupérer le code du projet, il vous suffit de télécharger le repository en cliquant  sur ce lien https://github.com/Kamel94/Projet_3_OC ensuite sur "clone or download", ensuite téléchargez l'ensemble au format ZIP (download Zip) et décompressez le dossier sur votre machine.


## Compilation de l’application

IMPORTANT : java version 8 et Maven 3

Pour compiler l’application il suffit d’ouvrir le terminal, de se placer dans le dossier qui contient le code de l’application que vous venez de télécharger et tapez cette commande :  mvn clean compile

## Exécution de l’application

Pour l’exécuter tapez cette commande : mvn exec:java -Dexec.mainClass=fr.main.Main

## Fonctionnement de l’application 

L'application fonctionne ainsi :

Un menu s'affiche pour proposer à l'utilisateur de choisir le mode de jeu :

- Challenger
- Défenseur
- Duel

A la fin du programme, l'utilisateur peut choisir de :

- Rejouer au même mode
- Joueur à un autre mode
- Quitter l’application

Si l'utilisateur perd, l'application affiche la combinaison de l’IA (pour les modes Challenger et Duel). 

Le mode développeur (permettant de voir la combinaison de l’IA), le nombre d'essais et le nombre de chiffres à découvrir sont définis et modifiables dans le fichier config.properties du sous-dossier resources ( voici le chemin exact : src/main/resources ).