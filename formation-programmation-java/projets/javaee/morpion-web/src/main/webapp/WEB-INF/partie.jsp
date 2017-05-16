<%@page import="javax.persistence.metamodel.SetAttribute"%>
<%@page import="fr.lteconsulting.Piece"%>
<%@page import="fr.lteconsulting.Plateau"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div id="upper-part">
	<!-- Cette DIV est l'endroit où on va insérer la grille en Javascript -->
	<div id="board">
	</div>
</div>

<!-- Cette DIV ne sera affichée que si c'est au tour du joueur de jouer -->
<h2 id='aVousJouer'>A VOUS DE JOUER !!!</h2>

<!-- Chargement du script JQuery -->
<script src="jquery-3.1.1.js" type="text/javascript"></script>

<script>
	// on attend le chargement complet de la page
	$(function(){
		// la variable ID_PARTIE contient l'identifiant de la partie.
		// notez la présence des guillements ' et l'expression EL.
		// pourquoi est-ce fait ainsi ?
		let ID_PARTIE = '${identifiantPartie}';
		
		let PARTIE = ${plateauJson};
		
		let JOUEUR = ${joueurConnecte};
		
		// fonction d'aide pour emettre des requetes AJAX et récupérer le résultat
		function requete(method, url, data, fonctionDeRappel) {
            if (typeof data == "function") {
                fonctionDeRappel = data;
                data = null;
            }

            let request = new XMLHttpRequest();
            request.open(method, url);
            request.onload = function () {
                let data = request.responseText ? JSON.parse(request.responseText) : null;

                fonctionDeRappel(data);
            }

            if (data != null) {
                request.setRequestHeader("Content-Type", "application/json");
                let json = JSON.stringify(data);
                request.send(json);
            }
            else {
                request.send();
            }
        }
		
		// fonction qui envoie une requete au serveur pour obtenir l'état de la partie
		function chargerPartie() {
			requete('GET', 'api/parties/' + ID_PARTIE, function(partieData) {
				// une fois que les données sont arrivées, on met à jour l'affichage
				rafraichirAffichagePartie(partieData);
				
				// si ce n'est pas au joueur courant de jouer, on redemmande
				// périodiquement l'état de la partie
				if( ! partieData.tour )
					setTimeout(chargerPartie, 2000);
			})
		}
		
		// fonction qui redessine la grille en fonction des données de la parties
		function rafraichirAffichagePartie(partie) {
			// on vide la grille
			$('#board').html('');
			
			// on affiche le message d'invitation à jouer si c'est le tour du joueur courant
			if(partie.tour)
				$('#aVousJouer').show();
			else
				$('#aVousJouer').hide();
			
			// on parcoure toutes les lignes
			for( let y=0; y<partie.plateau.length; y++){
				let ligne = partie.plateau[y];
				
				// création de la div qui représente la ligne
				let ligneDiv = $('<div></div>');
				
				for( let x=0; x<ligne.length; x++ ){
					let cellule = ligne[x];
					
					// création de la div qui représente la cellule
					let celluleDiv = $('<div></div>');
					
					// si c'est au tour du joueur de jouer et que la case est vide,
					// on ajoute un bouton
					if( partie.tour && cellule==null) {
						// création du bouton
						let buttonDiv = $('<button></button>');
						
						// ajout du bouton à la div de la cellule
						celluleDiv.append(buttonDiv);
						
						// on s'abonne au click sur le bouton.
						// quand le joueur clique, on envoie une requête pour jouer le coup
						buttonDiv.click(function(){
							// envoie la requête
							requete('POST', 'api/parties/'+ID_PARTIE, {x:x, y:y}, function() {
								// lorsque le coup est joué, on recharge la partie 
								chargerPartie();
							});
						});
					}
					else if( cellule != null ) {
						// si la cellule contient une pièce, on l'affiche
						celluleDiv.text(cellule);
					}
					
					// ajout de la cellule à la ligne
					ligneDiv.append(celluleDiv);
				}
				
				// ajout de la ligne à la grille
				$('#board').append(ligneDiv);
			}
		}
		
		// on appelle chargerPartie pour demander le chargement de la partie
		chargerPartie();
	})
</script>