package fr.lteconsulting.gravite;

import java.awt.Color;
import java.awt.Graphics;
import java.util.List;

import fr.lteconsulting.Display;

@SuppressWarnings( "serial" )
public class GraviteDisplay extends Display
{
	private final static float G = 9.81f;

	private List<Particule> particules;

	public void setParticules( List<Particule> particules )
	{
		this.particules = particules;
	}

	@Override
	protected void onPaint( Graphics g )
	{
		int cx = getWidth() / 2;
		int cy = getHeight() / 2;
		double rayon = 200;
		double rayon2 = 50;

		g.setColor( new Color( 255, 255, 255 ) );

		int ox = 0;
		int oy = 0;

		for( double angle = 0; angle < Math.PI * 2; angle += 0.01 )
		{
			int px = (int) (cx + Math.cos( angle ) * rayon);
			int py = (int) (cy + Math.sin( angle ) * rayon);

			px = (int) (px + Math.cos( angle * 4.5 ) * rayon2);
			py = (int) (py + Math.sin( angle * 4.5 ) * rayon2);

			g.drawLine( ox, oy, px, py );

			ox = px;
			oy = py;
		}
	}

	@Override
	protected void onUpdate()
	{
	}

	@Override
	protected void onMouseClicked( int x, int y )
	{
		float realX = (float) x / getWidth();
		float realY = (float) y / getHeight();

		particules.get( 0 ).setX( realX );
		particules.get( 1 ).setY( realY );
	}
}
