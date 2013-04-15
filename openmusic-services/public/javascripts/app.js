(function($){


    Song = Backbone.Model.extend({});

    Songs = Backbone.Collection.extend({
        model: Song,

        url:'http://localhost:9000/song/list',

    });

    var SongView = Backbone.View.extend({
        tagName: 'li',

        //template: Handlebars.compile( $('#song-template').html()),

        render: function(){
            //this.$el.html( this.template(this.model.toJSON()));
            console.log(this.model.toJSON().nombre);
            this.$el.append(this.model.toJSON().nombre)
            return this;
        }
    });

    var SongsView = Backbone.View.extend({
        tagName: 'ul',


        render:function(){
            var me = this;
            /*this.collection.fetch(
                {
                success:function(song,response){
                        //new SongView({model:song}).render();
                        var songView = new SongView({model:song});
                        console.log("$el: "+me.$el);
                        console.log(me);
                        me.$el.append(songView.render().el);
                    }
                } ); */


             this.collection.fetch({reset:false});
             this.collection.each(function(song){
                  var songView = new SongView({model:song});
                                          console.log("$el: "+me.$el);
                                          console.log(me);
                                          me.$el.append(songView.render().el);
             });

            return this;
        }
    });



    var songs = new Songs();
    /*songs.fetch(
    {
        success:function(model,response){
            //console.log(model.toJSON());
            var songView = new SongsView({model:model});
            songView.render();
        }
    }
    );
    */

    var songsView = new SongsView({collection:songs});
    console.log(songsView);
    console.log($(this.songs));
    $(this.songs).append("hola");
    $(this.songs).append(songsView.render().el)

})(jQuery);