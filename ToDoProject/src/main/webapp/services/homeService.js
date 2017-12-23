var toDo = angular.module('ToDo');

toDo.factory('homeService', function($http) {
	console.log("its coming to service");

	var notes = {};

	notes.service = function(method, url, note) {

		console.log("service", note);
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

	notes.saveNotes = function(note) {

		return $http({

			method : "POST",
			url : 'user/saveNote',
			data : note,

			headers : {

				'token' : localStorage.getItem('acessToken')
			}
		})
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

	// DELETE NOTE

	notes.deleteNotes = function(note) {

		console.log("inside delete function" + note.noteId);

		return $http({

			method : 'DELETE',
			data : note,
			url : 'user/deleteNote/' + note.noteId,

			headers : {
				
				'token' : localStorage.getItem('acessToken')
			},

		})
	}

/*	// Add To Archieve

	notes.noteArchive = function(note) {

		console.log("inside login archive service method");

		return $http({

			method : 'POST',

			url : 'isArchive/' + note.noteId,

			headers : {
			
				'token' : localStorage.getItem('acessToken')
			}
		})
	}

	// Add To Trash

	notes.noteTrash = function(note) {

		console.log("inside login archive service method");

		return $http({

			method : 'POST',

			url : 'emptyTrash/' + note.noteId,

			headers : {

				'token' : localStorage.getItem('acessToken')
			}
		})
	}*/

	// Restore note to Notes

	notes.updateNotes = function(note) {

		console.log("inside update service method" ,note.noteId);

		return $http({

			method : 'POST',
			data : note,
			url : 'user/update',

			headers : {

				'token' : localStorage.getItem('acessToken')
			}
		})
	}

	// add pin and unpin

	notes.addTopin = function(noteid, pin) {

		console.log("inside login archive service method");

		return $http({

			method : 'POST',

			url : 'isPin/' + noteid,

			data : pin,

			headers : {

				'token' : localStorage.getItem('acessToken')
			}
		})
	}
	
	notes.updateNote = function(token, note) {
		
		console.log("IN SERVICE");
		return $http({

			method : 'POST',
			data : note,
			url : 'user/update',

			headers : {

				'token' : localStorage.getItem('acessToken')
			}
		});
	}

	// get User

	notes.getUser = function() {

		return $http({

			method : "GET",
			url : 'getUser',

			headers : {

				'token' : localStorage.getItem('acessToken')
			}
		})
	}
	
	notes.changeProfile = function(User) {
		console.log("change profile",User)

		return $http({
			

			method : 'POST',
			url : 'user/profileChange',
			headers : {
				
				'token' : localStorage.getItem('acessToken')
			},
			data : User
		})
	}
	
	notes.getLabelNotes = function(labelName) {
		
		return $http({
	
			method : "GET",
			
			url : "getLabelNotes/" + labelName,
			
			headers : {

				'token' : localStorage.getItem('acessToken')
			}
		})
}
	notes.saveLabel = function(label) {
		
	console.log("inside the save label....");
		
		return $http({
			
			method : "POST",
			
			url : 'saveLabel',
			
			headers : {
				
				'token' : localStorage.getItem('acessToken')
			},
			data : label
})
	}
	return notes;
});