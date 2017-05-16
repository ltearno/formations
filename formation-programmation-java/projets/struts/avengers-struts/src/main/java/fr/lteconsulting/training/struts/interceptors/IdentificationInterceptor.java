package fr.lteconsulting.training.struts.interceptors;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.opensymphony.xwork2.util.logging.Logger;
import com.opensymphony.xwork2.util.logging.LoggerFactory;

public class IdentificationInterceptor extends AbstractInterceptor
{
	private static final Logger LOG = LoggerFactory.getLogger( IdentificationInterceptor.class );

	public String intercept( ActionInvocation invocation ) throws Exception
	{
		if( !invocation.getInvocationContext().getSession().containsKey( "utilisateur" ) )
			return "login_required";

		return invocation.invoke();
	}
}
