package presentation.controllers
import play.api.mvc._
import play.api.test.Helpers._
import play.api.test._
import helper.{ SpecificationHelper, Injector }

import scala.concurrent.Future

class UserControllerSpec extends SpecificationHelper {
  val controller = Injector.inject[UserController]
  "UserController" should {
    "index" should {
      "show all users" in new WithApplication() {
        val result = controller.index().apply(FakeRequest())
        val doc = parse(contentAsString(result))
        doc.select("tr") must have size 2
        doc.title must equalTo("users")
      }
    }
  }
}
