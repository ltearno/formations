package fr.lteconsulting;

/**
 * Votre classe du Jeu De La Vie doit implémenter cette interface
 * afin que la classe {@link BoardDisplay} puisse faire l'affichage
 */
public interface IConway
{
	/**
	 * Largeur du damier
	 */
	int getWidth();

	/**
	 * Hauteur du damier
	 */
	int getHeight();

	/**
	 * Renvoie {@code true} si la cellule à la coordonnée {@code (x, y)} est vivante,
	 * {@code false} sinon.
	 */
	boolean getCell( int x, int y );

	/**
	 * Fait évoluer le damier selon les règles du jeu de Conway
	 */
	void evolve();

	void makeCellAlive( int cellX, int cellY );
}
