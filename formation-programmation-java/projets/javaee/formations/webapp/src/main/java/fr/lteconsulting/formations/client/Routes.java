package fr.lteconsulting.formations.client;

import fr.lteconsulting.angular2gwt.client.JsArray;
import fr.lteconsulting.angular2gwt.client.JsObject;
import fr.lteconsulting.angular2gwt.client.interop.ng.ProviderWrapper;
import fr.lteconsulting.angular2gwt.client.interop.ng.router.RouterConfig;
import fr.lteconsulting.angular2gwt.client.interop.ng.router.RouterModule;
import fr.lteconsulting.formations.client.components.CollaborateursComponent_AngularComponent;
import fr.lteconsulting.formations.client.components.HomeComponent_AngularComponent;

public class Routes implements ProviderWrapper
{
	@Override
	public Object get()
	{
		return RouterModule.forRoot( JsArray.of(
				RouterConfig.route( "", "/home", "full" ),
				RouterConfig.route( "home", HomeComponent_AngularComponent.getComponentPrototype() ),
				RouterConfig.route( "collaborateurs", CollaborateursComponent_AngularComponent.getComponentPrototype() ) ),
				new JsObject().set( "useHash", true ) );
	}
}