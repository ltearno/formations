# Formation Programmation Orientée Objet avec Java

Ceci est le cours...

Les projets sont dans le répertoire `projets`.

## Exercices

Mercredi 22 juin :

- implanter l'algorithme de tri naïf et l'algorithme de tri fusion sur un tableau d'entiers.

Voici un lien[https://www.infres.telecom-paristech.fr/people/charon/coursJava/exercices/chifoumi.html] vers différents exercices.

Je vous propose de les réaliser dans l'ordre suivant :

Jeudi 23 juin :

- calculer une factorielle
- palindromes
- jeu de Chifoumi

Vendredi 24 juin :

- Classe abstraite pour un animal
- Chaînage des constructeurs
- Polymorphisme

Puis cet exercice :

### Exercice - Jeu de Cartes, énoncé :

Vous vous intéressez dans cet exercice à décrire les données d'un jeu simulant des combats de magiciens.

Dans ce jeu, il existe trois types de cartes : les terrains, les créatures et les sortilèges.

- Les terrains possèdent une couleur (parmi 5 : `Blanc`, `Bleu`, `Noir`, `Rouge` et `Vert`. Pour ceci créez un enum `Couleur`).
- Les créatures possèdent un nom, un nombre de points de dégâts et un nombre de points de vie.
- Les sortilèges possèdent un nom et une explication sous forme de texte.

De plus, chaque carte, indépendamment de son type, possède un coût. Celui d'un terrain est 0.

Dans un nouveau projet nommé Magic, implémentez une hiérarchie de classes permettant de représenter des cartes de différents types.

Chaque classe aura un constructeur permettant de spécifier la/les valeurs de ses attributs.

Le programme doit utiliser la conception orientée objet et ne doit pas comporter de duplication de code.

Ajoutez ensuite aux cartes une méthode `afficher()` qui, pour toute carte, affiche son coût et la valeur de ses arguments spécifiques.

Créez de plus une classe `Jeu` pour représenter un jeu de cartes, c'est-à-dire une collection de telles cartes.

Cette classe devra avoir une méthode `piocher()` permettant d'ajouter une carte au jeu. On supposera qu'un jeu comporte au plus 10 cartes. Le jeu comportera également une méthode `joue()` permettant de jouer une carte. Pour simplifier, on jouera les cartes dans l'ordre où elles sont stockées dans le jeu, et on mettra la carte jouée à null dans le jeu de cartes.

Pour finir, dans la méthode `main(String[] args)`, constituez un jeu contenant divers types de cartes et faites afficher le jeu grâce à une méthode `afficher()` propre à cette classe.

Par exemple la méthode main pourrait ressembler à quelque chose comme cela  :

	class Magic {
		public static void main(String[] args) {
			Jeu maMain = new Jeu(10);
	 
			maMain.piocher(new Terrain(Couleur.Bleu));
			maMain.piocher(new Creature(6, "Golem", 4, 6));
			maMain.piocher(new Sortilege(1, "Croissance Gigantesque", 
					"La créature ciblée gagne +3/+3 jusqu'à la fin du tour"));
	 
			System.out.println("Là, j'ai en stock :");
			maMain.afficher();
			maMain.joue();
		}
	}

qui produirait quelque chose comme :

	Là, j'ai en stock :
	Un terrain bleu
	Une créature Golem 4/6
	Un sortilège Croissance Gigantesque
	Je joue une carte...
	La carte jouée est :
	Un terrain bleu