angular.module('workout', ['ngRoute']).run(['$rootScope', '$location', function ($rootScope, $location) {

}])

.config(function($routeProvider, $httpProvider) {

    $routeProvider.when('/', {
        templateUrl: 'login.html',
        controller: 'navigationCtrl'
    }).when('/login', {
        templateUrl: 'login.html',
        controller: 'navigationCtrl'
    }).when('/main', {
        templateUrl: 'main.html',
        controller: 'trainingCtrl'
    }).when('/register', {
        templateUrl: 'register.html',
        controller: 'navigationCtrl'
    }).when('/logout', {
        templateUrl: 'login.html',
        controller: 'navigationCtrl'
    }).otherwise('/');

    $httpProvider.defaults.headers.common['X-Requested-With'] = 'XMLHttpRequest';

}).controller('navigationCtrl', function($rootScope, $scope, $http, $location, $route) {
    $scope.tab = function(route) {
        return $route.current && route === $route.current.controller;
    };

    $scope.go = function(path) {
        $location.path(path);
    };

    var authenticate = function(credentials, callback) {
        var headers = credentials ? {
            authorization: "Basic " + btoa(credentials.email + ":" + credentials.password)
        } : {};

        $http.get('user/login', {
            headers: headers
        }).success(function(data) {
            if (data.name) {
                $rootScope.authenticated = true;
            } else {
                $rootScope.authenticated = false;
            }
            callback && callback($rootScope.authenticated);
        }).error(function() {
            $rootScope.authenticated = false;
            callback && callback(false);
        });
    };

    $scope.credentials = {};
    $scope.login = function() {
        authenticate($scope.credentials, function(authenticated) {
            if (authenticated) {
                console.log("Login succeeded")
                $location.path("/main");
                $scope.error = false;
                $rootScope.authenticated = true;
            } else {
                console.log("Login failed")
                $location.path("/login");
                $scope.error = true;
                $rootScope.authenticated = false;
            }
        })
    };

    var register = function(credentials) {
        $http.post('user/register', {
            userDTO: credentials
        }).success(function(data) {
            authenticate(credentials, function(authenticated) {
                if (authenticated) {
                    console.log("Login succeeded")
                    $location.path("/main");
                    $scope.error = false;
                    $rootScope.authenticated = true;
                } else {
                    console.log("Login failed")
                    $location.path("/login");
                    $scope.error = true;
                    $rootScope.authenticated = false;
                }
            })
        }).error(function() {
            console.log("Login failed")
            $location.path("/login");
            $scope.error = true;
            $rootScope.authenticated = false;
        });
    };

    $scope.register = function() {
        register($scope.credentials)
    };

}).controller('trainingCtrl', function($rootScope, $scope, $http, $location) {
    
	// initialize date picker
	$('#datetimePicker').datepicker({
	    format: 'dd-mm-yyyy',
	});
	$('#datetimePicker').datepicker("setDate", new Date());
	
 // Load modal
    $scope.$on('$viewContentLoaded', function(){
		$('#addExerciseModal').modal({
			blurring : true
		});
		
		$('#addExerciseTypeModal').modal({
			blurring : true
		});
    });
	
	getTrainings();
	getExerciseTypes();
	
	function getTrainings() {
		var selectedDate = $('#datetimePicker').datepicker('getFormattedDate');
		$http.get('/training/' + selectedDate).success(function(data) {
	        $scope.trainings = data;
	    }).error(function(error, status) {
	    });
	}
	
	function getExerciseTypes() {
		$http.get('/exerciseType').success(function(data) {
	        $scope.exerciseTypes = data;
	    }).error(function(error, status) {
	    });
	}
	
	$scope.logout = function() {
		$http.get('/logout', {}).success(function() {
			console.log("Logout succeeded")
			$rootScope.authenticated = false;
			$location.path("/login");
		}).error(function(data) {
			console.log("Logout failed")
			$rootScope.authenticated = false;
			$location.path("/login");
		});
	}
	
	$scope.addTraining = function() {
		$http.post('/training', {}).success(function(data) {
			getTrainings();
		}).error(function(data) {
			$location.path("/login");
		});
    };
    

	$scope.removeTraining = function(trainingId) {
		$http.delete('/training/' + trainingId, {}).success(function(data) {
			getTrainings();
		}).error(function(data) {
			$location.path("/login");
		});
    };
    
    $scope.removeExercise = function(exerciseId) {
		$http.delete('/exercise/' + exerciseId, {}).success(function(data) {
			getTrainings();
		}).error(function(data) {
			$location.path("/login");
		});
    };
    
    $scope.addExercise = function(trainingId) {
    	getExerciseTypes();
    	
    	$('#addExerciseModal').modal('show');
    	$('.ui.dropdown').dropdown('restore defaults');
    	$scope.currentTrainingId = trainingId;
    };
    
    $scope.addExerciseType = function() {
    	$('#addExerciseModal').modal('close');
    	$('#addExerciseTypeModal').modal('show');
    };
    
    $scope.addExerciseTypeSubmit = function(exerciseType) {
        $http.post('/exerciseType', exerciseType).success(function(data) {
                    console.log("succeeded")
        }).error(function() {
            console.log("failed")
        });
    };
    
    $scope.addExerciseSubmit = function(exercise) {
    	exercise.exerciseTypeId = $('.item.exerciseTypeInput.ng-binding.ng-scope.active.selected').attr('id');
        $http.post('/training/' + $scope.currentTrainingId +  '/exercise', exercise).success(function(data) {
        	getTrainings();
        }).error(function() {
            console.log("failed")
        });
    };
});