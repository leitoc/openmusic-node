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