package ar.com.blout.openmusic.node.metadata

import java.util.Arrays
import com.google.common.io.Files
import java.io.File
import scala.collection.JavaConversions._
import scala.collection.mutable.ListBuffer
import java.security.MessageDigest
import java.util.UUID
import scala.collection.immutable.StringOps
import ar.com.blout.openmusic.node.configuration.Configuration
import org.apache.logging.log4j.LogManager

/**
 *
 */
object MetadataManager {

  var logger = LogManager.getLogger(this.getClass())

  def all: java.util.Collection[Metadata] = {

    return asJavaCollection(new File(Configuration getString "folder")
      .listFiles()
      .filter({ elem => elem.isFile() })
      .map({ elem => this createMetadata elem })
      .toList)

  }

  def find(id: Int): Metadata = {
    return this.all.find { elem => elem.uuid.equals(id) }.get
  }

  def createMetadata(file: File): Metadata = {
    var metadata = new Metadata
    metadata.uuid = file.getPath.hashCode
    metadata.nombre = file.getName()
    metadata.path = file.getAbsolutePath()
    return metadata
  }
}