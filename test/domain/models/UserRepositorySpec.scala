package domain.models

import org.scalatestplus.play._
import play.api.test.Helpers._
import play.api.test._

import scala.concurrent.Await
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration.Duration
import helper.{ Specification, Injector }

class UserRepositorySpec extends Specification {
  val userRepo = Injector.inject[UserRepository]
  val taskRepo = Injector.inject[TaskRepository]

  "UserRepository" should {
    "work #create and #find" in new WithApplication() {
      val id = executeAndWait(userRepo.create("test", "test@gmail.com"))
      val found = executeAndWait(userRepo.find(id)).get

      found.id mustBe id
      found.name mustBe "test"
      found.email mustBe "test@gmail.com"
    }

    "append tasks and find it" in new WithApplication() {
      val id = executeAndWait(userRepo.create("test", "test@gmail.com"))
      executeAndWait(taskRepo.create(id, "chores", Some("get rid of dust.")))

      val found = executeAndWait(userRepo.find(id)).get
      found.tasks must have size 1
      found.tasks.head.name mustBe "chores"
      found.tasks.head.description.get mustBe "get rid of dust."
    }
  }
}

