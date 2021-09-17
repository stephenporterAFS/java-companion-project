'use strict';

angular.module('GameApp').controller('GameController',
		[ 'GameService', function(GameService) {
			var vm = this;
			vm.game = {
				game_id : '',
				game_name : '',
				game_genre : ''
			};
			vm.games = [];

			vm.fetchAllGames = function(){
				GameService.fetchAllGames().then(function(data) {
					vm.games = data;
				}).finally(function(){
					vm.game = {};
				});
			}

			vm.addGame = function(){
				return GameService.createGame(vm.game).then( function() {
					vm.fetchAllGames();
				});
			}
			
			vm.loadGame = function(gameToUpdate){
				vm.game = angular.copy(gameToUpdate);
			}
			
			vm.updateGame = function(){
				return GameService.updateGame(vm.game).then( function() {
					vm.fetchAllGames();
				});
			}
			
			vm.deleteGame = function(gameId){
				return GameService.deleteGame(gameId).then( function() {
					vm.fetchAllGames();
				});
			}
			
			vm.fetchAllGames();
		} ]);
