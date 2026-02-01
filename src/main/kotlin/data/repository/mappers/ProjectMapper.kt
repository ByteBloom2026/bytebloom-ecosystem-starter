package data.repository.mappers
import data.datasource.model.ProjectRow
import domain.model.Project
import kotlin.String
fun ProjectRow.toDomain(): Project =
    Project(
        id =id,
        name=name,
        assingedTeamId = teamId
    )
