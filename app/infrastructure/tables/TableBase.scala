package infrastructure.tables

import play.api.db.slick.DatabaseConfigProvider
import slick.backend.DatabaseConfig
import slick.driver.JdbcProfile

trait TableBase {
  val dbConfigProvider: DatabaseConfigProvider
  val dbConfig: DatabaseConfig[JdbcProfile]
  import com.github.tototoshi.slick.GenericJodaSupport
  object MyDriver extends GenericJodaSupport(dbConfig.driver)
}
