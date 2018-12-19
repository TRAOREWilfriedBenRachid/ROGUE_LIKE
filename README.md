MANUEL TECHNIQUE :

	Objectif du jeu: 
		L'objectif du jeu est de retrouver le coupe pour gagner.
		Pour survivre aussi, il faut manger, combatre le monstre et contourner les murs.
		
		Pour gagner, le joueur doit ramasser le maximum d'Item, et avoir le score > 100
		
	Fonction principal:
		Creature: Cette classe implemente les differentes methodes applicables par une creature joueur comme les attaques, 
	le ramassage d'Item, deplacement.
	
	
MANUEL UTILISATEUR :
	
	Pour jouer à Rogue Like, le joueur doit tout d'abord lancer le jeu, 
	ensuite, il faut appuyer sur: g ou , pour ramasser
							    x pour examiner les items deja ramasser
							    D pour supprimer les items de l'inventaire
							    
							    e pour manger le pain ou la pomme ramassee
							    ; pour voir le resume de la partie
							    entrer si score >100 
							    
	l'items à ramasser: V (pour gagner)
	
	 

		
		
		
		
		
		
		
		Pour commencer le projet, il faut tout d'abord definir les différents environnements que l'on va utiliser,
	c'est pour cela que nous avons créer la Class : Tile "enum"
	
	Maintenant qu'il y a les environnements, il faut un monde pour les contenir, d'ou la classe : World
	Pour des changement de monde, il faut appeler la classe WorldBuilder contenant des méthodes qui crée des nouveaux mondes pour jouer
	