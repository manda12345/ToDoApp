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
/*-----------------------------------------Add Notes------------------------------------------------*/


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

	/*------------------------Get All Notes------------------------*/

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

	/*------------------------Delete Notes------------------------*/

	notes.deleteNotes = function(note) {

		console.log("inside delete function" + note.noteId);

		return $http({

			method : 'DELETE',
			data : note,
			url : 'note/deleteNote/'+ note.noteId,

			headers : {

				'token' : localStorage.getItem('acessToken')
			},

		})
	}
	
	/*------------------------Update Notes---------------------------*/

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
	
/*----------------------------------------- Restore note to Notes----------------------------------------------*/

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

/*-----------------------------------------pinned Notes-----------------------------------------------*/

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

/*---------------------------------------------get user-------------------------------------------------*/

	notes.getUser = function() {

		return $http({

			method : "GET",
			url : 'getUser',

			headers : {

				'token' : localStorage.getItem('acessToken')
			}
		})
	}
	
/*-------------------------------------get url------------------------------------------------------*/

	notes.getUrl=function(urlToSend){
		return $http({
		    method: 'POST',
		    url: 'getUrlData',
		    headers: {
		        'url': urlToSend
		    }
		
		});
	}

/*-------------------------------------save labels------------------------------------------------------*/
	
	notes.saveLabel = function(label) {

		return $http({

			method : 'POST',
			url : 'note/addLabels',
			data : label,

			headers : {

				'token' : localStorage.getItem('acessToken')
			}
		})
	}
	
	/*------------------------delete labels-------------------------*/

	notes.deleteLabel = function(label) {

		return $http({

			method : "DELETE",
			url : 'note/deleteLabels/'+label.labelId,

			headers : {

				'token' : localStorage.getItem('acessToken')
			}
		})
	}
	
	/*------------------------getAll Labels--------------------------*/

	notes.getAllLabels = function() {

		return $http({

			method : "GET",
			url : "note/getLabelAllLabels",

			headers : {

				'token' : localStorage.getItem('acessToken')
			}
		})
	}
	
	/*------------------------  Edit labels-------------------------*/


	notes.editLabel = function(label) {

		console.log("IN SERVICE",label);
	
		return $http({

			method : 'POST',
			data : label,
			url : 'note/editLabel',

			headers : {

				'token' : localStorage.getItem('acessToken')
			}
		});
	}
	
	/*------------------------get Labels on Notes--------------------------*/
	
	notes.getLabelNotes = function(labelName) {

		return $http({

			method : "GET",

			url : "getLabelNotes/" + labelName,

			headers : {

				'token' : localStorage.getItem('acessToken')
			}
		})
	}
	
	/*------------------------get Author--------------------------*/
	
	notes.getAuthor = function(){
		return localStorage.getItem('acessToken');
	}
	
/*---------------------------- show collaborator modal-----------------------------------------------------*/

	notes.getUserlist = function(note) {

		return $http({

			method : 'POST',
			url : 'note/collaborator',
			data : note,
			headers : {

				'token' : localStorage.getItem('acessToken')
			}
		});
	}
	
	/*------------------------ get the owner  ---------------------------*/
	
	notes.getOwner =function(note)
	{
		return $http({

			method : 'POST',
			url : 'note/getOwner',
			data : note,
			headers : {

				'token' : localStorage.getItem('acessToken')
			}
		});
	}
	/*----------------- collaborate the owner and share user------------*/
	
	notes.collborate = function(note)
	{

		return $http({

			method : 'POST',
			url : 'note/collaborator',
			data : note,
			headers : {

				'token' : localStorage.getItem('acessToken')
			}
		});
	}
	
	/*------------------------ delete the collaborator------------*/

	notes.removeCollborator=function(note)
	{
		return $http({

			method : 'POST',
			url : 'note/removeCollborator',
			data : note,
			headers : {

				'token' : localStorage.getItem('acessToken')
			}
		});
	}
	
/*----------------------------------------uploading images--------------------------------------------------*/

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
	
	return notes;
});