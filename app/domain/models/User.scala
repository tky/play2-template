package domain.models

import javax.inject.{ Inject, Singleton }

import play.api.db.slick.DatabaseConfigProvider

import scala.concurrent.Future

import infrastructure.Repository
import infrastructure.tables.{ TaskTable, UserTable }
import infrastructure.rows.{ TaskRow, UserRow }

case class User(
  id: Int,
  name: String,
  email: String,
  tasks: Seq[Task]
)

@Singleton
class UserRepository @Inject() ()(
  val dbConfigProvider: DatabaseConfigProvider
) extends Repository
    with UserTable
    with TaskTable {

  import scala.concurrent.ExecutionContext.Implicits.global
  import dbConfig.profile.api._

  def find(id: Int): Future[Option[User]] = {
    val fUser = db.run(Users.filter(_.id === id).result.headOption)
    val fTaksks = db.run(Tasks.filter(_.userId === id).result)
    for {
      user <- fUser
      tasks <- fTaksks
    } yield {
      user.map(u => assemble(u, tasks))
    }
  }

  def all: Future[Seq[User]] = {
    val fUsers = db.run(Users.result)
    val fTasks = db.run(Tasks.result)

    for {
      users <- fUsers
      tasks <- fTasks
      taskMap = tasks.groupBy(_.userId)
    } yield users.map { u => assemble(u, taskMap.get(u.id).getOrElse(Nil)) }
  }

  def create(name: String, email: String): Future[Int] = {
    val user = UserRow(id = 0, name = name, email = email)
    db.run(Users returning Users.map(_.id) += user)
  }

  private def assemble(user: UserRow, tasks: Seq[TaskRow]): User = {
    User(
      id = user.id,
      name = user.name,
      email = user.email,
      tasks = tasks.map { t => Task(id = t.id, name = t.name, description = t.description, createdAt = t.createdAt) }
    )
  }
}
