package repository.mappers
import data.dataSource.model.ProjectRow
import domain.model.Project
fun ProjectRow.toDomain(): Project =
    Project(
        projectId = projectId,
        projectName = projectName,
        teamId = teamId
    )
