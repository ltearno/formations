package fr.lteconsulting;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Application
{
	private static final String COMMAND_BUTTON_RED = "rouge";
	private static final String COMMANDE_BOUTON_BLEU = "bleu";

	public static void main( String[] args )
	{
		JFrame frame = new JFrame();
		frame.setSize( 400, 300 );
		frame.setTitle( "Matrix" );
		frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

		JButton boutonRouge = new JButton( "Pilule rouge" );
		boutonRouge.setActionCommand( COMMAND_BUTTON_RED );

		JButton boutonBleu = new JButton( "Pilule bleu" );
		boutonBleu.setActionCommand( COMMANDE_BOUTON_BLEU );

		JPanel panel = new JPanel();
		panel.add( boutonRouge );
		panel.add( boutonBleu );

		SpinnerNumberModel modelRouge = new SpinnerNumberModel( 0, 0, 255, 10 );
		JSpinner spinnerRouge = new JSpinner( modelRouge );
		spinnerRouge.setPreferredSize( new Dimension( 40, 20 ) );

		SpinnerNumberModel modelVert = new SpinnerNumberModel( 0, 0, 255, 10 );
		JSpinner spinnerVert = new JSpinner( modelVert );
		spinnerVert.setPreferredSize( new Dimension( 40, 20 ) );

		SpinnerNumberModel modelBleu = new SpinnerNumberModel( 0, 0, 255, 10	 );
		JSpinner spinnerBleu = new JSpinner( modelBleu );
		spinnerBleu.setPreferredSize( new Dimension( 40, 20 ) );

		ChangeListener changeListener = new ChangeListener()
		{
			@Override
			public void stateChanged( ChangeEvent e )
			{
				Color color = new Color(
						(int) modelRouge.getNumber(),
						(int) modelVert.getNumber(),
						(int) modelBleu.getNumber() );

				panel.setBackground( color );
			}
		};

		spinnerRouge.addChangeListener( changeListener );
		spinnerVert.addChangeListener( changeListener );
		spinnerBleu.addChangeListener( changeListener );

		panel.add( spinnerRouge );
		panel.add( spinnerVert );
		panel.add( spinnerBleu );

		JLabel label = new JLabel( "Choisissez la votre" );
		panel.add( label );

		JTextField textField = new JTextField();
		textField.setPreferredSize( new Dimension( 150, 70 ) );
		textField.addKeyListener( new KeyListener()
		{
			@Override
			public void keyTyped( KeyEvent e )
			{
				String text = textField.getText();
				System.out.println( "TEXT => " + text );
				frame.setTitle( text );
			}

			@Override
			public void keyReleased( KeyEvent e )
			{
			}

			@Override
			public void keyPressed( KeyEvent e )
			{
			}
		} );
		panel.add( textField );

		ActionListener listener = new ActionListener()
		{
			@Override
			public void actionPerformed( ActionEvent e )
			{
				label.setForeground( Color.WHITE );

				String actionCommand = e.getActionCommand();
				switch( actionCommand )
				{
					case COMMAND_BUTTON_RED:
						panel.setBackground( new Color( 230, 30, 30 ) );
						label.setText( "Bravo, c'est le bon choix" );
						break;

					case COMMANDE_BOUTON_BLEU:
						panel.setBackground( new Color( 30, 30, 230 ) );
						label.setText( "Bravo, c'est le bon choix !" );
						break;
				}

				System.out.println( "Wao" );
			}
		};

		boutonRouge.addActionListener( listener );
		boutonBleu.addActionListener( listener );

		frame.add( panel );

		frame.setVisible( true );
	}
}
