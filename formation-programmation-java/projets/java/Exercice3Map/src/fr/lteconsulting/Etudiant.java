package fr.lteconsulting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Etudiant
{
	private String nom;
	private Map<Exercice, Integer> notes;

	public Etudiant( String nom )
	{
		this.nom = nom;
		this.notes = new HashMap<>();
	}

	public void ajouterNote( Exercice exercice, int note )
	{
		notes.put( exercice, note );
	}

	public void afficherNotes()
	{
		System.out.println( "PAS DE TRI - ETUDIANT " + nom );
		for( Entry<Exercice, Integer> entry : notes.entrySet() )
		{
			Exercice exercice = entry.getKey();
			Integer note = entry.getValue();

			System.out.println( " - Exercice " + exercice.getIntitule() + " NOTE : " + note );
		}
	}

	public void afficherNotesTriees1()
	{
		System.out.println( "TRI1 - ETUDIANT " + nom );

		List<Entry<Exercice, Integer>> entrees = new ArrayList<>();
		entrees.addAll( notes.entrySet() );

		Collections.sort( entrees, new Comparator<Entry<Exercice, Integer>>()
		{
			@Override
			public int compare( Entry<Exercice, Integer> o1, Entry<Exercice, Integer> o2 )
			{
				// return o1.getKey().getIntitule().compareTo( o2.getKey().getIntitule() );
				return - o1.getValue().compareTo( o2.getValue() );
			}
		} );

		for( Entry<Exercice, Integer> entry : entrees )
		{
			Exercice exercice = entry.getKey();
			Integer note = entry.getValue();

			System.out.println( " - Exercice " + exercice.getIntitule() + " NOTE : " + note );
		}
	}

	public void afficherNotesTriees2()
	{
		System.out.println( "TRI2 - ETUDIANT " + nom );

		Set<Exercice> ensembleExercices = notes.keySet();
		List<Exercice> listeExercices = new ArrayList<>( ensembleExercices );
		Collections.sort( listeExercices, new Comparator<Exercice>()
		{
			@Override
			public int compare( Exercice o1, Exercice o2 )
			{
				return o1.getIntitule().compareTo( o2.getIntitule() );
			}
		} );

		for( Exercice exercice : listeExercices )
		{
			Integer note = notes.get( exercice );

			System.out.println( " - Exercice " + exercice.getIntitule() + " NOTE : " + note );
		}
	}

	public String getNom()
	{
		return nom;
	}
}
