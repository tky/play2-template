package infrastructure

import slick.driver.JdbcProfile
import slick.backend.DatabaseConfig
import play.api.db.slick.DatabaseConfigProvider

import scala.concurrent.Future

trait Repository {
  val dbConfigProvider: DatabaseConfigProvider
  val dbConfig: DatabaseConfig[JdbcProfile] = dbConfigProvider.get[JdbcProfile]
  val db = dbConfig.db
}
