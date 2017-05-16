package fr.lteconsulting.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import fr.lteconsulting.dao.CategorieDao;
import fr.lteconsulting.model.Categorie;

@ManagedBean
@ViewScoped
public class CategoryCrudBean implements Serializable
{
	private static final long serialVersionUID = 1L;

	@EJB
	private CategorieDao dao;

	private Categorie editedItem;

	@PostConstruct
	public void init()
	{
		resetItem();
	}

	public List<Categorie> getCategories()
	{
		return dao.getCategories();
	}

	public Categorie getItem()
	{
		return editedItem;
	}

	public void edit( Categorie editedItem )
	{
		this.editedItem = editedItem;
	}

	public void resetItem()
	{
		editedItem = new Categorie();
	}

	public void valider()
	{
		if( editedItem.getId() == null )
		{
			dao.addCategorie( editedItem );
			
			FacesMessage message = new FacesMessage( "La catégorie a bien été ajoutée !" );
	        FacesContext.getCurrentInstance().addMessage( null, message );
		}
		else
		{
			dao.saveCategorie( editedItem );
			
			FacesMessage message = new FacesMessage( "La catégorie a bien été sauvegardée !" );
	        FacesContext.getCurrentInstance().addMessage( null, message );
		}

		resetItem();
	}

	public boolean isEdition()
	{
		return editedItem != null && editedItem.getId() != null;
	}

	public boolean isCreation()
	{
		return editedItem != null && editedItem.getId() == null;
	}

	public void delete( Categorie categorie )
	{
		dao.delete( categorie.getId() );
	}
}