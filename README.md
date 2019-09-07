# Projet_3_OC
Projet 3 OPENCLASSROOMS - Escape Game Online

Présentation du projet

Je vous présente une application qui permet de jouer à 3 modes de jeu : 

- Challenger :  L’IA génère une combinaison et vous devez trouver la bonne combinaison en un nombre d’essai définit. L’IA indique pour chaque chiffre de la combinaison proposée si le chiffre de sa combinaison est plus grand (+), plus petit (-) ou si c’est le bon (=).

- Défenseur : Vous choisissez une combinaison et l’ordinateur doit trouver la bonne combinaison en un nombre d’essai définit. Le joueur indique pour chaque chiffre de la combinaison proposée si le chiffre de sa combinaison est plus grand (+), plus petit (-) ou si c’est le bon (=). L’IA fait une autre proposition en se basant sur la réponse fournit par le joueur.

- Duel : Vous et l’IA jouerez à tour de rôle, le premier qui trouvera la combinaison de l'autre aura gagné.

Il y a également un mode développeur pour tester le bon fonctionnement de l'application.

Fonctionnement de l’application

L'application fonctionne ainsi :

Un menu s'affiche pour proposer à l'utilisateur de choisir le mode de jeu (Challenger, Défenseur ou Duel).
A la fin du programme, l'utilisateur peut choisir de :

- Rejouer au même mode
- Joueur à un autre mode
- Quitter l’application

Si l'utilisateur perd, l'application affiche la combinaison de l’IA (pour les modes Challenger et Duel). 

Le mode développeur (permettant de voir la combinaison de l’IA), le nombre d'essai et le nombre de chiffre à découvrir sont définis et modifiables dans le fichier Config.properties du sous-dossier resources. 

Lancement du programme

Afin de récupérer le code du projet, il vous suffit de télécharger le repository en cliquant  sur ce lien https://github.com/Kamel94/Projet_3_OC ensuite sur "clone or download", ensuite téléchargez l'ensemble au format ZIP (download Zip) et décompressez le dossier sur votre machine.

Ouvrez votre IDE Java (Eclipse par exemple) et importez le projet "Projet_3_OC". Positionnez-vous sur la classe Main qui contient la méthode main (point d'entrée du programme) : vous pouvez désormais lancer l'application et vous amuser avec les 3 modes de jeu !