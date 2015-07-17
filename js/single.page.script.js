	// create the module and name it scotchApp
	var scotchApp = angular.module('scotchApp', ['ngRoute']);

	// configure our routes
	scotchApp.config(function($routeProvider) {
		$routeProvider

			// route for the home page
			.when('/', {
				templateUrl : 'pages/home.html',
				controller  : 'mainController'
			})

			// route for the about page
			.when('/about', {
				templateUrl : 'pages/upladMvieImg.html',
				controller  : 'aboutController'
			})

			// route for the contact page
			.when('/contact', {
				templateUrl : 'pages/movieInfo.html',
				controller  : 'contactController'
			});
	});

	scotchApp.service('httpService', function($http, $q) {
		
		
		this.doGet = function(reqParams, callback) {
//			loadingIndicatorDisplay();
			var getRequestPromise = $q.defer();

			$http({
	    	    url: reqParams.url,
	    	    method	: 'GET',
	    	    headers	: {'Content-Type': 'application/json'},
	            dataType: 'json'
	    	}).success(function(respObj) {  
	    		if (!angular.isUndefined(reqParams.callback)) {
	    			var respData = reqParams.callback(respObj);
	    			
	    			//resolves the derived promise with the value
	    			getRequestPromise.resolve(respData);

	    			//hide the loading icon
//	    			loadingIndicatorHide();
	    		} else {
	    			//no callback provided, resolve the response object
	    			getRequestPromise.resolve(respObj);
//	    			loadingIndicatorHide();
	    		}
	    	}).error(function(respObj) {
	    		getRequestPromise.reject(""); //rejects the derived promise with the reason (no reason provided here, since it is handled by application controller)
//	    		loadingIndicatorHide();
	    	});
					
			return getRequestPromise.promise;
		};
		
		this.doPost = function(reqParams) {
//			loadingIndicatorDisplay();
			return $http({
	    	    url: reqParams.url,
	    	    method	:	"POST",
	    	    headers	: 	{	
	    	    				'Content-Type'		: 	'application/json',
	    	    				'OWASP_CSRFTOKEN' 	:	reqParams.csrfToken 
							},			
	    	    data	:	reqParams.data            
	    	});
		};
		
		
	});
	
	
	
	// create the controller and inject Angular's $scope
	scotchApp.controller('mainController', function($scope) {
		// create a message to display in our view
		$scope.message = 'Everyone come and see how good I look!';
	});

	scotchApp.controller('aboutController', function($scope) {
		$scope.message = 'Look! I am an about page.';
	});

	scotchApp.controller('contactController', function($scope, httpService) {
		
		$scope.message = 'Contact us! JK. This is just a demo.';
		
		$scope.submitForm = function () {
			console.log("submit")
			var requestParams =	{
								'url'		: 	'service/saveMovieInfo',
								'csrfToken'	:	$scope.csrfToken,								
								'data' 		: 	$scope.model 
							};
			
			var requst = httpService.doPost(requestParams);
			
			requst.success(function(respObj) {
				console.log(JSON.stringify(respObj));
			});
			
			requst.error(function(respObj) {
				alert("ERR :"+respObj);
//				loadingIndicatorHide();
//				pocAppModel.failureAlert($scope, alertDataSaveFailure);
			});
		};
		
		
		//GET
		$scope.getMovieInfo = function () {
			console.log("get movie info");
			var requestParams = {'url' : 'service/getMovieInfo/' + $scope.movieInfoId};
			
			var moveInfoReq = httpService.doGet(requestParams);
			
			moveInfoReq.then(function(respObj) {
				$scope.data = respObj.data;
				$scope.movInfoBean = $scope.data.movInfoBean;
				console.log(JSON.stringify(respObj));
				
			}, function(respObj) {
				alert("ERR :"+respObj);
				//pocAppModel.failureAlert($scope, ajaxRetrievalFailure);
			});
		};
		
		
		
		
		
		
	});
