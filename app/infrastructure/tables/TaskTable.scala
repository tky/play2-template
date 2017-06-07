package infrastructure.tables

import org.joda.time.DateTime
import infrastructure.rows.TaskRow

trait TaskTable extends TableBase {
  import dbConfig.driver.api._

  import MyDriver._

  val Tasks = TableQuery[TaskTable]

  class TaskTable(tag: Tag) extends Table[TaskRow](tag, "tasks") {
    def id = column[Int]("id", O.AutoInc, O.PrimaryKey)
    def userId = column[Int]("user_id")
    def name = column[String]("name")
    def description = column[String]("description")
    def createdAt = column[DateTime]("created_at")

    def * = (id, userId, name, description.?, createdAt) <> (TaskRow.tupled, TaskRow.unapply)
  }
}
