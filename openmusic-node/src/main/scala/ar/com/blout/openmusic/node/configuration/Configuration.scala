package ar.com.blout.openmusic.node.configuration

import org.apache.commons.configuration.PropertiesConfiguration

/**
 * Wrapper para la configuracion.
 */
object Configuration {

  var configuration: PropertiesConfiguration = _

  def config(configurationPath: String) = configuration = new PropertiesConfiguration(configurationPath)

  def getInt(option: String): Int = configuration getInt option

  def getString(option: String): String = configuration getString option

}