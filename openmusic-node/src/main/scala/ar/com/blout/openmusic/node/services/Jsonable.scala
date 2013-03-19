package ar.com.blout.openmusic.node.services

import com.google.gson.GsonBuilder

trait Jsonable {

  implicit def AnythingToJson(obj: Any): String = this toJson obj

  def toJson(obj: Any) = new GsonBuilder().setPrettyPrinting().create().toJson(obj)

}