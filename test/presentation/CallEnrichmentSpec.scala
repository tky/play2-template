package presentation

import play.api.mvc._
import play.api.test.Helpers._
import play.api.test._

import helper.SpecificationHelper

class CallEnrichmentSpec extends SpecificationHelper {
  import CallEnrichment._
  "CallEnrichment" should {
    "withParams" should {
      "works with a parameter" in {
        val call = new Call("GET", "https://sample.co.jp")
        call.withParams(("q", "test")).url must equalTo("https://sample.co.jp?q=test")
      }

      "works with multi paramters" in {
        val call = new Call("GET", "https://sample.co.jp")
        call.withParams(("q", "test"), ("page", "1")).url must equalTo("https://sample.co.jp?q=test&page=1")
      }

      "works a url with query" in {
        val call = new Call("GET", "https://sample.co.jp?q=test")
        call.withParams(("page", "1")).url must equalTo("https://sample.co.jp?q=test&page=1")
      }
    }
  }
}
