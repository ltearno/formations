package fr.cgi.heritage;

public class Perroquet extends Oiseau
{
	private String modele;
	
	public Perroquet( String nom, String modele )
	{
		super( nom );
		
		this.modele = modele;
	}

	@Override
	public void chante()
	{
		super.chante();
		System.out.println( modele );
	}
}
