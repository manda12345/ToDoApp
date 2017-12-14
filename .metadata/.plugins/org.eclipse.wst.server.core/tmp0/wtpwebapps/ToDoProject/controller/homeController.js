var todoApp = angular.module('ToDo');

todoApp.controller('homeController', function($scope, toastr, $interval,homeService,$filter, $uibModal,
		loginService,$state,$http,$location) {

	$scope.noteFilter = null;

	$scope.searchFilter = function (note) {
		var re = new RegExp($scope.nameFilter, 'i');
		return !$scope.nameFilter || re.test(note.title) || re.test(note.description);
	};

	//colors added in notes 
	
	$scope.AddNoteColor = "#ffffff";

	$scope.addNoteColorChange = function(color) {
		$scope.AddNoteColor = color;
		console.log(color);
	}

	$scope.colors = [

	{
		"color" : '#ffffff',
		"path" : 'images/white.png'
	}, {
		"color" : '#e74c3c',
		"path" : 'images/Red.png'
	}, {
		"color" : '#ff8c1a',
		"path" : 'images/orange.png'
	}, {
		"color" : '#fcff77',
		"path" : 'images/lightyellow.png'
	}, {
		"color" : '#80ff80',
		"path" : 'images/green.png'
	}, {
		"color" : '#99ffff',
		"path" : 'images/skyblue.png'
	}, {
		"color" : '#0099ff',
		"path" : 'images/blue.png'
	}, {
		"color" : '#9966ff',
		"path" : 'images/purple.png'
	}, {
		"color" : '#ff99cc',
		"path" : 'images/pink.png'
	}, {
		"color" : '#d9b38c',
		"path" : 'images/brown.png'
	}, {
		"color" : '#bfbfbf',
		"path" : 'images/grey.png'
	} ];

	if ($state.current.name == "home") {
		$scope.topNavBarColor = "#ffbb33";
		$scope.navBarHeading = "Fundoo Keep";
	} else if ($state.current.name == "archive") {
		$scope.topNavBarColor = "#669999";
		$scope.navBarHeading = "Archive";
	} else if ($state.current.name == "trash") {
		$scope.topNavBarColor = "#636363";
		$scope.navBarHeading = "Trash";
	}
	
//	logout

	$scope.signout = function() {

		localStorage.removeItem('token');
		$location.path("/login");
	}

//	side nav bar

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

//	add the notes

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

//	gets the all notes

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

//	delete the notes

	$scope.deleteNotes = function(note) {
		console.log("note id" + note.noteId);
		var notes = homeService.deleteNotes(note);
		notes.then(function(response) {
			console.log("delete sucessfully....")

		}),function(response) {
			$scope.error = response.data.message;
		};
	}
	
//update notes
	
	$scope.updateNotes = function(note) {
		console.log("inside update notes")
		console.log(note);
		var a = homeService.updateNotes(note);
		
		a.then(function(response) {
			
			getAllNotes
			
			}, function(response) {
		});
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

//	list view of notes

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

		if(note.archive==false)
		{
			note.archive=true;
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
		else
		{
			note.archive= false;
			console.log(note)
			var notes = homeService.updateNotes(note);
			notes.then(function(response) {

				getAllNotes();

			}, function(response) {

				console.log(response.data);
				getAllNotes();
				$scope.error = response.data;

			});
			getAllNotes();
		}
	}

	// add note to trash

	$scope.addToTrash= function(note) {

		if(note.emptyTrash==false)
		{
			note.emptyTrash=true;
			console.log()

			var notes = homeService.noteTrash(note);

			notes.then(function(response) {
				console.log("hai");
				getAllNotes();
			}, function(response) {			
				getAllNotes();
			});
			getAllNotes();
		}
		else
		{
			note.emptyTrash= false;
			console.log(note)
			
			var notes = homeService.updateNotes(note);
			notes.then(function(response) {

				getAllNotes();

			}, function(response) {

				console.log(response.data);
				getAllNotes();
				$scope.error = response.data;

			});
			getAllNotes();
		}
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

	//pin and unpinned

	$scope.addTopin = function(note) {
		var notes;
		if(note.pin==false)
		{
			notes = homeService.addTopin(note.noteId, true);
		}else{
			notes = homeService.addTopin(note.noteId, false);
		}

		notes.then(function(response) {

			getAllNotes();

		});
	}

	//Edit note

	$scope.showModal = function(note) {
		
		modalInstance = $uibModal.open({
			templateUrl : 'htmlpages/showDialog.html',
			scope : $scope,
			size : 'md'
		});
	};
	
	// social share
	
	$scope.fbShareInit = function(note) {
		
		FB.init({
			
			appId : '1347872695339978',
			status : true,
			cookie : true,
			xfbml : true,
			version : 'v2.4'
		});

		FB.ui({
			
			method : 'share_open_graph',
			
			action_type : 'og.likes',
			
			action_properties : JSON.stringify({
				
				object : {
					
					'og:title' : note.title,
					'og:description' : note.description
				}
			})
		},function(response) {
			
            if (!response || response.error) {
            	
             alert('Error while posting data');
             
            } else {
            	
            	alert('posting completed Successfully');
            }
		});
	};
	
	// Make a copy
	
	$scope.copy = function(note) {
		
		
		var notes = homeService.saveNotes(note);
		
		notes.then(function(response) {
			
			getAllNotes();
			
		}, function(response) {
			
		});
	}
	
	getUser();

	function getUser() {
		var a = homeService.getUser();
		a.then(function(response) {
			$scope.User = response.data;
			console.log(response.data);
		}, function(response) {
			// console.log("Not Found");
		});
	}

});