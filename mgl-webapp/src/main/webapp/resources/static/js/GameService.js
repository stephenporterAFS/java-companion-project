'use strict';

angular.module('GameApp').service('GameService', ['$http', '$log', function($http, $log) {

		var REST_SERVICE_URI = 'game/';

		var factory = {
			fetchAllGames : fetchAllGames,
			createGame : createGame,
			updateGame : updateGame,
			deleteGame : deleteGame,
			findGameById : findGameById
		};

		return factory;

		function fetchAllGames() {
			return $http.get(REST_SERVICE_URI + 'getAll').then(function(response) {
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
		
		function updateGame(game) {
			return $http.put(REST_SERVICE_URI, game).then(function(response) {
				return response.data;
				}
			);
		}
		
		function deleteGame(id) {
		return $http.delete(REST_SERVICE_URI + id).then(function(response) {
			if(!response.data) {
				$log.debug("No game deleted with id");				
			}
			return response.data;
				}
			);
		}
		
		function findGameById(id) {
		return $http.get(REST_SERVICE_URI + id).then(function(response) {
				return response.data;
				}
			);
		}	
		
}]);
