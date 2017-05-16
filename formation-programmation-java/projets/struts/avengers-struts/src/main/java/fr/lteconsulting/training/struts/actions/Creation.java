package fr.lteconsulting.training.struts.actions;

import com.opensymphony.xwork2.ActionSupport;
import fr.lteconsulting.training.struts.model.Marvel;
import fr.lteconsulting.training.struts.outils.Outils;
import org.apache.struts2.interceptor.SessionAware;

import java.util.List;
import java.util.Map;

public class Creation extends ActionSupport implements SessionAware
{
	private List<Marvel> marvels;

	private int createdMarvelId;

	public void setSession( Map<String, Object> session )
	{
		Outils.ensureMarvelsInSession( session );

		marvels = (List<Marvel>) session.get( "marvels" );
	}

	public String getCreatedMarvelId()
	{
		return String.valueOf( createdMarvelId );
	}

	@Override public String execute() throws Exception
	{
		createdMarvelId = Outils.getNextMarvelId();

		Marvel marvel = new Marvel( createdMarvelId, "Doe", "John", "couleur" );

		marvels.add( marvel );

		return SUCCESS;
	}
}
