package fr.lteconsulting.training.struts.actions;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.logging.Logger;
import com.opensymphony.xwork2.util.logging.LoggerFactory;
import fr.lteconsulting.training.struts.SimpleService;
import fr.lteconsulting.training.struts.model.CountriesResponse;
import fr.lteconsulting.training.struts.outils.Outils;
import org.apache.struts2.interceptor.SessionAware;
import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;

import javax.ws.rs.core.Response;
import java.util.Map;

public class Consultation extends ActionSupport implements SessionAware
{
	private static final Logger LOG = LoggerFactory.getLogger( Consultation.class );

	public void setSession( Map<String, Object> session )
	{
		Outils.ensureMarvelsInSession( session );
	}

	@Override public String execute() throws Exception
	{
		ResteasyClient client = new ResteasyClientBuilder().build();
		ResteasyWebTarget target = client.target( "http://services.groupkt.com/country" );

		SimpleService simple = target.proxy( SimpleService.class );
		//Response response = simple.getCountries();
		//LOG.warn( "Response " + response + " status=" + response.getStatus() + " text=" + response.readEntity( String.class ) );

		CountriesResponse rr = simple.getCountriesStructured();
		LOG.warn( "RESPONSE " + rr );

		return Action.SUCCESS;
	}
}
