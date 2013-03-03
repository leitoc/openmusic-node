package ar.com.blout.openmusic.node.metadata

import java.util.Arrays
import com.google.common.io.Files
import java.io.File
import ar.com.blout.openmusic.node.configuration.Configuration
import scala.collection.JavaConversions._
import scala.collection.mutable.ListBuffer
import java.security.MessageDigest
import java.util.UUID
import scala.collection.immutable.StringOps

/**
 *
 */
object MetadataManager {

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
    metadata.nombre = file.getName()
    metadata.uuid = file.getAbsolutePath().hashCode()
    metadata.path = file.getAbsolutePath()
    return metadata
  }
}