package presentation.controllers

import javax.inject.Inject

import scala.concurrent.ExecutionContext
import play.api.mvc._
import scala.concurrent.Future

class Application @Inject() (cc: ControllerComponents)(implicit exec: ExecutionContext) extends AbstractController(cc) {
  def index = Action.async { implicit rs =>
    Future.successful(Ok(views.html.index()))
  }
}
