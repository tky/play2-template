package helper

import play.api.test.Helpers._
import play.api.test._
import play.api.mvc._
import org.scalatest.BeforeAndAfterEach
import org.scalatest.concurrent.ScalaFutures
import org.scalatestplus.play._
import org.specs2.mutable._
import org.specs2.mutable.After

import org.specs2.mutable._
import scala.concurrent.{ Await, Awaitable }
import scala.concurrent.duration.Duration

// https://www.playframework.com/documentation/2.6.x/api/scala/index.html#play.api.test.PlaySpecification
trait SpecificationHelper
  extends PlaySpecification
  with Results
  with DomTestHelper
  with After
  with ScalaFutures {

  override def after = EvolutionHelper.clean()

  def executeAndWait[T](awaitable: Awaitable[T]): T = {
    Await.result(awaitable, Duration.Inf)
  }
}
