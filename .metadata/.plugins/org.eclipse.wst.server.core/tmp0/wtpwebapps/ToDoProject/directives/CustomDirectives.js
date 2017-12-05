var todoApp = angular.module('ToDo');
todoApp.directive('topNavBar', function() {
	return{
		templateUrl : 'htmlpages/TopNavBar.html'
	}
});
todoApp.directive('sideNavBar', function() {
	return{
		templateUrl : 'htmlpages/SideNavBar.html'
	}
});


todoApp.directive('contenteditable', [ '$sce', function($sce) {
	
	return {
		  restrict: 'A', // only activate on element attribute
		  require: '?ngModel', // get a hold of NgModelController
		  link: function(scope, element, attrs, ngModel) {
		      if (!ngModel) return; // do nothing if no ng-model

		    // Specify how UI should be updated
		      ngModel.$render = function() {
		        element.html($sce.getTrustedHtml(ngModel.$viewValue || ''));
		        read(); // initialize
		      };

		      // Listen for change events to enable binding
		      element.on('blur keyup change', function() {
		        scope.$evalAsync(read);
		      });

		      // Write data to the model
		      function read() {
		        var html = element.html();
		        // When we clear the content editable the browser leaves a <br> behind
		        // If strip-br attribute is provided then we strip this out
		        if ( attrs.stripBr && html == '<br>' ) {
		          html = '';
		        }
		        ngModel.$setViewValue(html);
		      }
		    }
		  };
} ]);