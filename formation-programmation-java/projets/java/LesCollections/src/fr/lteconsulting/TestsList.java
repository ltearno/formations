package fr.lteconsulting;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class TestsList
{
	public static void main( String[] args )
	{
		Map<String, Personne> repertoire = new HashMap<>();

		Personne p1 = new Personne( "Mr Toto", 1 );
		Personne p2 = new Personne( "Mme Titi", 2 );
		Personne p3 = new Personne( "Mme Tata", 3 );

		repertoire.put( "Mr T", p1 );
		repertoire.put( "Mrs Orange", p2 );
		repertoire.put( "X", p3 );
		repertoire.put( "Bonhomme", p1 );

		Personne p = repertoire.get( "Mrs Orange" );
		System.out.println( "Mrs Orange est en fait : " + p );

		p = repertoire.get( "Monsieur Y" );
		System.out.println( "Monsieur Y est en fait : " + p );

		repertoire.remove( "X" );

		System.out.println( "\nParcours conjoint des clés et valeurs" );
		for( Entry<String, Personne> entry : repertoire.entrySet() )
		{
			String surnom = entry.getKey();
			Personne personne = entry.getValue();

			System.out.println( personne + " a pour surnom " + surnom );
		}

		System.out.println( "\nParcours des clés" );
		for( String cle : repertoire.keySet() )
			System.out.println( "Je connais qqun surnommé " + cle );

		System.out.println( "\nParcours des valeurs" );
		for( Personne personne : repertoire.values() )
			System.out.println( "- " + personne );
	}
}
