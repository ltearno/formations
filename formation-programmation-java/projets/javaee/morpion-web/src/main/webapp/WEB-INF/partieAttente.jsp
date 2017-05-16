<%@page import="javax.persistence.metamodel.SetAttribute"%>
<%@page import="fr.lteconsulting.Piece"%>
<%@page import="fr.lteconsulting.Plateau"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

La partie <b>${partie.nom}</b> est en attente de joueur.<br/>

La page se rafraichira automatiquement une fois un joueur inscrit...