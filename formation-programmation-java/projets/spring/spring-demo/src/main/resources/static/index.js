var dumpCustomers = function(text) {
	// convertir le texte en objets javascript
	var customers = JSON.parse(text)

	// appeler dump() pour chaque customer
	for ( var i in customers) {
		var customer = customers[i];

		dump("<div class='customer'>" + "ID : " + customer.id + "<br/>"
				+ "Prenom : " + customer.firstName + "<br/>" + "Nom : "
				+ customer.lastName + "<br/>" + "</div>");
	}
}

function dump(text) {
	var element = document.getElementById("customers")

	element.innerHTML += text + '<br/>'
	// element.innerText = element.innerText + text;
}

var req = new XMLHttpRequest();
req.open('GET', 'customers');
req.onreadystatechange = function(aEvt) {
	dump("etat " + req.readyState + ' statut ' + req.status)
	if (req.readyState == 4) {
		if (req.status == 200)
			dumpCustomers(req.responseText);
		else
			dump("Erreur pendant le chargement de la page.\n");
	}
};

req.send(null);
