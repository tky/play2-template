package presentation

import play.api.mvc.Call
import com.netaporter.uri.Uri

object CallEnrichment {
  implicit def toRichCall(c: Call) = new {
    def withParams(params: (String, String)*): Call = {
      val uri = Uri.parse(c.url).addParams(params)
      Call(c.method, uri.toString, c.fragment)
    }
  }
}
