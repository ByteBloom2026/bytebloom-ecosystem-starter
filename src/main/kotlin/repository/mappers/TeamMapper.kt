package repository.mappers
import data.dataSource.model.TeamRow
import domain.model.Team
import domain.model.Project
fun TeamRow.toDomain(project: Project? = null): Team =
    Team(
        teamId = teamId,
        teamName = teamName,
        mentorLead = mentorLead,
        project = project
    )
