package presentation.controllers
import play.api.mvc._
import play.api.test.Helpers._
import play.api.test._
import helper.{ SpecificationHelper, Injector }

import scala.concurrent.Future

class ApplicationSpec extends SpecificationHelper {
  val controller = Injector.inject[Application]

  "Application" should {
    "show index" in new WithApplication() {
      val result = controller.index().apply(FakeRequest())
      val doc = parse(contentAsString(result))
      doc.title must equalTo("index")
    }
  }
}
