package fr.lteconsulting;

public class Magic
{
	public static void main( String[] args )
	{
		Jeu maMain = new Jeu( 10 );

		maMain.piocher( new Terrain( Couleur.Bleu ) );
		maMain.piocher( new Creature( 6, "Golem", 4, 6 ) );
		maMain.piocher( new Sortilege( 1, "Croissance Gigantesque", "La créature ciblée gagne +3/+3 jusqu'à la fin du tour" ) );

		System.out.println( "Là, j'ai en stock :" );
		maMain.afficher();
		maMain.joue();
	}
}
