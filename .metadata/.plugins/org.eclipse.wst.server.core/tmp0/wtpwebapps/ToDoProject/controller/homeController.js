var todoApp = angular.module('ToDo');
todoApp.controller('homeController', function($scope, toastr, $interval,homeService,$filter,
		loginService,$state,$http,$location) {
	
	 $scope.noteFilter = null;
	   
	    $scope.searchFilter = function (note) {
	        var re = new RegExp($scope.nameFilter, 'i');
	        return !$scope.nameFilter || re.test(note.title) || re.test(note.description);
	    };

	//logout
	    
	$scope.signout = function() {

		localStorage.removeItem('token');
		$location.path("/login");
	}
	
	//side nav bar

	$scope.toggleSideBar = function() {

		var width = $('#sidebar-wrapper').width();
		console.log(width);
		if (width == '250') {
			document.getElementById("sidebar-wrapper").style.width = "0px";
			document.getElementById("container-main").style.marginLeft = "270px";
		} else {
			document.getElementById("sidebar-wrapper").style.width = "250px";
			document.getElementById("container-main").style.marginLeft = "350px";
		}
	}
	
	// add the notes
	
	$scope.saveNote =function(){
		var message= homeService.service('POST','user/saveNote',$scope.note);
		console.log("its coming here");
		console.log($scope.note);
		message.then(function(response) {
			$scope.note={};

			getAllNotes();

		},function(response){
			
			getAllNotes();
			$scope.note={};
			console.log("some thing happening");
		});
	}
	// gets the all notes
	
	var getAllNotes = function() {

		var notes = homeService.getAllNotes();
		console.log("in this function");
		
		notes.then(function(response) {
			console.log("in coming here also");

			console.log(response.data);
			$scope.notes = response.data;
		}, function(response) {

			$scope.error = response.data.message;
		});
	}
	
	$scope.newnote = false;

	$scope.show = function() {
		$scope.newnote = true;
	}

	$scope.hide = function() {
		$scope.newnote = false;
	}
	getAllNotes();
	
	//delete the notes
	
	$scope.deleteNotes = function(note) {
		console.log("note id" + note.noteId);
		var notes = homeService.deleteNotes(note);
		notes.then(function(response) {
			console.log("delete sucessfully....")
		
		}),function(response) {
			$scope.error = response.data.message;
		};
	}
	
	$scope.ListView = true;

	$scope.ListViewToggle = function() {
		if ($scope.ListView == true) {
			$scope.ListView = false;
			listGrideView();
		} else {
			$scope.ListView = true;
			listGrideView();
		}
	}
//list view of notes
	
	listGrideView();

	function listGrideView() {
		if ($scope.ListView) {
			var element = document
					.getElementsByClassName('card');
			for (var i = 0; i < element.length; i++) {
				element[i].style.width = "900px";
			}
		} else {
			var element = document
					.getElementsByClassName('card');
			for (var i = 0; i < element.length; i++) {
				element[i].style.width = "300px";
			}
		}
	}
	
	// add notes to archive
	
	$scope.addToArchive = function(note) {
		console.log()

		var notes = homeService.noteArchive(note);
		
		notes.then(function(response) {
			console.log("hai");
			getAllNotes();
		}, function(response) {			
			getAllNotes();
		});
		getAllNotes();
	}
	
	// add note to trash
	
	$scope.addToTrash = function(note) {
		console.log("hiiiiiiii")

		var notes = homeService.noteTrashService(note);
		
		notes.then(function(response) {
			console.log("hai");
			getAllNotes();
		}, function(response) {			
			getAllNotes();
		});
		getAllNotes();
	}
	
	//restore notes to notes
	
	$scope.restoreToNotes = function(note) {

		note.emptyTrash = false;
		console.log(note)
		var notes = homeService.updateNotes(note);
		notes.then(function(response) {

			getAllNotes();

		}, function(response) {

			console.log(response.data);
			getAllNotes();

			$scope.error = response.data;

		});
	}

	getAllNotes();
});