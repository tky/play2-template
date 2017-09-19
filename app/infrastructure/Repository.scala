package infrastructure

import slick.jdbc.JdbcProfile
import slick.basic.DatabaseConfig
import play.api.db.slick.DatabaseConfigProvider

import scala.concurrent.Future

trait Repository {
  val dbConfigProvider: DatabaseConfigProvider
  val dbConfig: DatabaseConfig[JdbcProfile] = dbConfigProvider.get[JdbcProfile]
  val db = dbConfig.db
}
