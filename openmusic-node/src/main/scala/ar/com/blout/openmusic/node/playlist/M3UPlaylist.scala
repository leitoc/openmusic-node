package ar.com.blout.openmusic.node.playlist

import ar.com.blout.openmusic.node.metadata.Metadata

trait M3UPlaylist {

  def toM3U = m3uElements.foldLeft("#EXTM3U")((b, a) => b + "\n" + a)

  def m3uElements: List[String];

}