package model.configuration

import play.api.Play
import play.api.Play.current

object Configuration {

  def load = Play.application.configuration

}
