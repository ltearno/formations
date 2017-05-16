package fr.lteconsulting.training.struts.actions;

import com.opensymphony.xwork2.ActionSupport;
import fr.lteconsulting.training.struts.model.Marvel;
import fr.lteconsulting.training.struts.outils.Outils;
import org.apache.struts2.interceptor.SessionAware;

import java.util.List;
import java.util.Map;

public class Edition extends ActionSupport implements SessionAware
{
	private int id;

	private String nom;
	private String prenom;
	private String couleur;

	private List<Marvel> marvels;

	private Marvel editedMarvel;

	public void setSession( Map<String, Object> session )
	{
		Outils.ensureMarvelsInSession( session );

		marvels = (List<Marvel>) session.get( "marvels" );
	}

	public void setId( String id )
	{
		try
		{
			this.id = Integer.parseInt( id );
		}
		catch( Exception e )
		{
		}
	}

	public void setNom( String nom )
	{
		this.nom = nom;
	}

	public void setPrenom( String prenom )
	{
		this.prenom = prenom;
	}

	public void setCouleur( String couleur )
	{
		this.couleur = couleur;
	}

	public Marvel getEditedMarvel()
	{
		return editedMarvel;
	}

	@Override public String execute() throws Exception
	{
		editedMarvel = Outils.findMarvelById( marvels, id );

		if( editedMarvel == null )
			return ERROR;

		boolean formSubmitted = nom != null && prenom != null && couleur != null;

		if( !formSubmitted )
		{
			return "show_form";
		}
		else
		{
			editedMarvel.setNom( nom );
			editedMarvel.setPrenom( prenom );
			editedMarvel.setCouleur( couleur );

			return SUCCESS;
		}
	}
}
