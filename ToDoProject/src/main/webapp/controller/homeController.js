var todoApp = angular.module('ToDo');
todoApp.controller('homeController', function($scope, toastr, $interval,homeService,
		loginService,$state,$http) {
	
	$scope.signout = function() {

		localStorage.removeItem('token');
		$location.path("/login");
	}

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
	
	var getAllNotes = function() {

		var notes = homeService.getAllNotes();
		console.log("in this function");
		
		notes.then(function(response) {
			console.log(response.data);
			$scope.notes = response.data;
		}, function(response) {

			$scope.error = response.data.message;
		});

	}
	
	getAllNotes();
});