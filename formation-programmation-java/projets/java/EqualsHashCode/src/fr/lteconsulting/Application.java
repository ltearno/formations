package fr.lteconsulting;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Set;

public class Application
{
	public static void main( String[] args )
	{
		Set<Personne> e = new HashSet<>();
		Personne p1 = new Personne( "Jean", 1244 );
		e.add( p1 );
		e.add( new Personne( "JeanMi", 1244 ) );
		e.add( new Personne( "Jean", 1246 ) );
		e.add( new Personne( "Pierre", 1244 ) );

		System.out.println( e.contains( new Personne( "Jean", 1244 ) ) );
		System.out.println( e.contains( p1 ) );

		System.out.println( "Taille E : " + e.size() );
		System.out.println( e );

		Class<?> c = p1.getClass();
		System.out.println( "La classe de l'objet p1 s'appelle " + c.getName() );

		Field[] fields = c.getDeclaredFields();
		for( Field field : fields )
		{
			System.out.println( " - champ " + field.getName() + " est de type " + field.getType().getName() );
		}

	}
}
