package fr.lteconsulting.commande.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import fr.lteconsulting.commande.Commande;
import fr.lteconsulting.commande.ContexteExecution;
import fr.lteconsulting.modele.Disque;

public class AffichageDisquesParCodeBarre implements Commande
{
	@Override
	public String getNom()
	{
		return "Affichage des disques par code barre";
	}

	@Override
	public void executer(ContexteExecution contexte)
	{
		List<Disque> disques = new ArrayList<>( contexte.getBibliotheque().getDisques() );

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
