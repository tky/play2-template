package infrastructure.tables

import infrastructure.rows.UserRow

trait UserTable extends TableBase {
  import dbConfig.profile.api._

  val Users = TableQuery[UserTable]

  class UserTable(tag: Tag) extends Table[UserRow](tag, "users") {
    def id = column[Int]("id", O.AutoInc, O.PrimaryKey)
    def name = column[String]("name")
    def email = column[String]("email")
    def * = (id, name, email) <> (UserRow.tupled, UserRow.unapply)
  }
}
