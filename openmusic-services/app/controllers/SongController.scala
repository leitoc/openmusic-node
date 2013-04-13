package controllers

import play.api._
import libs.json.{JsArray, Json}
import play.api.mvc._
import model.metadata.MetadataManager
import model.services.Jsonable

object SongController extends Controller with Jsonable{

  def index = Action {
    Ok("Your new application is ready.")
  }

  def list = Action {

    Ok {
      ListToJson(MetadataManager.all)
    }


  }

}