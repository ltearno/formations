package fr.lteconsulting.training.struts.actions;

import com.opensymphony.xwork2.ActionSupport;
import fr.lteconsulting.training.struts.model.Marvel;
import fr.lteconsulting.training.struts.outils.Outils;
import org.apache.struts2.interceptor.SessionAware;

import java.util.List;
import java.util.Map;

public class Suppression extends ActionSupport implements SessionAware
{
	private int id;
	private List<Marvel> marvels;

	public void setId( String id )
	{
		try
		{
			this.id = Integer.parseInt( id );
		}
		catch( Exception e )
		{
			e.printStackTrace();
		}
	}

	public void setSession( Map<String, Object> session )
	{
		Outils.ensureMarvelsInSession( session );

		marvels = (List<Marvel>) session.get( "marvels" );
	}

	@Override
	public String execute() throws Exception
	{
		Marvel marvel = Outils.findMarvelById( marvels, id );

		if( marvel != null )
			marvels.remove( marvel );

		return SUCCESS;
	}
}
