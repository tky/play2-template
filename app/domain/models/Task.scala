package domain.models

import javax.inject.{ Inject, Singleton }

import play.api.db.slick.DatabaseConfigProvider

import org.joda.time.DateTime

import scala.concurrent.Future

import infrastructure.Repository
import infrastructure.tables.TaskTable
import infrastructure.rows.TaskRow

case class Task(
  id: Int,
  name: String,
  description: Option[String],
  createdAt: DateTime
)

@Singleton
class TaskRepository @Inject() ()(
    val dbConfigProvider: DatabaseConfigProvider
) extends Repository with TaskTable {

  import dbConfig.profile.api._

  def create(userId: Int, name: String, description: Option[String]): Future[Int] = {
    val task = TaskRow(id = 0, userId = userId, name = name, description = description, createdAt = DateTime.now())
    db.run(Tasks returning Tasks.map(_.id) += task)
  }
}
