/*Copyright (c) 2013 -  SideEffectIdeas 
*
*	Module openmusic-node
*
*   Licensed under the Apache License, Version 2.0 (the "License");
*   you may not use this file except in compliance with the License.
*   You may obtain a copy of the License at
*
*       http://www.apache.org/licenses/LICENSE-2.0
*
*   Unless required by applicable law or agreed to in writing, software
*   distributed under the License is distributed on an "AS IS" BASIS,
*   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
*   See the License for the specific language governing permissions and
*   limitations under the License.
*   
*   Project: http://github.com/SideEffectIdeas/openmusic-node
*   Wiki: http://github.com/SideEffectIdeas/openmusic-node/wiki
*   Mailing list: http://groups.google.com/group/sideEffectIdeas
*/

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
import ar.com.blout.openmusic.node.services.PlaylistService
import scala.collection.JavaConverters
import ar.com.blout.openmusic.node.services.SongService
import ar.com.blout.openmusic.node.services.PlaylistService

object Node {

  var logger = LogManager.getLogger(this.getClass())

  def main(args: Array[String]): Unit = {

    logger info "Comienza el proceso"
    configure(args)
    logger.info(Configuration getString "folder")
    netty(Configuration getInt "port", deployment) start

  }

  /*
   * AUXILIARES
   */

  /**
   * Crea el servidor netty que permite escuchar en un puerto especificado las peticiones rest
   */
  def netty(port: Int, deployment: ResteasyDeployment): NettyJaxrsServer = {
    val netty = new NettyJaxrsServer
    netty setPort port
    netty setDeployment deployment
    return netty
  }

  /**
   * Genera las clases que devuelven las especificaciones de los servicios rest
   */
  def deployment: ResteasyDeployment = {
    val deployment = new ResteasyDeployment()
    val services = List(classOf[SongService], classOf[PlaylistService])
    val servicesNames = services map {
      elem => elem.getName
    }
    deployment.setResourceClasses(JavaConverters.asJavaListConverter(servicesNames).asJava)
    return deployment
  }

  def configure(args: Array[String]) = {
    val cli = new CLIParameters
    new JCommander(cli, args.toArray: _*)
    logger info cli.folder
    Configuration config cli.folder
  }

}