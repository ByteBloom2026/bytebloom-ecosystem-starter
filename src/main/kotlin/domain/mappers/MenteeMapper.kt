package domain.mappers
import dataSource.model.MenteeRow
import domain.model.Mentee
fun MenteeRow.toDomain(): Mentee =
    Mentee(id = menteeId, name = name, teamId = teamId)
