'use strict';

angular.module('MGL_Task1_app').controller('Game_Controller',
		[ 'GameService', function(GameService) {
			var self = this;
			self.game = {};
			self.games = [];

			self.fetchAllGames = function(){
				GameService.fetchAllGames().then(function(data) {
					self.games = data;
				});
			}

			self.addGame = function(){
				return GameService.createGame(self.game).then( function() {
				self.fetchAllGames();
				});
			}
				
			self.deleteGame = function(gameToDelete){
				return GameService.deleteGame(gameToDelete).then( function() {
					self.fetchAllGames();
				});
			}
			
			self.selectGame = function(gameToUpdate){
				self.game = gameToUpdate;
			}
			
			self.fetchAllGames();
		} ]);
