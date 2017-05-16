package fr.lteconsulting.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import fr.lteconsulting.dao.UtilisateurDao;
import fr.lteconsulting.model.Utilisateur;

@ManagedBean
@ViewScoped
public class UtilisateurCrudBean implements Serializable
{
	private static final long serialVersionUID = 1L;

	@EJB
	UtilisateurDao utilisateurDao;

	private Utilisateur item;

	@PostConstruct
	public void init()
	{
		resetItem();
	}

	public List<Utilisateur> getUtilisateurs()
	{
		return utilisateurDao.getUtilisateurs();
	}

	public Utilisateur getItem()
	{
		return item;
	}

	public void edit( Utilisateur item )
	{
		this.item = item;
	}

	public void resetItem()
	{
		item = new Utilisateur();
	}

	public void valider()
	{
		if( item.getId() == null )
		{
			utilisateurDao.add( item );

			FacesMessage message = new FacesMessage( "L'utilisateur a bien été ajouté !" );
			FacesContext.getCurrentInstance().addMessage( null, message );
		}
		else
		{
			utilisateurDao.save( item );

			FacesMessage message = new FacesMessage( "L'utilisateur a bien été modifié !" );
			FacesContext.getCurrentInstance().addMessage( null, message );
		}

		resetItem();
	}

	public boolean isEdition()
	{
		return item.getId() != null;
	}

	public boolean isCreation()
	{
		return item.getId() == null;
	}

	public void delete( Utilisateur utilisateur )
	{
		utilisateurDao.delete( utilisateur.getId() );
	}
}