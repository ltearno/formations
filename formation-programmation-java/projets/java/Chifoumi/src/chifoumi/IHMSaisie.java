package chifoumi;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

public class IHMSaisie extends JOptionPane
{
	final static long serialVersionUID = 1;
	JDialog dialogue;
	Choix[] choix = { Choix.CAILLOU, Choix.CISEAUX, Choix.PAPIER };

	public IHMSaisie( String nom )
	{
		setMessage( nom + ", que jouez-vous ?" );
		setOptions( choix );
		dialogue = createDialog( null, "chifoumi" );
	}

	Choix proposerChoix()
	{
		dialogue.setVisible( true );
		return (Choix) getValue();
	}
}