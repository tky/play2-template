package presentation.controllers

import javax.inject.Inject

import play.api.mvc._
import scala.concurrent.{ ExecutionContext, Future }
import domain.models.{ User, UserRepository }

class UserController @Inject() (
  cc: ControllerComponents,
  userRepo: UserRepository)(implicit ec: ExecutionContext) extends AbstractController(cc) {

  def index = Action.async { implicit rs =>
    val fUsers = userRepo.all
    for {
      users <- fUsers
    } yield {
      Ok(views.html.users.index(users))
    }
  }
}
