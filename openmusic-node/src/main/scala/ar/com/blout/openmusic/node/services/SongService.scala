package ar.com.blout.openmusic.node.services

import javax.ws.rs.Path
import javax.ws.rs.GET

@Path("/openmusic")
class SongService {

  @GET
  @Path("/song")
  def song: String = {
    return "A ver si esto anda"
  }

}