package fr.lteconsulting.client;

import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.datepicker.client.DatePicker;

import fr.lteconsulting.shared.Personne;

public class FormulairePersonne extends Composite
{
	private TextBox nom = new TextBox();
	private TextBox prenom = new TextBox();
	private DatePicker dateNaissance = new DatePicker();
	private CheckBox accepteMarketing = new CheckBox();
	private ListBox sexe = new ListBox();
	private PasswordTextBox motDePasse = new PasswordTextBox();
	private TextArea description = new TextArea();

	public FormulairePersonne()
	{
		sexe.addItem( "Femme" );
		sexe.addItem( "Homme" );

		FlexTable table = createForm();

		initWidget( table );
	}

	public void updateFormFromPersonne( Personne p )
	{
		if( p == null )
		{
			nom.setText( "" );
			prenom.setText( "" );
			accepteMarketing.setValue( false );
			setSelectedSexe( Sexe.Femme );
			motDePasse.setText( "" );
			description.setText( "" );
		}
		else
		{
			nom.setText( p.getNom() );
			prenom.setText( p.getPrenom() );
			dateNaissance.setValue( p.getDateNaissance() );
			dateNaissance.setCurrentMonth( p.getDateNaissance() );
			accepteMarketing.setValue( p.isAccepteMarketing() );
			setSelectedSexe( p.getSexe() );
			motDePasse.setText( p.getMotDePasse() );
			description.setText( p.getDescription() );
		}
	}

	public void updatePersonneFromForm( Personne personne )
	{
		if( personne == null )
			return;

		personne.setNom( nom.getValue() );
		personne.setPrenom( prenom.getValue() );
		personne.setDateNaissance( dateNaissance.getValue() );
		personne.setAccepteMarketing( accepteMarketing.getValue() );
		personne.setSexe( getSelectedSexe() );
		personne.setMotDePasse( motDePasse.getText() );
		personne.setDescription( description.getValue() );
	}

	private FlexTable createForm()
	{
		FlexTable table = new FlexTable();

		table.setText( 0, 0, "Nom" );
		table.setWidget( 0, 1, nom );

		table.setText( 1, 0, "Prénom" );
		table.setWidget( 1, 1, prenom );

		table.setText( 2, 0, "Date de naissance" );
		table.setWidget( 2, 1, dateNaissance );

		table.setText( 3, 0, "Accepte le marketing" );
		table.setWidget( 3, 1, accepteMarketing );

		table.setText( 4, 0, "Sexe" );
		table.setWidget( 4, 1, sexe );

		table.setText( 5, 0, "Mot de passe" );
		table.setWidget( 5, 1, motDePasse );

		table.setText( 6, 0, "Description" );
		table.setWidget( 6, 1, description );
		return table;
	}

	private void setSelectedSexe( Sexe sexe )
	{
		int index = 0;

		switch( sexe )
		{
			case Femme:
				index = 0;
				break;
			case Homme:
				index = 1;
				break;
		}

		this.sexe.setSelectedIndex( index );
	}

	private Sexe getSelectedSexe()
	{
		int index = sexe.getSelectedIndex();

		switch( index )
		{
			case 0:
				return Sexe.Femme;
			case 1:
				return Sexe.Homme;
		}

		throw new RuntimeException( "Bizarre non ?" );
	}
}
