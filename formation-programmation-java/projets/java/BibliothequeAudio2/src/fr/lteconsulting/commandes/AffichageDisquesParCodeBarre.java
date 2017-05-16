package fr.lteconsulting.commandes;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import fr.lteconsulting.Commande;
import fr.lteconsulting.modele.Bibliotheque;
import fr.lteconsulting.modele.Disque;

public class AffichageDisquesParCodeBarre implements Commande
{
	private Bibliotheque bibliotheque;

	public AffichageDisquesParCodeBarre( Bibliotheque bibliotheque )
	{
		this.bibliotheque = bibliotheque;
	}

	@Override
	public String getNom()
	{
		return "Affichage des disques par code barre";
	}

	@Override
	public void executer()
	{
		List<Disque> disques = bibliotheque.getDisques();

		// trier par codeBarre, le comparateur est une classe anonyme
		Collections.sort( disques, new Comparator<Disque>()
		{
			@Override
			public int compare( Disque o1, Disque o2 )
			{
				return o1.getCodeBarre().compareTo( o1.getCodeBarre() );
			}
		} );

		for( Disque disque : disques )
			disque.afficher( false );
	}
}
