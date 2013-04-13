package model.playlist

import java.io.File
import com.google.common.io.Files
import com.google.common.base.Charsets

trait M3UPlaylist {

  def toM3U = m3uElements.foldLeft("#EXTM3U")((b, a) => b + "\n" + a)

  def m3uElements: List[String];

  def retrieve: File = {
    var file = new File("/tmp/playlist.m3u")
    Files.write(this.toM3U, file, Charsets.UTF_8)
    file
  }

}