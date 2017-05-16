package fr.lteconsulting;

import java.awt.Color;
import java.awt.Graphics;

public class GravitationDisplay extends Display
{
	int bleu = 0;

	@Override
	protected void onPaint( Graphics g )
	{
		// On doit dessiner dans la fenêtre

		int largeurFenetre = getWidth();

		for( int i = 0; i < 255; i++ )
		{
			for( int j = 0; j < 255; j++ )
			{
				g.setColor( new Color( bleu, bleu, bleu ) );
				g.fillRect( i, j, 1, 1 );
			}
		}
	}

	@Override
	protected void onUpdate()
	{
	}

	@Override
	protected void onMouseClicked( int x, int y )
	{
		bleu = x % 255;
	}
}
