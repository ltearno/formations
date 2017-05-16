package fr.lteconsulting.training.struts.actions;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.SessionAware;

import java.util.Map;

public class Identification extends ActionSupport implements SessionAware
{
	private String userName;
	private Map<String, Object> session;

	public void setUserName( String userName )
	{
		this.userName = userName;
	}

	public void setSession( Map<String, Object> session )
	{
		this.session = session;
	}

	@Override public String execute() throws Exception
	{
		if( userName == null )
			return INPUT;

		session.put( "utilisateur", userName );

		return SUCCESS;
	}
}
