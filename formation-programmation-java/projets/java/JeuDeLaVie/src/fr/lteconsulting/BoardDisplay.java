package fr.lteconsulting;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 * Classe permettant d'afficher le jeu de la vie en mode graphique.
 * 
 * Pour l'utiliser, il suffit d'appeler la méthode {@code BoardDisplay.displayBoard( conway )}
 * en passant une instance de l'interface {@code IConway}.
 *
 */
public class BoardDisplay extends JPanel
{
	private static final long serialVersionUID = 7195359356261678183L;

	private IConway conway;

	private Timer timer = new Timer( 1000 / 25, ( e ) -> {
		conway.evolve();
		repaint();
	} );

	public static void displayBoard( IConway conway )
	{
		JFrame frame = new JFrame( "Conway game" );
		frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		frame.add( new BoardDisplay( conway ) );
		frame.pack();
		frame.setVisible( true );
	}

	private BoardDisplay( IConway conway )
	{
		this.conway = conway;

		setBackground( Color.BLACK );
		setPreferredSize( new Dimension( conway.getWidth(), conway.getHeight() ) );
		setDoubleBuffered( true );

		timer.start();

		addMouseMotionListener( new MouseAdapter()
		{
			@Override
			public void mouseDragged( MouseEvent e )
			{
				int cellX = (conway.getWidth() * e.getX()) / getWidth();
				int cellY = (conway.getHeight() * e.getY()) / getHeight();

				conway.makeCellAlive( cellX, cellY );
			}
		} );

		addMouseListener( new MouseAdapter()
		{
			@Override
			public void mousePressed( MouseEvent e )
			{
				int cellX = (conway.getWidth() * e.getX()) / getWidth();
				int cellY = (conway.getHeight() * e.getY()) / getHeight();

				conway.makeCellAlive( cellX, cellY );
			}
		} );
	}

	@Override
	protected void paintComponent( Graphics g )
	{
		super.paintComponent( g );

		int displayWidth = getWidth();
		int displayHeight = getHeight();

		int cellPixelWidth = displayWidth / conway.getWidth();
		int cellPixelHeight = displayHeight / conway.getHeight();

		g.setColor( Color.WHITE );

		for( int i = 0; i < conway.getWidth(); i++ )
		{
			for( int j = 0; j < conway.getHeight(); j++ )
			{
				if( conway.getCell( i, j ) )
					g.fillRect( i * cellPixelWidth, j * cellPixelHeight, cellPixelWidth, cellPixelHeight );
			}
		}
	}
}
