requirejs.config({
	
	paths: {
		libs:'libs',
		templates:'../templates'
	       },
	shim: {
		"handlebars":{
			exports: 'Handlebars'
		},
		"underscore":{
			exports: '_'
		},
		"backbone":{
			exports:'Backbone'
		}

	      }

});



define([
	"libs/underscore",
	"libs/backbone",
	"libs/handlebars",
	"libs/text!templates/title.html"],




	function(_,Backbone,Handlebars,titleTemplate){

	console.log(Backbone);
	console.log(Handlebars);
	console.log(titleTemplate);	


});