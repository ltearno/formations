package fr.lteconsulting;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import fr.lteconsulting.model.Categorie;

@SuppressWarnings( "serial" )
@ManagedBean
@RequestScoped
public class CreationCategorieBean implements Serializable
{
	private Categorie categorie;
	
	public CreationCategorieBean()
	{
		categorie = new Categorie();
	}
	
	public Categorie getCategorie()
	{
		return categorie;
	}
	
	/**
	 * Cette méthode sera appelée par JSF
	 * au moment de la validation du formulaire
	 */
	public void validation()
	{
		System.out.println( "MERCI LE FORMULAIRE CONTIENT " + categorie );
	}
}
