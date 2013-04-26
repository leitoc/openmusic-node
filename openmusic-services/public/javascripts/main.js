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
	"libs/underscore",
	"libs/backbone",
	"views/HomeView"
	],

	function(_,Backbone,HomeView){

	var homeView = new HomeView();


});