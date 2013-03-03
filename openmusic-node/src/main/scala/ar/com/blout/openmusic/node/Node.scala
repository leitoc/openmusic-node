package ar.com.blout.openmusic.node

import org.apache.logging.log4j.LogManager
import ar.com.blout.openmusic.node.services.SongService
import org.jboss.resteasy.spi.ResteasyDeployment
import org.jboss.resteasy.plugins.server.netty.NettyJaxrsServer
import java.util.Collections
import ar.com.blout.openmusic.node.metadata.Metadata
import com.beust.jcommander.JCommander
import ar.com.blout.openmusic.node.configuration.CLIParameters
import ar.com.blout.openmusic.node.configuration.CLIParameters
import ar.com.blout.openmusic.node.configuration.Configuration

object Node {

  var logger = LogManager.getLogger(this.getClass())

  def main(args: Array[String]): Unit = {

    logger info "Comienza el proceso"
    configure(args)
    netty(Configuration getInt "port", deployment) start

  }

  /*
   * AUXILIARES
   */

  /**
   * Crea el servidor netty que permite escuchar en un puerto especificado las peticiones rest
   */
  def netty(port: Int, deployment: ResteasyDeployment): NettyJaxrsServer = {
    var netty = new NettyJaxrsServer
    netty setPort port
    netty setDeployment deployment
    return netty
  }

  /**
   * Genera las clases que devuelven las especificaciones de los servicios rest
   */
  def deployment: ResteasyDeployment = {
    var deployment = new ResteasyDeployment()
    deployment.setResourceClasses(Collections.singletonList(classOf[SongService].getName()))
    return deployment
  }

  def configure(args: Array[String]) = {
    var cli = new CLIParameters
    new JCommander(cli, args.toArray: _*)
    logger info cli.folder
    Configuration config cli.folder
  }

}