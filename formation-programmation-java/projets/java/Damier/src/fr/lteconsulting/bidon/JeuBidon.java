package fr.lteconsulting.bidon;

import fr.lteconsulting.Coordonnee;
import fr.lteconsulting.Plateau;
import fr.lteconsulting.Saisie;

public class JeuBidon
{
	private Plateau<Dame> plateau;

	public JeuBidon()
	{
		plateau = new Plateau<>( 13, 5 );
	}

	public void jouer()
	{
		while( true )
		{
			String reponseAjoutPiece = Saisie.saisie( "Voulez-vous ajouter une pièce ? (oui/non)" );

			if( "oui".equalsIgnoreCase( reponseAjoutPiece ) )
			{
				Coordonnee coordonnee = Saisie.saisieCoordonnee( "A quelle coordonnée ? (abscisse;ordonnee)" );
				
				CouleurNB couleur = Saisie.saisieCouleurNB( "De quelle couleur ?" );
				
				plateau.placer( new Dame( couleur ), coordonnee );
				
				plateau.afficher();
			}
			else
			{
				System.out.println( "Bravo tu as bien joué, à bientôt..." );
				return;
			}
		}
	}
}
