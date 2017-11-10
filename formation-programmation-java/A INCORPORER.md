## Exercices

Mercredi 22 juin :

- implanter l'algorithme de tri na�f et l'algorithme de tri fusion sur un tableau d'entiers.

Voici un lien[https://www.infres.telecom-paristech.fr/people/charon/coursJava/exercices/chifoumi.html] vers diff�rents exercices.

Je vous propose de les r�aliser dans l'ordre suivant :

Jeudi 23 juin :

- calculer une factorielle
- palindromes
- jeu de Chifoumi

Vendredi 24 juin :

- Classe abstraite pour un animal
- Cha�nage des constructeurs
- Polymorphisme

Puis cet exercice :

### Exercice - Jeu de Cartes, �nonc� :

Vous vous int�ressez dans cet exercice � d�crire les donn�es d'un jeu simulant des combats de magiciens.

Dans ce jeu, il existe trois types de cartes : les terrains, les cr�atures et les sortil�ges.

- Les terrains poss�dent une couleur (parmi 5 : `Blanc`, `Bleu`, `Noir`, `Rouge` et `Vert`. Pour ceci cr�ez un enum `Couleur`).
- Les cr�atures poss�dent un nom, un nombre de points de d�g�ts et un nombre de points de vie.
- Les sortil�ges poss�dent un nom et une explication sous forme de texte.

De plus, chaque carte, ind�pendamment de son type, poss�de un co�t. Celui d'un terrain est 0.

Dans un nouveau projet nomm� Magic, impl�mentez une hi�rarchie de classes permettant de repr�senter des cartes de diff�rents types.

Chaque classe aura un constructeur permettant de sp�cifier la/les valeurs de ses attributs.

Le programme doit utiliser la conception orient�e objet et ne doit pas comporter de duplication de code.

Ajoutez ensuite aux cartes une m�thode `afficher()` qui, pour toute carte, affiche son co�t et la valeur de ses arguments sp�cifiques.

Cr�ez de plus une classe `Jeu` pour repr�senter un jeu de cartes, c'est-�-dire une collection de telles cartes.

Cette classe devra avoir une m�thode `piocher()` permettant d'ajouter une carte au jeu. On supposera qu'un jeu comporte au plus 10 cartes. Le jeu comportera �galement une m�thode `joue()` permettant de jouer une carte. Pour simplifier, on jouera les cartes dans l'ordre o� elles sont stock�es dans le jeu, et on mettra la carte jou�e � null dans le jeu de cartes.

Pour finir, dans la m�thode `main(String[] args)`, constituez un jeu contenant divers types de cartes et faites afficher le jeu gr�ce � une m�thode `afficher()` propre � cette classe.

Par exemple la m�thode main pourrait ressembler � quelque chose comme cela  :

	class Magic {
		public static void main(String[] args) {
			Jeu maMain = new Jeu(10);
	 
			maMain.piocher(new Terrain(Couleur.Bleu));
			maMain.piocher(new Creature(6, "Golem", 4, 6));
			maMain.piocher(new Sortilege(1, "Croissance Gigantesque", 
					"La cr�ature cibl�e gagne +3/+3 jusqu'� la fin du tour"));
	 
			System.out.println("L�, j'ai en stock :");
			maMain.afficher();
			maMain.joue();
		}
	}

qui produirait quelque chose comme :

	L�, j'ai en stock :
	Un terrain bleu
	Une cr�ature Golem 4/6
	Un sortil�ge Croissance Gigantesque
	Je joue une carte...
	La carte jou�e est :
	Un terrain bleu