package fr.lteconsulting.formations.client.components;

import fr.lteconsulting.angular2gwt.ng.core.Component;
import fr.lteconsulting.formations.client.services.CollaborateurService;
import fr.lteconsulting.formations.client.services.DemandeFormationService;
import fr.lteconsulting.formations.client.services.FormationService;
import jsinterop.annotations.JsType;

@Component(
		selector = "my-app",
		templateUrl = "ApplicationComponent.html",
		styleUrls = "ApplicationComponent.css",
		providers = {
				CollaborateurService.class,
				DemandeFormationService.class,
				FormationService.class
		} )
@JsType
public class ApplicationComponent
{
}
