package infrastructure.rows

import org.joda.time.DateTime

case class TaskRow(
  id: Int,
  userId: Int,
  name: String,
  description: Option[String],
  createdAt: DateTime
)
