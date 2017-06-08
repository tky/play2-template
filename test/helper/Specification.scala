package helper

import play.api.test._
import play.api.mvc._
import org.scalatest.BeforeAndAfterEach
import org.scalatestplus.play._

import scala.concurrent.{ Await, Awaitable }
import scala.concurrent.duration.Duration

trait Specification extends PlaySpec with BeforeAndAfterEach with Results with DomTestHelper with OneAppPerTest {
  override def afterEach() = EvolutionHelper.clean()

  def executeAndWait[T](awaitable: Awaitable[T]): T = {
    Await.result(awaitable, Duration.Inf)
  }
}
