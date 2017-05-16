package fr.lteconsulting.gravite;

public class Particule
{
	private float x;
	private float y;
	private float m;

	public Particule( float x, float y, float m )
	{
		this.x = x;
		this.y = y;
		this.m = m;
	}

	public float getX()
	{
		return x;
	}

	public void setX( float x )
	{
		this.x = x;
	}

	public float getY()
	{
		return y;
	}

	public void setY( float y )
	{
		this.y = y;
	}

	public float getM()
	{
		return m;
	}

	public void setM( float m )
	{
		this.m = m;
	}
}
