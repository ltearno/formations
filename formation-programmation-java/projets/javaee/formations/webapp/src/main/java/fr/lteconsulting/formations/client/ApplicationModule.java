package fr.lteconsulting.formations.client;

import fr.lteconsulting.angular2gwt.client.interop.ng.forms.FormsModule;
import fr.lteconsulting.angular2gwt.client.interop.ng.http.HttpModule;
import fr.lteconsulting.angular2gwt.client.interop.ng.platformBrowser.BrowserModule;
import fr.lteconsulting.angular2gwt.ng.core.NgModule;
import fr.lteconsulting.formations.client.components.ApplicationComponent;
import fr.lteconsulting.formations.client.components.CollaborateurComponent;
import fr.lteconsulting.formations.client.components.CollaborateursComponent;
import fr.lteconsulting.formations.client.components.HomeComponent;
import fr.lteconsulting.formations.client.services.CollaborateurService;
import fr.lteconsulting.formations.client.services.DemandeFormationService;
import fr.lteconsulting.formations.client.services.FormationService;
import jsinterop.annotations.JsType;

@NgModule(
		imports = {
				BrowserModule.class,
				HttpModule.class,
				FormsModule.class,
				Routes.class
		},
		declarations = {
				ApplicationComponent.class,
				CollaborateursComponent.class,
				CollaborateurComponent.class,
				HomeComponent.class
		},
		entryComponents = {
				CollaborateursComponent.class,
				CollaborateurComponent.class,
				HomeComponent.class
		},
		providers = {
				CollaborateurService.class,
				DemandeFormationService.class,
				FormationService.class
		},
		bootstrap = ApplicationComponent.class )
@JsType
public class ApplicationModule
{
}
