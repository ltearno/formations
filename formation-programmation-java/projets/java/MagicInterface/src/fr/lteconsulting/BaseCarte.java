package fr.lteconsulting;

public abstract class BaseCarte
{
	private int cout;

	protected BaseCarte( int cout )
	{
		this.cout = cout;
	}

	protected int getCout()
	{
		return cout;
	}
}
