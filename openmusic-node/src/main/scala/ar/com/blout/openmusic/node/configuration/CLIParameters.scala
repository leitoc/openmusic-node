package ar.com.blout.openmusic.node.configuration

import com.beust.jcommander.Parameter

class CLIParameters {

  @Parameter
  var parameters = new java.util.ArrayList[String]

  @Parameter(names = Array("-p"), description = "Archivo de Configuracion")
  var folder: String = _

}