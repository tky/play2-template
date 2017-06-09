package presentation.controllers

import javax.inject.Inject

import play.api.mvc.{ Action, Controller }

import scala.concurrent.Future

import domain.models.{ User, UserRepository }

class UserController @Inject() (
    userRepo: UserRepository
) extends Controller {

  import scala.concurrent.ExecutionContext.Implicits.global

  def index = Action.async { implicit rs =>
    val fUsers = userRepo.all
    for {
      users <- fUsers
    } yield {
      Ok(views.html.users.index(users))
    }
  }
}
