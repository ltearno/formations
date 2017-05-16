package fr.lteconsulting;

public class TestEtudiant
{
	public static void main( String[] args )
	{
		Exercice exo1 = new Exercice( "Les Listes", "..." );
		Exercice exo2 = new Exercice( "Les Maps", "..." );
		Exercice exo3 = new Exercice( "Types Primitifs", "..." );
		Exercice exo4 = new Exercice( "Interfaces", "..." );
		Exercice exo5 = new Exercice( "Héritage", "..." );

		Etudiant e1 = new Etudiant( "Toto" );
		Etudiant e2 = new Etudiant( "Titi" );

		e1.ajouterNote( exo2, 12 );
		e1.ajouterNote( exo3, 16 );
		e1.ajouterNote( exo5, 2 );

		e2.ajouterNote( exo1, 18 );
		e2.ajouterNote( exo3, 13 );
		e2.ajouterNote( exo4, 19 );
		e2.ajouterNote( exo5, 20 );

		e1.afficherNotes();
		e1.afficherNotesTriees1();
		e1.afficherNotesTriees2();

		e2.afficherNotes();
		e2.afficherNotesTriees1();
		e2.afficherNotesTriees2();
	}
}
