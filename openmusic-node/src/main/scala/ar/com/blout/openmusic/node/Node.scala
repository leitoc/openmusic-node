package ar.com.blout.openmusic.node

import org.apache.logging.log4j.LogManager
import ar.com.blout.openmusic.node.services.SongService
import org.jboss.resteasy.spi.ResteasyDeployment
import org.jboss.resteasy.plugins.server.netty.NettyJaxrsServer
import java.util.Collections

object Node {

  val logger = LogManager.getLogger(this.getClass())
  val port = 8080

  def main(args: Array[String]): Unit = {

    logger trace "Comienza el proceso"
    var deployment = new ResteasyDeployment
    deployment.setResourceClasses(Collections.singletonList(classOf[SongService].getName()))

    var netty = new NettyJaxrsServer
    netty setPort port
    netty setDeployment deployment
    netty start

  }

}