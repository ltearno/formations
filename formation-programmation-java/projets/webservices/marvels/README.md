# README

ATTENTION POUR CE PROJET IL FAUT UTILISER WILDFLY EN VERSION 10 AU MOINS !!!

## Appel d'un Web Service depuis un navigateur

- importer JQuery dans marvels-ui
- en JS faire un appel au WS Marvels du projet marvels-store pour obtenir les marvels dnas le navigateur
- afficher ces Marvels avec JQuery

## Implémentation de nouvelles méthodes de service

- Dans le projet marvels-store, implémenter les opérations CRUD côté service web
- Dans le projet marvels-ui, utiliser ces nouvelles méthode côté navigateur (appels ajax) pour manipuler la collection de marvels (ajout, edition, suppression).

## Implémentation d'un client REST

- S'enregistrer sur developer.marvels.com pour obtenir une clé d'API (qui vous donnera le droit d'utiliser leurs services)
- Dans le projet marvels-store, définir un client pour l'API de marvels.com
- Dans l'EJB MarvelsDataStore, ajouter une méthode qui crée un client REST et appelle developer.marvels.com pour obtenir les données et mettre à jour la liste des marvels.
- Permettre à un client externe de déclencher cette méthode (en ajoutant une méthode dans le service web qui délègue à celle-ci) à partir d'un bouton 'IMPORTER' dans la page web de marvels-ui.