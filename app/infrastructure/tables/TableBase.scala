package infrastructure.tables

import play.api.db.slick.DatabaseConfigProvider
import slick.basic.DatabaseConfig
import slick.jdbc.JdbcProfile

trait TableBase {
  val dbConfigProvider: DatabaseConfigProvider
  val dbConfig: DatabaseConfig[JdbcProfile]
  import com.github.tototoshi.slick.GenericJodaSupport
  object MyDriver extends GenericJodaSupport(dbConfig.profile)
}
