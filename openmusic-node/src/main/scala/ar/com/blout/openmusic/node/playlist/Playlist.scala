package ar.com.blout.openmusic.node.playlist

import ar.com.blout.openmusic.node.metadata.Metadata

class Playlist extends M3UPlaylist {

  var elements: List[Metadata] = List()

  def add(element: Metadata) = elements = elements :+ element

  def m3uElements = elements.map({ elem => elem.toM3u })

}