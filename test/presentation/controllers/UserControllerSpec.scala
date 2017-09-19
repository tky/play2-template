package presentation.controllers
import play.api.mvc._
import play.api.test.Helpers._
import play.api.test._
import helper.{ Specification, Injector }

import scala.concurrent.Future

class UserControllerSpec extends Specification {
  val controller = Injector.inject[UserController]

  "UserController" should {
    "index" should {
      "show all users" in new WithApplication() {
        val result = controller.index().apply(FakeRequest())
        val doc = parse(contentAsString(result))
        doc.select("tr") must have size 2
        doc.title mustBe "users"
      }
    }
  }
}

