var toDo = angular.module('ToDo');

toDo.factory('homeService', function($http) {
	console.log("its coming to service");

	var notes = {};

	notes.service = function(method, url, note) {
		console.log("service",note);
		console.log(localStorage.getItem('acessToken'))
		return $http({
			method : method,
			url : url,
			data : note,
			headers : {
				'token' : localStorage.getItem('acessToken')
			}
		});
	}
	
// get all notes
	
	notes.getAllNotes = function() {
		console.log(localStorage.getItem('acessToken'))

		return $http({
			method : 'GET',
			url : 'user/getAllNotes',
			headers : {
				'token' : localStorage.getItem('acessToken')
			}
		});
	}

	//DELETE NOTE

	notes.deleteNotes = function(note) {
		console.log("inside delete function" + note.noteId);
		console.log("inside delete function" + JSON.stringify(note));

		return $http({
			method : 'DELETE',
			data:note,
			url : 'user/deleteNote/' + note.noteId,		
			headers : {
				'token' : localStorage.getItem('acessToken')
			},

		})
	}

	// Add To Archieve

	notes.noteArchive = function(note) {

		console.log("inside login archive service method");

		return $http({

			method : 'POST',

			url : 'isArchive/'+ note.noteId,

			headers : {
				'token' : localStorage.getItem('acessToken')
			}
		})
	}

	// Add To Trash

	notes.noteTrashService = function(note) {

		console.log("inside login Trash service method");

		return $http({

			method : 'POST',

			url : 'emptyTrash/'+ note.noteId,

			headers : {
				'token' : localStorage.getItem('acessToken')
			}
		})
	}

	//Restore note to Notes
	
	notes.updateNotes = function(note){
		
		console.log("inside login Trash service method");

		return $http({

			method : 'POST',
			data:note,
			url : 'user/update',

			headers : {
				
				'token' : localStorage.getItem('acessToken')
			}
		})
	}
	return notes;
});


