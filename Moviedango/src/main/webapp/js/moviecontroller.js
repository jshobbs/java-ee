/**
 * @author Jeff
 */
var dangoMovieApp = angular.module('dangoMovieApp', []);

dangoMovieApp.controller('movieSearchController', function($scope, $http) {
	$scope.movies = [];

	$scope.search = function() {
		//remove current results
		$scope.movies = [];
		$scope.messageText="";
		
		//search
		$http.get('/Moviedango/rest/movies',		
			{params: {
				movieName:$scope.searchMovieName, 
				movieStudio:$scope.searchStudio}})
			.success(function(data, status) {
				$scope.httpStatus = status;
				$scope.httpData = data;
				$scope.errorStatus=false;
				$scope.messageText="Found "+data.length;
				$scope.movies = data;
			})
			.error(function(data, status) {
				$scope.httpStatus = status;				
				$scope.httpData = data;
				$scope.errorStatus=true;
				$scope.messageText=data.error.code+ " "+ data.error.message;
			});		
	};
	
	$scope.moviesByTheater = function() {
		//remove current results
		$scope.movies = [];
		$scope.messageText="";
		
		//search
		$http.get('/Moviedango/rest/showtimes',		
			{params: {
				theaterId:$scope.theater.id}})
			.success(function(data, status) {
				$scope.httpStatus = status;
				$scope.httpData = data;
				$scope.errorStatus=false;
				$scope.messageText="Found "+data.length;
				$scope.movies = data;
			})
			.error(function(data, status) {
				$scope.httpStatus = status;				
				$scope.httpData = data;
				$scope.errorStatus=true;
				$scope.messageText=data.error.code+ " "+ data.error.message;
			});		
	};
});

dangoMovieApp.controller('addMovieController', function($scope, $http) {	
	
	$scope.create = function() {
		$scope.messageText="";
		
		$http.post('/Moviedango/rest/movies',
				{"movie":{"movieName":$scope.createMovieName,"playLength":$scope.createPlayLength,"description":$scope.createDescription,"studio":$scope.createStudio,"category":$scope.createCategory}})
			.success(function(data, status) {
				$scope.httpStatus = status;
				$scope.httpData = data;
				$scope.errorStatus=false;
				$scope.messageText="Created new movie with ID "+data.movie.id;				
			})
			.error(function(data, status) {
				$scope.httpStatus = status;				
				$scope.httpData = data;
				$scope.errorStatus=true;
				$scope.messageText=data.error.code+ " "+ data.error.message;
			});
	};
});

dangoMovieApp.controller('moviesReturnController', function($scope, $http) {
	$scope.allMovies = [];

	$scope.getAll = function() {
		//remove current results
		$scope.allMovies = [];
		$scope.messageText="";
		
		//search
		$http.get('/Moviedango/rest/movies')
			.success(function(data, status) {
				$scope.httpStatus = status;
				$scope.httpData = data;
				$scope.errorStatus=false;
				$scope.messageText="Found "+data.length;
				$scope.allMovies = data;
			})
			.error(function(data, status) {
				$scope.httpStatus = status;				
				$scope.httpData = data;
				$scope.errorStatus=true;
				$scope.messageText=data.error.code+ " "+ data.error.message;
			});		
	};
});

dangoMovieApp.controller('theatersReturnController', function($scope, $http) {
	$scope.allTheaters = [];

	$scope.getAllTheaters = function() {
		//remove current results
		$scope.allTheaters = [];
		$scope.messageText="";
		
		//search
		$http.get('/Moviedango/rest/theaters')
			.success(function(data, status) {
				$scope.httpStatus = status;
				$scope.httpData = data;
				$scope.errorStatus=false;
				$scope.messageText="Found "+data.length;
				$scope.allTheaters = data;
			})
			.error(function(data, status) {
				$scope.httpStatus = status;				
				$scope.httpData = data;
				$scope.errorStatus=true;
				$scope.messageText=data.error.code+ " "+ data.error.message;
			});		
	};
});

dangoMovieApp.controller('reviewsReturnController', function($scope, $http) {
	$scope.allReviews = [];

	$scope.getAllReviews = function() {
		//remove current results
		$scope.allReviews = [];
		$scope.messageText="";
		
		//search
		$http.get('/Moviedango/rest/reviews')
			.success(function(data, status) {
				$scope.httpStatus = status;
				$scope.httpData = data;
				$scope.errorStatus=false;
				$scope.messageText="Found "+data.length;
				$scope.allReviews = data;
			})
			.error(function(data, status) {
				$scope.httpStatus = status;				
				$scope.httpData = data;
				$scope.errorStatus=true;
				$scope.messageText=data.error.code+ " "+ data.error.message;
			});		
	};
});

dangoMovieApp.controller('theaterSearchController', function($scope, $http) {
	$scope.foundTheaters = [];

	$scope.searchTheater = function() {
		//remove current results
		$scope.foundTheaters = [];
		$scope.messageText="";
		
		//search
		$http.get('/Moviedango/rest/theaters',		
			{params: {
				theaterName:$scope.searchTheaterName}})
			.success(function(data, status) {
				$scope.httpStatus = status;
				$scope.httpData = data;
				$scope.errorStatus=false;
				$scope.messageText="Found "+data.length;
				$scope.foundTheaters = data;
			})
			.error(function(data, status) {
				$scope.httpStatus = status;				
				$scope.httpData = data;
				$scope.errorStatus=true;
				$scope.messageText=data.error.code+ " "+ data.error.message;
			});		
	};
	
	$scope.theatersByMovie = function() {
		//remove current results
		$scope.foundTheaters = [];
		$scope.messageText="";
		
		//search
		$http.get('/Moviedango/rest/showtimes',		
			{params: {
				movieId:$scope.movie.id}})
			.success(function(data, status) {
				$scope.httpStatus = status;
				$scope.httpData = data;
				$scope.errorStatus=false;
				$scope.messageText="Found "+data.length;
				$scope.foundTheaters = data;
			})
			.error(function(data, status) {
				$scope.httpStatus = status;				
				$scope.httpData = data;
				$scope.errorStatus=true;
				$scope.messageText=data.error.code+ " "+ data.error.message;
			});		
	};
});