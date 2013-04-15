package controllers

import play.api._
import play.api.mvc._
import model.metadata.MetadataManager
import model.services.Jsonable

object SongController extends Controller with Jsonable {

  def index = Action {
    Ok("Your new application is ready.")
  }

  def list = Action {
    Ok {
      ListToJson(MetadataManager.all)
    }
  }

  def metadata(id : Int) = Action {
    Ok{
      toJson(MetadataManager.find(id))
    }
  }

  def retrieve(id: Int) = Action {
    Ok.sendFile {
      MetadataManager.find(id).retrieve
    }
  }

}