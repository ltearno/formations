"use strict";

function RestService(baseUrl) {
	this.baseUrl = baseUrl
}

RestService.prototype = {
		getAll: function(callback) {
			$.get(this.baseUrl, callback)
		},
		
		getOne: function(id, callback) {
			$.get(`${this.baseUrl}/${id}`, callback)
		},
		
		createOrUpdate(pop, callback) {
			$.ajax(this.baseUrl, {
				method: pop.id<=0 ? 'put' : 'post',
				dataType: 'json',
				contentType: 'application/json',
				data: JSON.stringify(pop),
				success: callback
			})
		},
		
		delete: function(id, callback) {
			$.ajax(`${this.baseUrl}/${id}`, {
				method: 'delete',
				success: () => callback()
			})
		}
}

// Mémorise le FunkoPop actuellement édité
// Si c'est à null, ca veut dire qu'on est en train de créer un FP
let editedPop = null

function getTableRowForPop(pop) {
	return `<tr data-id='${pop.id}'>
				<td>${pop.name}</td>
				<td>${pop.universe}</td>
				<td>${pop.waterproof?'<i class="small material-icons">done</i>':''}</td>
				<td>${pop.latitude}, ${pop.longitude}</td>
				<td><div class="buttonBar">
					<a class="editButton btn-floating yellow"><i class="material-icons">edit</i></a>
					<a class="deleteButton btn-floating red"><i class="material-icons">delete</i></a>
				</div></td>
			</tr>`
}

function showTable() {
	editedPop = null
	
	$('#crudFlipContainer').removeClass('flip')
}

function showCreateForm() {
	editedPop = null
	
	$('#name').val('')
	$('#universe').val('')
	$('#waterproof').prop('checked', false)
	$('#latitude').val(0)
	$('#longitude').val(0)
	
	$('#crudFlipContainer').addClass('flip')
	
	$('#name').focus()
}

function showEditForm(pop) {
	editedPop = pop
	
	$('#name').val(pop.name)
	$('#universe').val(pop.universe)
	$('#waterproof').prop('checked', pop.waterproof)
	$('#latitude').val(pop.latitude)
	$('#longitude').val(pop.longitude)
	
	$('#crudFlipContainer').addClass('flip')
	
	$('#name').focus()
}

$(function() {
	let service = new RestService('funko/pop')
	
	// Attention ce n'est pas forcément recommandé d'écrire de façon si condensée !
	// Avez-vous des difficultés à lire cette ligne de code ?
	service.getAll( (pops) => $('table.funkoPops').append( $(pops.map(getTableRowForPop).join('')) ) )
	
	$("table.funkoPops").on("click", ".deleteButton", function() {
		let tableRow = $(this).closest("tr[data-id]")
		let id = tableRow.attr("data-id")
		
		service.delete(id, () => tableRow.hide("slow", ()=> tableRow.remove()))
	})
	
	$("table.funkoPops").on("click", ".editButton", function() {
		let tableRow = $(this).closest("tr[data-id]")
		let id = tableRow.attr("data-id")
		
		service.getOne(id, showEditForm)
	})
	
	$('#createButton').click(showCreateForm)
	
	$('#okButton').click(function() {
		let pop = editedPop
		if( !pop )
			pop = { id: -1 }
		
		pop.name = $('#name').val()
		pop.universe = $('#universe').val()
		pop.waterproof = $('#waterproof').is(":checked")
		pop.latitude = 1 * $('#latitude').val()
		pop.longitude = 1 * $('#longitude').val()
		
		service.createOrUpdate(pop, function(pop) {
			let rowHtml = getTableRowForPop(pop)
			
			let popRow = $(`table.funkoPops tr[data-id=${pop.id}]`)
			if( popRow.length )
				popRow.replaceWith(rowHtml)
			else
				$('table.funkoPops').append( $(rowHtml) )
		})
		
		showTable()
	})
})