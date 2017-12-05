var toDo = angular.module('ToDo');

toDo.factory('homeService', function($http) {
	console.log("its coming to service");

	var notes = {};

	notes.service = function(method, url, note) {
		console.log(note);
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

	return notes;
});