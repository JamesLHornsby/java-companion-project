'use strict';

angular.module('MGL_Task1_app').controller('Game_Controller',
		[ 'GameService', function(GameService) {
			var self = this;
			self.game = {
				id : '',
				name : '',
				genre : ''
			};
			
			self.games = [];
			self.genres = [{name: 'All'}]; 
			self.selectedGenre = 'All';
			self.selectedOrder = 'byId';

			self.fetchAllGames = function(){
				if (self.selectedGenre == 'All') {
				GameService.fetchAllGames().then(function(data) {
					self.games = data;
					if(self.games.length > 0){
							self.genres = parseGenres();	
						}else{
							self.genres = [{name: 'All'}];//clear
						}
				})
				} else {
					GameService.filterByGenre(self.selectedGenre).then(function(data) {
						self.games = data;
						
					});
				}
			}
			

			
			function parseGenres(){
				var strArray = [];
				var genreArray = [{name: 'All'}];
				self.games.forEach((game) =>{
					strArray.push( game.gameGenre );
				})
				strArray = Array.from( new Set(strArray));
				//lets make an object list for easy handling.
				strArray.forEach((genre) =>{
					genreArray.push({ name : genre });
				})
				return genreArray;
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
			//clear button
			self.reset = function() {
				self.game = {};
			}
			

			self.fetchAllGames();
		} ]);
