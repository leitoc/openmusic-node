package ar.com.blout.openmusic.node.services

import javax.ws.rs.Path
import javax.ws.rs.GET
import javax.ws.rs.Produces
import ar.com.blout.openmusic.node.metadata.MetadataManager
import ar.com.blout.openmusic.node.playlist.PlaylistManager

@Path("/openmusic/playlist")
class PlaylistService extends Jsonable {

  @GET
  @Path("/list")
  @Produces(Array("application/json"))
  def list: String = this toJson (PlaylistManager.all)

}