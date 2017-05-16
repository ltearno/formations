package fr.lteconsulting;

public class EmployeTempsPartiel extends Employe
{
	public EmployeTempsPartiel( String nom )
	{
		super( nom );
	}

	@Override
	public double getSalaire( float nbHeuresTravaillees )
	{
		if( nbHeuresTravaillees < 40 )
		{
			return super.getSalaire( nbHeuresTravaillees );
		}
		else
		{
			return super.getSalaire( nbHeuresTravaillees ) + 0.8 * (nbHeuresTravaillees - 40);
		}
	}

	@Override
	public String getCategorie()
	{
		return "PARTIEL";
	}
}
