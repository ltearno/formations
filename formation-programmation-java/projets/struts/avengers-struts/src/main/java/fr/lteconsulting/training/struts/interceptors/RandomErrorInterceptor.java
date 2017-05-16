package fr.lteconsulting.training.struts.interceptors;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.opensymphony.xwork2.util.logging.Logger;
import com.opensymphony.xwork2.util.logging.LoggerFactory;

public class RandomErrorInterceptor extends AbstractInterceptor
{
	private static final Logger LOG = LoggerFactory.getLogger( RandomErrorInterceptor.class );

	public String intercept( ActionInvocation invocation ) throws Exception
	{
		if( Math.random() >= 0.5 )
		{
			LOG.error( "L'intercepteur a mis la requête en erreur !" );
			return Action.ERROR;
		}

		// invocation.getInvocationContext().getSession().put( "clé", value );

		// L'appel à invoke peut ou pas déclencher la génération du flux HTML
		return invocation.invoke();
	}
}
