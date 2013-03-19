package ar.com.blout.openmusic.node.playlist

trait M3UElement {

  def toM3u = "#EXTINF:" + duration + "," + title + "\n" + url

  def duration: String;
  def title: String;
  def url: String;

}