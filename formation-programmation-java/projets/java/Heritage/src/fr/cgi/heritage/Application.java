package fr.cgi.heritage;

public class Application
{
	public static void main( String[] args )
	{
		Oiseau oiseau = new Oiseau( "Titi" );
		oiseau.presenteToi();
		oiseau.chante();
		// oiseau.faitLaRoue();

		Paon paon = new Paon( 9 );
		paon.presenteToi();
		paon.chante();
		paon.faitLaRoue();

		Kiwi kiwi = new Kiwi();
		kiwi.presenteToi();
		kiwi.chante();

		Rossignol rossignol = new Rossignol();
		rossignol.presenteToi();
		rossignol.chante();

		Perroquet perroquet = new Perroquet( "Jaco", "mille sabords" );
		perroquet.presenteToi();
		perroquet.chante();
	}
}
