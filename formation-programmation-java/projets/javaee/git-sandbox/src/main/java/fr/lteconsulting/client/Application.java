package fr.lteconsulting.client;

import java.util.List;

import org.fusesource.restygwt.client.Defaults;
import org.fusesource.restygwt.client.Method;
import org.fusesource.restygwt.client.MethodCallback;
import org.fusesource.restygwt.client.Resource;
import org.fusesource.restygwt.client.RestServiceProxy;

import com.google.gwt.cell.client.AbstractCell;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;
import com.google.gwt.safehtml.shared.SafeHtmlUtils;
import com.google.gwt.user.cellview.client.CellList;
import com.google.gwt.user.cellview.client.HasKeyboardSelectionPolicy.KeyboardSelectionPolicy;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.DockLayoutPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.MenuBar;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.user.client.ui.SplitLayoutPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.view.client.SingleSelectionModel;

import fr.lteconsulting.shared.Personne;

public class Application implements EntryPoint
{
	private FormulairePersonne formulairePersonne = new FormulairePersonne();

	private TextBox searchBox = new TextBox();
	private Button searchButton = new Button( "Rechercher" );

	private Button valider = new Button( "Valider" );
	private Button supprimer = new Button( "Supprimer" );
	private Button nouvellePersonne = new Button( "Nouvelle personne" );

	private CellList<Personne> cellList;

	private Personne editedPersonne;

	private PersonneService service;

	@Override
	public void onModuleLoad()
	{
		// Création du proxy pour le web service REST
		Resource resource = new Resource( GWT.getHostPageBaseURL() + "api/" + "personnes" );
		service = GWT.create( PersonneService.class );
		((RestServiceProxy) service).setResource( resource );

		// Option pour RestyGWT
		Defaults.setDateFormat( null );

		initGui();

		initGuiHandlers();

		refreshPersonnes();
	}

	/**
	 * Construit l'interface graphique de l'application
	 */
	private void initGui()
	{
		MenuBar menu = createMenu();
		createCellList();

		VerticalPanel vp = new VerticalPanel();
		vp.add( formulairePersonne );
		vp.add( valider );
		vp.add( supprimer );
		vp.add( nouvellePersonne );

		VerticalPanel vp2 = new VerticalPanel();
		vp2.add( searchBox );
		vp2.add( searchButton );
		vp2.add( cellList );

		SplitLayoutPanel split = new SplitLayoutPanel();
		split.addWest( new ScrollPanel( vp2 ), 200 );
		split.add( new ScrollPanel( vp ) );

		DockLayoutPanel layout = new DockLayoutPanel( Unit.EM );
		layout.addNorth( menu, 2 );
		layout.add( split );

		RootLayoutPanel.get().add( layout );
	}

	/**
	 * Branche les différents évènements de l'interface graphique sur
	 * les actions appropriées
	 */
	private void initGuiHandlers()
	{
		// Réaction à la sélection d'une personne dans la liste
		SingleSelectionModel<Personne> selectionModel = new SingleSelectionModel<>();
		cellList.setSelectionModel( selectionModel );
		selectionModel.addSelectionChangeHandler( event -> {
			editedPersonne = selectionModel.getSelectedObject();
			formulairePersonne.updateFormFromPersonne( editedPersonne );
		} );

		// Branchement des actions liées aux différents boutons
		valider.addClickHandler( event -> updateSelectedPersonne() );
		nouvellePersonne.addClickHandler( event -> createPersonne() );
		supprimer.addClickHandler( event -> supprimerSelectedPersonne() );
		searchButton.addClickHandler( event -> rechercherPersonnes() );

		// Lorsque la touche ENTER est tapée dans la zone de texte de recherche,
		// on déclenche la recherche
		searchBox.addKeyUpHandler( event -> {
			if( event.getNativeKeyCode() == KeyCodes.KEY_ENTER )
				rechercherPersonnes();
		} );
	}

	/**
	 * Demande les données fraîches au serveur et mes à jour la CellList
	 */
	private void refreshPersonnes()
	{
		service.get( new MethodCallback<List<Personne>>()
		{
			@Override
			public void onSuccess( Method method, List<Personne> response )
			{
				setCellListData( response );
			}

			@Override
			public void onFailure( Method method, Throwable exception )
			{
				Window.alert( "FAILED " + exception );
			}
		} );
	}

	/**
	 * Demande la mise à jour côté serveur de la personne avec les données contenues
	 * dans le formulaire
	 */
	private void updateSelectedPersonne()
	{
		formulairePersonne.updatePersonneFromForm( editedPersonne );

		service.update( editedPersonne, new MethodCallback<Personne>()
		{
			@Override
			public void onSuccess( Method method, Personne response )
			{
				refreshPersonnes();
			}

			@Override
			public void onFailure( Method method, Throwable exception )
			{
				Window.alert( "FAILED " + exception );
			}
		} );
	}

	/**
	 * Demande au serveur la création d'une nouvelle personne, puis rafraîchit les données
	 */
	private void createPersonne()
	{
		Personne personne = new Personne();
		formulairePersonne.updatePersonneFromForm( personne );

		service.create( personne, new MethodCallback<Personne>()
		{
			@Override
			public void onSuccess( Method method, Personne response )
			{
				refreshPersonnes();
			}

			@Override
			public void onFailure( Method method, Throwable exception )
			{
				Window.alert( "FAILED " + exception );
			}
		} );
	}

	/**
	 * Demande au serveur la suppression d'une personne et rafraichit ensuite les données
	 */
	private void supprimerSelectedPersonne()
	{
		if( editedPersonne == null )
			return;

		service.delete( editedPersonne.getId(), new MethodCallback<Boolean>()
		{
			@Override
			public void onSuccess( Method method, Boolean response )
			{
				if( response )
					refreshPersonnes();
			}

			@Override
			public void onFailure( Method method, Throwable exception )
			{
				Window.alert( "FAILED " + exception );
			}
		} );

		editedPersonne = null;
		formulairePersonne.updateFormFromPersonne( null );
	}

	/**
	 * Fait une demande de recherche de personnes au serveur
	 */
	private void rechercherPersonnes()
	{
		if( searchBox.getText().trim().isEmpty() )
		{
			refreshPersonnes();
			return;
		}

		service.searchByName( searchBox.getText(), new MethodCallback<List<Personne>>()
		{
			@Override
			public void onSuccess( Method method, List<Personne> response )
			{
				setCellListData( response );
			}

			@Override
			public void onFailure( Method method, Throwable exception )
			{
				Window.alert( "FAILED " + exception );
			}
		} );
	}

	/**
	 * Affiche la boite de dialogue 'A Propos'
	 */
	private void showAPropos()
	{
		DialogBox box = new DialogBox( true );
		box.setAnimationEnabled( true );
		box.setGlassEnabled( true );

		box.setText( "A propos" );
		box.setWidget( new Label( "Je suis un programme en cours d'élaboration" ) );

		box.center();
	}

	/**
	 * Quitte l'application (en fait c'est une blague : il n'est
	 * pas possible de fermer la page programmatiquement !)
	 */
	private void quit()
	{
		Window.alert( "Not yet implemented, sorry !" );
	}

	/**
	 * Mets à jour les données dans la CellList
	 * 
	 * @param response
	 */
	private void setCellListData( List<Personne> response )
	{
		// Si le nombre d'éléments affichés dans la CellList diminue, il
		// faut absolument redonner sa nouvelle taille à la liste
		cellList.setRowCount( response != null ? response.size() : 0 );

		cellList.setRowData( 0, response );
	}

	/**
	 * Crée la barre de menu principale
	 * 
	 * @return
	 */
	private MenuBar createMenu()
	{
		MenuBar fileMenu = new MenuBar( true );
		fileMenu.addItem( "A propos...", this::showAPropos );
		fileMenu.addItem( "Quitter", this::quit );

		MenuBar menu = new MenuBar();
		menu.addItem( "File", fileMenu );

		return menu;
	}

	/**
	 * Crée la CellList de personnes
	 */
	private void createCellList()
	{
		cellList = new CellList<Personne>( new AbstractCell<Personne>()
		{
			@Override
			public void render( Context context, Personne value, SafeHtmlBuilder sb )
			{
				sb.append( SafeHtmlUtils.fromString( value.getPrenom() + " " + value.getNom() ) );
			}
		} );

		cellList.setKeyboardSelectionPolicy( KeyboardSelectionPolicy.ENABLED );

		cellList.setPageSize( 500 );
	}
}