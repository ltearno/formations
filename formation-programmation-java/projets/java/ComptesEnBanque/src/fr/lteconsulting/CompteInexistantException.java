package fr.lteconsulting;

@SuppressWarnings( "serial" )
public class CompteInexistantException extends Exception
{
	private String ibanDemande;

	public CompteInexistantException( String message, String ibanDemande )
	{
		super( message );
		
		this.ibanDemande = ibanDemande;
	}

	public String getIbanDemande()
	{
		return ibanDemande;
	}
}
