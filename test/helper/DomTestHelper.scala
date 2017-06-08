package helper

import akka.util.Timeout
import play.api.mvc._
import play.api.test._
import org.jsoup.Jsoup
import org.jsoup.nodes.{ Document }
import org.jsoup.select.Elements
import scala.concurrent.Future

case class DocumentWrapper(doc: Document) {
  def select(selector: String): Elements = doc.select(selector)
}

trait DomTestHelper {
  def parse(body: String): DocumentWrapper = {
    val doc = Jsoup.parse(body)
    DocumentWrapper(doc)
  }
}
