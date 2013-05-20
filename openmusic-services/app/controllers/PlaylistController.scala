/*Copyright (c) 2013 -  SideEffectIdeas
*
*	Module: openmusic-services - controllers
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

package controllers

import play.api.mvc._
import model.services.Jsonable
import model.playlist.PlaylistManager
import model.metadata.MetadataManager
import java.io.File

object PlaylistController extends Controller with Jsonable {

  def list = Action {
    Ok {
      toJson(PlaylistManager.all)
    }
  }

  def playlist(id: String) = Action {
    Ok.sendFile {
      PlaylistManager.find(id) match {
        case Some(x) => x.retrieve
        case None => new File("")
      }
    }
  }


  def metadata(id: String) = Action {
    Ok {
      PlaylistManager.find(id) match {
        case Some(x) => toJson(x)
        case None => throw new RuntimeException
      }
    }

  }

  def newPlaylist = Action {
    Ok {
      (PlaylistManager newPlaylist).id
    }
  }

  def add(playlist: String, song: Int) = Action {
    Ok {
      PlaylistManager.find(playlist) match {
        case Some(x) => {
          val meta = MetadataManager.find(song)
          meta addTo x
        }
        toJson(x)
        case None => throw new RuntimeException
      }
    }
  }

}
