package controllers

import play.api.mvc._
import model.services.Jsonable
import model.playlist.PlaylistManager
import model.metadata.MetadataManager
import java.io.File

object PlaylistController extends Controller with Jsonable {

  def list = Action {
    Ok {
      ListToJson(PlaylistManager.all)
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
