package ar.com.sideeffect.openmusic.node.test

import org.specs2.mutable.Specification
import org.specs2.matcher.ShouldMatchers
import org.specs2.mutable._
import ar.com.blout.openmusic.node.metadata.Metadata
import org.junit.runner.RunWith
import org.specs2.runner.JUnitRunner
import ar.com.blout.openmusic.node.configuration.Configuration

@RunWith(classOf[JUnitRunner])
class PlaylistTest extends Specification {

  "Song metadata" should {
    "be transformed into M3U line" in {

      var config = getClass.getClassLoader.getResource("configuration.properties")
      Configuration config config.getPath
      var port = Configuration getInt "port"

      var metadata = new Metadata
      metadata.autor = "Mago de Oz"
      metadata.path = "/algun/path/loco/desde-mi-cielo.mp3"
      metadata.nombre = "Desde mi cielo"
      metadata.uuid = metadata.path.hashCode()

      var result = metadata.toM3u

      //Primero se ira por el camino de no especificar 
      //la duracion de la pista, por eso el "-1"
      var expected = "#EXTINF:-1,Mago de Oz - Desde mi cielo\n" +
        "http://localhost:" + port + "/openmusic/music/song/" + metadata.uuid

      result must be equalTo (expected)
    }
  }

}