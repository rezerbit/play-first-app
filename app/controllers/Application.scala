package controllers

import play.api._
import play.api.mvc._

object Application extends Controller {

  val result = Ok("Hello World!").withHeaders(
    CACHE_CONTROL -> "max-age=3600",
    ETAG -> "xx")

  val htmlResult = Ok(<h1>Hello World1!</h1>).as("text/html")
  val htmlResult2 = Ok(<h1>Hello World2!</h1>).as(HTML)

  val xmlResult = Ok(<message>Hello World!</message>)

  val result_with_cookies = Ok("Hello world").withCookies(
    Cookie("theme", "blue"))

  val result3 = result.withCookies(Cookie("theme", "blue")).discardingCookies(DiscardingCookie("skin"))

//  def index = Action {
//    Ok(views.html.index("Your new application is ready."))
//  }

  def index(name: String) = Action {
    Ok(views.html.index(name))
  }


  def hello(name: String) = Action {

    Ok("Hello " + name + "!")
    result3
  }

}
