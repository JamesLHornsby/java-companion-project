<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="mgl" %>
    <!DOCTYPE html>
    <html>

    <head>
        <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.7.8/angular.min.js"></script>
        <script src="resources/static/js/app.js" /></script>
        <script src="resources/static/js/service/game.service.js"></script>
        <script src="resources/static/js/controller/game.controller.js"></script>

        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
		<link rel="stylesheet" href="resources/style.css">
        <title>Mist Library Task 1-Games</title>
        <style type="text/css">
            body {
            	background-image:
            		url('https://ak6.picdn.net/shutterstock/videos/1024598666/thumb/1.jpg');
            	background-repeat: no-repeat;
            	background-size: cover;
            }
        </style>
        <link rel="apple-touch-icon" sizes="180x180" href="/android-chrome-192x192.png">
    	<link rel="icon" type="image/png" sizes="32x32" href="resources/static/images/favicon-32x32.png">
    	<link rel="icon" type="image/png" sizes="16x16" href="resources/static/images/favicon-16x16.png">
    </head>

    <body ng-app="MGL_Task1_app" class="ng-cloak">
        <mgl:myNav/>
        <br>
        <div class="container" ng-controller="Game_Controller as ctrl">
            <div class="panel panel-default">
                <div class="panel-heading text-light"><span class="lead">Game Registration Form </span></div>
                <div class="formcontainer">
                    <form ng-submit="ctrl.addGame()" name="gameForm" class="form-horizontal">
                        <input type="hidden" ng-model="ctrl.game.gameid" />
                        <div class="row">
                            <div class="form-group col-md-12">
                                <label class="col-md-2 control-lable text-light" for="game_name">Name (Required)</label>
                                <div class="col-md-7">
                                    <input type="text" ng-model="ctrl.game.gameName" id="gameName" class="gameName form-control input-sm" placeholder="Enter the name of the new game [required]" required ng-minlength="3" />
                                    <div class="has-error" ng-show="gameForm.$dirty">
                                        <span ng-show="gameForm.game_name.$error.required">This is a required field</span>
                                        <span ng-show="gameForm.game_name.$error.minlength">Minimum length required is 3</span>
                                        <span ng-show="gameForm.game_name.$invalid">This field is invalid </span>
                                    </div>
                                </div>
                            </div>
                        </div>


                        <div class="row">
                            <div class="form-group col-md-12">
                                <label class="col-md-2 control-lable text-light" for="game_genre">Game Genre</label>
                                <div class="col-md-7">
                                    <input type="text" ng-model="ctrl.game.gameGenre" id="gameGenre" class="form-control input-sm" placeholder="Enter the genre of the new game" />
                                </div>
                            </div>
                        </div>

                        <div class="row">
                            <div class="form-actions floatRight">
                                <!--  <input type="submit" id="add_button" value="Add" class="btn btn-primary btn-sm">-->
                                <button ng-if="ctrl.game.gameId" type="submit" id="add_button" class="btn btn-success btn-sm">Update</button>
                                <button ng-if="!ctrl.game.gameId" type="submit" id="add_button" class="btn btn-primary btn-sm">Add</button>
                                <button ng-click="ctrl.reset()" id="clear" type="reset" class="btn btn-danger btn-sm">Clear</button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
            <div class="panel panel-default">
                <!-- Default panel contents -->
                <div class="panel-heading text-light"><span class="lead">List of all current games</span></div>
               <!--  
                <span data-ng-if="ctrl.genres.length > 1"><span class="lead"> | </span>
                	<label style="color: white" class="lead" for="select_genre_filter">Filter by Genre</label>
                	 <select id="select_genre_filter"
                	 		 data-ng-options="genre.name as genre.name for genre in ctrl.genres" 
                	 		 data-ng-model="ctrl.selectedGenre" 
                	 		 data-ng-change="ctrl.fetchAllGames()">
                	 </select>
                	</span> -->
                
                
                <div class="tablecontainer">
                    <table class="table table-dark table-striped text-light">
                        <thead>
                            <tr>
                                <th>Game Name</th>
                                
                                <th>Game Genre</th>
                                <th>
                                	<span data-ng-if="ctrl.genres.length > 1"><span class="lead"> | </span>
                                	<label  for="select_genre_filter" > Select Genre </label>
                                	<select id="select_genre_filter" class="btn btn-secondary btn-sm" name="gameFilter"
                                	data-ng-options="genre.name as genre.name for genre in ctrl.genres" 
		                	 		 data-ng-model="ctrl.selectedGenre" 
		                	 		 data-ng-change="ctrl.fetchAllGames()">
                	 		 
                                
                                	</select>
                                </span>
									
								</th>
                                <th></th>
                                <th></th>
                                <th width="20%"></th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr ng-repeat="currentGame in ctrl.games">
                                <td><span ng-bind="currentGame.gameName"></span></td>
                                <td><span ng-bind="currentGame.gameGenre"></span></td>
                                <td></td>
                                <td><button data-ng-click="ctrl.selectGame(currentGame)" class="btn btn-secondary btn-sm">Select</button></td>
                                <td><button data-ng-click="ctrl.deleteGame(currentGame)" class="btn btn-secondary btn-sm">Delete</button></td>
                                <td>
                                </td>
                            </tr>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>

    </body>
    <script type="text/javascript"></script>

    </html>