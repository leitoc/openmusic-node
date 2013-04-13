/*Copyright (c) 2013 -  SideEffectIdeas 
*
*	Module: openmusic - services
*
*   Licensed under the Apache License, Version 2.0 (the "License");
*   you may not use this file except in compliance with the License.
*   You may obtain a copy of the License at
*
*       http://www.apache.org/licenses/LICENSE-2.0
*
*   Unless required by applicable law or agreed to in writing, software
*   distributed under the License is distributed on an "AS IS" BASIS,
*   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
*   See the License for the specific language governing permissions and
*   limitations under the License.
*   
*   Project: http://github.com/SideEffectIdeas/openmusic-node
*   Wiki: http://github.com/SideEffectIdeas/openmusic-node/wiki
*   Mailing list: http://groups.google.com/group/sideEffectIdeas
*/

package ar.com.blout.openmusic.node.services

import javax.ws.rs.Path
import javax.ws.rs.GET
import javax.ws.rs.Produces
import ar.com.blout.openmusic.node.playlist.PlaylistManager
import javax.ws.rs.PathParam
import java.io.File
import scala.collection.JavaConversions._
import javax.ws.rs.POST
import ar.com.blout.openmusic.node.metadata.MetadataManager
import ar.com.blout.openmusic.node.playlist.Playlist
import ar.com.blout.openmusic.node.utils.JavaConvertions
import ar.com.blout.openmusic.node.utils.JavaConvertions

@Path("/openmusic/playlist")
class PlaylistService extends Jsonable {

  @GET
  @Path("/list")
  @Produces(Array("application/json"))
  def list: String = PlaylistManager.all

  @GET
  @Path("/{id}")
  @Produces(Array("audio/x-mpegurl"))
  def song(@PathParam("id") id: String): File =
    PlaylistManager.find(id) match {
      case Some(x) => x.retrieve
      case None => new File()
    }

  @GET
  @Path("/{id}/info")
  @Produces(Array("application/json"))
  def info(@PathParam("id") id: String): String =
    PlaylistManager.find(id) match {
      case Some(x) => x
      case None => throw new RuntimeException
    }

  @GET
  @Path("/new")
  @Produces(Array("application/json"))
  def newPlaylist: String = (PlaylistManager newPlaylist).id

  @GET
  @Path("/{id}/add/{metadata}")
  @Produces(Array("audio/mpeg"))
  def add(@PathParam("id") id: String, @PathParam("metadata") metadata: Int) =
    PlaylistManager.find(id) match {
      case Some(x) =>
        {
          var meta = MetadataManager.find(metadata)
          meta addTo x
        }
        var playlist = x
      case None => throw new RuntimeException
    }

}