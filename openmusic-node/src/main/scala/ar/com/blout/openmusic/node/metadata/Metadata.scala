package ar.com.blout.openmusic.node.metadata

import java.io.File
import ar.com.blout.openmusic.node.configuration.Configuration

class Metadata {

  var uuid: Int = _
  var nombre: String = _
  var autor: String = _
  var nodo: String = _
  var path: String = _

  /**
   * Se encarga de obtener ese archivo de media y devolverlo para poder ser consumido
   */
  def retrieve: File = {
    return new File(path)
  }

}