package fr.lteconsulting.ws;

import javax.ejb.EJB;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import fr.lteconsulting.DonneesScope;
import fr.lteconsulting.Joueur;
import fr.lteconsulting.Partie;
import fr.lteconsulting.Piece;
import fr.lteconsulting.dao.PartieDao;
import fr.lteconsulting.dto.Coup;
import fr.lteconsulting.dto.PartieDto;

@Path( "parties" )
public class PartieWebService
{
	@EJB
	PartieDao partieDao;
	
	@POST
	@Path( "{id}" )
	@Consumes( MediaType.APPLICATION_JSON )
	public void jouerCoup( Coup coup, @PathParam( "id" ) String id, @Context HttpServletRequest request )
	{
		// récupère la partie
		Partie partie = partieDao.getPartie( id );
		if( partie == null )
			return;

		// récupère le joueur connecté.
		Joueur joueurConnecte = DonneesScope.getJoueurSession( request );
		if( joueurConnecte == null )
			return;

		int x = coup.getX();
		int y = coup.getY();

		// placer une pièce correspondant au joueur dans la partie
		partie.getPlateau().placerPiece( new Piece( joueurConnecte.getCharacter() ), x, y );

		// persister le changement en base de données
		partieDao.updatePartie( partie );
	}

	@GET
	@Produces( MediaType.APPLICATION_JSON )
	@Path( "{id}" )
	public PartieDto getPartie( @PathParam( "id" ) String id, @Context HttpServletRequest request )
	{
		// récupère la partie
		Partie partie = partieDao.getPartie( id );
		if( partie == null )
			return null;

		// récupère le joueur connecté.
		Joueur joueurConnecte = DonneesScope.getJoueurSession( request );
		if( joueurConnecte == null )
			return null;

		// crée un DTO représentant la partie
		PartieDto partieDto = new PartieDto( partie.getPlateau().getLargeur(), partie.getPlateau().getHauteur() );

		// remplir les pieces dans le DTO
		for( int i = 0; i < partie.getPlateau().getLargeur(); i++ )
		{
			for( int j = 0; j < partie.getPlateau().getHauteur(); j++ )
			{
				Piece piece = partie.getPlateau().getPiece( i, j );
				if( piece != null )
					partieDto.setPiece( i, j, piece.getDisplayChar() );
			}
		}

		// positionne dans le DTO le tour de jeu
		partieDto.setTour( joueurConnecte.getId() == partie.getJoueurCourant().getId() );

		// retourne l'objet DTO qui sera transformé en JSON par la couche JAX-RS
		return partieDto;
	}
}
