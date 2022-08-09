'use strict';

angular.module('MGL_Task1_app').factory('GameService', ['$http','$log', function($http, $log) {

		var REST_SERVICE_URI = 'game/';

		var factory = {
			fetchAllGames : fetchAllGames,
			createGame : createGame,
			deleteGame : deleteGame,
			updateGame : updateGame
		};

		return factory;

		function fetchAllGames() {
			return $http.get(REST_SERVICE_URI).then(function(response) {
					return response.data;
				}
			);
		}

		function createGame(game) {
			return $http.post(REST_SERVICE_URI, game).then(function(response) {
					return response.data;
				}
			);
		}
		
		// localhost:8081/game/1 DELETE
		function deleteGame(game) {
			return $http.post(REST_SERVICE_URI + 'delete',game).then( function( response ) {
				if(response.data) {
					$log.info("Successully deleted game with id: " + game);
				} else {
					$log.debug("No Game Deleted with id: " + game);
				}
				return response.data;
			});
		}
		
		function updateGame(game) {
			return $http.post(REST_SERVICE_URI, game).then(function(response) {
				return response.data;
			});
		}

}]);
