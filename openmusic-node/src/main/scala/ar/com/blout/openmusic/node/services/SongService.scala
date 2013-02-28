package ar.com.blout.openmusic.node.services

import javax.ws.rs.Path
import javax.ws.rs.GET
import ar.com.blout.openmusic.node.metadata.MetadataManager
import ar.com.blout.openmusic.node.metadata.Metadata
import javax.ws.rs.Produces
import com.google.gson.Gson
import javax.ws.rs.core.MediaType
import java.io.File
import com.google.gson.GsonBuilder
import javax.ws.rs.PathParam

@Path("/openmusic/music")
class SongService {

  def json = new GsonBuilder().setPrettyPrinting().create();

  @GET
  @Path("/song/{id}/metadata")
  @Produces(Array("application/json"))
  def songMetadata(@PathParam("id") id: Int): String = {
    return json toJson MetadataManager.find(id)
  }

  @GET
  @Path("list")
  @Produces(Array("application/json"))
  def list: String = {
    return json.toJson(MetadataManager.all)
  }

  @GET
  @Path("/song/{id}")
  @Produces(Array("audio/mpeg"))
  def song(@PathParam("id") id: Int): File = {
    return MetadataManager.find(id).retrieve
  }

}