package fr.lteconsulting.dao;

import java.util.List;

import fr.lteconsulting.Produit;
import fr.lteconsulting.exception.DAOException;

public interface ProduitDAO
{
	List<Produit> getAll() throws DAOException;

	Produit getOne( int reference ) throws DAOException;

	void addProduit( Produit produit ) throws DAOException;

	void updateProduit( Produit produit ) throws DAOException;

	void deleteProduit( int reference ) throws DAOException;
}
