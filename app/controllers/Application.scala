package controllers

import javax.inject.Inject

import play.api.mvc.{ Action, Controller }
import scala.concurrent.Future

class Application @Inject() () extends Controller {
  def index = Action.async { implicit rs =>
    Future.successful(Ok(views.html.index()))
  }
}
