package ar.com.blout.openmusic.node.metadata

import java.io.File
import ar.com.blout.openmusic.node.configuration.Configuration
import ar.com.blout.openmusic.node.playlist.M3U
import com.google.gson.annotations.Expose

class Metadata extends M3U {

  var nombre: String = _
  var autor: String = _
  var nodo: String = _
  var path: String = _
  var uuid: Int = _

  /**
   * Se encarga de obtener ese archivo de media y devolverlo para poder ser consumido
   */
  def retrieve: File = new File(path)

  // M3U implementation
  def duration = "-1"
  def title = autor + " - " + nombre
  def url = "http://localhost:" + (Configuration getInt "port") + "/openmusic/music/song/" + uuid

}