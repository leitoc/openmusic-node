requirejs.config({
	
	paths: {
		libs:'libs',
		templates:'../templates',
		jquery:'libs/jquery-1.9.0.min'
	       },
	shim: {
		"libs/handlebars":{
			exports: 'Handlebars'
		},
		"libs/underscore":{
			exports: '_'
		},
		"libs/backbone":{
			exports:'Backbone',
			deps:['libs/underscore']
		}

	      }

});



require([
	"views/HomeView",
	"views/SongsView"
	],

	function(HomeView,SongsView){

	new HomeView();
	new SongsView();



});